package ds.energymonitoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.protobuf.Timestamp;


public class EnergyUsageRepository{
	private final Map<String, List<EnergyUsage>> energyData;
	
	public EnergyUsageRepository(){
		energyData = new HashMap<>();
	}

    public void addEnergyUsage(String deviceId, double usage, Timestamp timestamp) {
        EnergyUsage energyUsage = new EnergyUsage(deviceId, usage, timestamp);
        if (!energyData.containsKey(deviceId)) {
            energyData.put(deviceId, new ArrayList<>());
        }
        energyData.get(deviceId).add(energyUsage);
    }

    public List<EnergyUsage> getEnergyUsage(String deviceId, long startTime, long endTime) {
        List<EnergyUsage> usageData = new ArrayList<>();
        if (energyData.containsKey(deviceId)) {
            for (EnergyUsage usage : energyData.get(deviceId)) {
                Timestamp timestamp = usage.getTimestamp();
                long timestampSec = timestamp.getSeconds();
                if (timestampSec > startTime && timestampSec < endTime){
                    usageData.add(usage);
                }
            }
        }
        return usageData;
    }

}
