package ds.applicationoptimization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ApplianceOptimizationServer extends ApplicationOptimizationImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplianceOptimizationServer AOserver = new ApplianceOptimizationServer();
		//int port = 50058;
		
		
		Properties prop = AOserver.getProperties();
		
		AOserver.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port"));
		
		try {
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
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/applianceoptimization.properties")) {

	            prop = new Properties();

	            // load a properties file
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
	
	
	private  void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	           // int service_port = 1234;
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
		public void setApplianceMode(SetApplianceModeRequest request, StreamObserver<SetApplianceModeResponse> responseObserver) {
		    // Implement code to set the appliance mode based on the request parameters
			String applianceId = request.getApplianceId();
		    String mode = request.getMode();
		    String location = request.getLocation();
		    System.out.println("Setting appliance mode to " + mode + "...");
		    boolean status = setApplianceModeLogic(applianceId, mode, location);

		    // Create a response object to confirm the mode change
		    SetApplianceModeResponse response = SetApplianceModeResponse.newBuilder().setStatus(status).setMessage(status ? "Appliance mode set successfully" : "Failed to set appliance mode")
	                .build();

		    // Send the response back to the client
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
		}
	private boolean setApplianceModeLogic(String applianceId, String mode, String location) {
	    System.out.println("Setting mode of appliance " + applianceId + " to " + mode + " in location " + location);
	    return true;
	}


	@Override
	public void setApplianceLimit(SetApplianceLimitRequest request, StreamObserver<SetApplianceLimitResponse> responseObserver) {
	    // Implement code to set the appliance limit based on the request parameters
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
	public StreamObserver<SetApplianceScheduleRequest> setApplianceSchedule(StreamObserver<SetApplianceScheduleResponse> responseObserver) {
	    return new StreamObserver<SetApplianceScheduleRequest>() {
	        private StringBuilder messageBuilder = new StringBuilder("");
	        private int count = 0;
	        
	        @Override
	        public void onNext(SetApplianceScheduleRequest request) {
	            // Implement code to set the appliance schedule based on the request parameters
	        	String applianceId = request.getApplianceId();
	            int startTime = (int) request.getStartTime();
	            int endTime = (int) request.getEndTime();
	            System.out.println("Setting " + applianceId + " schedule from " + startTime + " to " + endTime + "...");
	            
	            // Append the schedule information to the response message
	            if (count > 0) {
	                messageBuilder.append("Appliance schedule for " +applianceId + " set");
	            }
	            messageBuilder.append(": from ").append(startTime).append(" to ").append(endTime+"\n");
	            count++;
	        }

	        @Override
	        public void onError(Throwable t) {
	            // Handle errors
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
