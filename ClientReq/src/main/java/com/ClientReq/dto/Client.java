package com.ClientReq.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	private String clientName;
	private String requirement;
	private String emailId;
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + ", requirement=" + requirement + ", emailId="
				+ emailId + "]";
	}
	
	
	

}
