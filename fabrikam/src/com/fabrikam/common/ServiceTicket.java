package com.fabrikam.common;

import java.sql.Timestamp;

public class ServiceTicket {
	
	private int ref;
	private int status;
	private int escalation;
	private String title;
	private String name;
	private Timestamp openedDate;
	
	public ServiceTicket(int ref,int status,int escalation,String title,
			String name,Timestamp openedDate){
		
		this.ref=ref;
		this.status=status;
		this.escalation=escalation;
		this.title=title;
		this.name=name;
		this.openedDate = openedDate;
	}
		
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEscalation() {
		return escalation;
	}
	public void setEscallation(int escalation) {
		this.escalation = escalation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getOpenedDate() {
		return openedDate;
	}
	public void setOpened(Timestamp openedDate) {
		this.openedDate = openedDate;
	}

}
