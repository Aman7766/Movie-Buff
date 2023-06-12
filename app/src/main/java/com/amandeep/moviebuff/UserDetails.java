package com.amandeep.moviebuff;

public class UserDetails {

    String name;
    String mobile;
    String email;
    String password;

    UserDetails(String name,String mobile,String email,String password)
    {
        this.name=name;
        this.mobile=mobile;
        this.email=email;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
