//package com.ems.daoImpl;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.ems.dao.EmployeeDAO;
//import com.ems.entity.Employee;
//@Repository
//public class EmployeeDAOImpl implements EmployeeDAO{
//
//	@Autowired
//	HibernateTemplate  hTemplate;
//	
//	@Override
//	public void addEmployee(Employee emp) {
//		hTemplate.save(emp);
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//	  List<Employee> empList=hTemplate.loadAll(Employee.class);	
//		return empList;
//	}
//
//	@Override
//	public Employee getEmployeeById(String empId) {
//	Employee  emp=hTemplate.get(Employee.class, empId);	
//		return emp;
//	}
//
//	@Override
//	public Employee getEmployeeByEmail(String email) {
//		return null;
//	}
//
//	@Override
//	public List<Employee> getAllEmployeesDateRange(Date startDate, Date endDate) {
//		return null;
//	}
//
//	@Override
//	public void deleteEmployeeById(String empId) {
//		Employee emp=hTemplate.get(Employee.class, empId);
//		if(emp!=null)
//			hTemplate.delete(emp);
//	}
//
//	@Override
//	public void updateEmployee(Employee emp) {
//		hTemplate.update(emp);
//		
//	}
//
//	@Override
//	public boolean assignProjectToEmployee(String empId, String projectId) {
//		return false;
//	}
//
//	@Override
//	public boolean checkEmployeeOnProject(String empId) {
//		return false;
//	}
//
//	@Override
//	public boolean releaseEmployeeFromProject(String empId) {
//		return false;
//	}
//
//	@Override
//	public List<Employee> getAllBenchEmployees() {
//		return null;
//	}
//
//	@Override
//	public boolean verifyEmployeeEmail(String email) {
//		return false;
//	}
//
//}
