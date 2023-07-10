package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.Heart;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.CommentService;
import com.jihyun.stockcommunity.service.ContentService;
import com.jihyun.stockcommunity.service.HeartService;
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

    private final HeartService heartService;

    @Autowired
    public ContentController(ContentService contentService, CommentService commentService, HeartService heartService) {
        this.contentService = contentService;

        this.commentService = commentService;
        this.heartService = heartService;
    }

    @GetMapping("/members/contentlist")
    public String contentlist(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        int pageSize = 5; // 페이지당 게시글 수
        int totalCount = contentService.getContentCount();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        int offset = (page - 1) * pageSize;
        List<ContentCommunity> contentList = contentService.getContentListView(offset);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("contentList", contentList);

        log.info("게시글목록 조회 기능 컨트롤러 작동");
        return "/members/contentlist";
    }

    @GetMapping("/content/{idValue}")
    public String content(@PathVariable("idValue") String idValue, Model model, HttpSession httpsession) {
        User session = (User) httpsession.getAttribute(Constant.USER_SESSION_KEY);
        String username = session.getUsername();
        ContentCommunity contentDetailView = contentService.getContentDetailView(idValue, username);

        //댓글관련
//        List<SelectComment> selectComment = commentService.selectComment(idValue);
        List<SelectComment> selectNewComment = commentService.selectNewComment(idValue, username);

        //좋아요 개수 관련

        model.addAttribute("commentAuthor", username);
        model.addAttribute("contentDetailView", contentDetailView);

        //댓글관련
//        model.addAttribute("selectComment", selectComment);
        model.addAttribute("selectNewComment", selectNewComment);
        model.addAttribute("commentSelectId", selectNewComment.get(0));

        //좋아요 개수 관련
//

        log.info("myLike 값:{}", contentDetailView.getMyLike());

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
