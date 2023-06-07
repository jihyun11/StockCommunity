package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final StockService stockService;

    public HomeController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    public String ladybug() {
        return "index";
    }

    @GetMapping("/members/new")
    public String newmember() {
        return "/members/new";
    }

    @PostMapping("/members/new")
    public void memberRight(StockCommunity stockCommunity) {
        StockCommunity stockCommunity1 = new StockCommunity();
        stockCommunity1.setUsername(stockCommunity.getUsername());
        stockCommunity1.setPassword(stockCommunity.getPassword());

        stockService.insertStock(stockCommunity1);
        System.out.println("회원가입 컨트롤러 작동");
//        return "redirect:/";
    }

    @GetMapping("/members/content")
    public String content() {
        return "/members/content";
    }
}
