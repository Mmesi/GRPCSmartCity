package ds.energymonitoring;

import java.util.Scanner;

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
			channel.shutdown();
			

		}


		//unary rpc
		public static void getEnergyUsage() {
			long num1 = 10;
			long num2 = 20;

			GetEnergyUsageRequest req = GetEnergyUsageRequest.newBuilder().setStartTime(num1).setEndTime(num2).build();

			GetEnergyUsageResponse response = blockingStub.getEnergyUsage(req);

			System.out.println("Total: " + response.getTotalEnergyUsage() +  "\n Average: " + response.getAveragePowerConsumption());
		}

		public static void getEnergyUsageBySource() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("What Energy Source Data do you wish to Retrieve?\n 1. Gas\n 2. Electricity");
			String source_id = sc.nextLine();
			System.out.println("What Start Date do you wish to retrieve from?");
			long start_time = sc.nextLong();
			sc.close();
			long end_time = System.currentTimeMillis();
			UsageBySourceRequest req = UsageBySourceRequest.newBuilder().setSourceId(source_id).setStartTime(start_time).setEndTime(end_time).build();
					       //CountDownLatch finishLatch = new CountDownLatch(1);

		        StreamObserver<UsageBySourceResponse> responseObserver = new StreamObserver<UsageBySourceResponse>() {
		            @Override
		            public void onNext(UsageBySourceResponse response) {
		                System.out.println("Energy usage: " + response.getEnergyUsage());
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


		}
	
