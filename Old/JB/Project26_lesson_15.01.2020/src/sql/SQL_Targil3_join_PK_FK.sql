-- display the the product_name, product_code, list_price,
--  (suppliers) suppliers last_name, (suppliers)  first_name 
select 
suppliers.first_name as 'Supplier first name',
suppliers.last_name as 'Supplier last name',
products.supplier_ids as 'supplier ID foreign key',
product_name, product_code, products.id as 'product id primary key', 
list_price from products
join suppliers on suppliers.id = products.supplier_ids