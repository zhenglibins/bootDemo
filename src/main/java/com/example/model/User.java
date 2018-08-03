package com.example.model;

import java.io.*;

public class User implements Serializable{
    private Integer userId;

    private String userName;

    private String desc;

    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public static void main(String args[]){
        writeObj();
        readObj();
    }

    public static void writeObj()  {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
            User user = new User();
            user.setUserId(1);
            user.setUserName("test");
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", desc='" + desc + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void readObj(){
        try {
            ObjectInputStream ooi=new ObjectInputStream(new FileInputStream("obj.txt"));
            try {
                User user = (User)ooi.readObject();
                System.out.println(user.getUserName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}