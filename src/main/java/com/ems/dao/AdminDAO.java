package com.ems.dao;

import java.sql.SQLException;

public interface AdminDAO {

	public boolean login(String email,String password) throws SQLException;
	
}
