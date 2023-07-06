package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.Heart;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.HeartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class HeartController {

    private final HeartService heartService;

    public HeartController(HeartService heartService) {
        this.heartService = heartService;
    }


    @GetMapping("/like/{idValue}")
    public String Heart() {
        return "/like";
    }

    @PostMapping("/like/{idValue}")
    public String HeartLike(@PathVariable("idValue") String idValue, @RequestParam("commentSelectId") int commentSelectId, Model model, HttpSession httpsession) {
        User session = (User) httpsession.getAttribute(Constant.USER_SESSION_KEY);
        String s = session.getUsername();
        heartService.Heart(commentSelectId, s);


        log.info("좋아요 기능 수행");
        return "redirect:/content/" + idValue;
    }



    }
