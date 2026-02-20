create table cinema_session (
                                cinema_id bigint not null,
                                session_id bigint not null
);

alter table if exists cinema_session
    add constraint FKqyx26k096nkocgmtrgq2p4l6v
        foreign key (session_id)
            references session;

alter table if exists cinema_session
    add constraint FKq7hd1tdiuy1m844inu2xb7ofj
        foreign key (cinema_id)
            references cinema;