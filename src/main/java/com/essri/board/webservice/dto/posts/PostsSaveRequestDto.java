package com.essri.board.webservice.dto.posts;

import com.essri.board.webservice.domain.posts.Posts;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}