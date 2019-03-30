package entity;

public class Tracker {
	private String workTime;
	private double quantity;
	private double daySalary;
	private double overTime;

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getDaySalary() {
		return daySalary;
	}

	public void setDaySalary(double daySalary) {
		this.daySalary = daySalary;
	}

	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}
	
	public double getTotal() {
		double total = (daySalary * quantity) - (daySalary * quantity * 0.05);
		if("half".equals(workTime)) {
			total /= 2;
		} else if("off".equals(workTime)) {
			total = 0;
		}
		
		return total;
	}
	
	public double getDays() {
		double sumDay = 0;
		for(int i = 0 ; i < this.quantity ; i++) {
			if("half".equals(this.workTime)) {
				sumDay += 0.5;
			} else if("off".equals(this.workTime)) {
				sumDay += 0;
			} else {
				sumDay++;
			}
		}
		return sumDay;
	}
	
}
