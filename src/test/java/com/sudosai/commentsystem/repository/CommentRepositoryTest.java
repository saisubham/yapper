package com.sudosai.commentsystem.repository;

import com.sudosai.commentsystem.entity.Comment;
import com.sudosai.commentsystem.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    private Comment c1, c2, c3;

    @BeforeEach
    public void init() {
        User u1 = new User();
        u1.setName("john");
        u1 = userRepository.save(u1);

        User u2 = new User();
        u2.setName("mary");
        u2 = userRepository.save(u2);

        c1 = new Comment();
        c1.setUser(u1);
        c1.setText("text 1");

        c2 = new Comment();
        c2.setUser(u2);
        c2.setText("text 2");

        c3 = new Comment();
        c3.setUser(u1);
        c3.setText("text 3");
    }

    @Test
    public void addComment() {
        Comment c = commentRepository.save(c1);
        assertEquals(c.getText(), c1.getText(), "comment should be saved");
    }

    @Test
    public void addNestedComment() {
        c1 = commentRepository.save(c1);
        c2.setParent(c1);
        c2 = commentRepository.save(c2);
        c3.setParent(c2);
        c3 = commentRepository.save(c3);

        assertNull(c1.getParent(), "root reply should have no parent");
        assertEquals(c2.getParent(), c1, "parent should be set for level 1 reply");
        assertEquals(c3.getParent(), c2, "parent should be set for level 2 reply");

        // BUG: replies don't get set in h2 test but sets properly in persistent db.
        // System.out.println(commentRepository.findById(c1.getCommentId()).orElseThrow().getReplies());
    }
}