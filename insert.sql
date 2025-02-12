USE GestionTaches;

INSERT INTO Account (firstname, lastname, email, password) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123'),
('Jane', 'Smith', 'jane.smith@example.com', 'securepassword'),
('Alice', 'Johnson', 'alice.johnson@example.com', 'alicepass');

INSERT INTO Category (name) VALUES
('Work'),
('Home'),
('Shopping'),
('Hobby'),
('Urgent'),
('Personal');

INSERT INTO Task (title, description, createdAt, status, account_id) VALUES
('Finish report', 'Complete the monthly report', '2023-10-01', true, 1),
('Buy groceries', 'Get milk, bread, and eggs', '2023-10-02', false, 2),
('Read book', 'Finish reading the novel', '2023-10-03', true, 3),
('Paint room', 'Paint the living room', '2023-10-04', false, 1);

INSERT INTO TaskCategory (task_id, category_id) VALUES
(1, 1),
(1, 5),
(2, 3),
(2, 2),
(3, 4),
(3, 6),
(4, 2),
(4, 5);
