package com.sim.webflux.domain.post.service;

import com.sim.webflux.domain.post.service.dto.request.PostCreateRequest;
import com.sim.webflux.domain.post.service.dto.response.PostCreateResponse;
import com.sim.webflux.domain.post.service.dto.response.PostInfoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Flux<PostInfoResponse> getPostListByUserId(Long userId);

    Mono<PostCreateResponse> createPost(PostCreateRequest request);

    Mono<PostInfoResponse> getPostByPostId(Long postId);
}
