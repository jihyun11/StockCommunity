package com.jihyun.stockcommunity.service;


import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberMapper memberMapper;

    @Autowired
    public LoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public User loginSession(String username, String password) {
        User loginUser = memberMapper.login(username, password);
        return loginUser;
    }
}
