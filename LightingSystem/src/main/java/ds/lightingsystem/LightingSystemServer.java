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
		
		// creating an instance of the server
		LightingSystemServer LSserver = new LightingSystemServer();
		
		//Creating a Properties instance to retrieve the server properties
		Properties prop = LSserver.getProperties();
		
		
		
		//registering the service
		LSserver.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// port = 50063;
		
		
		
		try {
			//starting the server
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
	
	/*Definition of getProperties Method which gets the service name, type, description and port number
	 * from the lightingsystem.properties file
	 */
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/lightingsystem.properties")) {//read the file that contains the properties

	            prop = new Properties();

	            // loading a properties file
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
	
	//Definition of the registerService method
	private  void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	           
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #50063;

	            
	            String service_description_properties = prop.getProperty("service_description") ;
	            
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

	
	//Implementing the CLIENT STREAMING method- setLightLevels
	public StreamObserver<SetLightLevelsRequest> setLightLevels(StreamObserver<SetLightLevelsResponse> responseObserver) {
	    return new StreamObserver<SetLightLevelsRequest>() {
	         String systemId = "";//systemid 
	         float intensity = 0;//intensity 
	         boolean success = false;//Variable that stores the status
	        
	         
	    //method call for every input in the client streaming
	        @Override
	        public void onNext(SetLightLevelsRequest request) {
	        	systemId = request.getSystemId();
	        	intensity = request.getIntensity();            
	            System.out.println("Light System with ID: " + systemId +" to be set to an intensity of " + intensity);
	   	            
	         // call the logic method to set the light levels
	            success = setLightLevelsLogic(systemId, intensity);
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
	        	
	              // send a response based on the result of the operation
	            responseObserver.onNext(SetLightLevelsResponse.newBuilder()
	                .setStatus(success)
	                .setMessage(success ? "Light levels set successfully" : "Failed to set light levels for all systems")
	                .build());
	            responseObserver.onCompleted();
	        }
	    };
	}
	
	//Method that sets the light levels for a given system with a given intensity.
	//This is just a simulation
	private boolean setLightLevelsLogic(String systemId, float intensity){
			
		return true;
	}
	
	
	//Implementing the UNARY method- switchLight
	@Override
	public void switchLight(SwitchLightRequest request, StreamObserver<SwitchLightResponse> responseObserver) {
		
		    boolean lightState = request.getStatus();//variable that stores the status of light
		    
		    //logic that turns light on or off. This just returns a String.
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
	
	
	
	//Implementing the CLIENT STREAMING method- setLightSchedule
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

