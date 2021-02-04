package com.dileep.secondproject.Pjoclasses;

public class DataPojo {
    String userName,description,dob;
    int profileImage;

    public DataPojo(String userName, String description, String dob, int profileImage) {
        this.userName = userName;
        this.description = description;
        this.dob = dob;
        this.profileImage = profileImage;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
