package com.ems.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminDAOImpl implements com.ems.dao.AdminDAO{
	@Override
	public boolean login(String username, String password) throws SQLException {
	   return true;	
}
}