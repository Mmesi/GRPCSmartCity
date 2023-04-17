//GRAPHICAL USER INTERFACE FOR THE APPLIANCEOPTIMIZATION SERVICE
package ds.applicationoptimization;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationBlockingStub;
import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

public class ClientGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton modeBtn;
    private final JButton limitBtn;
    private final JButton scheduleBtn;
    private static JTextArea outputArea = new JTextArea();
    static String host = "_applianceoptimation._tcp.local.";
	static int port;
    static String resolvedIP;
    static ArrayList<String> appliances = new ArrayList<>();

    private static ApplicationOptimizationBlockingStub blockingStub;
    private static ApplicationOptimizationStub asyncStub;
    
    
    

    public ClientGUI() {

        super("Appliance Optimization Client");

        // Initialize GUI components
        title = new JLabel("Appliance Optimization Client");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        modeBtn = new JButton("Set Appliance Mode");
        limitBtn = new JButton("Set Appliance Limit");
        scheduleBtn = new JButton("Set Appliance Schedule");

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
        btnPanel.add(modeBtn);
        btnPanel.add(limitBtn);
        btnPanel.add(scheduleBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Set up stubs
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50058).usePlaintext().build();
        blockingStub = ApplianceOptimizationGrpc.newBlockingStub(channel);
        asyncStub = ApplianceOptimizationGrpc.newStub(channel);
        // Add listeners to buttons
        modeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setApplianceMode();
                channel.shutdown();
            }
        });

        limitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setApplianceLimit();
                channel.shutdown();
            }
        });

        scheduleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setApplianceSchedule();
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

		//starting the interface
    	ClientGUI gui = new ClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area of the USer Interface with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    // Unary RPC to set appliance mode
    static void setApplianceMode() {
    	String applianceId ="";
    	String location = "";
    	do {   	
    		applianceId = JOptionPane.showInputDialog("Enter Appliance ID:");
			try{
				if(applianceId.length() == 0){
					throw new InvalidEntryException();//if appliance name is not given
			}
		}catch (InvalidEntryException e) {
			    JOptionPane.showMessageDialog(null, e.getMessage());//print error message
			}
		}while(applianceId.length()==0);
        String[] choices = { "ECO", "ENERGY SAVING", "ON", "OFF"};
        String mode = (String) JOptionPane.showInputDialog(null, "Choose Mode...",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
        do {
        location = JOptionPane.showInputDialog("Enter Location:");
        try {
        	if(location.length() == 0) {
        		throw new InvalidEntryException();
        	}
        }
        	catch (InvalidEntryException e) {
			    JOptionPane.showMessageDialog(null, e.getLocationmessage());//print error message
			}
		}while(location.length()==0);

        SetApplianceModeRequest req = SetApplianceModeRequest.newBuilder()
                .setApplianceId(applianceId)
                .setMode(mode)
                .setLocation(location)
                .build();

        SetApplianceModeResponse response = blockingStub.setApplianceMode(req);

        updateOutput("Status: " + response.getStatus() + "\nMessage: " + response.getMessage());
    }

    // Unary RPC to set appliance limit
    static void setApplianceLimit() {
    	String applianceId = "";
        do{
        	applianceId = JOptionPane.showInputDialog("Enter Appliance ID:");
        	try {
        		if(applianceId.length()==0) {
        			throw new InvalidEntryException();
        		}
        	}
        	catch(InvalidEntryException e) {
        		JOptionPane.showMessageDialog(null, e.getMessage());
        	}
        }while(applianceId.length()==0);
        String limitString = JOptionPane.showInputDialog("Enter Limit in Kwh:");
        
        try {
            float limit = Float.parseFloat(limitString);
            SetApplianceLimitRequest req = SetApplianceLimitRequest.newBuilder().setApplianceID(applianceId).setLimit(limit).build();
    		SetApplianceLimitResponse response = blockingStub.setApplianceLimit(req);
    		updateOutput("Status: " + response.getStatus() +  "\n Message: " + response.getMessage());
        } catch (NumberFormatException e) {
            updateOutput("Invalid input for limit.");
            return;
        }
           
    }
    static void setApplianceSchedule() {
		// TODO Auto-generated method stub
    	ArrayList<Long> startTimes = new ArrayList<>();
    	ArrayList<Long> endTimes = new ArrayList<>();
    	int pointer = 1;
    	int result;
    	String applianceId;
    	do
    		{
    		do {   	
			applianceId = JOptionPane.showInputDialog("Enter ID for Appliance " + pointer+ ":");
			try{
				if(applianceId.length() == 0){
					throw new InvalidEntryException();//if appliance names is not given
			}
		}catch (InvalidEntryException e) {
			    JOptionPane.showMessageDialog(null, e.getMessage());//print error message
			}
		}while(applianceId.length()==0);
			appliances.add(applianceId);
			pointer++;
			String[] options = {"Add New Appliance", "Proceed"};

	        result = JOptionPane.showOptionDialog(
	                null,
	                "Do you wish to add another Appliance:",
	                "Selection Option",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.INFORMATION_MESSAGE,
	                null,
	                options,
	                options[0]);
			
    	} while(result==0);    	
			
		StreamObserver<SetApplianceScheduleResponse> responseObserver = new StreamObserver<SetApplianceScheduleResponse>() {
			@Override
			public void onNext(SetApplianceScheduleResponse value) {
				updateOutput("Message: " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
			@Override
			public void onCompleted() {
				updateOutput("Appliance Scheduling Completed ");
			}		
		};
	

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StreamObserver<SetApplianceScheduleRequest> requestObserver = asyncStub.setApplianceSchedule(responseObserver);
		try {
			int count = 0;
			do {
			updateOutput(appliances.get(count));
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId(appliances.get(count)).setStartTime(10000).setEndTime(200000).build());
			count++;
			} while(count<appliances.size());
			
			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


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


       
