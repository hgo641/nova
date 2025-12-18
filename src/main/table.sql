    create table message (
        created_at datetime(6),
        id bigint not null auto_increment,
        message varchar(255),
        primary key (id)
    ) engine=InnoDB