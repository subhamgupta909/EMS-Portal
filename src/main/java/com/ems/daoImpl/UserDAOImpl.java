package com.ems.daoImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.ems.dao.UserDAO;
import com.ems.entity.Role;
import com.ems.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	HibernateTemplate hTemplate;

	@Override
	public User login(String email, String password) throws SQLException {
	    String hql = "FROM User u WHERE u.email = :email";
	    List<User> list = (List<User>) hTemplate.findByNamedParam(
	            hql,
	            new String[]{"email"},
	            new Object[]{email}
	    );

	    if (list.isEmpty()) {
	        return null; 
	    }

	    User user = list.get(0);
	    
	    return user;
	}

	@Override
	public void addUser(User user) {
		hTemplate.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public User findUserById(String userId) {
		User user = hTemplate.get(User.class, userId);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		String hql = "FROM User u WHERE u.email = :email";
		List<User> users = (List<User>) hTemplate.findByNamedParam(hql, "email", email);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<User> findAllUsersByJoiningDateRange(Date start, Date end) {
		String hql = "FROM User u WHERE u.dateOfJoining BETWEEN :start AND :end";
		List<User> users = (List<User>) hTemplate.findByNamedParam(hql, new String[] { "start", "end" },
				new Object[] { start, end });
		return users;
	}

	@Override
	public void deleteUserById(String userId) {
		User user = hTemplate.get(User.class, userId);
		if (user != null) {
			hTemplate.delete(user);
		}
	}

	@Override
	public void updateUser(User user) {
		User existingUser = hTemplate.get(User.class, user.getUserId());
		if (existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPhone(user.getPhone());
			existingUser.setDept(user.getDept());
			existingUser.setRole(user.getRole());
			existingUser.setDateOfJoining(user.getDateOfJoining());
			existingUser.setProject(user.getProject());
			hTemplate.update(existingUser);
		}
	}

	@Override
	public boolean assignProject(String userId, String projectId) {
		return false;
	}

	@Override
	public boolean removeProject(String userId, String projectId) {
		return false;
	}

	@Override
	public List<User> findAllUsers(Role role) {
		String hql = "FROM User u WHERE u.role = :role";
		return (List<User>) hTemplate.findByNamedParam(hql, "role", role);
	}

	@Override
	public List<User> findAllEmployeesByProjectId(String projectId) {
		String hql = "from User u where u.project.projectId = :projectId";
		List<User> employees = (List<User>) hTemplate.findByNamedParam(hql, "projectId", projectId);
		return employees;
	}

}
