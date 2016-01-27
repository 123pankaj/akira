package com.akira.returnobjects;

import java.util.List;

public class Logs {
private int pages;
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
private List list;
public Logs(int pages,List list){
	this.list=list;
	this.pages=pages;
}
}
