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
		int port = 50059;
		
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
	        @Override
	        public void onNext(SetLightLevelsRequest request) {
	            // Implement code to set the light levels based on the request parameters
	            // ...

	            // Create a response object to confirm receipt of the request
	            SetLightLevelsResponse response = SetLightLevelsResponse.newBuilder()
	                .setMessage("Light levels set successfully.")
	                .build();

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


	@Override
	public void switchLight(SwitchLightRequest request, StreamObserver<SwitchLightResponse> responseObserver) {
		
		    // Implement code to switch the light on or off based on the request parameters
		    boolean lightState = request.getStatus();
		    if (lightState) {
		        System.out.println("Switching light on...");
		    } else {
		        System.out.println("Switching light off...");
		    }

		    // Create a response object to confirm the state change
		    SwitchLightResponse response = SwitchLightResponse.newBuilder()
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

