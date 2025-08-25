package com.ems.daoImpl;

import java.sql.*;

import com.ems.dao.LoginAttemptDAO;
import com.ems.entity.LoginAttempt;

public class LoginAttemptDAOImpl implements LoginAttemptDAO {

	@Override
	public LoginAttempt getLoginAttempt(String email, String role) {
		return null;
	}

	@Override
	public void createIfNotExists(String email, String role) {
	}

	@Override
	public void resetAttempt(String email, String role) {
	}

	@Override
	public int incrementAttemptAndGet(String email, String role) {
		return 0;
	}

	@Override
    public void lockAccount(String email, String role, int minutes) {
}
}