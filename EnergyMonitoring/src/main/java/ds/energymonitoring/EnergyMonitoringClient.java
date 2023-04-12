package ds.energymonitoring;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringBlockingStub;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class EnergyMonitoringClient {
	private static EnergyMonitoringBlockingStub blockingStub;
	private static EnergyMonitoringStub asyncStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50070).usePlaintext().build();

			//stubs -- generate from proto
			blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);

			asyncStub = EnergyMonitoringGrpc.newStub(channel);


			
			getEnergyUsage();
			getEnergyUsageBySource();
			getEnergyUsageHistory();
			channel.shutdown();
			

		}




		//unary rpc
		public static void getEnergyUsage() {
			long startTime = 10;
			long endTime = 20;

			GetEnergyUsageRequest req = GetEnergyUsageRequest.newBuilder().setStartTime(startTime).setEndTime(endTime).build();

			GetEnergyUsageResponse response = blockingStub.getEnergyUsage(req);

			System.out.println("Total: " + response.getTotalEnergyUsage() +  "\n Average: " + response.getAveragePowerConsumption());
		}

		public static void getEnergyUsageBySource() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("What Energy Source Data do you wish to Retrieve?\n 1. Gas\n 2. Electricity");
			String source_id = sc.nextLine();
			long start_time = System.currentTimeMillis();
			sc.close();
			long end_time = System.currentTimeMillis() + 1000;
			UsageBySourceRequest req = UsageBySourceRequest.newBuilder().setSourceId(source_id).setStartTime(start_time).setEndTime(end_time).build();
					       
		        StreamObserver<UsageBySourceResponse> responseObserver = new StreamObserver<UsageBySourceResponse>() {
		            @Override
		            public void onNext(UsageBySourceResponse response) {
		                System.out.println("Energy usage for "+ (source_id.equals("1") ? "Gas" : "Electricity") + " "+ response.getEnergyUsage() +"kWh");
		            }

		            @Override
		            public void onError(Throwable t) {
		                System.err.println("EnergyMonitoringClient error: " + t.getMessage());
		            }

		            @Override
		            public void onCompleted() {
		                System.out.println("Streaming completed.");
		            }
		        };
		        asyncStub.getEnergyUsageBySource(req, responseObserver);
		        try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		        
		}
		private static void getEnergyUsageHistory() {
			String deviceId = "Toaster";
			 GetEnergyUsageHistoryRequest request = GetEnergyUsageHistoryRequest.newBuilder()
	                    .setDeviceId(deviceId)
	                    .build();
			StreamObserver<EnergyUsageHistoryData> responseObserver = new StreamObserver<EnergyUsageHistoryData>() {
	            @Override
	            public void onNext(EnergyUsageHistoryData response) {
	            	String date = String.valueOf(response.getDateTime());
	                System.out.println("Energy usage Data from "+ date + " is " + response.getEnergyUsage() + "kWh");
	            }

	            @Override
	            public void onError(Throwable t) {
	                System.err.println("EnergyMonitoringClient error: " + t.getMessage());
	            }

	            @Override
	            public void onCompleted() {
	                System.out.println("Streaming completed.");
	            }
	        };
	        asyncStub.getEnergyUsageHistory(request, responseObserver);
	        try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		}
	
