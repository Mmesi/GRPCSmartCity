package ds.lightingsystem;

import java.io.IOException;

import ds.energymonitoring.EnergyMonitoringServer;
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

	@Override
	public StreamObserver<SetLightLevelsRequest> setLightLevels(
			StreamObserver<SetLightLevelsResponse> responseObserver) {
		// TODO Auto-generated method stub
		return super.setLightLevels(responseObserver);
	}

	@Override
	public void switchLight(SwitchLightRequest request, StreamObserver<SwitchLightResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.switchLight(request, responseObserver);
	}

	@Override
	public StreamObserver<SetLightScheduleRequest> setLightSchedule(
			StreamObserver<SetLightScheduleResponse> responseObserver) {
		// TODO Auto-generated method stub
		return super.setLightSchedule(responseObserver);
	}
	

	}

