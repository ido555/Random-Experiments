-- insert new employee
-- insert into employees values(10,'Northwind Traders', 'gal','nir');
-- insert into employees(id,first_name,last_name,job_title)
-- values (12,'Nir','Gal','CEO');
-- delete from employees where id = 12;
update employees set employees.job_title = "Java Developer", employees.last_name="Bezos" where id = 10;
select * from employees;
