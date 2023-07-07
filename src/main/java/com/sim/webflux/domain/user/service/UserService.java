package com.sim.webflux.domain.user.service;

import com.sim.webflux.domain.user.domain.User;
import com.sim.webflux.domain.user.service.dto.request.UserSignUpRequest;
import com.sim.webflux.domain.user.service.dto.response.UserInfoResponse;
import com.sim.webflux.domain.user.service.dto.response.UserSignUpResponse;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserSignUpResponse> createUser(UserSignUpRequest request);

    Mono<UserInfoResponse> getUserInfoByUserInfoResponse(Long userId);

    Mono<User> findById(Long userId);
}
