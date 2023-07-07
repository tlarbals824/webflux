//package com.sim.webflux.jpa.post;
//
//import com.sim.webflux.domain.post.domain.Post;
//import com.sim.webflux.domain.post.service.PostService;
//import com.sim.webflux.domain.post.service.dto.request.PostCreateRequest;
//import com.sim.webflux.domain.post.service.dto.response.PostCreateResponse;
//import com.sim.webflux.domain.post.service.dto.response.PostInfoResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//@RequiredArgsConstructor
//public class PostJpaService implements PostService {
//
//    private final PostJpaRepository postJpaRepository;
//
//    @Override
//    public Flux<PostInfoResponse> getPostListByUserId(Long userId) {
//        return Flux.just(postJpaRepository.findAllByUserId(userId))
//                .flatMapIterable(post -> post)
//                .map(PostInfoResponse::from);
//
//    }
//
//    @Override
//    public Mono<PostCreateResponse> createPost(PostCreateRequest request) {
//        Post post = postJpaRepository.save(new Post(request.getTitle(), request.getDescription(), request.getUserId()));
//        return Mono.just(post)
//                .map(PostCreateResponse::from);
//    }
//
//    @Override
//    public Mono<PostInfoResponse> getPostByPostId(Long postId) {
//        return Mono.just(postJpaRepository.findById(postId).orElseThrow())
//                .map(PostInfoResponse::from);
//    }
//}
