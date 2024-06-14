-- Drop the existing schema and user if they exist
DROP SCHEMA IF EXISTS spring;
DROP USER IF EXISTS 'user'@'localhost';

-- Create schema and user
CREATE SCHEMA spring;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass123';
GRANT SELECT, INSERT, DELETE, UPDATE ON spring.* TO 'user'@'localhost';
USE spring;

-- Create tables and insert initial data
CREATE TABLE IF NOT EXISTS problems (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    problem_code VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS test_cases (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    problem_code VARCHAR(255) NOT NULL,
    input_data TEXT NOT NULL,
    expected_output TEXT NOT NULL,
    CONSTRAINT fk_problem FOREIGN KEY (problem_code) REFERENCES problems(problem_code)
);

CREATE TABLE IF NOT EXISTS solutions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    problem_code VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    solution_code TEXT NOT NULL,
    CONSTRAINT fk_problem_solution FOREIGN KEY (problem_code) REFERENCES problems(problem_code)
);

CREATE TABLE IF NOT EXISTS execution_histories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    problem_code VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    execution_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    execution_output TEXT NOT NULL,
    CONSTRAINT fk_problem_execution FOREIGN KEY (problem_code) REFERENCES problems(problem_code)
);

-- Dados de teste
INSERT INTO problems (problem_code, title, description) VALUES
('P1', 'Exemplo de Problema 1', 'Descrição do Problema 1'),
('P2', 'Exemplo de Problema 2', 'Descrição do Problema 2');

INSERT INTO test_cases (problem_code, input_data, expected_output) VALUES
('P1', 'entrada1', 'saida1'),
('P2', 'entrada2', 'saida2');

INSERT INTO solutions (problem_code, author, solution_code) VALUES
('P1', 'Autor1', 'codigo_solucao1'),
('P2', 'Autor2', 'codigo_solucao2');

INSERT INTO execution_histories (problem_code, author, execution_output) VALUES
('P1', 'Autor1', 'output_execucao1'),
('P2', 'Autor2', 'output_execucao2');
