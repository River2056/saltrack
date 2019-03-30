package entity;

public class Salary {
	private int id;
	private int daysal;
	private String workdate;
	private String worktime;
	private int overtime;
	private String comments;
	
	public Salary() {
		
	}
	
	public Salary(int id, int daysal, String workdate, String worktime, int overtime, String comments) {
		this.id = id;
		this.daysal = daysal;
		this.workdate = workdate;
		this.worktime = worktime;
		this.overtime = overtime;
		this.comments = comments;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDaysal() {
		return daysal;
	}
	public void setDaysal(int daysal) {
		this.daysal = daysal;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", daysal=" + daysal + ", workdate=" + workdate + ", worktime=" + worktime
				+ ", overtime=" + overtime + ", comments=" + comments + "]";
	}

	
}
