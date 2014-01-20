# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table commentaire (
  id                        bigint not null,
  commentaire               varchar(255),
  date                      timestamp,
  cible                     varchar(255),
  user                      varchar(255),
  constraint pk_commentaire primary key (id))
;

create table lien (
  id                        bigint not null,
  lien1                     varchar(255),
  lien2                     varchar(255),
  date                      timestamp,
  constraint pk_lien primary key (id))
;

create table sous_commentaire (
  idd                       bigint not null,
  souscommentaire           varchar(255),
  date1                     timestamp,
  scommcible                varchar(255),
  user                      varchar(255),
  comm_id                   bigint,
  constraint pk_sous_commentaire primary key (idd))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create sequence commentaire_seq;

create sequence lien_seq;

create sequence sous_commentaire_seq;

create sequence user_seq;

alter table sous_commentaire add constraint fk_sous_commentaire_comm_1 foreign key (comm_id) references commentaire (id) on delete restrict on update restrict;
create index ix_sous_commentaire_comm_1 on sous_commentaire (comm_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists commentaire;

drop table if exists lien;

drop table if exists sous_commentaire;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists commentaire_seq;

drop sequence if exists lien_seq;

drop sequence if exists sous_commentaire_seq;

drop sequence if exists user_seq;

