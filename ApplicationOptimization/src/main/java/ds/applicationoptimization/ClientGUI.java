package ds.applicationoptimization;

import javax.swing.*;

import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationBlockingStub;
import ds.applicationoptimization.ApplianceOptimizationGrpc.ApplicationOptimizationStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ClientGUI extends JFrame {

	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton modeBtn;
    private final JButton limitBtn;
    private final JButton scheduleBtn;
    private static JTextArea outputArea = new JTextArea();

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

		//stubs -- generate from protO
    	ClientGUI gui = new ClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    // Unary RPC to set appliance mode
    static void setApplianceMode() {
        String applianceId = JOptionPane.showInputDialog("Enter Appliance ID:");
        String[] choices = { "ECO", "ENERGY SAVING", "ON", "OFF"};
        String mode = (String) JOptionPane.showInputDialog(null, "Choose Mode...",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
        String location = JOptionPane.showInputDialog("Enter Location:");

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
        String applianceId = JOptionPane.showInputDialog("Enter Appliance ID:");
        String limitString = JOptionPane.showInputDialog("Enter Limit:");
        
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
    	
			String applianceId = JOptionPane.showInputDialog("Enter Appliance ID:");
			
			StreamObserver<SetApplianceScheduleResponse> responseObserver = new StreamObserver<SetApplianceScheduleResponse>() {
				int count =0 ;
			@Override
			public void onNext(SetApplianceScheduleResponse value) {
				updateOutput("Message: " + value.getMessage());
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
			@Override
			public void onCompleted() {
				System.out.println("Appliance Scheduling Completed ");
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

			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("refridgerator").setStartTime(10000).setEndTime(200000).build());
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("microwave").setStartTime(10000).setEndTime(200000).build());
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("dishwasher").setStartTime(10000).setEndTime(200000).build());
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("Air-conditioner").setStartTime(10000).setEndTime(200000).build());
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId("dryer").setStartTime(10000).setEndTime(200000).build());


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
		
	}  
       
