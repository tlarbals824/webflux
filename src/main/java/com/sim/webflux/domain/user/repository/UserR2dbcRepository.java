package com.sim.webflux.domain.user.repository;

import com.sim.webflux.domain.user.domain.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserR2dbcRepository extends R2dbcRepository<User, Long> {
    Mono<Boolean> existsByUsername(String username);
}
