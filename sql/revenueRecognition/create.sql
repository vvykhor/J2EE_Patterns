create database revenue_recognition;

create table products (
    id int not null,
    name VARCHAR(100),
    type VARCHAR(100),
    primary key (id)
);

create table contracts (
    id int not null,
    product_id int,
    revenue decimal,
    date_signed date,
    primary key (id)
);

create table revenue_recognitions (
    contract int,
    amount decimal,
    recognized_on date,
    primary key (contract, recognized_on)
);