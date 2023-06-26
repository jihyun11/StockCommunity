package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.service.ContentService;
import com.jihyun.stockcommunity.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class ContentController {
    private final ContentService contentService;
    private final StockService stockService;

    @Autowired
    public ContentController(ContentService contentService, StockService stockService) {
        this.contentService = contentService;
        this.stockService = stockService;
    }

    @GetMapping("/members/contentlist")
    public String contentlist(Model model) {
        List<ContentCommunity> ContentList = contentService.getContentListView();
        model.addAttribute("ContentList", ContentList);
        System.out.println("게시글목록 조회 기능 컨트롤러 작동");
        return "/members/contentlist";
    }

    @GetMapping("/content/{title}")
    public String content(@PathVariable("title") String title, Model model) {
        List<ContentCommunity> ContentDetailView = contentService.getContentDetailView(title);
        model.addAttribute("ContentDetailView", ContentDetailView);
        System.out.println("게시글 상세페이지 조회 기능 컨트롤러 작동");
        return "/members/contentdetail";

    }

}
