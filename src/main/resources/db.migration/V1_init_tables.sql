create table developers
(
    id bigint auto_increment not null primary key,
    firstName varchar(50),
    lastName varchar(50),
    skills varchar(255)
);

create table teams
(
    id bigint auto_increment not null primary key,
    name varchar(50),
    developers varchar(255)
);

create table skills
(
    id bigint auto_increment not null primary key,
    name varchar(50)
);