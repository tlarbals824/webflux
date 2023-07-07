package com.sim.webflux.domain.post.controller;

import com.sim.webflux.domain.post.service.PostService;
import com.sim.webflux.domain.post.service.dto.request.PostCreateRequest;
import com.sim.webflux.domain.post.service.dto.response.PostCreateResponse;
import com.sim.webflux.domain.post.service.dto.response.PostInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    /**
     * 리팩터링 전 : 연관관계 1개, 1000개 데이터 조회시간 : 50s759ms, 개당 평균 조회 시간 : 42ms/data
     *
     */
    @GetMapping()
    public Flux<PostInfoResponse> getPostListByUserId(@RequestParam Long userId){
        return postService.getPostListByUserId(userId);
    }

    /**
     * 리팩터링 전 : 연관관계 1개, 1000개 데이터 입력시간 : 21s154ms, 개당 평균 입력 시간 : 6ms/data
     *
     */
    @PostMapping()
    public Mono<PostCreateResponse> createPost(@RequestBody PostCreateRequest request){
        return postService.createPost(request);
    }


    @GetMapping("/info")
    public Mono<PostInfoResponse> getPostByPostId(@RequestParam Long postId){
        return postService.getPostByPostId(postId);
    }

}
