package com.ems.serviceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.UserDAO;
import com.ems.entity.Role;
import com.ems.entity.User;
import com.ems.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO  userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


	@Override
	public User login(String email, String password) throws SQLException {
	   User user=userDao.login(email, password);
	   System.out.println("UserService"+user);
	   return user;
	}

	@Override
	public void addUser(User user) {
       String encodedPassword=passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(String userId) {
		User user=userDao.findUserById(userId);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
	   User user=userDao.findUserByEmail(email);
		return user;
	}

	@Override
	public List<User> findAllUsersByJoiningDateRange(Date start, Date end) {
		List<User>  empList=userDao.findAllUsersByJoiningDateRange(start, end);
		return empList;
	}

	@Override
	public void deleteUserById(String userId) {
          userDao.deleteUserById(userId);		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public boolean assignProject(String userId, String projectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProject(String userId, String projectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAllUsers(Role role) {
		List<User> userList=userDao.findAllUsers(role);
		return userList;
	}

	@Override
	public List<User> findAllEmployeesByProjectId(String projectId) {
		List<User>   empList=userDao.findAllEmployeesByProjectId(projectId);
		return empList;
	}
	
	

}
