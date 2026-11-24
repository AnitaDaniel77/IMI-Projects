-- Bookstore example: DDL, DML and a stored procedure (MySQL)

-- DDL: create the table
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    price DECIMAL(10, 2)
);

-- DDL: add a column
ALTER TABLE Books ADD publication_year INT;

-- DML: add books
INSERT INTO Books (book_id, title, author, price, publication_year)
VALUES (1, 'Clean Code', 'Robert Martin', 450.00, 2008);

INSERT INTO Books (book_id, title, author, price, publication_year)
VALUES (2, 'Head First Java', 'Kathy Sierra', 520.00, 2022);

-- DML: change a price
UPDATE Books SET price = 399.99 WHERE book_id = 1;

-- DQL: read books by one author
SELECT * FROM Books WHERE author = 'Kathy Sierra';

-- DML: remove a book
DELETE FROM Books WHERE book_id = 2;

-- Procedure: total value of all books
DELIMITER //
CREATE PROCEDURE total_book_value()
BEGIN
    SELECT SUM(price) AS total_value FROM Books;
END //
DELIMITER ;

-- Run the procedure
CALL total_book_value();

-- DDL: delete the whole table (only when you're done practising)
-- DROP TABLE Books;