package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.Comment;
import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.CommentService;
import com.jihyun.stockcommunity.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ContentController {
    private final ContentService contentService;
    private final CommentService commentService;

    @Autowired
    public ContentController(ContentService contentService, CommentService commentService) {
        this.contentService = contentService;

        this.commentService = commentService;
    }

    @GetMapping("/members/contentlist")
    public String contentlist(Model model) {
        List<ContentCommunity> contentList = contentService.getContentListView();
        model.addAttribute("contentList", contentList);
        log.info("게시글목록 조회 기능 컨트롤러 작동");
        return "/members/contentlist";
    }

    @GetMapping("/content/{idValue}")
    public String content(@PathVariable("idValue") String idValue, Model model, HttpSession httpsession) {
        ContentCommunity contentDetailView = contentService.getContentDetailView(idValue);
        User session = (User) httpsession.getAttribute(Constant.USER_SESSION_KEY);
        String s = session.getUsername();

        model.addAttribute("commentAuthor", s);
        model.addAttribute("contentDetailView", contentDetailView);
        log.info("게시글 상세페이지와 댓글 조회 기능 컨트롤러 작동");
        return "/members/contentdetail";

    }

    @GetMapping("/content/modify/{idValue}")
    public String contentview(@PathVariable("idValue") String idValue, Model model) {
        ContentCommunity contentDetailForView = contentService.getContentDetailUpdateForView(idValue);
        model.addAttribute("contentDetailForView", contentDetailForView);
        log.info("게시글 상세페이지에서 수정 기능 컨트롤러");
        return "/members/contentdetailupdate";
    }

    @PostMapping("/content/modify/{id}")
    public String contentviewUpdate(@RequestParam("contentTitle") String contentTitle, @RequestParam("contentContent")
                                    String contentContent, @RequestParam("contentUsername") String contentUsername,
                                    @RequestParam("contentId") int contentId) {
        contentService.updateContentDetail(contentTitle, contentContent, contentUsername, contentId);
        log.info("게시글 업데이트 기능 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/content/delete/{idValue}")
    public String contentDelete(@PathVariable("idValue") String idValue, Model model) {
        ContentCommunity contentDetailForView = contentService.getContentDetailUpdateForView(idValue);
        model.addAttribute("contentDetailForView", contentDetailForView);
        log.info("게시글 상세페이지에서 삭제 기능 조회 컨트롤러");
        return "/members/contentdetaildelete";
    }

    @PostMapping("/content/delete/{id}")
    public String contentviewDelete(@RequestParam("contentTitle") String contentTitle, @RequestParam("contentContent")
                                    String contentContent, @RequestParam("contentUsername") String contentUsername,
                                    @RequestParam("contentId") int contentId) {
        contentService.deleteContentDetail(contentTitle, contentContent, contentUsername, contentId);
        log.info("게시글 삭제 기능 컨트롤러 작동");
        return "redirect:/";
    }

}
