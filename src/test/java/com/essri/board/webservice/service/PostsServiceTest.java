package com.essri.board.webservice.service;

import com.essri.board.webservice.domain.posts.Posts;
import com.essri.board.webservice.domain.posts.PostsRepository;
import com.essri.board.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터_posts테이블에_저장된다 () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                    .title("테스트다!!")
                                    .content("본문이다!!")
                                    .author("나야나")
                                    .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

}
