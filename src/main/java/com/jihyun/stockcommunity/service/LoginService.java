package com.jihyun.stockcommunity.service;


import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.User;
import com.jihyun.stockcommunity.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private final MemberMapper memberMapper;

    @Autowired
    public LoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public User loginSession(String username, String password) {
        return memberMapper.login(username, password);

    }

    public List<User> myInfo() {
        return memberMapper.myinfo();
    }

    public void updateMyInfo(String username, String password, String newpassword) {
        memberMapper.updateMyInfo(username, password, newpassword);
    }

    public List<ContentCommunity> updateMemberGrade(String username) {
        return memberMapper.updateGrade(username);
    }

    public List<SelectComment> selectHeartComment(String loginUserName) { //좋아요한댓글 보기
        return memberMapper.heartCommentMyInfo(loginUserName);
    }

    public List<ContentCommunity> selectHeartContent(String loginUserName) { //좋아요한게시글 보기
        return memberMapper.heartContentMyInfo(loginUserName);
    }

    public void deleteHeartComment(int commentSelectId) { //좋아요한댓글 해제하기
        memberMapper.heartCommentMyInfoDelete(commentSelectId);
    }

    public void deleteHeartContent(int id) { //좋아요한게시글 해제하기
        memberMapper.heartContentMyInfoDelete(id);
    }
}
