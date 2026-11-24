-- Table and stored procedures used by Db10PreparedCallable.java (MySQL)

DROP TABLE IF EXISTS Books;
CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(100) NOT NULL,
    Author VARCHAR(50),
    Price DOUBLE
);

INSERT INTO Books (Title, Author, Price) VALUES
    ('Java Basics', 'Author X', 350.00),
    ('SQL Made Simple', 'Author Y', 420.00);

-- IN parameter, returns rows
DROP PROCEDURE IF EXISTS GetBooksByAuthor;
DELIMITER //
CREATE PROCEDURE GetBooksByAuthor(IN authorName VARCHAR(50))
BEGIN
    SELECT Title, Price FROM Books WHERE Author = authorName;
END //
DELIMITER ;

-- IN and OUT parameter, returns one value
DROP PROCEDURE IF EXISTS GetAveragePrice;
DELIMITER //
CREATE PROCEDURE GetAveragePrice(IN authorName VARCHAR(50), OUT avgPrice DOUBLE)
BEGIN
    SELECT AVG(Price) INTO avgPrice FROM Books WHERE Author = authorName;
END //
DELIMITER ;