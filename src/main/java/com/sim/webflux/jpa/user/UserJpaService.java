//package com.sim.webflux.jpa.user;
//
//import com.sim.webflux.domain.user.domain.User;
//import com.sim.webflux.domain.user.service.UserService;
//import com.sim.webflux.domain.user.service.dto.request.UserSignUpRequest;
//import com.sim.webflux.domain.user.service.dto.response.UserInfoResponse;
//import com.sim.webflux.domain.user.service.dto.response.UserSignUpResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//@Service
//@RequiredArgsConstructor
//public class UserJpaService implements UserService {
//
//        private final UserJpaRepository userJpaRepository;
//
//    @Override
//    public Mono<UserSignUpResponse> createUser(UserSignUpRequest request) {
//        return null;
//    }
//
//    @Override
//    public Mono<UserInfoResponse> getUserInfoByUserInfoResponse(Long userId) {
//        return null;
//    }
//
//    @Override
//    public Mono<User> findById(Long userId) {
//        return Mono.just(userJpaRepository.findById(userId).get())
//                .switchIfEmpty(Mono.error(new RuntimeException("not found user")));
//    }
//}
