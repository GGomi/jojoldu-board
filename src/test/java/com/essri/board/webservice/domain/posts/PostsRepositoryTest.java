package com.essri.board.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

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

    @Test
    public void BaseTimeEntity_등록 () {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .author("테스트 유저")
            .content("테스트 본문")
            .build());

        List<Posts> list = postsRepository.findAll();
        assertTrue(list.get(0).getCreatedDate().isAfter(now));
        assertTrue(list.get(0).getModifiedDate().isAfter(now));
    }
}
