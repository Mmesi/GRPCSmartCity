package ds.energymonitoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.protobuf.Timestamp;


public class EnergyUsageRepository{
	public EnergyUsageRepository(){
		new HashMap<>();
	}

    public List<EnergyUsage> getEnergyUsage(String deviceId, long startTime, long endTime) throws FileNotFoundException, IOException {
        
    	List<EnergyUsage> usageData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Mmesi\\Desktop\\Software Engineering\\Distributed Systems\\GRPCSmartCity\\GRPCSmartCity\\EnergyMonitoring\\src\\main\\java\\ds\\energymonitoring\\energyrepo.csv"))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                String csvdeviceId = fields[0];
                double energyUsage = Double.parseDouble(fields[1]);
                long timestampSec = Long.parseLong(fields[2]);

                if (csvdeviceId.equals(deviceId) && timestampSec > startTime && timestampSec < endTime) {
                    
                    EnergyUsage usage = new EnergyUsage(deviceId, energyUsage);
                    usageData.add(usage);
                }
            }
        }
        return usageData;
    }

	public List<EnergyUsageHistoryData> getEnergyUsageHistory(String deviceId) {
		// TODO Auto-generated method stub
		 List<EnergyUsageHistoryData> data = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            EnergyUsageHistoryData datum = EnergyUsageHistoryData.newBuilder()
	                    .setDateTime(System.currentTimeMillis())
	                    .setEnergyUsage((float) Math.random() * 100)
	                    .build();
	            data.add(datum);
	        }
	        return data;
	    }
	}


