package com.example.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "tbUser")
public class tbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iUserId;

    private String sUserName;
    private String sUserAccount;
    private String sPassword;
    private String sTelephone;

    public Integer getiUserId() {
        return iUserId;
    }

    public void setiUserId(Integer iUserId) {
        this.iUserId = iUserId;
    }

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public String getsUserAccount() {
        return sUserAccount;
    }

    public void setsUserAccount(String sUserAccount) {
        this.sUserAccount = sUserAccount;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsTelephone() {
        return sTelephone;
    }

    public void setsTelephone(String sTelephone) {
        this.sTelephone = sTelephone;
    }
}
