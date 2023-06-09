package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.constant.Constant;
import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.service.CommentService;
import com.jihyun.stockcommunity.service.LoginService;
import com.jihyun.stockcommunity.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    private final StockService stockService;
    private final LoginService loginService;

    private final CommentService commentService;

    public HomeController(StockService stockService, LoginService loginService, CommentService commentService) {
        this.stockService = stockService;
        this.loginService = loginService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String ladybug(HttpSession httpSession) {
        Object first = httpSession.getAttribute(Constant.USER_SESSION_KEY);
        if (first != null) {
            User user = (User) first;
            log.info("{}", user);
        }
        return "index";
    }

    @GetMapping("/members/new")
    public String newmember() {
        return "/members/new";
    }

    @PostMapping("/members/new")
    public String memberRight(StockCommunity stockCommunity) {
        StockCommunity stockCommunity1 = new StockCommunity();
        stockCommunity1.setUsername(stockCommunity.getUsername());
        stockCommunity1.setPassword(stockCommunity.getPassword());
        stockCommunity1.setInterests(stockCommunity.getInterests());



        stockService.insertStock(stockCommunity1);
        log.info("회원가입 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/content")
    public String content() {
        return "/members/content";
    }

    @PostMapping("/members/content")
    public String insertContent(ContentCommunity contentCommunity) {
        ContentCommunity contentCommunity1 = new ContentCommunity();
        contentCommunity1.setUsername(contentCommunity.getUsername());
        contentCommunity1.setContent(contentCommunity.getContent());
        contentCommunity1.setTitle(contentCommunity.getTitle());

        stockService.insertContentStock(contentCommunity1);

        log.info("게시글 등록 컨트롤러 작동");

        return "redirect:/";
    }
    @GetMapping("/members/view")
    public String view(Model model) {
            List<StockCommunity> stockList = stockService.getStockList();
            model.addAttribute("stockList", stockList);
            log.info("회원목록 조회 기능 컨트롤러 작동");
            return "/members/view";

    }

    @GetMapping("/members/contentview")
    public String contentview(Model model) {
        List<ContentCommunity> stockContentList = stockService.getContentStockList();
        model.addAttribute("stockContentList", stockContentList);
        log.info("게시글목록 조회 기능 컨트롤러 작동");
        return "/members/contentview";
    }


    @GetMapping("/members/bye")
    public String bye() {
        return "/members/bye";
    }

    @PostMapping("/members/bye")
    public String byeview(@RequestParam("username") String username, @RequestParam("password") String password) {
        stockService.deleteStockMember(username, password);
        log.info("회원정보 삭제 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/contentbye")
    public String contentbye() {
        return "/members/contentbye";
    }

    @PostMapping("/members/contentbye")
    public String byecontent(@RequestParam("username") String username, @RequestParam("title") String title) {
        //requestparam 괄호 안에 글자랑 똑같은 컬럼을 찾는 거임
        stockService.deleteStockContent(username, title);
        log.info("게시글 삭제 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/modify")
    public String modify(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute(Constant.USER_SESSION_KEY);
        String usernameInfo = loginUser.getUsername();
        List<ContentCommunity> info = loginService.updateMemberGrade(loginUser.getUsername());
        List<SelectComment> commentInfo = commentService.selectCommentGrade(loginUser.getUsername());
        int grade = (info.size());
        int commentGrade = (commentInfo.size());
        log.info("{}님의 게시글 수: {}, 댓글 수: {}", loginUser.getUsername(), grade, commentGrade);
//        회원등급을 정하기 위한 게시글 수 표시


        List<String> allInterests = Arrays.asList("정보공유", "친구만들기", "멤버십", "기타");

        model.addAttribute("usernameInfo", usernameInfo);

        model.addAttribute("allInterests", allInterests);
        model.addAttribute("interestList", loginUser.getInterestList());
        model.addAttribute("info", grade);
        model.addAttribute("commentInfo", commentInfo);
        return "/members/modify";
    }

    @PostMapping("/members/modify")
    public String newmodify(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("newpassword") String newpassword, @RequestParam("interests") String interests) {
        stockService.updateStock(username, password, newpassword, interests);
        log.info("회원정보 수정 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/contentmodify")
    public String mcontent() {
        return "/members/contentmodify";
    }

    @PostMapping("/members/contentmodify")
    public String contentmodify(@RequestParam("username") String username, @RequestParam("newcontent") String newcontent, @RequestParam("newtitle") String newtitle) {
        stockService.updateContentStock(username, newcontent, newtitle);
        log.info("게시글 수정 기능 컨트롤러 작동");
        return "redirect:/";
    }




}
