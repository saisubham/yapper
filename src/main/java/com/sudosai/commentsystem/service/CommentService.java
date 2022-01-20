package com.sudosai.commentsystem.service;

import com.sudosai.commentsystem.entity.Comment;

import java.util.Optional;

public interface CommentService {
    public Optional<Comment> getCommentById(Long id);

    public Comment postComment(Comment comment);
}
