package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        httpSession.setAttribute(Constant.USER_SESSION_KEY, loginUser);
        log.info("{}, {}", loginUser.getUsername(), loginUser.getPassword());
        log.info("로그인 기능 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/loginFail")
    public String loginFail() {
        return "/members/loginFail";
    }

    @GetMapping("/members/logout")
    public String logout() {
        return "/members/logout";
    }

    @PostMapping("/members/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        User loginUser = (User) session.getAttribute(Constant.USER_SESSION_KEY);
        if (loginUser != null) {
            String nowUsername = loginUser.getUsername();
            String nowPassword = loginUser.getPassword();
            log.info("로그인되어 있던 계정: {}, {}", nowUsername, nowPassword);
        } //세션에 저장된 정보의 속성명이랑 같으면 되는듯?

        session.invalidate();

        log.info("로그아웃 기능 컨트롤러 작동");

        return "redirect:/";
    }


    @GetMapping("/members/myinfo")
    public String myinfo1(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute(Constant.USER_SESSION_KEY);
        List<ContentCommunity> info = loginService.updateMemberGrade(loginUser.getUsername());
        String in = loginUser.getUsername();
        int grade = (info.size());

        model.addAttribute("myInfoUsername", in);
        model.addAttribute("info", grade);
        log.info("내정보 불러오는 컨트롤러 작동");
        return "/members/myinfo";
    }

    @PostMapping("/members/myinfo")
    public String updateInfo(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword) {
        loginService.updateMyInfo(username, password, newpassword);
        log.info("내정보 수정하는 페이지 작동");
        return "/members/myinfo";
    }



//    !!!!!!!내가좋아요한댓글페이지!!!!!!
    @GetMapping("/members/myheart")
    public String myHeart(HttpSession httpSession, Model model) {
        User loginUser = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String loginUserName = loginUser.getUsername();

        List<SelectComment> selectHeartComment = loginService.selectHeartComment(loginUserName);

        model.addAttribute("loginUserName", loginUserName);
        model.addAttribute("selectHeartComment", selectHeartComment);
        return "/members/myheart";
}

    //    !!!!!!!내가좋아요한댓글해제하기!!!!!!
    @PostMapping("/members/myheart")
    public String myHeartDelete(@RequestParam("commentSelectId") int commentSelectId, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String username = user.getUsername();
        loginService.deleteHeartComment(commentSelectId, username);

        return "redirect:/members/myheart";
    }




//    !!!!!!!내가좋아요한게시글페이지!!!!!!
    @GetMapping("/members/myheartcontent")
    public String myHeartContent(HttpSession httpSession, Model model) {
        User loginUser = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String loginUserName = loginUser.getUsername();

        List<ContentCommunity> selectHeartContent = loginService.selectHeartContent(loginUserName);

        model.addAttribute("loginUserName", loginUserName);
        model.addAttribute("selectHeartContent", selectHeartContent);
        return "/members/myheartcontent";
    }

//    !!!!!!!내가좋아요한게시글페이지!!!!!!
    @PostMapping("/members/myheartcontent")
    public String myHeartContentDelete(@RequestParam("id") int id, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String username = user.getUsername();
        loginService.deleteHeartContent(id, username);

        return "redirect:/members/myheartcontent";
    }





}


