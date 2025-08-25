package com.ems.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator ="id-gen")
	@GenericGenerator(name="id-gen",strategy = "com.ems.util.IDGenerator")
	@Column(name="user_id")
	private String userId;
	@Column(name="name")
    private String name;
	@Column(name="email",unique = true,nullable = false)
    private String email;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="dept")
    private String dept;
	@Column(name="phone")
    private Long phone;
	@Column(name="date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfJoining;
	@Column(name="relationship_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date relationshipDate;
	@Enumerated(EnumType.STRING)
	@Column(name="role",nullable = false)
	private Role role;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Project project;
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	private List<Project>  projects;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ContactPerson>  contactPersons;
    public User(String name, String email, String password, String dept, Long phone, Date dateOfJoining,
			Date relationshipDate, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dept = dept;
		this.phone = phone;
		this.dateOfJoining = dateOfJoining;
		this.relationshipDate = relationshipDate;
		this.role = role;
	}
	public User() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getRelationshipDate() {
		return relationshipDate;
	}
	public void setRelationshipDate(Date relationshipDate) {
		this.relationshipDate = relationshipDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}
	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", dept="
				+ dept + ", phone=" + phone + ", dateOfJoining=" + dateOfJoining + ", relationshipDate="
				+ relationshipDate + ", role=" + role + "]";
	}
	
}
