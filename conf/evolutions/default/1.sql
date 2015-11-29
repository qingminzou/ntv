# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table catagory (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  lft                       bigint,
  rgt                       bigint,
  last_updated_at           datetime,
  last_updated_by           varchar(255),
  created_by                varchar(255),
  created_at                datetime,
  parent_id                 bigint,
  constraint pk_catagory primary key (id))
;

alter table catagory add constraint fk_catagory_parent_1 foreign key (parent_id) references catagory (id) on delete restrict on update restrict;
create index ix_catagory_parent_1 on catagory (parent_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table catagory;

SET FOREIGN_KEY_CHECKS=1;

