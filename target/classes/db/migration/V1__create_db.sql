create table if not exists team (
    id bigint not null,
    name varchar(256) not null,
    captain_id bigint,
    constraint team_PK primary key (id),
    constraint name_UQ unique (name)
);

create table if not exists player (
    id bigint not null,
    team_id bigint,
    first_name varchar(256) not null,
    last_name varchar(256) not null,
    position varchar(256) not null,
    birthday date not null,
    constraint player_PK primary key (id),
    constraint player_team_FK foreign key (team_id) references team
);

alter table team add constraint team_captain_FK foreign key (captain_id) references player;
