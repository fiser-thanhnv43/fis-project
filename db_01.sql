
create table user(
	idUser int auto_increment primary key,
	name varchar(30) not null
);
create table love(
	idLove int auto_increment primary key,
	idUser1 int,
	idUser2 int
);
insert into user(name)
	values('hong'),('linh'), ('trang'), ('quan'), ('tuyet'), ('quyen'),('phi'),('thai'),('huyen'), ('minh');
insert into love(idUser1, idUser2)
	values(1, 4),(2, 6), (3, 7), (9, 10), (5, 8);

select F.name as Nu, M.name as Nam 
from ( select love.idUser2, name from user join love on user.idUser = love.idUser1 ) as F 
join user as M 
on F.idUser2 = M.idUser