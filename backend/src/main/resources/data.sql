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