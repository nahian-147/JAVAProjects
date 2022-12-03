package com.example.consumingwebservice;

public class IPAddress {
    private String ip = "";
    private boolean isAvailable = true;
    private String assignedUser = null;
    public int n;

    public IPAddress(String ip,int n){
        this.ip = ip;
        this.n = n;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String toString(){
        return this.ip;
    }
}
