package com.dileep.secondproject.Pjoclasses;

public class UsersPojo {
    String name,message,time,count;

    public UsersPojo() {
    }

    public UsersPojo(String name, String message, String time, String count) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
