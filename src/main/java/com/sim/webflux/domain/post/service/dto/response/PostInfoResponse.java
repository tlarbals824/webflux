package com.sim.webflux.domain.post.service.dto.response;

import com.sim.webflux.domain.post.domain.Post;

public record PostInfoResponse(Long postId, String title, String description, Long viewCount) {
    public static PostInfoResponse from(Post post){
        return new PostInfoResponse(post.getId(), post.getTitle(), post.getDescription(), post.getViewCount());
    }
}
