
public class Time {
	private int mins;
	private int secs;
	private int decimal;
	
	public Time(int mins, int secs) {
		this.mins = mins;
		this.secs = secs;
		this.decimal = 0;
	}
	
	public void increment() {
		decimal--;
		if (decimal < 0) {
			decimal = decimal + 100;
			secs--;
		}
		if (secs < 0) {
			secs = secs + 60;
			mins--;
		}
	}
	
	public int getMins() {
		return mins;
	}
	
	public int getSecs() {
		return secs;
	}
	
	public String toString() {
		if (secs >= 10) {
			return mins + ":" + secs + "." + decimal;
		} else {
			return mins + ":0" + secs + "." + decimal;
		}
	}
}
