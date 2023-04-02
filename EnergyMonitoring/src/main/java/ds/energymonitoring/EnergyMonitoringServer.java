package ds.energymonitoring;

import java.io.IOException;

import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class EnergyMonitoringServer extends EnergyMonitoringImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnergyMonitoringServer EMserver = new EnergyMonitoringServer();
		int port = 50057;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(EMserver).build().start();
			System.out.println("Energy Monitoring Server started, listening on " + port);
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
	public void getEnergyUsage(GetEnergyUsageRequest request, StreamObserver<GetEnergyUsageResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.getEnergyUsage(request, responseObserver);
	}

	@Override
	public void getEnergyUsageBySource(UsageBySourceRequest request,
			StreamObserver<UsageBySourceResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.getEnergyUsageBySource(request, responseObserver);
	}

	@Override
	public void getEnergyUsageHistory(GetEnergyUsageHistoryRequest request,
			StreamObserver<EnergyUsageHistoryData> responseObserver) {
		// TODO Auto-generated method stub
		super.getEnergyUsageHistory(request, responseObserver);
	}
	

	


	}


