package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/members/login")
    public String login() {
        return "/members/login";
    }

    @PostMapping("/members/login")
    public String loginsession(@RequestParam("username") String username, @RequestParam("password") String password,
                               HttpSession httpSession) {
        User loginUser = loginService.loginSession(username, password);
        if(loginUser == null) {
            return "redirect:/members/loginFail";
        }
        httpSession.setAttribute("first", loginUser);
        log.info("{}, {}", loginUser.getUsername(), loginUser.getPassword());
        System.out.println("로그인 기능 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/loginFail")
    public String loginFail() {
        return "/members/loginFail";
    }
}
