create table if not exists category
(
    id integer not null primary key,
    name varchar(255),
    description varchar(255)
);

create table if not exists mission
(
    id integer not null primary key,
    title varchar(255),
    description varchar(255),
    start_date DATE NOT NULL DEFAULT CURRENT_DATE,
    end_date DATE NOT NULL DEFAULT CURRENT_DATE,
    status varchar(255),
    category_id integer constraint fk_category_mission references category,
    tjm numeric(38,2),
    address varchar(255),
    phone varchar(255),
    email varchar(255)
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists mission_seq increment by 50;