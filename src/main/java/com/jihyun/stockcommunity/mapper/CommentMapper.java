package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(String commentContent, String commentAuthor);

}
