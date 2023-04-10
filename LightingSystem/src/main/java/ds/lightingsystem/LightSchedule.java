package ds.lightingsystem;

public class LightSchedule {
	private String system_id;
	private long start_time;
	private long end_time;
	private float intensity;
	public LightSchedule(String system_id, long start_time, long end_time, float intensity) {
		super();
		this.system_id = system_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.intensity = intensity;
	}
	public String getSystemID() {
		// TODO Auto-generated method stub
		return system_id;
	}
	
	
	

}
