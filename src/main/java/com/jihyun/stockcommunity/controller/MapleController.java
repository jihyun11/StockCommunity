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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/members/deleteM")
    public String deleteM() {
        return "/members/deleteM";
    }

    @PostMapping("/members/deleteM")
    public String deleteMaple(String name, String world) {
        mapleService.deleteMaple(name, world);

        return "redirect:/members/maple";
    }

    @GetMapping("/level/{idValue}")
    public String mapleSelectDetail(@PathVariable("idValue") String idValue, Model model) {
        Maple maple = (mapleService.mapleSelectDetail(idValue));
        model.addAttribute("mapleDetail", maple);
        return "/members/mapleDetail";
    }

    @PostMapping("/level/{idValue}")
    public String mapleUpdateDetail(@PathVariable("idValue") String idValue,
                                    @RequestParam("nowLevel") int nowLevel,
                                    @RequestParam("goalLevel") int goalLevel,
                                    @RequestParam("world") String world,
                                    @RequestParam("name") String name,
                                    @RequestParam("phone") String phone) {
        mapleService.updateMaple(nowLevel, goalLevel, world, name, phone);
        log.info("업데이트문 작동");
        log.info(String.valueOf(nowLevel), goalLevel, world, name, phone);
        return "redirect:/members/maple";
    }

    @GetMapping("/members/maplecontent")
    public String maplecontent() {
        return "/members/maplecontent";
    }
}
