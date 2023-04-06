package ds.energymonitoring;

import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringBlockingStub;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EnergyMonitoringClient {
	private static EnergyMonitoringBlockingStub blockingStub;
	private static EnergyMonitoringStub asyncStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50060).usePlaintext().build();

			//stubs -- generate from proto
			blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);

			asyncStub = EnergyMonitoringGrpc.newStub(channel);


			
			getEnergyUsage();
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

		//blocking server-streaming
		

		}
	
