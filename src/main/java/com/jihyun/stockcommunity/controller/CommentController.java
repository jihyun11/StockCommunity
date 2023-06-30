package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/content/{idValue}")
    public String comment(@RequestParam("comment_content") String comment_content, @RequestParam("comment_author")
                          String comment_author) {
        commentService.comment(comment_content, comment_author);
        log.info("댓글 작성자와 내용: {}, {}", comment_author, comment_content);
        System.out.println("댓글 작성 컨트롤러 작동");
        return "/members/contentdetail";
    }
}
