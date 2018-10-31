DROP TABLE if exists board;

create table board (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(255) not null,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime,
    read_count int,
    primary key(id)
);

insert into board (id, title, name, content, regdate, read_count) values( null, 'title1', 'kim', 'hello content1', now(), 0);
insert into board (id, title, name, content, regdate, read_count) values( null, 'title2', 'kim', 'hello content2', now(), 0);
insert into board (id, title, name, content, regdate, read_count) values( null, 'title3', 'kim', 'hello content3', now(), 0);
insert into board (id, title, name, content, regdate, read_count) values( null, 'title4', 'kim', 'hello content4', now(), 0);
insert into board (id, title, name, content, regdate, read_count) values( null, 'title5', 'kim', 'hello content5', now(), 0);
