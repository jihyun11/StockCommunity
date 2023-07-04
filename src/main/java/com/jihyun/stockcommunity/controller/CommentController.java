package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.Comment;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.service.CommentService;
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
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/content/{idValue}")
    public String comment(@RequestParam("commentContent") String commentContent, @RequestParam("commentAuthor")
                          String commentAuthor, @RequestParam("commentContentId") int commentContentId,
                          @PathVariable("idValue") String idValue) {
        commentService.comment(commentContent, commentAuthor, commentContentId);
        log.info("댓글 작성자와 내용: {}, {}", commentAuthor, commentContent);
        log.info("댓글 작성 컨트롤러 작동");
        log.info(idValue);
        return "redirect:/content/" + idValue;
    }

    @GetMapping("/comment/modify/{commentIdValue}")
    public String commentModify(@PathVariable("commentIdValue") String commentIdValue, Model model) {
        log.info("클릭된 댓글번호: {}", commentIdValue);
        SelectComment selectCommentUpdate = commentService.selectCommentUpdate(commentIdValue);
        model.addAttribute("selectCommentUpdate", selectCommentUpdate);

        return "/members/commentmodify";
    }
}
