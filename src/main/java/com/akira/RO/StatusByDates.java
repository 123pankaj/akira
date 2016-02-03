package com.akira.RO;

import java.util.List;

public class StatusByDates {
private List<Integer> numberOfSuccess;
private List<Integer> numberOfFailure;
private List<String> dates;
public List<Integer> getNumberOfSuccess() {
	return numberOfSuccess;
}
public void setNumberOfSuccess(List<Integer> numberOfSuccess) {
	this.numberOfSuccess = numberOfSuccess;
}
public List<Integer> getNumberOfFailure() {
	return numberOfFailure;
}
public void setNumberOfFailure(List<Integer> numberOfFailure) {
	this.numberOfFailure = numberOfFailure;
}
public List<String> getDates() {
	return dates;
}
public void setDates(List<String> dates) {
	this.dates = dates;
}

}
