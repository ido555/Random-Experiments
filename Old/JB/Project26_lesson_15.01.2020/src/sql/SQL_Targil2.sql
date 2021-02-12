-- display average shipping_fee for all orders
-- display average shipping_fee for each ship_name
-- display number of products in each category
-- display min and max list_price of each product in each category
-- display min and max list_price of each product for each supplier

select avg(shipping_fee) from orders; -- 1.
select ship_name, avg(shipping_fee) from orders group by ship_name; -- 2.
select category, count(id) from products group by category; -- 3.
select category, max(list_price), min(list_price) from products group by category; -- 4.

select supplier_ids as SupplierID,
 max(list_price) as Max,
 min(list_price) as Min
 from products
 group by supplier_ids
 order by supplier_ids; -- 5.
