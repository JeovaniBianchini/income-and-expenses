package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.User;

import java.util.Optional;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String userName;

    public UserDto(){
    }

    public UserDto(UUID id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UserDto(User user) {
        id = user.getId();
        userName = user.getUserName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
