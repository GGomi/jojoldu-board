package com.essri.board.web;

import com.essri.board.web.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @GetMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
