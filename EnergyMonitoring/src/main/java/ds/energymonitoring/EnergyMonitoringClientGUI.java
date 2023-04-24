//GRAPHICAL USER INTERFACE FOR THE ENERGYMONITORING SERVICE
package ds.energymonitoring;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import ds.energymonitoring.EnergyMonitoringClientGUI;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringBlockingStub;
import ds.energymonitoring.EnergyMonitoringGrpc.EnergyMonitoringStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class EnergyMonitoringClientGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton usageBtn;
    private final JButton sourceBtn;
    private final JButton historyBtn;
    private static JTextArea outputArea = new JTextArea();
    static String host = "_energymonitoring._tcp.local.";//host DNS Address
	static int port;
    static String resolvedIP;

  //Declaring the stubs
    private static EnergyMonitoringBlockingStub blockingStub;
    private static EnergyMonitoringStub asyncStub;
    
    
    

    public EnergyMonitoringClientGUI() {

        super("Energy Monitoring Client");

        // Initialize GUI components
        title = new JLabel("Energy Usage Monitoring Client");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        //Adding buttons for the 3 methods
        usageBtn = new JButton("Retrieve Energy Usage");
        sourceBtn = new JButton("Retrieve Energy Usage by Source (Gas/Electricity)");
        historyBtn = new JButton("Retrieve Energy Usage History Data");

        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Adding GUI components to JFrame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(title, BorderLayout.NORTH);

        
        //Creating and defining a Panel and Adding the buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1));
        btnPanel.add(usageBtn);
        btnPanel.add(sourceBtn);
        btnPanel.add(historyBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        //method call to resolve and retrieve the IP Address and Port number
        testClientJMDNS();        
        
        
        // Adding listeners to buttons
        usageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//calling the getEnergyUsage Method when button is clicked
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);
                asyncStub = EnergyMonitoringGrpc.newStub(channel);
                getEnergyUsage();
                channel.shutdown();
            }
        });

        sourceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);
                asyncStub = EnergyMonitoringGrpc.newStub(channel);
            	//calling the getEnergyUsageBySource Method when button is clicked
                getEnergyUsageBySource();
                channel.shutdown();
            }
        });

        historyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Set up stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = EnergyMonitoringGrpc.newBlockingStub(channel);
                asyncStub = EnergyMonitoringGrpc.newStub(channel);
            	//Calling the getEnergyUsageHistory Method when button is clicked
                getEnergyUsageHistory();
                channel.shutdown();
            }
        });

        // Setting the JFrame properties
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    //Main Method
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	//Starting the Interface
    	EnergyMonitoringClientGUI gui = new EnergyMonitoringClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    // Implementation of Unary RPC to get Energy Usage mode
    static void getEnergyUsage() {
        String deviceId = "";//initializing deviceId
        
        //Error Handling for wrong input for deviceId 
        do{
        	deviceId = JOptionPane.showInputDialog("Enter Device ID: eg. television, fan, etc");
        	try{
        		
        		if(deviceId.length()==0) {
        			throw new InvalidEntryException();
        		}
        	}
        	catch(InvalidEntryException e){
        		JOptionPane.showMessageDialog(null, e.getMessage());
        	}
        }while(deviceId.length()==0);
        
             
        
        long startTime = 0;//initializing the startTime
        long endTime = 0;//Initializing the endTime
      //Creating an instance of the LocalTime with midnight as value
        LocalTime midnight = LocalTime.of(0, 0, 0);
        
        //Creating an SpinnerDateModel instance of date selection using 
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy"));
        
        
        do {
        Object[] message = {"Date:", dateSpinner};
        // Show the JSpinner in a JOptionPane dialog box
        int choice = JOptionPane.showConfirmDialog(null, message, "Select a Start Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Handle the user's choice
        if (choice == JOptionPane.OK_OPTION) {
            // Get the selected date from the JSpinner
        	LocalDateTime selectedDate = LocalDateTime.of(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate(), midnight);
            // Convert the LocalDate to epoch format
            startTime = selectedDate.toEpochSecond(ZoneOffset.UTC);
            
        }
        choice = JOptionPane.showConfirmDialog(null, message, "Select an End Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
     // Handle the user's choice
        if (choice == JOptionPane.OK_OPTION) {
            // Get the selected date from the JSpinner
            LocalDateTime selectedDate = LocalDateTime.of(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate(), midnight);
            // Convert the LocalDate to epoch format
            endTime = selectedDate.toEpochSecond(ZoneOffset.UTC);
        }
         
        
        //if the start time is later than the end time
        if(startTime>endTime) {
        	JOptionPane.showMessageDialog(null, "Start time cannot be later than End Time");
        }
        }while(startTime>endTime);//loop if start time is later than the end time
        
        
        //Sending request to the server 
        GetEnergyUsageRequest req = GetEnergyUsageRequest.newBuilder().setDeviceId(deviceId).setStartTime(startTime).setEndTime(endTime).build();
        
        //Receiving the response from the server
		GetEnergyUsageResponse response = blockingStub.getEnergyUsage(req);
		
		float totalEnergyUsage = response.getTotalEnergyUsage();
		
		if(totalEnergyUsage==0) {
			updateOutput("No Usage Data Available");
		}
		else
		//Outputting the result to the console
		 updateOutput("Total Energy Usage: " + totalEnergyUsage +  "Kwh\n Average for period: " + response.getAveragePowerConsumption()+"Kwh");

    }

    // Implementation of the server streaming method getEnergyUsageBySource
    static void getEnergyUsageBySource() {
    	String[] choices = { "GAS", "ELECTRICITY"};
    	
    	//Reading the sourceID from a dropdown list
        String sourceId= (String) JOptionPane.showInputDialog(null, "What Energy Source Data do you wish to Retrieve?",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
        
      
        
        long startTime = 0;//initializing the startTime
        long endTime = 0;//Initializing the endTime
      //Creating an instance of the LocalTime with midnight as value
        LocalTime midnight = LocalTime.of(0, 0, 0);
        
        //Creating an SpinnerDateModel instance of date selection using 
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy"));
        
        
        do {
        Object[] message = {"Date:", dateSpinner};
        // Show the JSpinner in a JOptionPane dialog box
        int choice = JOptionPane.showConfirmDialog(null, message, "Select a Start Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        // Handle the user's choice
        if (choice == JOptionPane.OK_OPTION) {
            // Get the selected date from the JSpinner
        	LocalDateTime selectedDate = LocalDateTime.of(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate(), midnight);
            // Convert the LocalDate to epoch format
            startTime = selectedDate.toEpochSecond(ZoneOffset.UTC);
            
        }
        choice = JOptionPane.showConfirmDialog(null, message, "Select an End Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
     // Handle the user's choice
        if (choice == JOptionPane.OK_OPTION) {
            // Get the selected date from the JSpinner
            LocalDateTime selectedDate = LocalDateTime.of(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate(), midnight);
            // Convert the LocalDate to epoch format
            endTime = selectedDate.toEpochSecond(ZoneOffset.UTC);
        }
         
        
        //if the start time is later than the end time
        if(startTime>endTime) {
        	JOptionPane.showMessageDialog(null, "Start time cannot be later than End Time");
        }
        }while(startTime>endTime);//loop if start time is later than the end time
        
        
        //Sending request to the server
        UsageBySourceRequest req = UsageBySourceRequest.newBuilder().setSourceId(sourceId).setStartTime(startTime).setEndTime(endTime).build();
	       
        
        //Receiving response from the server
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
    
   //Implementation of the server stream method- get Energy Usage History 
    static void getEnergyUsageHistory() {
		// TODO Auto-generated method stub
    	
    	String deviceId = "";//Initializing the deviceID
    	
    	//Error Handling for wrong input for deviceId 
        do{
        	deviceId = JOptionPane.showInputDialog("Enter Device ID:");
        	try{
        		
        		if(deviceId.length()==0) {
        			throw new InvalidEntryException();
        		}
        	}
        	catch(InvalidEntryException e){
        		JOptionPane.showMessageDialog(null, e.getMessage());
        	}
        }while(deviceId.length()==0);
			
       
        //Sending request to server
    	GetEnergyUsageHistoryRequest request = GetEnergyUsageHistoryRequest.newBuilder()
                .setDeviceId(deviceId)
                .build();
    	updateOutput("Available Energy usage Data for "+deviceId+" per year Till: ");
    //Receiving the Stream Response from the Server
	StreamObserver<EnergyUsageHistoryData> responseObserver = new StreamObserver<EnergyUsageHistoryData>() {
        @Override
        
        public void onNext(EnergyUsageHistoryData response) {
        	
        	Long dateMiilis = response.getDateTime();
        	Date date = new Date(dateMiilis);
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        	String dateString = dateFormat.format(date);
        	
        	updateOutput(" "+dateString + " is " + response.getEnergyUsage() + "kWh");
        	}

        @Override
        //Error Handling
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
    
  //Service Listener that derives IP and Port number based on the DNS Address
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
    
    
	//Creating and adding the service using JMDNS
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
