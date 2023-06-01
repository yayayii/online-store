create table if not exists company (
    id bigint generated by default as identity primary key,
    name varchar(50) unique not null
);

create table if not exists computer (
    id bigint generated by default as identity primary key,
    series varchar(50) unique not null,
    company_id int references company not null,
    price double not null,
    amount int not null,
    form_factor varchar not null
);

create table if not exists laptop (
    id bigint generated by default as identity primary key,
    series varchar(50) unique not null,
    company_id int references company not null,
    price double not null,
    amount int not null,
    screen_size int not null
);

create table if not exists monitor (
    id bigint generated by default as identity primary key,
    series varchar(50) unique not null,
    company_id int references company not null,
    price double not null,
    amount int not null,
    screen_size int not null
);

create table if not exists hdd (
    id bigint generated by default as identity primary key,
    series varchar(50) unique not null,
    company_id int references company not null,
    price double not null,
    amount int not null,
    storage_size double not null
);