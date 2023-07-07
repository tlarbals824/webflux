# webflux

## 테이블

### USER

~~~
CREATE TABLE IF NOT EXISTS USER(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_date DATETIME NOT NULL,
    last_modified_date DATETIME NOT NULL
);
~~~

### POST

~~~
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
~~~

### R2DBC SELECT,INSERT 테스트

조건 : postman runs를 이용한 테스트, 1000건 데이터 입력 후 1000건 데이터 조회 1000번 반복, user,post 연관관계 설정

* 1000 데이터 입력 : 총 시간(21s154ms), 평균 시간(6ms/data)
* 1000 데이터 조회 1000번 반복 : 총 시간(50s759ms), 평균 시간(42ms/data)

