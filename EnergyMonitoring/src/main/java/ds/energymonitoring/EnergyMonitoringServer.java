package ds.energymonitoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringImplBase;
import ds.energymonitoring.GetEnergyUsageResponse.Builder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class EnergyMonitoringServer extends EnergyMonitoringImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnergyMonitoringServer EMserver = new EnergyMonitoringServer();
		int port = 50060;
		
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
		final EnergyUsageRepository energyRepository = new EnergyUsageRepository() ;
	    String deviceId = request.getDeviceId();
	    long startTimeMillis = request.getStartTime() * 1000 + request.getStartTime() / 1000000;
	    long endTimeMillis = request.getEndTime() * 1000 + request.getEndTime() / 1000000;
	    List<EnergyUsage> energyUsageList = energyRepository.getEnergyUsage(deviceId, startTimeMillis, endTimeMillis);

	    float totalEnergyUsage = 0.0f;
	    float totalPowerConsumption = 0.0f;

	    for (EnergyUsage energyUsage : energyUsageList) {
	        totalEnergyUsage += energyUsage.getUsage();
	        totalPowerConsumption += energyUsage.getPowerConsumption();
	        }

	    float averagePowerConsumption = totalPowerConsumption / energyUsageList.size();

	    GetEnergyUsageResponse response = GetEnergyUsageResponse.newBuilder().setTotalEnergyUsage(totalEnergyUsage).setAveragePowerConsumption(averagePowerConsumption).build();

	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
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


