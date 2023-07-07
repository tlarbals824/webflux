drop table if exists POST;

CREATE TABLE if not exists POST(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title varchar(100) not null,
    description varchar(100) not null,
    view_count bigint not null,
    created_date DATETIME NOT NULL,
    last_modified_date DATETIME NOT NULL,
    user_id bigint not null,
    foreign key (user_id) references USER(id)
)