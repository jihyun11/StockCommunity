package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.domain.Comment;
import com.jihyun.stockcommunity.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void comment(String commentContent, String commentAuthor) {
        commentMapper.insertComment(commentContent, commentAuthor);
    }

}
