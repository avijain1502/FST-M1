REM   Script: Activity_1_5
REM   FST_Activities

create table salesman(salesman_id int, salesman_name varchar2(255), salesman_city varchar2(255), commission int) 
 
;

create table salesman(salesman_id int, salesman_name varchar2(255), salesman_city varchar2(255), commission int);

Discribe salesman; 


describe salesman


insert into salesman (1,Avi,Bangalore,25);

insert into salesman (1,Avi,Bangalore,25);

insert into salesman (1,Avi,Bangalore,25) select 1 from dual;

insert all into salesman (1,Avi,Bangalore,25) select 1 from dual;

insert all into salesman (1,"Avi","Bangalore",25) select 1 from dual;

insert all into salesman values(1,"Avi","Bangalore",25) select 1 from dual;

insert all  
    into salesman values(1,"Avi","Bangalore",25)  
    select 1 from dual;

insert all  
    into salesman values(1,"Avi","Indore",25)  
    select 1 from dual;

insert all  
    into salesman values(1,'Avi','Indore',25)  
    select 1 from dual;

insert all  
    into salesman values(5001,'James Hoog ','New York',15)  
    into salesman values(5002,'Nail Knite','Paris',13)  
    into salesman values(5005,'Pit Alex','London',11)  
    into salesman values(5006,'McLyon','Paris',14)  
    into salesman values(5007,'Paul Adam','Rome',13)  
    into salesman values(5003,'Lauson Hen','San Jose',12)  
    select 1 from dual;

select * from salesman;

