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
select * from Person
where age > 21
order by dateTimeCreate asc;