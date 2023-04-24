package ds.energymonitoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EnergyUsageRepository{
	public EnergyUsageRepository(){
		new HashMap<>();
	}

	//Method that returns energy usage data
    public List<EnergyUsage> getEnergyUsage(String deviceId, long startTime, long endTime) throws FileNotFoundException, IOException {
        
    	//Create an array list of type EnergyUsage
    	List<EnergyUsage> usageData = new ArrayList<>();

    	
    	//Read repository from the local machine
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Mmesi\\Desktop\\Software Engineering\\Distributed Systems\\GRPCSmartCity\\GRPCSmartCity\\EnergyMonitoring\\src\\main\\java\\ds\\energymonitoring\\energyrepo.csv"))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                String csvdeviceId = fields[0];//deviceId in the csv file
                double energyUsage = Double.parseDouble(fields[1]);//enerUsage Data from the csv file
                long timestampSec = Long.parseLong(fields[2]);//timeStamp in epoch form

                if (csvdeviceId.equals(deviceId) && timestampSec > startTime && timestampSec < endTime) {
                    
                    EnergyUsage usage = new EnergyUsage(deviceId, energyUsage);
                    usageData.add(usage);
                }
            }
        }
        return usageData;
    }

  //Method that returns energy usage history data
	public List<EnergyUsageHistoryData> getEnergyUsageHistory(String deviceId) {
		// TODO Auto-generated method stub
		 List<EnergyUsageHistoryData> data = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	        	//We return a random number
	            EnergyUsageHistoryData datum = EnergyUsageHistoryData.newBuilder()
	                    .setDateTime(System.currentTimeMillis())
	                    .setEnergyUsage((float) Math.random() * 100)
	                    .build();
	            data.add(datum);
	        }
	        return data;
	    }
	}


