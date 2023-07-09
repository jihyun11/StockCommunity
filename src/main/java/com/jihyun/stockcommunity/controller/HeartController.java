package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.HeartService;
import com.jihyun.stockcommunity.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HeartController {

    private final HeartService heartService;
    private final LoginService loginService;

    public HeartController(HeartService heartService, LoginService loginService) {
        this.heartService = heartService;
        this.loginService = loginService;
    }


//    게시글 상세페이지에서 게시글에 좋아요 기능
    @GetMapping("/like/content/{idValue}")
    public String ContentHeart() {
        return "/likecontent";
    }

    @PostMapping("/like/content/{idValue}")
    public String ContentLike(@PathVariable("idValue") String idValue, @RequestParam("contentSelectId") int id, Model model, HttpSession httpsession) {
        User session = (User) httpsession.getAttribute(Constant.USER_SESSION_KEY);
        String s = session.getUsername();
        heartService.HeartContent(id, s);

        log.info("게시글에 좋아요 기능 수행");
        return "redirect:/content/" + idValue;
    }

//    게시글 상세페이지에서 게시글에 좋아요 해제 기능
    @GetMapping("/like/content/cancel/{idValue}")
    public String HeartContent() {
        return "/likecontentcancel";
    }

    @PostMapping("/like/content/cancel/{idValue}")
    public String HeartContentCancel(@PathVariable("idValue") String idValue, @RequestParam("id") int id,
                                     HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String username = user.getUsername();
        loginService.deleteHeartContent(id, username);

        log.info("게시글 좋아요 해제 기능 수행");
        return "redirect:/content/" + idValue;
    }





//    게시글 상세페이지에서 댓글에 좋아요 기능
    @GetMapping("/like/{idValue}")
    public String Heart() {
        return "/like";
    }

    @PostMapping("/like/{idValue}")
    public String HeartLike(@PathVariable("idValue") String idValue, @RequestParam("commentSelectId") int commentSelectId, HttpSession httpsession) {
        User session = (User) httpsession.getAttribute(Constant.USER_SESSION_KEY);
        String s = session.getUsername();
        heartService.Heart(commentSelectId, s);

        //좋아요 정보를 세션에 넣음
        int selectSession = commentSelectId;
        httpsession.setAttribute("selectSession", selectSession);


        log.info("좋아요 기능 수행");
        return "redirect:/content/" + idValue;
    }


//    게시글 상세페이지에서 댓글에 좋아요 해제 기능
    @GetMapping("/like/cancel/{idValue}")
    public String HeartComment() {
        return "/likecancel";
    }

    @PostMapping("/like/cancel/{idValue}")
    public String HeartCommentCancel(@PathVariable("idValue") String idValue,
                                     @RequestParam("commentSelectId") int commentSelectId,
                                     HttpSession httpSession) {
        User user = (User) httpSession.getAttribute(Constant.USER_SESSION_KEY);
        String username = user.getUsername();

        loginService.deleteHeartComment(commentSelectId, username);
        log.info("댓글 좋아요 해제 기능 수행");
        return "redirect:/content/" + idValue;
    }


}