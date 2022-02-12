create table category
(
    category_id int auto_increment,
    name        varchar(100)          not null,
    is_deleted  boolean default false not null,
    constraint category_pk
        primary key (category_id)
);

create unique index category_category_id_uindex
    on category (category_id);

create table sub_category
(
    sub_category_id int auto_increment,
    category_id     int                   not null,
    name            varchar(100)          not null,
    is_deleted      boolean default false not null,
    constraint sub_category_pk
        primary key (sub_category_id),
    constraint sub_category_id_fk
        foreign key (category_id) references category (category_id)
);

create unique index sub_category_sub_category_id_uindex
    on sub_category (sub_category_id);

create table resource
(
    resource_id     int auto_increment,
    category_id     int                   not null,
    sub_category_id int                   null,
    name            varchar(100)          not null,
    is_deleted      boolean default false not null,
    constraint resource_pk
        primary key (resource_id)
);

create unique index resource_resource_id_uindex
    on resource (resource_id);

create table resource_picture
(
    resource_picture_id int auto_increment,
    resource_id         int                   not null,
    picture_path        varchar(100)          not null,
    is_deleted          boolean default false not null,
    constraint resource_picture_pk
        primary key (resource_picture_id)
);

create unique index resource_picture_resource_picture_id_uindex
    on resource_picture (resource_picture_id);


