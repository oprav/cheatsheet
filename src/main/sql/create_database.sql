create sequence theme_id_seq;

create table theme
(
	id int primary key default nextval('theme_id_seq'),
	title varchar (100) not null
	
);

alter sequence theme_id_seq owned by theme.id;

create sequence topic_id_seq;

create table topic
(
	id int primary key default nextval('topic_id_seq'),
	theme_id int not null,
	title varchar (500) not null,
	sort_id int not null,
	is_delete bit not null
);

alter sequence topic_id_seq owned by topic.id;