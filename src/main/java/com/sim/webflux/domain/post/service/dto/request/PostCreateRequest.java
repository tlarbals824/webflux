package com.sim.webflux.domain.post.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreateRequest {
    private String title;
    private String description;
    private Long userId;
}
