/* Populate tables */
INSERT INTO person (first_name, last_name) VALUES('Elkin', 'Giraldo');
INSERT INTO person (first_name, last_name) VALUES('Martha', 'Pinedo');
INSERT INTO person (first_name, last_name) VALUES('Jairo', 'Jimenez');

INSERT INTO person_known_people (person_id, known_people) VALUES(1, 3);
INSERT INTO person_known_people (person_id, known_people) VALUES(1, 2);
INSERT INTO person_known_people (person_id, known_people) VALUES(3, 2);