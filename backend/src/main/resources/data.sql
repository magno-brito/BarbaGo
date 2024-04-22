INSERT INTO UF(nome) VALUES('ES');
INSERT INTO UF(nome) VALUES('MG');
INSERT INTO UF(nome) VALUES('SP');
INSERT INTO UF(nome) VALUES('RJ');

INSERT INTO Cidade (nome, UF) VALUES ('Vitória', 'ES');
INSERT INTO Cidade (nome, UF) VALUES ('Belo Horizonte', 'MG');
INSERT INTO Cidade (nome, UF) VALUES ('São Paulo', 'SP');
INSERT INTO Cidade (nome, UF) VALUES ('Rio de Janeiro', 'RJ');

INSERT INTO Bairro(nome, CIDADE, UF) VALUES ('Jardim Camburi', 1, 'ES');
INSERT INTO Bairro (nome, CIDADE, UF) VALUES ('Savassi', 2, 'MG');
INSERT INTO Bairro (nome, CIDADE, UF) VALUES ('Jardins', 3, 'SP');
INSERT INTO Bairro (nome, CIDADE, UF) VALUES ('Copacabana', 4, 'RJ');

INSERT INTO Pessoa (nome, email, senha, bairro_id) VALUES ('Carlos Silva', 'carlos.silva@example.com', 'senha123', 1);
INSERT INTO Pessoa (nome, email, senha, bairro_id) VALUES ('Ana Souza', 'ana.souza@example.com', 'minhasenha', 2);
INSERT INTO Pessoa (nome, email, senha, bairro_id) VALUES ('Pedro Lima', 'pedro.lima@example.com', '123456', 3);
INSERT INTO Pessoa (nome, email, senha, bairro_id) VALUES ('Mariana Castro', 'mariana.castro@example.com', 'castro123', 4);

INSERT INTO usuario (id)
VALUES ((SELECT id FROM pessoa WHERE email = 'carlos.silva@example.com'));

INSERT INTO usuario (id)
VALUES ((SELECT id FROM pessoa WHERE email = 'ana.souza@example.com'));