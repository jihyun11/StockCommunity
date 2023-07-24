package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.Maple;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.service.MapleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MapleController {

    private final MapleService mapleService;

    @Autowired
    public MapleController(MapleService mapleService) {
        this.mapleService = mapleService;
    }

    @GetMapping("/members/maple")
    public String maple(Model model) {
        List<Maple> maple = mapleService.selectMaple();
        model.addAttribute("maple", maple);
        return "/members/maple";
    }

    @PostMapping("/members/maple")
    public String insertMaple(Maple maple) {

        Maple maple1 = new Maple();
        maple1.setNowLevel(maple.getNowLevel());
        maple1.setGoalLevel(maple.getGoalLevel());
        maple1.setWorld(maple.getWorld());
        maple1.setName(maple.getName());
        maple1.setPhone(maple.getPhone());

        mapleService.insertMaple(maple1);
        return "redirect:/members/maple";
    }
}
