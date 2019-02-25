package com.essri.board.web;

import com.essri.board.web.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
