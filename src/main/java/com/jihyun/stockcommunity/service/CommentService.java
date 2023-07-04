package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.Comment;
import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.mapper.CommentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void comment(String commentContent, String commentAuthor, int commentContentId) {
        commentMapper.insertComment(commentContent, commentAuthor, commentContentId);
    }

    public List<SelectComment> selectComment(String idValue) {
        return commentMapper.selectComment(idValue);
    }

    public SelectComment selectCommentUpdate(String commentIdValue) {
        return commentMapper.selectCommentUpdate(commentIdValue);
    }

}
