//package com.ems.entity;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.format.annotation.DateTimeFormat;
//@Entity
//@Table(name="client")
//public class Client {
//	@Id
//	@GeneratedValue(generator="client-id")
//	@GenericGenerator(name="client-id",strategy = "com.ems.util.ClientIDGenerator")
//	@Column(name="client_id")
//	private String clientId;
//	@Column(name="client_name")
//	private String clientName;
//	@Column(name="email")
//	private String email;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Column(name = "relationship_date")
//	private Date relationshipDate;
////	private List<ContactPerson> contactPersons;
////	private List<Project> projects;
//
//	public Client() {
//	}
//
//	public Client(String clientId, String clientName, String email, Date relationshipDate) {
//		super();
//		this.clientId = clientId;
//		this.clientName = clientName;
//		this.email = email;
//		this.relationshipDate = relationshipDate;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getClientId() {
//		return clientId;
//	}
//
//	public void setClientId(String clientId) {
//		this.clientId = clientId;
//	}
//
//	public String getClientName() {
//		return clientName;
//	}
//
//	public void setClientName(String clientName) {
//		this.clientName = clientName;
//	}
//
//	public Date getRelationshipDate() {
//		return relationshipDate;
//	}
//
//	public void setRelationshipDate(Date relationshipDate) {
//		this.relationshipDate = relationshipDate;
//	}
//
////	public List<ContactPerson> getContactPersons() {
////		return contactPersons;
////	}
////
////	public void setContactPersons(List<ContactPerson> contactPersons) {
////		this.contactPersons = contactPersons;
////	}
////
////	public List<Project> getProjects() {
////		return projects;
////	}
////
////	public void setProjects(List<Project> projects) {
////		this.projects = projects;
////	}
////
//	@Override
//	public String toString() {
//		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", relationshipDate=" + relationshipDate
//				+ "]";
//	}
//
//}
