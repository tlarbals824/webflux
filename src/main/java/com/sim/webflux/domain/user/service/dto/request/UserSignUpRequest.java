package com.sim.webflux.domain.user.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignUpRequest {
    private String username;
    private String password;
}
