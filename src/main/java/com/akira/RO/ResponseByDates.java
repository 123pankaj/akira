package com.akira.RO;

import java.util.List;

public class ResponseByDates {
	private List<Integer> numberOfResponseTime;
	private List<String> dates;
	public List<String> getDates() {
		return dates;
	}
	public void setDates(List<String> dates) {
		this.dates = dates;
	}
	public List<Integer> getNumberOfResponseTime() {
		return numberOfResponseTime;
	}
	public void setNumberOfResponseTime(List<Integer> numberOfResponseTime) {
		this.numberOfResponseTime = numberOfResponseTime;
	}
	
}
