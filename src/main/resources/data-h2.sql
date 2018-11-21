INSERT INTO author VALUES (NEXT VALUE FOR s_author_id, 'George', 'Orwell', '1903-06-25', 1903, 'american');
INSERT INTO author VALUES (NEXT VALUE FOR s_author_id, 'Paulo', 'Coelho', '1947-08-24', 1947, 'english');

INSERT INTO book VALUES (1, 1, NULL, NULL, '1984', 1948, 1,
                            'To know and not to know, to be conscious of complete truthfulness while telling carefully constructed lies, to hold simultaneously two opinions which cancelled out, knowing them to be contradictory and believing in both of them, to use logic against logic, to repudiate morality while laying claim to it, to believe that democracy was impossible and that the Party was the guardian of democracy, to forget, whatever it was necessary to forget, then to draw it back into memory again at the moment when it was needed, and then promptly to forget it again, and above all',
                            NULL, TRUE, 1, '2010-01-01 12:32:45');
INSERT INTO book VALUES (2, 1, NULL, NULL, 'Animal Farm', 1945, 1, NULL, NULL, TRUE, NULL, '2010-01-01 08:21:35');
INSERT INTO book VALUES (3, 2, NULL, NULL, 'O Alquimista', 1988, 4, NULL, NULL, TRUE, 1, '2012-11-01 03:21:35');
INSERT INTO book VALUES (4, 2, NULL, NULL, 'Brida', 1990, 2, NULL, NULL, FALSE, NULL, '2008-01-23 23:21:35');