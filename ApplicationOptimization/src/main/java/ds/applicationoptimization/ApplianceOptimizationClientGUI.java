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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    static ArrayList<Long> startTimes = new ArrayList<>();//Arraylist that stores start Times
    static ArrayList<Long> endTimes = new ArrayList<>();//Arraylist that stores end Time
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
                try {
					channel.awaitTermination(10000, TimeUnit.SECONDS);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
    	
    	int pointer = 1;//variable to identify number of appliance entries
    	int result;//variable that holds the choice after adding an appliance
    	long startTime = 0;//initializing the startTime
        long endTime = 0;//Initializing the endTime
      //Creating an SpinnerDateModel instance of date selection using 
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy"));
        
      //Creating an instance of the LocalTime with midnight as value
        LocalTime midnight = LocalTime.of(0, 0, 0);
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
			do {
	            Object[] message = {"Date:", dateSpinner};
	            // Show the JSpinner in a JOptionPane dialog box
	            int choice = JOptionPane.showConfirmDialog(null, message, "Select a Start Time for "+applianceId, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	            
	            // Handle the user's choice
	            if (choice == JOptionPane.OK_OPTION) {
	                // Get the selected date from the JSpinner
	            	LocalDateTime selectedDate = LocalDateTime.of(((Date)dateSpinner.getValue()).toInstant().atZone(ZoneOffset.systemDefault()).toLocalDate(), midnight);
	                // Convert the LocalDate to epoch format
	                startTime = selectedDate.toEpochSecond(ZoneOffset.UTC);
	                
	            }
	            choice = JOptionPane.showConfirmDialog(null, message, "Select an End Time for "+applianceId, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
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
				startTimes.add(startTime);
				endTimes.add(endTime);
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
				updateOutput("Message:\n " + value.getMessage());
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
			requestObserver.onNext(SetApplianceScheduleRequest.newBuilder().setApplianceId(appliances.get(count)).setStartTime(startTimes.get(count)).setEndTime(endTimes.get(count)).build());
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


       
