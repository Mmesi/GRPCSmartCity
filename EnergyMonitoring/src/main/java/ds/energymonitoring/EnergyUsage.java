package ds.energymonitoring;

import com.google.protobuf.Timestamp;


public class EnergyUsage {
	String deviceId;
	double usage;
	Timestamp timestamp;
	public EnergyUsage(String deviceId, double usage, Timestamp timestamp) {
		// TODO Auto-generated constructor stub
		this.deviceId = deviceId;
		this.usage = usage;
		this.timestamp = timestamp;
	}

	public float getUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Timestamp getTimestamp() {
		// TODO Auto-generated method stub
		return timestamp;
	}

	public float getPowerConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}

}