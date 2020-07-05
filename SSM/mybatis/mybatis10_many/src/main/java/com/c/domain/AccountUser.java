package com.c.domain;

public class AccountUser extends Account {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return super.toString() + " AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
