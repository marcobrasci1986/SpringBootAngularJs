INSERT INTO ITEM(id,checked,description) VALUES (1, false, 'My default description');
INSERT INTO ITEM(id,checked,description) VALUES (2, true, 'Another description');


INSERT INTO Department(id,department_name, city) VALUES (1, 'IT', 'New york');
INSERT INTO Department(id,department_name, city) VALUES (2, 'HelpDesk', 'Boston');
INSERT INTO Department(id,department_name, city) VALUES (3, 'HR', 'Washington');
INSERT INTO Department(id,department_name, city) VALUES (4, 'Cleaning', 'Miami');



INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (1, 'John', 'Doe', 33, 1);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (2, 'Mark', 'Johnston', 17, 1);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (3, 'Eden', 'Hazard', 56, 1);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (4, 'Jordan', 'Lukaku', 89, 1);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (5, 'Tony', 'Alder', 33, 2);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (6, 'Thibaud', 'Courtois', 4, 2);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (7, 'Ben', 'Doe', 5, 2);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (8, 'Josh', 'Long', 15, 2);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (9, 'Sarah', 'Smith', 24, 3);
INSERT INTO Person(id,first_name,last_name, age, department_id) VALUES (10, 'Milly', 'Bond', 21, 4);


-- password == username
INSERT INTO user_info(username, password, enabled) VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', true);
INSERT INTO user_info(username, password, enabled) VALUES ('user', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', true);

INSERT INTO Role(username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Role(username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO Role(username, role) VALUES ('user', 'ROLE_USER');







