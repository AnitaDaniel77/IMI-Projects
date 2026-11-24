-- More SQL examples from the reading (MySQL 8), with fixes where the reading was wrong

CREATE TABLE Sales (SaleID INT PRIMARY KEY, Product VARCHAR(50), Amount INT, Region VARCHAR(20));
INSERT INTO Sales VALUES (1, 'Laptop', 1000, 'East'), (2, 'Smartphone', 500, 'East'),
                         (3, 'Laptop', 1200, 'West'), (4, 'Smartphone', 700, 'West');

CREATE TABLE Customers (CustomerID INT PRIMARY KEY, Name VARCHAR(50));
INSERT INTO Customers VALUES (1, 'Alice'), (2, 'Bob'), (3, 'Charlie');

CREATE TABLE Orders (OrderID INT PRIMARY KEY, CustomerID INT, Amount INT,
                     FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID));
INSERT INTO Orders VALUES (101, 1, 500), (102, 2, 700);

CREATE TABLE Employees (EmployeeID INT PRIMARY KEY, Name VARCHAR(50), ManagerID INT);
INSERT INTO Employees VALUES (1, 'Alice', NULL), (2, 'Bob', 1), (3, 'Charlie', 1);

CREATE TABLE Regions (Region VARCHAR(20) PRIMARY KEY, TargetSales INT);
INSERT INTO Regions VALUES ('East', 1400), ('West', 1100);

-- GROUP BY: total per product
SELECT Product, SUM(Amount) AS TotalSales FROM Sales GROUP BY Product;

-- HAVING: only products over 1500
SELECT Product, SUM(Amount) AS TotalSales FROM Sales GROUP BY Product HAVING SUM(Amount) > 1500;

-- ORDER BY: biggest first
SELECT Product, SUM(Amount) AS TotalSales FROM Sales GROUP BY Product ORDER BY TotalSales DESC;

-- INNER JOIN: customers with orders
SELECT Customers.Name, Orders.Amount
FROM Customers INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID;

-- LEFT JOIN: all customers, NULL if no order
SELECT Customers.Name, Orders.Amount
FROM Customers LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID;

-- SELF JOIN: employee and their manager
SELECT E1.Name AS Employee, E2.Name AS Manager
FROM Employees E1 LEFT JOIN Employees E2 ON E1.ManagerID = E2.EmployeeID;

-- Subquery: customers with an order over 600
SELECT Name FROM Customers
WHERE CustomerID IN (SELECT CustomerID FROM Orders WHERE Amount > 600);

-- Window: ROW_NUMBER (fixed: join for Name, alias not "Rank")
SELECT c.Name, o.Amount, ROW_NUMBER() OVER (ORDER BY o.Amount DESC) AS RowNum
FROM Orders o JOIN Customers c ON o.CustomerID = c.CustomerID;

-- Window: region total on every row (gives 4 rows, East 1500, West 1900)
SELECT Region, Product, Amount, SUM(Amount) OVER (PARTITION BY Region) AS RegionalSales
FROM Sales;

-- CTE: products over 1000
WITH ProductSales AS (
    SELECT Product, SUM(Amount) AS TotalSales FROM Sales GROUP BY Product
)
SELECT Product, TotalSales FROM ProductSales WHERE TotalSales > 1000;

-- Two CTEs: actual vs target per region
WITH RegionalSales AS (
    SELECT Region, SUM(Amount) AS TotalSales FROM Sales GROUP BY Region
),
RegionalTargets AS (
    SELECT Region, TargetSales FROM Regions
)
SELECT RS.Region, RS.TotalSales, RT.TargetSales
FROM RegionalSales RS JOIN RegionalTargets RT ON RS.Region = RT.Region;=