//GRAPHICAL USER INTERFACE FOR THE LIGHTINGSYSTEM SERVICE
package ds.lightingsystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;


import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
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

	//Declaring Variables
	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton levelsBtn;
    private final JButton switchBtn;
    private final JButton scheduleBtn;
    private static JTextArea outputArea = new JTextArea();
    static String host = "_lightingsystem._tcp.local.";//host DNS Address
	static int port;//port number
    static String resolvedIP;

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

      //Creating and defining a Panel and Adding the buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1));
        btnPanel.add(levelsBtn);
        btnPanel.add(switchBtn);
        btnPanel.add(scheduleBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        //method call to resolve and retrieve the IP Address and Port number
        testClientJMDNS();
          
        
        // Add listeners to buttons
        levelsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = LightingSystemGrpc.newBlockingStub(channel);
                asyncStub = LightingSystemGrpc.newStub(channel);
            	//calling the set Light Levels Method when button is clicked
                setLightLevels();
                channel.shutdown();
            }

			
        });

        switchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = LightingSystemGrpc.newBlockingStub(channel);
                asyncStub = LightingSystemGrpc.newStub(channel);
            	//calling the switch Light Method when button is clicked
                switchLight();
                channel.shutdown();
            }
        });

        scheduleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = LightingSystemGrpc.newBlockingStub(channel);
                asyncStub = LightingSystemGrpc.newStub(channel);
            	//calling the set Light Schedule Method when button is clicked
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

    
    private static class SampleListener implements ServiceListener {
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}
		@SuppressWarnings("deprecation")
		public void serviceResolved(ServiceEvent event) {
					System.out.println("Service resolved: " + event.getInfo());
			
                    ServiceInfo info = event.getInfo();
                    port = info.getPort();
                    resolvedIP = info.getHostAddress();                    
                    System.out.println("IP Resolved - " + resolvedIP + ":" + port);
		}
	}
	
	public static void testClientJMDNS() {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener(host, new SampleListener());

			// Wait a bit
            Thread.sleep(20000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

