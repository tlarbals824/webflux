package com.sim.webflux.domain.user.domain;

import com.sim.webflux.common.entity.BaseEntity;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("USER")
@Getter
public class User extends BaseEntity {
    @Id
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
