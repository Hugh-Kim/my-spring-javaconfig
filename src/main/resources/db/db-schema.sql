CREATE TABLE users (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE article (
  seqNo INTEGER PRIMARY KEY,
  title VARCHAR(500),
  author VARCHAR(30),
  content VARCHAR(4000),
  createDate TIMESTAMP
);