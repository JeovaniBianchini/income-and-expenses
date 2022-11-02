package com.bianchinijeovani.incomeandexpenses.dtos;

public class UserDto {

    private Long id;
    private String userName;

    public UserDto(){
    }

    public UserDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
