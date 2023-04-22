package ds.energymonitoring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringImplBase;
import ds.energymonitoring.GetEnergyUsageResponse.Builder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class EnergyMonitoringServer extends EnergyMonitoringImplBase{

	public static void main(String[] args) {
	
		// creating an instance of the server
		EnergyMonitoringServer EMserver = new EnergyMonitoringServer();

		
		//Creating a Properties instance to retrieve the server properties
		Properties prop = EMserver.getProperties();
		
		//registering the service
		EMserver.registerService(prop);
		
		
		//retrieving the port number 
		int port = Integer.valueOf( prop.getProperty("service_port") );
		
		try {
			//starting the server
			Server server = ServerBuilder.forPort(port).addService(EMserver).build().start();
			System.out.println("Energy Monitoring Server started, listening on " + port);
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*Definition of getProperties Method which gets the service name, type, description and port number
	 * from the energymonitoring.properties file
	 */
private Properties getProperties() {
	
	Properties prop = null;		
	
	 try (InputStream input = new FileInputStream("src/main/resources/energymonitoring.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Energy Monitoring Service properties ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

	 return prop;
}

//Definition of the registerService method
private  void registerService(Properties prop) {
	
	 try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            
            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name")  ;// "example";
           
            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

            
            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
            
            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);
            
            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
            
            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
}

//Implementation of the Unary rpc method- getEnergyUsage
	@Override
	public void getEnergyUsage(GetEnergyUsageRequest request, StreamObserver<GetEnergyUsageResponse> responseObserver) {
		final EnergyUsageRepository energyRepository = new EnergyUsageRepository();
		
		//Get deviceID, startTime and endTime
	    String deviceId = request.getDeviceId();
	    long startTimeMillis = request.getStartTime();
	    long endTimeMillis = request.getEndTime();
	    
	    //Read data from a repository given the deviceID, startTime, and endTime 
	    List<EnergyUsage> energyUsageList = energyRepository.getEnergyUsage(deviceId, startTimeMillis, endTimeMillis);

	    //Initializing totalEnergyUsage  
	    float totalEnergyUsage = 0.0f;
	   

	    for (EnergyUsage energyUsage : energyUsageList) {
	        totalEnergyUsage += energyUsage.getUsage();//calculating the total energy usage
	        }
	    //calculating the average power consumption
	    float averagePowerConsumption = totalEnergyUsage / energyUsageList.size();

	    //Generating the response to be sent to the client
	    GetEnergyUsageResponse response = GetEnergyUsageResponse.newBuilder().setTotalEnergyUsage(totalEnergyUsage).setAveragePowerConsumption(averagePowerConsumption).build();

	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}

	//Implementation of the Server Streaming rpc method- getEnergyUsageBySource
	@Override
	public void getEnergyUsageBySource(UsageBySourceRequest request,
			StreamObserver<UsageBySourceResponse> responseObserver) {
		
		        long startTime = request.getStartTime();//getting startTime from the request
		        long endTime = request.getEndTime();//getting endTime from the request
		        String source_id = request.getSourceId();//getting a sourceId from the request

		        // In this implementation, the energy usage data is simulated
		        // for the given source and time range, and stream the results back
		        long interval = 3600000; // milliseconds
		        long currentTime = startTime;
		        
		        //Getting the energyUsage from the specified startTime to the endTime
		        while (currentTime < endTime) {
		        	
		        
		            float energyUsage = EnergyUsage(source_id, currentTime, currentTime + interval);
		            
		            //generating the response sent back to client
		            UsageBySourceResponse response = UsageBySourceResponse.newBuilder()
		                    .setEnergyUsage(energyUsage)
		                    .build();
		            responseObserver.onNext(response);
		            //increase current time bt interval
		            currentTime += interval;
		            try {
						//wait for a second
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }

		        responseObserver.onCompleted();
		    }
//This method is a simulation that returns a random number for the energy usage
		    private float EnergyUsage(String sourceId, long startTime, long endTime) {
		        
		        return (float) Math.random() * 100;
		    
		}

		
		

@Override
	//Implementation of the Server Streaming rpc Method- getEnergyUsageHistory
	public void getEnergyUsageHistory(GetEnergyUsageHistoryRequest request,
			StreamObserver<EnergyUsageHistoryData> responseObserver) {
		
		final EnergyUsageRepository energyRepository = new EnergyUsageRepository();
		  //Calling a method in the EnergyUsageRepository class that returns usage History Data.
	        List<EnergyUsageHistoryData> energyUsageHistoryDataList = energyRepository.getEnergyUsageHistory(request.getDeviceId());

	        for (EnergyUsageHistoryData e : energyUsageHistoryDataList) {
	            responseObserver.onNext(e);//returning the result to the client
	        }
	        responseObserver.onCompleted();
	    }
		
	}
	


