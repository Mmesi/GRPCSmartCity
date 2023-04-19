//GRAPHICAL USER INTERFACE FOR THE LIGHTINGSYSTEM SERVICE
package ds.lightingsystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;

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

import ds.lightingsystem.InvalidEntryException;
import ds.lightingsystem.LightingSystemClientGUI;
import ds.lightingsystem.LightingSystemGrpc;
import ds.lightingsystem.LightingSystemGrpc.LightingSystemBlockingStub;
import ds.lightingsystem.LightingSystemGrpc.LightingSystemStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class LightingSystemClientGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    
    static ArrayList<String> systems = new ArrayList<>();//Arraylist that stores deviceIDs
    static ArrayList<Integer> intensities = new ArrayList<>();//arraylist that stores intensity levels
    static ArrayList<String> systemschedules = new ArrayList<>();
    static ArrayList<Long> startTimes = new ArrayList<>();
    static ArrayList<Long> endTimes = new ArrayList<>();
    static ArrayList<Integer> intensityschedule = new ArrayList<>();
    
    

    public LightingSystemClientGUI() {

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
    //Main Method
    public static void main(String[] args) {
		// TODO Auto-generated method stub

    	//Starting the Interface
    	LightingSystemClientGUI gui = new LightingSystemClientGUI();
    	gui.frame.setVisible(true);
					

	}
	// Method to update output area with text
    static void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    //Method call for setLightLevels from the server
    private void setLightLevels() {
    	
    		int pointer = 1;//variable to identify number of system2 entries
        	int result;//variable that holds the choice after adding a system
        	String systemId="";
        	int intensity;//variable that carries the intensity value
        	
        	//do while loop performs if option selected is "Add another System"
        	do
        		{
        		//do while performs if no system id id entered
        		do {   	
        		systemId = JOptionPane.showInputDialog("Enter ID for System " + pointer+ ":");
    			try{//check if any ID is entered
    				if(systemId.length() == 0){
    					throw new InvalidEntryException();//if device Id is not given
    			}
    		}catch (InvalidEntryException e) {
    			    JOptionPane.showMessageDialog(null, e.getMessage());//print error message
    			}
    		}while(systemId.length()==0);//repeat systemId input request if ID not given
    			systems.add(systemId);//add systemId to the arraylist
    			
    			
    			//do while performs if an invalid entry is made for the intensity
    			do {
    				intensity=-1;//initialize intensity to -1
    				try{//check if the entry for intensity is valid
    					
    					intensity = Integer.parseInt(JOptionPane.showInputDialog("Enter a number for Level of Intensity for System "+pointer));
    				}
    				catch(NumberFormatException e) {
    					JOptionPane.showMessageDialog(null,"Invalid Entry for Intensity");
    				}
    				
    			}while(!(intensity>=0));
    			intensities.add(intensity);//add intensity to the arraylist 
    			pointer++;//increase pointer
    			String[] options = {"Add New Device", "Proceed"};//options for the selection buttons

    			//variable for choice of selection buttons
    	        result = JOptionPane.showOptionDialog(
    	                null,
    	                "Do you wish to add another Device:",
    	                "Selection Option",
    	                JOptionPane.DEFAULT_OPTION,
    	                JOptionPane.INFORMATION_MESSAGE,
    	                null,
    	                options,
    	                null);
    			
        	} while(result==0);//while loop performs if choice is Add New Appliance    	
    		
        	
        	//generate response from server
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

    	//Stream request to the server
    	StreamObserver<SetLightLevelsRequest> requestObserver = asyncStub.setLightLevels(responseObserver);
    	try {
    		int count = 0;
    		do{//retrieve system IDs and intensity levels from arraylist to be sent to server
    			requestObserver.onNext(SetLightLevelsRequest.newBuilder().setSystemId(systems.get(count)).setIntensity(intensities.get(count)).build()); 		
    		Thread.sleep(500);
    		count++;
    		}while(count<systems.size());

    		// Mark the end of requests
    		requestObserver.onCompleted();

    		
    		Thread.sleep(10000);
    		
    	} catch (RuntimeException e) {
    		e.printStackTrace();
    	} catch (InterruptedException e) {			
    		e.printStackTrace();
    	}
		
	}
    
    
    //Method call to switch light off or on
    private static void switchLight() {
   
		
    	String[] choices = { "ON", "OFF"};//choice to turn light on or off
    	String lightId="";//variable that stores the light IDs
    	
    	do{//repeat if the ID is empty
        	lightId = JOptionPane.showInputDialog(null,"Enter Light ID");
        	try {
        		if(lightId.length()==0) {
        			throw new InvalidEntryException();
        		}
        	}
        	catch(InvalidEntryException e){
        		JOptionPane.showMessageDialog(null, e.getMessage());
        	}
        }while(lightId.length()==0);
    	//drop down list
        String mode= (String) JOptionPane.showInputDialog(null, "Turn Light: On or Off",
            "", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
    	
        

		boolean status = false;
		if(mode.equals("ON")) {
			status = true;//set status to true if mode choice is ON
		}
		
		//send request to Server
		SwitchLightRequest request = SwitchLightRequest.newBuilder()
                .setLightId(lightId)
                .setStatus(status)
                .build();
        
		//retrieve request from Server
        SwitchLightResponse response = blockingStub.switchLight(request);
        
        updateOutput("Status: " + response.getLightState());
        updateOutput("Message: " + response.getMessage());
        
		
	}
    
    //Method call for setLightSchedule
    private void setLightSchedule() {
    	String systemId = "";
    	int pointer = 1;
    	int result;
    	int intensity;
    	long startTime = 0;
    	long endTime = 0;
    	do
		{
		do {   	
		systemId = JOptionPane.showInputDialog("Enter ID for System " + pointer+ ":");
		try{
			if(systemId.length() == 0){
				throw new InvalidEntryException();//if system name is not given
		}
	}catch (InvalidEntryException e) {
		    JOptionPane.showMessageDialog(null, e.getMessage());//print error message
		}
	}while(systemId.length()==0);//repeat systemId input request if ID not given
		systemschedules.add(systemId);
		do {
			startTime= -1;//initialize startTime to -1
			try{//check if the entry for intensity is valid
				
				startTime = Long.parseLong(JOptionPane.showInputDialog("Enter a Start Time for System "+pointer));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Invalid Entry for Start Time");
			}
			
		}while(!(startTime>=0));
		startTimes.add(startTime);//add startTime to arraylist
		
		do {
			endTime=-1;//initialize endtime  to -1
			try{//check if the entry for intensity is valid
				
				endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter an End Time for System "+pointer));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Invalid Entry for End Time");
			}
			
		}while(!(endTime>=0));
		endTimes.add(endTime);//add endTime to arraylist
		
		do {
			intensity=-1;//initialize intensity to -1
			try{//check if the entry for intensity is valid
				
				intensity = Integer.parseInt(JOptionPane.showInputDialog("Enter a number for Level of Intensity for System "+pointer));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Invalid Entry for Intensity");
			}
			
		}while(!(intensity>=0));
		intensityschedule.add(intensity);
		pointer++;
		String[] options = {"Add New Appliance", "Proceed"};//options for the selection buttons

		//variable for choice of selection buttons
        result = JOptionPane.showOptionDialog(
                null,
                "Do you wish to add another System:",
                "Selection Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                null);
		
	} while(result==0);//while loop performs if choice is Add New Appliance
		
    	
    	//Initiating response from server
    	StreamObserver<SetLightScheduleResponse> responseObserver = new StreamObserver<SetLightScheduleResponse>() {

    		
    		//Get Status and message 
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
		
	//Stream request to Server
	StreamObserver<SetLightScheduleRequest> requestObserver = asyncStub.setLightSchedule(responseObserver);
	try {
		int count = 0;//this is used to get the entries in all the arrays
		
		do {//loop that retrieves all the entries in the arraylists and sends requests
		requestObserver.onNext(SetLightScheduleRequest.newBuilder().setSystemId(systemschedules.get(count)).setStartTime(startTimes.get(count)).setEndTime(endTimes.get(count)).setIntensity(intensityschedule.get(count)).build());
		Thread.sleep(500);
		count++;
		}while(count<systemschedules.size());

		
	//Stream completed	
     requestObserver.onCompleted();

		
		Thread.sleep(5000);
		
		
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

