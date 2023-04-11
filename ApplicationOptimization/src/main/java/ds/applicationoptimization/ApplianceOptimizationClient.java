package ds.applicationoptimization;

import java.util.Random;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationBlockingStub;
import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ApplianceOptimizationClient {
		private static ApplicationOptimizationBlockingStub blockingStub;
		private static ApplicationOptimizationStub asyncStub;

		public static void main(String[] args) {
			// TODO Auto-generated method stub

				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50058).usePlaintext().build();

				//stubs -- generate from proto
				blockingStub = ApplianceOptimizationGrpc.newBlockingStub(channel);

				asyncStub = ApplianceOptimizationGrpc.newStub(channel);


				
				setApplianceMode();
				setApplianceLimit();
				setApplianceSchedule();
				channel.shutdown();
				

		}
			
			//unary rpc
			public static void setApplianceMode() {
				String applianceId = "refridgerator";
				String mode = "Energy Saving";
				String location = "Sitting Room";

				SetApplianceModeRequest req = SetApplianceModeRequest.newBuilder().setApplianceId(applianceId).setMode(mode).setLocation(location).build();

				SetApplianceModeResponse response = blockingStub.setApplianceMode(req);

				System.out.println("Status: " + response.getStatus() +  "\n Message: " + response.getMessage());
			}
			
			
	
			private static void setApplianceLimit() {
				// TODO Auto-generated method stub
				String applianceId = "refridgerator";
				float limit = 10.0f;
				SetApplianceLimitRequest req = SetApplianceLimitRequest.newBuilder().setApplianceID(applianceId).setLimit(limit).build();
				SetApplianceLimitResponse response = blockingStub.setApplianceLimit(req);
				System.out.println("Status: " + response.getStatus() +  "\n Message: " + response.getMessage());
			}
			
			
			private static void setApplianceSchedule() {
				// TODO Auto-generated method stub
				StreamObserver<SetApplianceScheduleResponse> responseObserver = new StreamObserver<SetApplianceScheduleResponse>() {
					int count =0 ;
					
					@Override
					public void onNext(SetApplianceScheduleResponse value) {
						System.out.println("Message: " + value.getMessage());
						count += 1;
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}
					@Override
					public void onCompleted() {
						System.out.println("Appliance Scheduling Completed ");
						
						//completed too
					}
					
				};
				StreamObserver<SetApplianceScheduleRequest> requestObserver = asyncStub.setApplianceSchedule(responseObserver);
				try {

					requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("refridgerator").setStartTime(10000).setEndTime(200000).build());
					requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("microwave").setStartTime(10000).setEndTime(200000).build());
					requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("dishwasher").setStartTime(10000).setEndTime(200000).build());
					requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("Air-conditioner").setStartTime(10000).setEndTime(200000).build());
					requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("dryer").setStartTime(10000).setEndTime(200000).build());


					// Mark the end of requests
					requestObserver.onCompleted();


					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);


				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}



				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
}

