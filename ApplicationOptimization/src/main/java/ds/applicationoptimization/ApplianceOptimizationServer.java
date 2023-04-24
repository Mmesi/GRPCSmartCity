package ds.applicationoptimization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.Date;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ApplianceOptimizationServer extends ApplicationOptimizationImplBase{

	public static void main(String[] args) {
		// creating an instance of the server
		ApplianceOptimizationServer AOserver = new ApplianceOptimizationServer();

		
		//Creating a Properties instance to retrieve the server properties
		Properties prop = AOserver.getProperties();
		
		
		//registering the service
		AOserver.registerService(prop);
		
		
		//retrieving the port number 
		int port = Integer.valueOf( prop.getProperty("service_port"));
		
		try {
			//starting the server
			Server server = ServerBuilder.forPort(port).addService(AOserver).build().start();
			System.out.println("Application Optimization Server started, listening on " + port);
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
 * from the applianceoptimization.properties file
 */
	
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/applianceoptimization.properties")) {//read the file that contains the properties

	            prop = new Properties();

	            // loading a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Application Optimization Service properties ...");
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
	            
	            //retrieve the service type and service name
	            String service_type = prop.getProperty("service_type") ;
	            String service_name = prop.getProperty("service_name") ;
	   
	          //retrieve the port number
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );

	            //get service description
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register the service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);


	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}

	@Override
	
	//Implementation of the unary rpc setApplianceMode method
	
		public void setApplianceMode(SetApplianceModeRequest request, StreamObserver<SetApplianceModeResponse> responseObserver) {
		    
		
		// Implementing code to set the appliance mode based on the request parameters
			String applianceId = request.getApplianceId();
		    String mode = request.getMode();
		    String location = request.getLocation();
		    System.out.println("Setting appliance mode to " + mode + "...");
		    
		    
		    //passing the given parameters to the Logic where the appliance is identified and turned on
		    boolean status = setApplianceModeLogic(applianceId, mode, location);
		    

		    // Create a response object to confirm the mode change
		    SetApplianceModeResponse response = SetApplianceModeResponse.newBuilder().setStatus(status).setMessage(status ? "Appliance mode for " +applianceId+ " set to "+ mode + " successfully" : "Failed to set appliance mode")
	                .build();

		    // Send the response back to the client
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
		}
	
	/*This method accepts the applianceId, mode to set the appliance and location. 
	 * This is a mere simulation of the logic
	 */
	private boolean setApplianceModeLogic(String applianceId, String mode, String location) {
	    System.out.println("Setting mode of appliance " + applianceId + " to " + mode + " in location " + location);
	    return true;
	}

	//Implementation of the unary rpc setApplianceLimit method
	@Override
	public void setApplianceLimit(SetApplianceLimitRequest request, StreamObserver<SetApplianceLimitResponse> responseObserver) {
	    // Implementing code to set the appliance limit based on the request parameters
	    int limit = (int) request.getLimit();
	    System.out.println("Setting appliance limit to " + limit + "...");

	    // Create a response object to confirm the limit change
	    SetApplianceLimitResponse response = SetApplianceLimitResponse.newBuilder()
	        .setMessage("Appliance limit set to " + limit + "Kwh successfully.")
	        .build();

	    // Send the response back to the client
	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}


	@Override
	//Implementation of the bidirectional rpc setApplianceSchedule method
	public StreamObserver<SetApplianceScheduleRequest> setApplianceSchedule(StreamObserver<SetApplianceScheduleResponse> responseObserver) {
	    return new StreamObserver<SetApplianceScheduleRequest>() {
	    	
	    	
	        private StringBuilder messageBuilder = new StringBuilder("");//message that relays the result of each entry in the server streaming
	        private int count = 0;
	        
	        @Override
	        public void onNext(SetApplianceScheduleRequest request) {
	        	
	            // Implementing code to set the appliance schedule based on the request parameters
	        	String applianceId = request.getApplianceId();
	            long startTime = request.getStartTime();
	            long endTime = request.getEndTime();
	            
	            //C
	            Date startTimeDate = new Date(startTime*1000);
	            Date endTimeDate = new Date(endTime*1000);
	            
	            // Create a SimpleDateFormat object with desired date format
	            SimpleDateFormat startTimedateFormat = new SimpleDateFormat("yyyy/MM/dd");
	            SimpleDateFormat endTimedateFormat = new SimpleDateFormat("yyyy/MM/dd");
	            
	            // Convert Date object to string format
	            String startTimeString = startTimedateFormat.format(startTimeDate);
	            String endTimeString = endTimedateFormat.format(endTimeDate);
	            
	            
	            //Print the activity to the console
	            System.out.println("Setting " + applianceId + " schedule from " + startTimeString + " to " + endTimeString + "...");
	            
	            // Append the schedule information to the response message
	            if (count > -1) {
	                messageBuilder.append("Appliance schedule for " +applianceId + " set");
	            }
	            messageBuilder.append(": from ").append(startTimeString).append(" to ").append(endTimeString+"\n");
	            count++;
	        }

	        @Override
	        public void onError(Throwable t) {
	            // Handle errors that stems from setting the schedule
	            System.err.println("Error in setting appliance schedule: " + t.getMessage());
	        }

	        @Override
	        public void onCompleted() {
	        	
	        	
	            // Create a response object to confirm the schedule change
	            SetApplianceScheduleResponse response = SetApplianceScheduleResponse.newBuilder()
	                .setMessage(messageBuilder.toString())
	                .build();

	            // Send the response back to the client
	            responseObserver.onNext(response);
	            responseObserver.onCompleted();
	        }
	    };
	}

	
	

}
