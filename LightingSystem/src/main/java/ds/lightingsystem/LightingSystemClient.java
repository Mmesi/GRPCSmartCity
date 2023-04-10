package ds.lightingsystem;


import java.util.Scanner;

import ds.lightingsystem.LightingSystemGrpc.LightingSystemBlockingStub;
import ds.lightingsystem.LightingSystemGrpc.LightingSystemStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class LightingSystemClient {
	private static LightingSystemBlockingStub blockingStub;
	private static LightingSystemStub asyncStub;
	
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50063).usePlaintext().build();

		//stubs -- generate from proto
		blockingStub = LightingSystemGrpc.newBlockingStub(channel);

		asyncStub = LightingSystemGrpc.newStub(channel);


		
		setLightLevels();
		switchLight();
		
		setLightSchedule();
		channel.shutdown();
	}
	
	

	public static void setLightLevels() {
	
	StreamObserver<SetLightLevelsResponse> responseObserver = new StreamObserver<SetLightLevelsResponse>() {

		@Override
		public void onNext(SetLightLevelsResponse response) {
			 System.out.println("Status: " + response.getStatus());
             System.out.println("Message: " + response.getMessage());
		}

		@Override
		public void onError(Throwable t) {
			t.printStackTrace();
		}

		@Override
		public void onCompleted() {
			System.out.println("stream is completed");
		}

	};


	StreamObserver<SetLightLevelsRequest> requestObserver = asyncStub.setLightLevels(responseObserver);
	try {
		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L12").setIntensity(10).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L31").setIntensity(11).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L45").setIntensity(12).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L32").setIntensity(13).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L80").setIntensity(14).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L21").setIntensity(41).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L43").setIntensity(13).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L54").setIntensity(11).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L12").setIntensity(1).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId("L12").setIntensity(13).build());
		Thread.sleep(500);


		// Mark the end of requests
		requestObserver.onCompleted();

		
		Thread.sleep(10000);
		
	} catch (RuntimeException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {			
		e.printStackTrace();
	}


}
	private static void switchLight() {
		// TODO Auto-generated method stub
		System.out.println("Turn Light:\n 1. On\n 2. Off");
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		boolean status = false;
		if(mode==1) {
			status = true;
		}
		String lightId = "";
		SwitchLightRequest request = SwitchLightRequest.newBuilder()
                .setLightId(lightId)
                .setStatus(status)
                .build();
        
        SwitchLightResponse response = blockingStub.switchLight(request);
        
        System.out.println("Status: " + response.getLightState());
        System.out.println("Message: " + response.getMessage());
        
		
	}
	public static void setLightSchedule() {
		
		StreamObserver<SetLightScheduleResponse> responseObserver = new StreamObserver<SetLightScheduleResponse>() {

			@Override
			public void onNext(SetLightScheduleResponse response) {
				 System.out.println("Status: " + response.getStatus());
	             System.out.println("Message: " + response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed");
			}

		};
	StreamObserver<SetLightScheduleRequest> requestObserver = asyncStub.setLightSchedule(responseObserver);
	try {
		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId("L12").setStartTime(174233).setEndTime(182322).setIntensity(10).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId("L31").setStartTime(174233).setEndTime(182322).setIntensity(11).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId("L45").setStartTime(174233).setEndTime(182322).setIntensity(12).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId("L32").setStartTime(174233).setEndTime(182322).setIntensity(13).build());
		Thread.sleep(500);

		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId("L80").setStartTime(174233).setEndTime(182322).setIntensity(14).build());
		Thread.sleep(500);
		
		
requestObserver.onCompleted();

		
		Thread.sleep(10000);
		
	} catch (RuntimeException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {			
		e.printStackTrace();
	}
}
	}
