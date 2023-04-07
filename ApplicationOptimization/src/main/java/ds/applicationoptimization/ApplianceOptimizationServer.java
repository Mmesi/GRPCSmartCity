package ds.applicationoptimization;

import java.io.IOException;


import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ApplianceOptimizationServer extends ApplicationOptimizationImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplianceOptimizationServer AOserver = new ApplianceOptimizationServer();
		int port = 50058;
		
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

	@Override
		public void setApplianceMode(SetApplianceModeRequest request, StreamObserver<SetApplianceModeResponse> responseObserver) {
		    // Implement code to set the appliance mode based on the request parameters
		    String mode = request.getMode();
		    System.out.println("Setting appliance mode to " + mode + "...");

		    // Create a response object to confirm the mode change
		    SetApplianceModeResponse response = SetApplianceModeResponse.newBuilder()
		        .setMessage("Appliance mode set to " + mode + " successfully.")
		        .build();

		    // Send the response back to the client
		    responseObserver.onNext(response);
		    responseObserver.onCompleted();
		}


	@Override
	public void setApplianceLimit(SetApplianceLimitRequest request, StreamObserver<SetApplianceLimitResponse> responseObserver) {
	    // Implement code to set the appliance limit based on the request parameters
	    int limit = (int) request.getLimit();
	    System.out.println("Setting appliance limit to " + limit + "...");

	    // Create a response object to confirm the limit change
	    SetApplianceLimitResponse response = SetApplianceLimitResponse.newBuilder()
	        .setMessage("Appliance limit set to " + limit + " successfully.")
	        .build();

	    // Send the response back to the client
	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}


	@Override
	public StreamObserver<SetApplianceScheduleRequest> setApplianceSchedule(StreamObserver<SetApplianceScheduleResponse> responseObserver) {
	    return new StreamObserver<SetApplianceScheduleRequest>() {
	        private StringBuilder messageBuilder = new StringBuilder("Appliance schedule set: ");
	        private int count = 0;
	        
	        @Override
	        public void onNext(SetApplianceScheduleRequest request) {
	            // Implement code to set the appliance schedule based on the request parameters
	        	String applianceId = request.getApplianceId();
	            int startTime = (int) request.getStartTime();
	            int endTime = (int) request.getEndTime();
	            System.out.println("Setting appliance schedule from " + startTime + " to " + endTime + "...");
	            
	            // Append the schedule information to the response message
	            if (count > 0) {
	                messageBuilder.append(", ");
	            }
	            messageBuilder.append("Day ").append(": from ").append(startTime).append(" to ").append(endTime);
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
