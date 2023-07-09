package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.ContentCommunity;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    User login(String username, String password);

    List<User> myinfo();

    void updateMyInfo(String username, String password, String newpassword);

    List<ContentCommunity> updateGrade(String username);

    List<SelectComment> heartCommentMyInfo(String loginUserName); //좋아요한댓글 보기

    List<ContentCommunity> heartContentMyInfo(String loginUserName); //좋아요한게시글 보기

    void heartCommentMyInfoDelete(int commentSelectId, String username); //좋아요한댓글 해제하기

    void heartContentMyInfoDelete(int id, String username); //좋아요한게시글 해제하기


}
