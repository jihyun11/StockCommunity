package com.jihyun.stockcommunity.service;

import com.jihyun.stockcommunity.mapper.CommentMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void comment(String comment_content, String comment_author) {
        commentMapper.insertComment(comment_content, comment_author);
    }
}
