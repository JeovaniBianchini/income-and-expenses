package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.User;

public class UserForm {

    private String userName;
    private String passWord;

    public UserForm(){
    }

    public UserForm(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public UserForm(User user){
        userName = user.getUserName();
        passWord = user.getPassWord();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
