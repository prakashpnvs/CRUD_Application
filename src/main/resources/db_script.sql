create database crud_db;
CREATE USER 'cruduser'@'%' IDENTIFIED BY 'crudpass';
GRANT ALL PRIVILEGES ON *.* TO 'cruduser'@'%';
USE crud_db;
CREATE TABLE products ( product_id BIGINT(19) UNSIGNED, product_type varchar(255), product_name varchar(255));
INSERT INTO products (product_id, product_type, product_name) VALUES (1, 'Electronics', 'PS4');
SELECT * FROM products;
