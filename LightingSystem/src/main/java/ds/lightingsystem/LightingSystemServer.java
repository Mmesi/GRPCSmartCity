package ds.lightingsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ds.lightingsystem.LightingSystemGrpc.LightingSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightingSystemServer extends LightingSystemImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightingSystemServer LSserver = new LightingSystemServer();
		int port = 50063;
		
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


	/*public StreamObserver<SetLightScheduleRequest> setLightSchedule(StreamObserver<SetLightScheduleResponse> responseObserver) {
	    return new StreamObserver<SetLightScheduleRequest>() {
	        @Override
	        public void onNext(SetLightScheduleRequest request) {
	        	
	    				System.out.println("Set Light Schedule of : "+ request.getSystemId() + " from: "+ request.getStartTime() + " to: "+ request.getEndTime() + "with an Intensity of: " +request.getIntensity());
	    				
	    				String converted =  Integer.toString(Integer.parseInt(msg.getNumC(), msg.getFromBase()), msg.getToBase());
	    				
	    				ConvertResponse reply = ConvertResponse.newBuilder().setNumber(converted).setBase(msg.getToBase()).build();
	    				
	    				responseObserver.onNext(reply);
	    				
	    			}

	    			@Override
	    			public void onError(Throwable t) {
	    				
	    				t.printStackTrace();
	    				
	    			}

	    			@Override
	    			public void onCompleted() {
	    				System.out.println("receiving convertBase completed ");
	    				
	    				//completed too
	    				responseObserver.onCompleted();
	    			}
	    			
	    		};
	    	}

	    	
	            // Create a response object to confirm receipt of the request
	            SetLightScheduleResponse response = SetLightScheduleResponse.newBuilder().setMessage("Light schedule set successfully.").build();

	            // Send the response back to the client
	            responseObserver.onNext(response);
	        }

	        @Override
	        public void onError(Throwable t) {
	            // Handle any errors that might occur and send an error response back to the client
	            responseObserver.onError(t);
	        }

	        @Override
	        public void onCompleted() {
	            // Signal the end of the response stream
	            responseObserver.onCompleted();
	        }
	    };
	}*/


	    @Override
	    public StreamObserver<SetLightScheduleRequest> setLightSchedule(StreamObserver<SetLightScheduleResponse> responseObserver) {
	        return new StreamObserver<SetLightScheduleRequest>() {

	            // Store the schedules received from the client
	            List<LightSchedule> schedules = new ArrayList<>();

	            @Override
	            public void onNext(SetLightScheduleRequest request) {
	                // Create a new light schedule from the request
	            	System.out.println("Setting Light Schedule of : "+ request.getSystemId() + " from: "+ request.getStartTime() + " to: "+ request.getEndTime() + "with an Intensity of: " +request.getIntensity());
	                LightSchedule schedule = new LightSchedule(request.getSystemId(), request.getStartTime(), request.getEndTime(), request.getIntensity());

	                // Add the schedule to the list
	                schedules.add(schedule);

	                // Log the new schedule
	                System.out.println("Received new light schedule: " + schedule.getSystemID());
	            }

	            @Override
	            public void onError(Throwable throwable) {
	                // Log any errors
	                System.out.println("Error in setLightSchedule: " + throwable.getMessage());
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

