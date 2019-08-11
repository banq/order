create table order_table(
id integer identity primary key

);
create table order_item (
product_id varchar ,
qty integer ,
order_table integer ,
order_table_key integer identity primary key);

create table address (
street varchar ,
zip varchar ,
order_table integer,
 id integer identity primary key);

create table order_status (
state integer ,
order_table integer,
 id integer identity primary key);