package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.service.CommentService;
import com.jihyun.stockcommunity.service.HeartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class CommentController {

    private final CommentService commentService;

    private final HeartService heartService;

    public CommentController(CommentService commentService, HeartService heartService) {
        this.commentService = commentService;
        this.heartService = heartService;
    }

    @PostMapping("/content/{idValue}")
    public String comment(@RequestParam("commentContent") String commentContent, @RequestParam("commentAuthor")
                          String commentAuthor, @RequestParam("commentContentId") int commentContentId,
                          @PathVariable("idValue") String idValue
                          ) {
        commentService.comment(commentContent, commentAuthor, commentContentId);
        log.info("댓글 작성자와 내용: {}, {}", commentAuthor, commentContent);
        log.info("댓글 작성 컨트롤러 작동");
        log.info(idValue);

        return "redirect:/content/" + idValue;
    }

    @GetMapping("/comment/modify/{commentIdValue}")
    public String commentModifyView(@PathVariable("commentIdValue") String commentIdValue, Model model) {
        log.info("클릭된 댓글번호: {}", commentIdValue);
        SelectComment selectCommentUpdateView = commentService.selectCommentUpdateView(commentIdValue);
        model.addAttribute("selectCommentUpdateView", selectCommentUpdateView);

        return "/members/commentmodify";
    }

    @PostMapping("/comment/modify/{commentIdValue}")
    public String commentModify(@RequestParam("commentSelectContent") String commentSelectContent,
                                @RequestParam("commentSelectId") int commentSelectId,
                                @RequestParam("commentSelectAuthor") String commentSelectAuthor,
                                @RequestParam("commentSelectContentId") int commentSelectContentId) {
        commentService.selectCommentUpdate(commentSelectContent, commentSelectId, commentSelectAuthor, commentSelectContentId);
        log.info("댓글수정: 댓글번호-{}, 작성자-{}, 글내용-{}", commentSelectId, commentSelectAuthor, commentSelectContent);

        return "redirect:/content/" + commentSelectContentId;
    }

    @GetMapping("/comment/delete/{commentIdValue}")
    public String commentDeleteView(@PathVariable("commentIdValue") String commentIdValue, Model model) {
        log.info("클릭된 삭제댓글번호: {}", commentIdValue);
        SelectComment selectCommentUpdateView = commentService.selectCommentUpdateView(commentIdValue);
        model.addAttribute("selectCommentUpdateView", selectCommentUpdateView);

        return "/members/commentdelete";
    }

    @PostMapping("/comment/delete/{commentIdValue}")
    public String commentDelete(@RequestParam("commentSelectContent") String commentSelectContent,
                                @RequestParam("commentSelectId") int commentSelectId,
                                @RequestParam("commentSelectAuthor") String commentSelectAuthor,
                                @RequestParam("commentSelectContentId") int commentSelectContentId) {
        commentService.selectCommentDelete(commentSelectContent, commentSelectId, commentSelectAuthor, commentSelectContentId);

        return "redirect:/content/" + commentSelectContentId;
    }

}
