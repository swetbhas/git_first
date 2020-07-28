insert into course(id,name,last_updated_date,created_date) values(10001,'JPA found',sysdate(),sysdate());
insert into course(id,name,last_updated_date,created_date) values(10002,'Java',sysdate(),sysdate());
insert into course(id,name,last_updated_date,created_date) values(10003,'JPA Software',sysdate(),sysdate());


insert into passport(id,name) values(40001,'Ep123');
insert into passport(id,name) values(40002,'Java23');
insert into passport(id,name) values(40003,'Ja2222');


insert into student(id,name,passport_id) values(20001,'Ranga',40001);
insert into student(id,name,passport_id) values(20002,'Adam',40002);
insert into student(id,name,passport_id) values(20003,'Jane',40003);





insert into review(id,rating,description,course_id) values(50001,4,'Great course',10001);
insert into review(id,rating,description,course_id) values(50002,5,'awesome course',10001);
insert into review(id,rating,description,course_id) values(50003,4,'too good course',10002);
insert into review(id,rating,description,course_id) values(50004,5,'Great!!! course',10003);



