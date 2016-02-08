package com.akira.RO;

import java.util.List;

public class Logs {
private long pages;
public long getPages() {
	return pages;
}
public void setPages(long pages) {
	this.pages = pages;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
private List list;
public Logs(long pages,List list){
	this.list=list;
	this.pages=pages;
}
}
