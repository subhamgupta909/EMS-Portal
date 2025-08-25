//package com.ems.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.format.annotation.DateTimeFormat;
//@Entity
//@Table(name="employee")
//public class Employee {
//	@Id
//	@GeneratedValue(generator = "employee-id-gen")
//	@GenericGenerator(name="employee-id-gen",strategy = "com.ems.util.EmployeeIDGenerator")
//    @Column(name="emp_id")
//	private String empId;
//	@Column(name="name")
//	private String name;
//	private String email;
//	private String dept;
//	private Long phone;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Column(name="date_of_joining")
//	private Date dateOfJoining;
//	//@OneToOne
//	//private Project project;
//	public Employee(String empId, String name, String email, String dept, Long phone, Date dateOfJoining) {
//		super();
//		this.empId = empId;
//		this.name = name;
//		this.email = email;
//		this.dept = dept;
//		this.phone = phone;
//		this.dateOfJoining = dateOfJoining;
//	}
//	public Employee() {
//	}
//	public String getEmpId() {
//		return empId;
//	}
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public Long getPhone() {
//		return phone;
//	}
//	public void setPhone(Long phone) {
//		this.phone = phone;
//	}
//	public Date getDateOfJoining() {
//		return dateOfJoining;
//	}
//	public void setDateOfJoining(Date dateOfJoining) {
//		this.dateOfJoining = dateOfJoining;
//	}
////	public Project getProject() {
////		return project;
////	}
////	public void setProject(Project project) {
////		this.project = project;
////	}
//	@Override
//	public String toString() {
//		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", dept=" + dept + ", phone="
//				+ phone + ", dateOfJoining=" + dateOfJoining +  "]";
//	}
//
//
//}
