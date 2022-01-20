package com.sudosai.commentsystem.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Comment implements Serializable {
    @Id
    @SequenceGenerator(
            name = "comment_id",
            sequenceName = "comment_id",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "comment_id",
            strategy = GenerationType.SEQUENCE
    )
    private Long commentId;

    @OneToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

    private String text;

    @ManyToOne
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "commentId"
    )
    private Comment parent;

    @OneToMany(
            mappedBy = "parent",
            fetch = FetchType.EAGER
    )
    private List<Comment> replies;

    public Comment() {
    }

    public Comment(Long commentId, User user, String text, Comment parent, List<Comment> replies) {
        this.commentId = commentId;
        this.user = user;
        this.text = text;
        this.parent = parent;
        this.replies = replies;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", replies=" + replies +
                '}';
    }
}
