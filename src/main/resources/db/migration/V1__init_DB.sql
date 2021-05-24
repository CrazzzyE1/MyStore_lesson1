drop table if exists buckets cascade;
drop table if exists buckets_products cascade;
drop table if exists categories cascade;
drop table if exists orders cascade;
drop table if exists orders_details cascade;
drop table if exists products cascade;
drop table if exists products_categories cascade;
drop table if exists users cascade;
drop sequence if exists bucket_seq;
drop sequence if exists category_seq;
drop sequence if exists order_details_seq;
drop sequence if exists order_seq;
drop sequence if exists product_seq;
drop sequence if exists user_seq;
create sequence bucket_seq start 1 increment 1;
create sequence category_seq start 1 increment 1;
create sequence order_details_seq start 1 increment 1;
create sequence order_seq start 1 increment 1;
create sequence product_seq start 1 increment 1;
create sequence user_seq start 1 increment 1;
create table buckets
(
    id      int8 not null,
    user_id int8,
    primary key (id)
);
create table buckets_products
(
    bucket_id  int8 not null,
    product_id int8 not null
);
create table categories
(
    id    int8 not null,
    title varchar(255),
    primary key (id)
);
create table orders
(
    id      int8 not null,
    address varchar(255),
    created timestamp,
    status  varchar(255),
    sum     numeric(19, 2),
    updated timestamp,
    user_id int8,
    primary key (id)
);
create table orders_details
(
    id         int8 not null,
    amount     numeric(19, 2),
    price      numeric(19, 2),
    order_id   int8,
    product_id int8,
    details_id int8 not null,
    primary key (id)
);
create table products
(
    id    int8 not null,
    price numeric(19, 2),
    title varchar(255),
    primary key (id)
);
create table products_categories
(
    product_id  int8 not null,
    category_id int8 not null
);
create table users
(
    id        int8    not null,
    archive   boolean not null,
    email     varchar(255),
    name      varchar(255),
    password  varchar(255),
    role      varchar(255),
    bucket_id int8,
    primary key (id)
);
alter table if exists orders_details add constraint UK_details_id unique (details_id);
alter table if exists buckets add constraint FK_user_id foreign key (user_id) references users;
alter table if exists buckets_products add constraint FK_product_id foreign key (product_id) references products;
alter table if exists buckets_products add constraint FK_bucket_id foreign key (bucket_id) references buckets;
alter table if exists orders add constraint FK_user_id_users foreign key (user_id) references users;
alter table if exists orders_details add constraint FK_order_id foreign key (order_id) references orders;
alter table if exists orders_details add constraint FK_product_id_products foreign key (product_id) references products;
alter table if exists orders_details add constraint FK_details_id foreign key (details_id) references orders_details;
alter table if exists products_categories add constraint FK_category_id foreign key (category_id) references categories;
alter table if exists products_categories add constraint FK_product_id_prod foreign key (product_id) references products;
alter table if exists users add constraint FK_bucket_id foreign key (bucket_id) references buckets;


