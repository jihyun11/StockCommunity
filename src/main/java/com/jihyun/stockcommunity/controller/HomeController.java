package com.jihyun.stockcommunity.controller;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.StockCommunity;
import com.jihyun.stockcommunity.domain.User;
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

    public HomeController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    public String ladybug(HttpSession httpSession) {
        Object first = httpSession.getAttribute("first");
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
//        String ss = stockCommunity1.getInterests().toString();
//        String[] interestsArray = stockCommunity1.getInterests().split(",");
//        List<String> interestsList = Arrays.asList(interestsArray);

        stockCommunity1.setInterests(stockCommunity1.getInterests());


        stockService.insertStock(stockCommunity1);
        System.out.println("회원가입 컨트롤러 작동");
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

        System.out.println("게시글 등록 컨트롤러 작동");

        return "redirect:/";
    }
    @GetMapping("/members/view")
    public String view(Model model) {
            List<StockCommunity> stockList = stockService.getStockList();
            model.addAttribute("stockList", stockList);
            System.out.println("회원목록 조회 기능 컨트롤러 작동");
            return "/members/view";

    }

    @GetMapping("/members/contentview")
    public String contentview(Model model) {
        List<ContentCommunity> stockContentList = stockService.getContentStockList();
        model.addAttribute("stockContentList", stockContentList);
        System.out.println("게시글목록 조회 기능 컨트롤러 작동");
        return "/members/contentview";
    }


    @GetMapping("/members/bye")
    public String bye() {
        return "/members/bye";
    }

    @PostMapping("/members/bye")
    public String byeview(@RequestParam("username") String username, @RequestParam("password") String password) {
        stockService.deleteStockMember(username, password);
        System.out.println("회원정보 삭제 컨트롤러 작동");
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
        System.out.println("게시글 삭제 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/modify")
    public String modify(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("first");
        String usernameInfo = loginUser.getUsername();
        model.addAttribute("usernameInfo", usernameInfo);
        return "/members/modify";
    }

    @PostMapping("/members/modify")
    public String newmodify(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword) {
        stockService.updateStock(username, password, newpassword);
        System.out.println("회원정보 수정 컨트롤러 작동");
        return "redirect:/";
    }

    @GetMapping("/members/contentmodify")
    public String mcontent() {
        return "/members/contentmodify";
    }

    @PostMapping("/members/contentmodify")
    public String contentmodify(@RequestParam("username") String username, @RequestParam("newcontent") String newcontent, @RequestParam("newtitle") String newtitle) {
        stockService.updateContentStock(username, newcontent, newtitle);
        System.out.println("게시글 수정 기능 컨트롤러 작동");
        return "redirect:/";
    }




}
