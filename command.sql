drop table if exists admins;
create table admins(
	id int auto_increment primary key,
	realname varchar(30),
	email varchar(20) not null,
	passwd varchar(20) not null,
	qq varchar(20),
	phone varchar(20),
	type int,
	status int,
	photo varchar(20)
);

drop table if exists constants;
create table constants(
	type varchar(20),
	name int,
	title varchar(20)
);
insert into constants(type,name,title) values("admintype",1,"用户");
insert into constants(type,name,title) values("admintype",2,"商品");
insert into constants(type,name,title) values("admintype",3,"订单");
insert into constants(type,name,title) values("admintype",4,"物流");
insert into constants(type,name,title) values("adminstatus",1,"正常");
insert into constants(type,name,title) values("adminstatus",2,"禁用");
insert into constants(type,name,title) values("adminstatus",3,"删除");

drop table if exists phones;
create table phones(
	id int auto_increment primary key,
	fac_id int ,
	name varchar(20),
	price Double,
	phone_count int,
	description varchar(30)
);

drop table if exists factory;
create table factory(
	id int primary key,
	name varchar(20)
);
insert into factory(id,name) values (1,"三星");
insert into factory(id,name) values (2,"华为");
insert into factory(id,name) values (3,"小米");
insert into factory(id,name) values (4,"苹果");
insert into factory(id,name) values (5,"魅族");

create view phoneVw as
select phones.id as id,fac_id,phones.name,price,phone_count,description,factory.name as fac_name
from phones,factory
where phones.fac_id = factory.id;



