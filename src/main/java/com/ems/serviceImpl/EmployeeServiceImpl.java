//package com.ems.serviceImpl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ems.dao.EmployeeDAO;
//import com.ems.entity.Employee;
//import com.ems.service.EmployeeService;
//@Service
//@Transactional
//public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	EmployeeDAO employeeDao;
//
//	@Override
//    @Transactional(readOnly = false)
//	public void addEmployee(Employee emp) {
//		employeeDao.addEmployee(emp);
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//	  List<Employee>	empList=employeeDao.getAllEmployees();
//		return empList;
//	}
//
//	@Override
//	public Employee getEmployeeById(String empId) {
//		Employee emp=employeeDao.getEmployeeById(empId);
//		return emp;
//	}
//
//	@Override
//	public Employee getEmployeeByEmail(String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Employee> getAllEmployeesDateRange(Date startDate, Date endDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	
//	public void deleteEmployeeById(String empId) {
//		employeeDao.deleteEmployeeById(empId);
//	}
//
//	@Override
//	@Transactional
//	public void updateEmployee(Employee emp) {
//		
//		employeeDao.updateEmployee(emp);
//	}
//
//	@Override
//	public boolean assignProjectToEmployee(String empId, String projectId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean checkEmployeeOnProject(String empId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean releaseEmployeeFromProject(String empId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Employee> getAllBenchEmployees() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean verifyEmployeeEmail(String email) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
