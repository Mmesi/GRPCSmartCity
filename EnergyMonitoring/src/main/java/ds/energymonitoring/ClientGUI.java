package ds.energymonitoring;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ds.energymonitoring.EnergyMonitoringGrpc;
import ds.energymonitoring.ClientGUI;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringBlockingStub;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ClientGUI extends JFrame {

	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton usageBtn;
    private final JButton sourceBtn;
    private final JButton historyBtn;
    private static JTextArea outputArea = new JTextArea();

    private static EnergyMonitoringBlockingStub blockingStub;
    private static EnergyMonitoringStub asyncStub;
    
    
    

    public ClientGUI() {

        super("Energy Monitoring Client");

        // Initialize GUI components
        title = new JLabel("Energy Usage Monitoring Client");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        usageBtn = new JButton("Retrieve Energy Usage");
        sourceBtn = new JButton("Retrieve Energy Usage by Source(Gas/Electricity");
        historyBtn = new JButton("Retrieve Energy Usage History Data");

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
        btnPanel.add(usageBtn);
        btnPanel.add(sourceBtn);
        btnPanel.add(historyBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Set up stubs
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50070).usePlaintext().build();
        blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);
        asyncStub = EnergyMonitoringGrpc.newStub(channel);
        // Add listeners to buttons
        usageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEnergyUsage();
                channel.shutdown();
            }
        });

        sourceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEnergyUsageBySource();
                channel.shutdown();
            }
        });

        historyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEnergyUsageHistory();
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
    static void getEnergyUsage() {
        String deviceId = JOptionPane.showInputDialog("Enter Device ID:");
        String startTimeString = JOptionPane.showInputDialog("Enter Start Time of Energy Usage:");
        String endTimeString = JOptionPane.showInputDialog("Enter End Time of Energy Usage:");
        long startTime = 0;
        long endTime = 0;
        
        try {
        	startTime = Long.parseLong(startTimeString);
        }
        catch(NumberFormatException e) {
        	updateOutput("Invalid input for Start Time.");
        	return;
        }
        try {
        	endTime = Long.parseLong(endTimeString);
        }
        catch(NumberFormatException e) {
        	updateOutput("Invalid input for End Time.");
        	return;
        }
        
        GetEnergyUsageRequest req = GetEnergyUsageRequest.newBuilder().setDeviceId(deviceId).setStartTime(startTime).setEndTime(endTime).build();

		GetEnergyUsageResponse response = blockingStub.getEnergyUsage(req);

		 updateOutput("Total: " + response.getTotalEnergyUsage() +  "\n Average: " + response.getAveragePowerConsumption());

    }

    // Unary RPC to set appliance limit
    static void getEnergyUsageBySource() {
    	String[] choices = { "GAS", "ELECTRICITY"};
        String sourceId= (String) JOptionPane.showInputDialog(null, "What Energy Source Data do you wish to Retrieve?",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
    	String startTimeString = JOptionPane.showInputDialog("Enter Start Time: ");
        String endTimeString = JOptionPane.showInputDialog("Enter End Time: ");
        long startTime = 0;
        long endTime = 0;
        
        
        try {
            startTime = Long.parseLong(startTimeString);           
    		
        } catch (NumberFormatException e) {
            updateOutput("Invalid input for Start Time.");
            return;
        }
        try {
            endTime = Long.parseLong(endTimeString);           
    		
        } catch (NumberFormatException e) {
            updateOutput("Invalid input for End Time.");
            return;
        }
        UsageBySourceRequest req = UsageBySourceRequest.newBuilder().setSourceId(sourceId).setStartTime(startTime).setEndTime(endTime).build();
	       
        StreamObserver<UsageBySourceResponse> responseObserver = new StreamObserver<UsageBySourceResponse>() {
        	@Override
            public void onNext(UsageBySourceResponse response) {
        		updateOutput("Energy usage for "+ sourceId + " "+ response.getEnergyUsage() +"kWh");
            }
        	@Override
            public void onError(Throwable t) {
                System.err.println("EnergyMonitoringClient error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
            	updateOutput("Streaming completed.");
            }
        };
        asyncStub.getEnergyUsageBySource(req, responseObserver);
        try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    static void getEnergyUsageHistory() {
		// TODO Auto-generated method stub
    	
    	String deviceId = JOptionPane.showInputDialog("Enter Device ID:");
			
    	GetEnergyUsageHistoryRequest request = GetEnergyUsageHistoryRequest.newBuilder()
                .setDeviceId(deviceId)
                .build();
	StreamObserver<EnergyUsageHistoryData> responseObserver = new StreamObserver<EnergyUsageHistoryData>() {
        @Override
        public void onNext(EnergyUsageHistoryData response) {
        	String date = String.valueOf(response.getDateTime());
        	updateOutput("Energy usage Data from "+ date + " is " + response.getEnergyUsage() + "kWh");
        }

        @Override
        public void onError(Throwable t) {
            System.err.println("EnergyMonitoringClient error: " + t.getMessage());
        }

        @Override
        public void onCompleted() {
        	updateOutput("Streaming completed.");
        }
    };
    asyncStub.getEnergyUsageHistory(request, responseObserver);
    try {
		Thread.sleep(15000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
}
