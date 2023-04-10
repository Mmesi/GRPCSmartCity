package ds.lightingsystem;

import java.io.IOException;
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


	public StreamObserver<SetLightScheduleRequest> setLightSchedule(StreamObserver<SetLightScheduleResponse> responseObserver) {
	    return new StreamObserver<SetLightScheduleRequest>() {
	        @Override
	        public void onNext(SetLightScheduleRequest request) {
	            // Implement code to set the light schedule based on the request parameters
	            // ...

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
	}

	}

