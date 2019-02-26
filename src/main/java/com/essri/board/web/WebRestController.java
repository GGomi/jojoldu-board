package com.essri.board.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;

    @PostMapping("/posts")
    public void savePosts(@ModelAttribute PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
