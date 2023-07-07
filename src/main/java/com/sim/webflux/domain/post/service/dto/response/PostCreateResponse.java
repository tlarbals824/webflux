package com.sim.webflux.domain.post.service.dto.response;

import com.sim.webflux.domain.post.domain.Post;

public record PostCreateResponse(Long postId, String title, String description, Long viewCount, Long userId) {
    public static PostCreateResponse from(Post post){
        return new PostCreateResponse(post.getId(), post.getTitle(), post.getDescription(), post.getViewCount(), post.getUserId());
    }
}
