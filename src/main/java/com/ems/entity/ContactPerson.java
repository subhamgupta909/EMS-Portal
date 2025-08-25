package com.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_persons")
public class ContactPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	private String name;
	@Column(name="email",unique = true)
	private String email;
	private Long phone;
	private String designation;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	private User client;
	public ContactPerson(String name, String email, Long phone, String designation) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
	}
	public ContactPerson() {
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "ContactPerson [name=" + name + ", email=" + email + ", phone=" + phone + ", designation=" + designation
				+ "]";
	}

}
