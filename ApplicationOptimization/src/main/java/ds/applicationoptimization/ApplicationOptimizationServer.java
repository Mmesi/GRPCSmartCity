package ds.applicationoptimization;

import java.io.IOException;


import ds.applicationoptimization.ApplicationOptimizationGrpc.ApplicationOptimizationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ApplicationOptimizationServer extends ApplicationOptimizationImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationOptimizationServer AOserver = new ApplicationOptimizationServer();
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
	public void setApplianceMode(SetApplianceModeRequest request,
			StreamObserver<SetApplianceModeResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.setApplianceMode(request, responseObserver);
	}

	@Override
	public void setApplianceLimit(SetApplianceLimitRequest request,
			StreamObserver<SetApplianceLimitResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.setApplianceLimit(request, responseObserver);
	}

	@Override
	public StreamObserver<SetApplianceScheduleRequest> setApplianceSchedule(
			StreamObserver<SetApplianceScheduleResponse> responseObserver) {
		// TODO Auto-generated method stub
		return super.setApplianceSchedule(responseObserver);
	}
	
	

}
