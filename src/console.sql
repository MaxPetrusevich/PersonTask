create schema People;
use People;
create table Person(
    id int primary key auto_increment,
    age int,
    salary double,
    passport varchar(10),
    address character(200),
    dateOfBirthday date,
    dateTimeCreate datetime,
    timeToLunch time,
    letter text
);

insert into Person values
(1, 27, 705.5, '1535f134g', 'Baker street', '1995-01-15','2010-05-06 02:21:21', '12:00:00','Hello'),
(2, 29, 1993.2, '6546fh24g', 'New Avenue','1993-01-30','2015-07-09 20:13:43', '13:21:10','Hi'),
(3, 15, 0, '9854gh42r', 'Victory Place','2008-01-09','2020-12-25 14:45:23','15:30:22','Good morning'),
(4, 20, 1000,'2358gd46j','Boulevard of Broken Dreams', '2002-08-12','2011-10-10 10:10:10', '14:27:56','Im tired'),
(5,21,953, '4865it45i','Empty Street','2001-10-26','2008-03-15 21:54:21','16:56:33','Hello world');

select * from Person
where age > 21
order by dateTimeCreate asc;