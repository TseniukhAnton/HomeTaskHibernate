create table developers
(
    id        serial not null primary key,
    firstName varchar(50),
    lastName  varchar(50),
    team_id   serial,
    FOREIGN KEY (team_id) REFERENCES teams (id)
);

create table teams
(
    id   serial not null primary key,
    name varchar(50),
    teamStatus varchar(15) null
);

create table skills
(
    id   serial not null primary key,
    name varchar(50)
);

create table developer_skills
(
    developer_id serial not null ,
    skill_id     serial not null ,
    CONSTRAINT fk_developer
        FOREIGN KEY (developer_id)
            REFERENCES developers (id),
    CONSTRAINT fk_skill
        FOREIGN KEY (skill_id)
            REFERENCES skills (id)
);

