package com.jihyun.stockcommunity.mapper;

import com.jihyun.stockcommunity.domain.SelectComment;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CommentMapper {
    void insertComment(String commentContent, String commentAuthor, int commentContentId);

    List<SelectComment> selectNewComment(String idValue, String username);

    SelectComment selectCommentUpdateView(String commentIdValue);

    void selectCommentUpdate(String commentSelectContent, int commentSelectId, String commentSelectAuthor, int commentSelectContentId);

    void selectCommentDelete(String commentSelectContent, int commentSelectId, String commentSelectAuthor, int commentSelectContentId);

    List<SelectComment> updateCommentGrade(String commentSelectAuthor);

}
