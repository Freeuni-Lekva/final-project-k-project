USE myDatabase;

-- remove table if it already exists and start from scratch
DROP TABLE IF EXISTS quizzes;

CREATE TABLE quizzes (
    quiz_name CHAR(64),
    question_number INTEGER,
    best_score INTEGER
);

INSERT INTO quizzes VALUES
('usa presidents', 10, 0)
