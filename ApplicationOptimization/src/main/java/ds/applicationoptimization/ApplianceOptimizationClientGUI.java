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

public class ApplianceOptimizationClientGUI extends JFrame {

	/**Declaring and Initializing variables
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
    private final JLabel title;
    private final JButton modeBtn;
    private final JButton limitBtn;
    private final JButton scheduleBtn;
    private static JTextArea outputArea = new JTextArea();
    static String host = "_applianceoptimization._tcp.local.";//host DNS Address
	static int port;
    static String resolvedIP;
    static ArrayList<String> appliances = new ArrayList<>();//Arraylist that stores applianceIDs

    //Declaring the stubs
    private static ApplicationOptimizationBlockingStub blockingStub;
    private static ApplicationOptimizationStub asyncStub;
    
    
    

    public ApplianceOptimizationClientGUI() {

        super("Appliance Optimization Client");

        // Initialize GUI components
        title = new JLabel("Appliance Optimization Client");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        
        //Initializing the buttons for the 3 methods
        modeBtn = new JButton("Set Appliance Mode");
        limitBtn = new JButton("Set Appliance Limit");
        scheduleBtn = new JButton("Set Appliance Schedule");

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
        btnPanel.add(modeBtn);
        btnPanel.add(limitBtn);
        btnPanel.add(scheduleBtn);
        contentPane.add(btnPanel, BorderLayout.WEST);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        
      //method call to resolve and retrieve the IP Address and Port number
        testClientJMDNS();
        
        
        
        
        
        
        // Adding listeners to buttons
        modeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//calling the set Appliance mode Method when button is clicked
            	// Setting up the stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = ApplianceOptimizationGrpc.newBlockingStub(channel);
                asyncStub = ApplianceOptimizationGrpc.newStub(channel);
                setApplianceMode(); 
                channel.shutdown();
            }
        });

        limitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Setting up the stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = ApplianceOptimizationGrpc.newBlockingStub(channel);
                asyncStub = ApplianceOptimizationGrpc.newStub(channel);
            	//calling the set Appliance limit Method when button is clicked
                setApplianceLimit();
                channel.shutdown();
            }
        });

        scheduleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// Setting up the stubs
                ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
                blockingStub = ApplianceOptimizationGrpc.newBlockingStub(channel);
                asyncStub = ApplianceOptimizationGrpc.newStub(channel);
                
            	//calling the set Appliance Schedule Method when button is clicked
                setApplianceSchedule();
                channel.shutdown();
            }
        });

        // Setting JFrame properties
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    //Main Method
    public static void main(String[] args) {
	

		//starting the interface
    	ApplianceOptimizationClientGUI gui = new ApplianceOptimizationClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area of the User Interface with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    //Defining the Unary RPC method to set appliance mode
    static void setApplianceMode() {
    	String applianceId ="";//initializing appliance id
    	String location = "";//initializing location
    	
    	/*Input request for applianceID with Invalid Entry Error handling
    	 * 
    	 */
    	
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
    	
    	
    	//A drop down list to choose the mode
        String[] choices = { "ECO", "ENERGY SAVING", "ON", "OFF"};
        String mode = (String) JOptionPane.showInputDialog(null, "Choose Mode...",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
        
        /*Input request for Location with Invalid Entry Error handling
    	 * 
    	 */
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

        
        //Sending request to server
        SetApplianceModeRequest req = SetApplianceModeRequest.newBuilder()
                .setApplianceId(applianceId)
                .setMode(mode)
                .setLocation(location)
                .build();

        //Receiving response from the server
        SetApplianceModeResponse response = blockingStub.setApplianceMode(req);

        updateOutput("Status: " + response.getStatus() + "\nMessage: " + response.getMessage());
    }

    //Defining the Unary RPC method to set appliance limit
    static void setApplianceLimit() {
    	String applianceId = "";//initializing application Id
    	
    	
    	//Input request for applianceID with Invalid Entry Error handling
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
        
        //Input Request for limit
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
    
    
  //Defining the Bidirectional RPC method to set Appliance schedule
    static void setApplianceSchedule() {
		// TODO Auto-generated method stub
    	//ArrayList<Long> startTimes = new ArrayList<>();
    	//ArrayList<Long> endTimes = new ArrayList<>();
    	int pointer = 1;//variable to identical number of appliance entries
    	int result;//variable that holds the choice after adding an appliance
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
		}while(applianceId.length()==0);//repeat applianceId input request if ID not given
			appliances.add(applianceId);
			pointer++;
			String[] options = {"Add New Appliance", "Proceed"};//options for the selection buttons

			//variable for choice of selection buttons
	        result = JOptionPane.showOptionDialog(
	                null,
	                "Do you wish to add another Appliance:",
	                "Selection Option",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.INFORMATION_MESSAGE,
	                null,
	                options,
	                null);
			
    	} while(result==0);//while loop performs if choice is Add New Appliance    	
			
    	
    	//stream response from server
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
		
		//stream request to server
		StreamObserver<SetApplianceScheduleRequest> requestObserver = asyncStub.setApplianceSchedule(responseObserver);
		try {
			int count = 0;
			do {
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId(appliances.get(count)).setStartTime(10000).setEndTime(200000).build());
			count++;
			} while(count<appliances.size());//
			
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


       
