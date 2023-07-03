package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.Comment;
import com.jihyun.stockcommunity.domain.SelectComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(String commentContent, String commentAuthor, int commentContentId);

//    List<Comment> selectComment(String idValue);
    List<SelectComment> selectComment(String idValue);


}
