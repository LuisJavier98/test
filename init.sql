CREATE TABLE Clients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(100),
    phone VARCHAR(100)
);

CREATE TABLE Products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    price NUMERIC(10,2)
);

INSERT INTO Clients (name,address, phone) VALUES ('Luis','Av...', '99898989');

INSERT INTO Products (name,description, price) VALUES ('Laptop','use for', 999.99);
INSERT INTO Products (name,description, price) VALUES ('iPhone','use for', 2500.00);