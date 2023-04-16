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
		// TODO Auto-generated method stub
		EnergyMonitoringServer EMserver = new EnergyMonitoringServer();
		//int port = 

		;
		
		Properties prop = EMserver.getProperties();
		EMserver.registerService(prop);
		int port = Integer.valueOf( prop.getProperty("service_port") );
		
		try {
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

	@Override
	public void getEnergyUsage(GetEnergyUsageRequest request, StreamObserver<GetEnergyUsageResponse> responseObserver) {
		final EnergyUsageRepository energyRepository = new EnergyUsageRepository();
		
	    String deviceId = request.getDeviceId();
	    long startTimeMillis = request.getStartTime();
	    long endTimeMillis = request.getEndTime();
	    List<EnergyUsage> energyUsageList = energyRepository.getEnergyUsage(deviceId, startTimeMillis, endTimeMillis);

	    float totalEnergyUsage = 0.0f;
	    float totalPowerConsumption = 0.0f;

	    for (EnergyUsage energyUsage : energyUsageList) {
	        totalEnergyUsage += energyUsage.getUsage();
	        totalPowerConsumption += energyUsage.getPowerConsumption();
	        }

	    float averagePowerConsumption = totalPowerConsumption / energyUsageList.size();

	    GetEnergyUsageResponse response = GetEnergyUsageResponse.newBuilder().setTotalEnergyUsage(totalEnergyUsage).setAveragePowerConsumption(averagePowerConsumption).build();

	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}

	@Override
	public void getEnergyUsageBySource(UsageBySourceRequest request,
			StreamObserver<UsageBySourceResponse> responseObserver) {
		        long startTime = request.getStartTime();
		        long endTime = request.getEndTime();
		        String source_id = request.getSourceId();

		        // In this implementation, we simulate energy usage data
		        // for the given source and time range, and stream the results back
		        long interval = 60; // seconds
		        long currentTime = startTime;
		        while (currentTime < endTime) {
		            float energyUsage = EnergyUsage(source_id, currentTime, currentTime + interval);
		            UsageBySourceResponse response = UsageBySourceResponse.newBuilder()
		                    .setEnergyUsage(energyUsage)
		                    .build();
		            responseObserver.onNext(response);
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

		    private float EnergyUsage(String sourceId, long startTime, long endTime) {
		        
		        return (float) Math.random() * 100;
		    
		}

		
		

@Override
	public void getEnergyUsageHistory(GetEnergyUsageHistoryRequest request,
			StreamObserver<EnergyUsageHistoryData> responseObserver) {
		
		final EnergyUsageRepository energyRepository = new EnergyUsageRepository();
	        List<EnergyUsageHistoryData> energyUsageHistoryDataList = energyRepository.getEnergyUsageHistory(request.getDeviceId());

	        for (EnergyUsageHistoryData e : energyUsageHistoryDataList) {
	            responseObserver.onNext(e);
	        }
	        responseObserver.onCompleted();
	    }
		
	}
	


