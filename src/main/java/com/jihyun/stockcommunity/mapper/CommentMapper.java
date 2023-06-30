package com.jihyun.stockcommunity.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void insertComment(String comment_content, String comment_author);
}
