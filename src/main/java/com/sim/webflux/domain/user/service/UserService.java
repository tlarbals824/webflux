package com.sim.webflux.domain.user.service;

import com.sim.webflux.common.exception.BusinessException;
import com.sim.webflux.domain.user.domain.User;
import com.sim.webflux.domain.user.repository.UserR2dbcRepository;
import com.sim.webflux.domain.user.service.dto.request.UserSignUpRequest;
import com.sim.webflux.domain.user.service.dto.response.UserInfoResponse;
import com.sim.webflux.domain.user.service.dto.response.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserR2dbcRepository userR2dbcRepository;

    public Mono<UserSignUpResponse> createUser(UserSignUpRequest request) {
        return userR2dbcRepository.existsByUsername(request.getUsername())
                .flatMap(exist -> {
                    if (!exist) {
                        return userR2dbcRepository.save(new User(request.getUsername(), request.getPassword()))
                                .map(user -> new UserSignUpResponse(user.getId(), user.getUsername(), user.getPassword()));
                    }
                    return Mono.error(new BusinessException("already user exist"));
                });
    }

    public Mono<UserInfoResponse> getUserInfoByUserInfoResponse(Long userId){
        return findById(userId)
                .map(user -> new UserInfoResponse(user.getUsername(), user.getPassword(), user.getCreatedDate(), user.getLastModifiedDate()));
    }

    public Mono<User> findById(Long userId){
        return userR2dbcRepository.findById(userId)
                .switchIfEmpty(Mono.error(new BusinessException("not found user")));
    }


}
