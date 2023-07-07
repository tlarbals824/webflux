package com.sim.webflux.r2dbc.post;

import com.sim.webflux.common.exception.BusinessException;
import com.sim.webflux.domain.post.domain.Post;
import com.sim.webflux.domain.post.service.PostService;
import com.sim.webflux.domain.post.service.dto.request.PostCreateRequest;
import com.sim.webflux.domain.post.service.dto.response.PostCreateResponse;
import com.sim.webflux.domain.post.service.dto.response.PostInfoResponse;
import com.sim.webflux.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostR2dbcService implements PostService {

    private final PostR2dbcRepository postR2dbcRepository;
    private final UserService userService;

    public Flux<PostInfoResponse> getPostListByUserId(Long userId) {
        return postR2dbcRepository.findAllByUserId(userId)
                .flatMap(post -> Flux.just(PostInfoResponse.from(post)));
    }

    public Mono<PostCreateResponse> createPost(PostCreateRequest request) {
        return postR2dbcRepository.save(new Post(request.getTitle(), request.getDescription(), request.getUserId()))
                .map(PostCreateResponse::from);
    }

    public Mono<PostInfoResponse> getPostByPostId(Long postId) {
        return findById(postId)
                .map(PostInfoResponse::from);
    }

    public Mono<Post> findById(Long postId) {
        return postR2dbcRepository.findById(postId)
                .switchIfEmpty(Mono.error(new BusinessException("not found post")));
    }
}
