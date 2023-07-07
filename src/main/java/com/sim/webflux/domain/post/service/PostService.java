package com.sim.webflux.domain.post.service;

import com.sim.webflux.common.exception.BusinessException;
import com.sim.webflux.domain.post.domain.Post;
import com.sim.webflux.domain.post.repository.PostR2dbcRepository;
import com.sim.webflux.domain.post.service.dto.request.PostCreateRequest;
import com.sim.webflux.domain.post.service.dto.response.PostCreateResponse;
import com.sim.webflux.domain.post.service.dto.response.PostInfoResponse;
import com.sim.webflux.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostR2dbcRepository postR2dbcRepository;
    private final UserService userService;

    public Flux<PostInfoResponse> getPostListByUserId(Long userId){
        return userService.findById(userId)
                .flatMapMany(user -> Flux.merge(postR2dbcRepository.findAllByUserId(userId))
                        .map(PostInfoResponse::from));
    }

    public Mono<PostCreateResponse> createPost(PostCreateRequest request){
        return postR2dbcRepository.save(new Post(request.getTitle(), request.getDescription(), request.getUserId()))
                .map(PostCreateResponse::from);
    }

    public Mono<PostInfoResponse> getPostByPostId(Long postId){
        return findById(postId)
                .map(PostInfoResponse::from);
    }

    public Mono<Post> findById(Long postId){
        return postR2dbcRepository.findById(postId)
                .switchIfEmpty(Mono.error(new BusinessException("not found post")));
    }
}
