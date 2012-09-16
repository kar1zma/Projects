--create the table student
drop table student cascade constraints;
create table  student (
	sid	varchar2(5) not null,
	name	varchar2(15) not null,
	class	number(2),
	major	varchar2(10),
	primary key(sid));


--create table student_dir

drop table student_dir cascade constraints;
create table student_dir (
	sid 	varchar2(5) not null,
	address varchar2(30),
	phone	varchar2(15),
	primary key(sid),
	foreign key (sid) references student(SID));

--create table course
drop table course cascade constraints;
create table course (
	course_no	varchar2(10) not null,
	name		varchar2(50),
	course_level		varchar2(10),
	primary key(course_no));

--create table course_taken

drop table courses_taken cascade constraints;
create table courses_taken (
	course_no	varchar2(10) not null,
	sid		varchar2(5) not null,
	term		varchar2(15),
	grade		number(3,2),
	primary key(course_no, sid, term),
	foreign key(course_no) references course(course_no),
	foreign key(sid) references student(sid));

--insert data into student table 
insert into student(sid, name, class, major)
	values('123', 'John', 3, 'CS');

insert into student(sid, name, class, major)
	values('124', 'Mary', 3, 'CS');

insert into student(sid, name, class, major)
	values('126', 'Sam', 2, 'CS');

insert into student(sid, name, class, major)
	values('129', 'Julie', 2, 'Math');


--insert data into student_dir table

insert into student_dir(sid, address, phone)
	values('123', '333 Library St', '555-535-5263');

insert into student_dir(sid, address, phone)
	values('124', '219 Library St', '555-963-9653');

insert into student_dir(sid, address, phone)
	values('129', '555 Library St', '555-123-4567');

--insert data into course

insert into course(course_no, name, course_level)
	values('CS1520', 'Web Applications', 'UGrad');

insert into course(course_no, name, course_level)
	values('CS1555', 'Database Management Systems', 'UGrad');

insert into course(course_no, name, course_level)
	values('CS1550', 'Operating Systems', 'UGrad');

insert into course(course_no, name, course_level)
	values('CS2550', 'Database Management Systems', 'Grad');

insert into course(course_no, name, course_level)
	values('CS1655', 'Secure Data Management and Web Applications', 'UGrad');


--insert into course_taken
insert into courses_taken(course_no, sid, term, grade)
	values('CS1520', '123', 'Spring 09', 3.75);

insert into courses_taken(course_no, sid, term, grade)
	values('CS1520', '124', 'Spring 09', 4);

insert into courses_taken(course_no, sid, term, grade)
	values('CS1520', '126', 'Spring 09', 3);

insert into courses_taken(course_no, sid, term, grade)
	values('CS1555', '123', 'Spring 09', 4);

insert into courses_taken(course_no, sid, term, grade)
	values('CS1555', '124', 'Spring 09', null);

insert into courses_taken(course_no, sid, term, grade)
	values('CS1550', '123', 'Fall 10', null );

insert into courses_taken(course_no, sid, term, grade)
	values('CS1550', '124', 'Fall 10', null );

insert into courses_taken(course_no, sid, term, grade)
	values('CS1550', '126', 'Fall 10', null );

insert into courses_taken(course_no, sid, term, grade)
	values('CS1550', '129', 'Fall 10', null );

insert into courses_taken(course_no, sid, term, grade)
	values('CS2550', '124', 'Fall 10', null );

insert into courses_taken(course_no, sid, term, grade)
	values('CS1520', '126', 'Fall 10', null );

--display a head-up
prompt finish creating tables and inserting data;






	



