-- Books table and AddBook procedure for Db11BookCrud.java (MySQL)

DROP TABLE IF EXISTS Books;
CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(100) NOT NULL,
    Author VARCHAR(50),
    Price DOUBLE,
    Genre VARCHAR(30),
    PublicationDate DATE,
    PublisherID INT
);

INSERT INTO Books (Title, Author, Price, Genre, PublicationDate, PublisherID) VALUES
    ('Java Basics', 'Author X', 350.00, 'Programming', '2020-05-10', 1),
    ('Clean Code', 'Author Z', 450.00, 'Programming', '2008-08-01', 2);

DROP PROCEDURE IF EXISTS AddBook;
DELIMITER //
CREATE PROCEDURE AddBook(
    IN pTitle VARCHAR(100), IN pAuthor VARCHAR(50), IN pPrice DOUBLE,
    IN pGenre VARCHAR(30), IN pDate DATE, IN pPublisherId INT)
BEGIN
    INSERT INTO Books (Title, Author, Price, Genre, PublicationDate, PublisherID)
    VALUES (pTitle, pAuthor, pPrice, pGenre, pDate, pPublisherId);
END //
DELIMITER ;