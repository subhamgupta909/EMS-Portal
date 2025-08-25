package com.ems.dao;

import com.ems.entity.LoginAttempt;

public interface LoginAttemptDAO {
    LoginAttempt getLoginAttempt(String email, String role);
    void createIfNotExists(String email, String role);
    void resetAttempt(String email, String role);
    int incrementAttemptAndGet(String email, String role);
    void lockAccount(String email, String role, int minutes);
}
