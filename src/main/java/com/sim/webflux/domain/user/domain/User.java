package com.sim.webflux.domain.user.domain;

import com.sim.webflux.common.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("USER")
@Getter
//@Entity
@NoArgsConstructor
public class User extends BaseEntity {
//    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    private Long id;
    private String username;
    private String password;

    @PersistenceCreator
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this(null, username, password);
    }

}
