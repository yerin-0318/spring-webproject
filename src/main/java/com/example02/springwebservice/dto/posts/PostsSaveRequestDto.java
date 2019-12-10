package com.example02.springwebservice.dto.posts;

import com.example02.springwebservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* Entity클래스를 Request/Response클래스로 사용하면 안된다.
* Entity클래스 : 가장 Core한 클래스, 이가 변경되면 여러 클래스에 영향을 끼친다.
* Request/Response용 DTO : View를 위한 클래스라 자주 변경이 필요하다
* 따라서 View Layer와 DB Layer를 철저하게 역할 분리하는 것이 좋다.
* */

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    //id제외 Posts(Entity)와 동일함
    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
