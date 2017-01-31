alter table user_role change user_role_id user_role_id varchar(20);
alter table user change user_role_id user_role_id varchar(20);
insert into user_role(user_role_id,description) values('ROLE_ADMIN','ADMIN');
insert into user_role(user_role_id,description) values('ROLE_USR','USER');

insert into user(username,password,name,user_role_id,active) values('admin','admin','admin','ROLE_ADMIN','S');
insert into user(username,password,name,user_role_id,active) values('dani','dani','dani','ROLE_USR','S');