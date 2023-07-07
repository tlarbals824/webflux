package com.sim.webflux.domain.post.domain;

import com.sim.webflux.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("POST")
@Getter
//@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

//    @jakarta.persistence.Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Id
    private Long id;
    private String title;
    private String description;
    private Long viewCount;
    private Long userId;


    @PersistenceCreator
    public Post(Long id, String title, String description, Long viewCount, Long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.viewCount = viewCount;
        this.userId = userId;
    }



    public Post(String title, String description, Long userId) {
        this(null, title,description, 0L, userId);
    }
}
