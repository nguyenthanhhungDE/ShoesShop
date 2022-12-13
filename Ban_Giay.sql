create database Ban_Giay_Dep;
use Ban_Giay_Dep;
create table categories (
	categoryid char(10) primary key,
    categoryname nvarchar(255)
);
create table products (
	productid char(10) primary key,
    productname nvarchar(255),
    image varchar(255),
    price int,
    discount int,
    quantity int,
    status int,
    categoryid char(10),
    foreign key (categoryid) references categories (categoryid)
);
create table productsizes (
	productid char(10),
    size int,
    primary key (productid, size),
    foreign key (productid) references products (productid)
);
create table accounts (
	accountid char(10) primary key,
    username varchar(100),
    password varchar(100),
    isadmin bit default 1
);
create table customers (
	customerid char(10) primary key,
    lastname nvarchar(100),
    firstname nvarchar(100),
    gender varchar(10),
    phone varchar(11),
    address nvarchar(255),
    addressdelivery nvarchar(255),
    accountid char(10),
    foreign key (accountid) references accounts (accountid)
);
create table admins (
	adminid char(10) primary key,
    accountid char(10),
    foreign key (accountid) references accounts (accountid)
);
create table orders (
	orderid char(10) primary key,
    orderdate datetime,
    customerid char(10),
    foreign key (customerid) references customers (customerid)
);
create table orderdetails (
	orderdetailid char(10) primary key,
    price int,
    quantity int,
    size int,
    status int,
    orderid char(10),
    productid char(10),
    foreign key (orderid) references orders (orderid),
    foreign key (productid) references products (productid)
);
insert into accounts values ('ACC326', 'pro04112002@gmail.com', 'lhk', 0);
insert into accounts values ('ACC436', 'yen@gmail.com', 'lpy', 1);
insert into accounts values ('ACC249', 'luu@gmail.com', 'pql', 1);
insert into admins values ('ADM342', 'ACC326');
insert into customers values ('USR231', 'Le', 'Phuoc Yen', 'Nam', '0947537212', 'Dong Thap', '', 'ACC436');
insert into customers values ('USR632', 'Phan', 'Quoc Luu', 'Nam', '0947537364', 'Binh Dinh', '', 'ACC249');



--------------------------------------------------------------------------------------------------------
delimiter $$
Create trigger trg_CapNhatSoLuong  
after 
Insert ON orderdetails 
FOR EACH ROW
BEGIN 
	UPDATE products SET products.quantity = products.quantity - NEW.quantity WHERE productid = NEW.productid;
END$$
delimiter ;


select * from accounts;
select * from orders;
select * from orderdetails;
select * from customers;
select * from cateries;
select * from productsizes where productid = 'PR712';
select * from products where status = 1 order by discount limit 20;
select * from products where productid = 'PR526';
select p.productid, p.productname, p.image, count(od.quantity) as soluong, sum(od.price) as tong
from products p
join  orderdetails od
on p.productid = od.productid
join orders o
on o.orderid = od.orderid
where od.status = 1
group by p.productid,p.productname
Order by tong desc limit 3;
select * from productsizes;
select * from customers, accounts 
where 'ACC249' = customers.accountid and accounts.accountid = customers.accountid;

select c.customerid, c.lastname, c.firstname, count(o.orderid) as sodon, sum(od.price) as tong
from customers c
join orders o
on o.customerid = c.customerid
join orderdetails od
on od.orderid = o.orderid
where od.status = 1
group by c.customerid,c.firstname,c.lastname
Order by tong desc limit 5;


select products.image, products.productname, orderdetails.quantity, orderdetails.price, orders.orderdate, customers.lastname as lastname, customers.firstname as firstname, orderdetails.status 
from customers, products, orders, orderdetails
where orders.orderid = orderdetails.orderid
	and orderdetails.productid = products.productid
    and orders.customerid = customers.customerid
order by orders.orderdate desc;

select products.productid, products.productname, products.image, products.quantity, products.price, products.discount, products.status, cateries.cateryname
from products, cateries
where products.cateryid = cateries.cateryid; 



drop database ban_giay_dep