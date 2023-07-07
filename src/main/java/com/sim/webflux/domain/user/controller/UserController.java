package com.sim.webflux.domain.user.controller;

import com.sim.webflux.domain.user.service.UserService;
import com.sim.webflux.domain.user.service.dto.request.UserSignUpRequest;
import com.sim.webflux.domain.user.service.dto.response.UserInfoResponse;
import com.sim.webflux.domain.user.service.dto.response.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public Mono<UserInfoResponse> getUserInfo(@PathVariable Long userId){
        return userService.getUserInfoByUserInfoResponse(userId);
    }

    @PostMapping("/signUp")
    public Mono<UserSignUpResponse> signUp(@RequestBody UserSignUpRequest userSignUpRequest){
        return userService.createUser(userSignUpRequest);
    }


}
