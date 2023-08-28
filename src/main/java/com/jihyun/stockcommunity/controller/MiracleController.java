package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.Maple;
import com.jihyun.stockcommunity.domain.Miracle;
import com.jihyun.stockcommunity.service.MiracleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MiracleController {

    private final MiracleService miracleService;

    @Autowired
    public MiracleController(MiracleService miracleService) {
        this.miracleService = miracleService;
    }

    @GetMapping("/members/miracle")
    public String miracle(Model model) {
        List<Miracle> miracles = miracleService.selectMiracle();
        model.addAttribute("miracles", miracles);
        return "/members/miracle";
    }

    @PostMapping("/members/miracle")
    public String insertMiracle(String miracle) {
        miracleService.insertMiracle(miracle);
        return "redirect:/members/miracle";
    }

    @GetMapping("/members/deleteMiracle")
    public String deleteMiracleGet() {
        return "/members/deleteMiracle";
    }

    @PostMapping("/members/deleteMiracle")
    public String deleteMiraclePost(String miracle_id, String miracle, String miracle_date) {
        miracleService.deleteMiracle(miracle_id, miracle, miracle_date);
        return "redirect:/members/miracle";
    }
}
