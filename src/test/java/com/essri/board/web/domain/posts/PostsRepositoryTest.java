package com.essri.board.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        postsRepository.save(Posts.builder()
            .title("Test!!!")
            .content("Test Content!!!")
            .author("Test User")
            .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("Test!!!"));
        assertThat(posts.getContent(), is("Test Content!!!"));
    }
}
