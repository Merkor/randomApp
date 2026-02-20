create table session (
                         id bigint not null,
                         session_time timestamp(6),
                         name varchar(255),
                         primary key (id)
)