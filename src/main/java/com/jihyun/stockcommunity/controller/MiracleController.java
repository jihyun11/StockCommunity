package com.jihyun.stockcommunity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MiracleController {

    @GetMapping("/members/miracle")
    public String miracle() {
        return "/members/miracle";
    }
}
