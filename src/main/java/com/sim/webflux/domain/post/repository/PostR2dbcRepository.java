package com.sim.webflux.domain.post.repository;

import com.sim.webflux.domain.post.domain.Post;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface PostR2dbcRepository extends R2dbcRepository<Post, Long> {

    Flux<Post> findAllByUserId(Long userId);

}
