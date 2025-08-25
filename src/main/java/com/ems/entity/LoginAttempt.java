package com.ems.entity;

import java.sql.Timestamp;

public class LoginAttempt {
    private int id;
    private String email;
    private String userType;
    private int attemptCount;
    private Timestamp lastAttemptTime;
    private Timestamp lockUntil;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public int getAttemptCount() { return attemptCount; }
    public void setAttemptCount(int attemptCount) { this.attemptCount = attemptCount; }

    public Timestamp getLastAttemptTime() { return lastAttemptTime; }
    public void setLastAttemptTime(Timestamp lastAttemptTime) { this.lastAttemptTime = lastAttemptTime; }

    public Timestamp getLockUntil() { return lockUntil; }
    public void setLockUntil(Timestamp lockUntil) { this.lockUntil = lockUntil; }
}
