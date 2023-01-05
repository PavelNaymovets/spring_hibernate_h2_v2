DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255),  price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Молоко', 100), ('Хлеб', 70), ('Мороженое', 10), ('Конфеты', 90), ('Сахар', 50);
DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255));
INSERT INTO customers (name) VALUES ('Bob'), ('Ivan'), ('Jo');
DROP TABLE IF EXISTS products_customers CASCADE;
CREATE TABLE IF NOT EXISTS products_customers (product_id integer REFERENCES products(id), customer_id integer REFERENCES customers(id))
INSERT INTO products_customers (product_id, customer_id) VALUES (1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (4,1), (5,1);