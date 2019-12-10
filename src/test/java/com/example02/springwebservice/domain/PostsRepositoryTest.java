package com.example02.springwebservice.domain;

import com.example02.springwebservice.domain.posts.Posts;
import com.example02.springwebservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        //이후 테스트 코드에 영향 끼치지 않기위해 테스트 메소드가 끝날 때 마다 respository 전체 비우는 코드
        postsRepository.deleteAll();
    }

    @Test
    public void postSaveAndPrint(){
        //given
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .content("테스트 본문")
            .author("han@gmail.com")
            .build());

        //when
        List<Posts> postsLst = postsRepository.findAll();

        //then
        Posts posts = postsLst.get(0);
        assertThat(posts.getTitle(),is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntityInsert(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("날짜입력 테스트 게시글")
                .content("날짜입력 테스트 본문")
                .author("yerin@gmail.com")
                .build()
                );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
