package ds.lightingsystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.lightingsystem.ClientGUI;
import ds.lightingsystem.LightingSystemGrpc;
import ds.lightingsystem.LightingSystemGrpc.LightingSystemBlockingStub;
import ds.lightingsystem.LightingSystemGrpc.LightingSystemStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ClientGUI extends JFrame {

	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton levelsBtn;
    private final JButton switchBtn;
    private final JButton scheduleBtn;
    private static JTextArea outputArea = new JTextArea();

    private static LightingSystemBlockingStub blockingStub;
    private static LightingSystemStub asyncStub;
    
    
    

    public ClientGUI() {

        super("Light System Client");

        // Initialize GUI components
        title = new JLabel("Light System Client");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        levelsBtn = new JButton("Set Light Levels");
        switchBtn = new JButton("Switch Light");
        scheduleBtn = new JButton("Set Light Schedule");

        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add GUI components to JFrame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(title, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1));
        btnPanel.add(levelsBtn);
        btnPanel.add(switchBtn);
        btnPanel.add(scheduleBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Set up stubs
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50063).usePlaintext().build();
        blockingStub = LightingSystemGrpc.newBlockingStub(channel);
        asyncStub = LightingSystemGrpc.newStub(channel);
        // Add listeners to buttons
        levelsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLightLevels();
                channel.shutdown();
            }

			
        });

        switchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchLight();
                channel.shutdown();
            }
        });

        scheduleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLightSchedule();
                channel.shutdown();
            }

			
        });

        // Set JFrame properties
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		//stubs -- generate from protO
    	ClientGUI gui = new ClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    private void setLightLevels() {
    	StreamObserver<SetLightLevelsResponse> responseObserver = new StreamObserver<SetLightLevelsResponse>() {

    		@Override
    		public void onNext(SetLightLevelsResponse response) {
    			updateOutput("Status: " + response.getStatus());
    			updateOutput("Message: " + response.getMessage());
    		}

    		@Override
    		public void onError(Throwable t) {
    			t.printStackTrace();
    		}

    		@Override
    		public void onCompleted() {
    			updateOutput("stream is completed");
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
    	String[] choices = { "ON", "OFF"};
        String mode= (String) JOptionPane.showInputDialog(null, "Turn Light:\\n 1. On\\n 2. Off",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
    	
        String lightId = JOptionPane.showInputDialog(null,"Enter Light ID");

		boolean status = false;
		if(mode.equals("ON")) {
			status = true;
		}
		
		SwitchLightRequest request = SwitchLightRequest.newBuilder()
                .setLightId(lightId)
                .setStatus(status)
                .build();
        
        SwitchLightResponse response = blockingStub.switchLight(request);
        
        updateOutput("Status: " + response.getLightState());
        updateOutput("Message: " + response.getMessage());
        
		
	}
    private void setLightSchedule() {
		// TODO Auto-generated method stub
    	StreamObserver<SetLightScheduleResponse> responseObserver = new StreamObserver<SetLightScheduleResponse>() {

			@Override
			public void onNext(SetLightScheduleResponse response) {
				updateOutput("Status: " + response.getStatus());
				updateOutput("Message: " + response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				updateOutput("stream is completed");
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

		
		Thread.sleep(5000);
		
	} catch (RuntimeException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {			
		e.printStackTrace();
	}
		
	}

}
