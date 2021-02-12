-- select distinct city from employees -- only first appearance shown 
-- concat is a function
-- as = name the column
-- select concat(first_name, ' ', last_name) as 'Full Name' from employees;
-- count another function
select count(city) from employees; -- if worker forgot to add his city this wont count him
-- avg(id) sum()
-- min(), max() -- also work on dates
select category, sum(standard_cost)
 from products
 group by category
 order by category; -- A - Z --- 0 - INFINITY --- aes - desc -- descending ascending
