package ds.lightingsystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.lightingsystem.LightingSystemGrpc.LightingSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightingSystemServer extends LightingSystemImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightingSystemServer LSserver = new LightingSystemServer();
		Properties prop = LSserver.getProperties();
		
		LSserver.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );
		
		// port = 50063;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(LSserver).build().start();
			System.out.println("Lighting System Server started, listening on " + port);
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
		
		 try (InputStream input = new FileInputStream("src/main/resources/lightingsystem.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Lighting System Service properties ...");
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

	public StreamObserver<SetLightLevelsRequest> setLightLevels(StreamObserver<SetLightLevelsResponse> responseObserver) {
	    return new StreamObserver<SetLightLevelsRequest>() {
	    	
	    	 private float intensitySum = 0;
	         private int numRequests = 0;
	         String systemId = "";
	         float intensity = 0;
	        
	        @Override
	        public void onNext(SetLightLevelsRequest request) {
	        	systemId = request.getSystemId();
	        	intensity = request.getIntensity();
	        	intensitySum += request.getIntensity();
	            numRequests++;	            
	            System.out.println("Light System with ID: " + systemId +" to be set to an intensity of " + intensity);
	   	            // Send the response back to the client
	        }

	        @Override
	        public void onError(Throwable t) {
	        	System.err.println("Error during setLightLevels streaming: " + t.getMessage());
	            responseObserver.onNext(SetLightLevelsResponse.newBuilder().setStatus(false).setMessage("Error during streaming: " + t.getMessage())
	                .build());
	            responseObserver.onCompleted();
	        }

	        @Override
	        public void onCompleted() {
	        	// compute the average intensity from all requests
	            float averageIntensity = intensitySum / numRequests;

	            // call the logic method to set the light levels
	            boolean success = setLightLevelsLogic(systemId, averageIntensity);

	            // send a response based on the result of the operation
	            responseObserver.onNext(SetLightLevelsResponse.newBuilder()
	                .setStatus(success)
	                .setMessage(success ? "Light levels set successfully" : "Failed to set light levels")
	                .build());
	            responseObserver.onCompleted();
	        }
	    };
	}
	private boolean setLightLevelsLogic(String systemId, float intensity){
		
		//System.out.println("Light Level" + systemId +" to be set to an intensity of" + intensity);
		
		return true;
	}
	
	

	@Override
	public void switchLight(SwitchLightRequest request, StreamObserver<SwitchLightResponse> responseObserver) {
		
		    boolean lightState = request.getStatus();
		    if (lightState) {
		        System.out.println("Switching light on...");
		    } else {
		        System.out.println("Switching light off...");
		    }

		    // Create a response object to confirm the state change
		    SwitchLightResponse response = SwitchLightResponse.newBuilder().setLightState(lightState)
		        .setMessage("Light switched " + (lightState ? "on" : "off") + " successfully.")
		        .build();

		    // Send the response back to the client
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
		}

	    @Override
	    public StreamObserver<SetLightScheduleRequest> setLightSchedule(StreamObserver<SetLightScheduleResponse> responseObserver) {
	        return new StreamObserver<SetLightScheduleRequest>() {

	            // Store the schedules received from the client
	            List<LightSchedule> schedules = new ArrayList<>();

	            @Override
	            public void onNext(SetLightScheduleRequest request) {
	                // Create a new light schedule from the request
	            	System.out.println("Setting Light Schedule of : "+ request.getSystemId() + " from: "+ request.getStartTime() + " to: "+ request.getEndTime() + " with an Intensity of: " +request.getIntensity());
	                LightSchedule schedule = new LightSchedule(request.getSystemId(), request.getStartTime(), request.getEndTime(), request.getIntensity());

	                // Add the schedule to the list
	                schedules.add(schedule);

	                // Log the new schedule
	                System.out.println("Received new light schedule: " + schedule.getSystemID());
	            }

	            @Override
	            public void onError(Throwable t) {
	                // Log any errors
	                System.out.println("Error in setLightSchedule: " + t.getMessage());
	            }

	            @Override
	            public void onCompleted() {
	                // TODO: Implement logic to set the light schedules

	                // Send the response to the client
	                SetLightScheduleResponse response = SetLightScheduleResponse.newBuilder()
	                        .setStatus(true)
	                        .setMessage("Light schedules have been set.")
	                        .build();
	                responseObserver.onNext(response);
	                responseObserver.onCompleted();
	            }
	        };
	    }
	}

