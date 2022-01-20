package com.sudosai.commentsystem.service;

import com.sudosai.commentsystem.entity.Comment;
import com.sudosai.commentsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment postComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
