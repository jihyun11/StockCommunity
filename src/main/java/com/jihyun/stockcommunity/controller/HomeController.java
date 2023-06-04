package com.jihyun.stockcommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String ladybug() {
        return "index";
    }

    @GetMapping("/members/new")
    public String newmember() {
        return "/members/new";
    }

    @PostMapping("/members/new")
    public String memberRight() {

        return "redirect:/";
    }

    @GetMapping("/members/content")
    public String content() {
        return "/members/content";
    }
}
