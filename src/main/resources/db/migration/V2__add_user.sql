INSERT INTO users (id, archive, email, name, password, role, bucket_id)
VALUES (1, false, 'mail@mail.com', 'admin', '$2a$10$/0Qa9cXcmJZdTESlgYwUvOQqrIwsotzagYQTKdBdTgnl3a6xCmg32', 'ADMIN',
        null);


ALTER SEQUENCE user_seq RESTART WITH 2;


