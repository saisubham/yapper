package com.sudosai.commentsystem.controller;

import com.sudosai.commentsystem.entity.Comment;
import com.sudosai.commentsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment postComment(@RequestBody Comment comment) {
        return commentService.postComment(comment);
    }
}
