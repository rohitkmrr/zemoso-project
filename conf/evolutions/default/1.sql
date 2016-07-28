# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_data (
  note_id                       bigint auto_increment not null,
  user_id                       integer,
  title                         varchar(255),
  description                   varchar(255),
  state                         integer,
  reminder_start                datetime(6),
  modified_on                   datetime(6),
  is_reminder_set               integer,
  created_on                    datetime(6),
  deleted_on                    varchar(255),
  constraint pk_user_data primary key (note_id)
);

create table user_registration (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  email                         varchar(255),
  constraint pk_user_registration primary key (id)
);


# --- !Downs

drop table if exists user_data;

drop table if exists user_registration;

