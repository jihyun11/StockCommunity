package com.jihyun.stockcommunity.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String password;


    public String user(HttpSession session) {
        User login = (User) session.getAttribute("first");
        String myInfoUsername = login.getUsername();
        String myInfoPassword = login.getPassword();

        List<String> loginUser = new ArrayList<>();
        loginUser.add(myInfoUsername);
        loginUser.add(myInfoPassword);

        return myInfoUsername;
    }

//    private List<String> loginUser;



}
