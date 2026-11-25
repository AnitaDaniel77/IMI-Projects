-- Starter rows, INSERT IGNORE skips them if they already exist
INSERT IGNORE INTO Books (BookID, Title, Author, Price) VALUES
    (1, 'Java Basics', 'Author X', 350.00),
    (2, 'Spring Boot in Practice', 'Author Y', 560.00);