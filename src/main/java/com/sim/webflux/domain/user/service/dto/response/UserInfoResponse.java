package com.sim.webflux.domain.user.service.dto.response;

import java.time.LocalDateTime;

public record UserInfoResponse(String username, String password, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
}
