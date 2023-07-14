package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.SelectComment;
import com.jihyun.stockcommunity.mapper.CommentMapper;
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


    public List<SelectComment> selectNewComment(String idValue, String username, int offset) {
        return commentMapper.selectNewComment(idValue, username, offset);
    }
    public int getCommentCount (int idValue) {
        return commentMapper.getCommentCount(idValue);
    }

    public SelectComment selectCommentUpdateView(String commentIdValue) {
        return commentMapper.selectCommentUpdateView(commentIdValue);
    }

    public void selectCommentUpdate(String commentSelectContent, int commentSelectId, String commentSelectAuthor,
                                    int commentSelectContentId) {
        commentMapper.selectCommentUpdate(commentSelectContent, commentSelectId, commentSelectAuthor, commentSelectContentId);
    }

    public void selectCommentDelete(String commentSelectContent, int commentSelectId, String commentSelectAuthor,
                                    int commentSelectContentId) {
        commentMapper.selectCommentDelete(commentSelectContent, commentSelectId, commentSelectAuthor, commentSelectContentId);
    }

    public List<SelectComment> selectCommentGrade(String commentSelectAuthor) {
        return commentMapper.updateCommentGrade(commentSelectAuthor);
    }

}
