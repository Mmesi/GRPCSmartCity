package ds.applicationoptimization;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationBlockingStub;
import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

	}
