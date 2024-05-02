-- Creating states
INSERT INTO UF (nome) VALUES ('AC');
INSERT INTO UF (nome) VALUES ('AL');
INSERT INTO UF (nome) VALUES ('AP');
INSERT INTO UF (nome) VALUES ('AM');
INSERT INTO UF (nome) VALUES ('BA');
INSERT INTO UF (nome) VALUES ('CE');
INSERT INTO UF (nome) VALUES ('DF');
INSERT INTO UF (nome) VALUES ('ES');
INSERT INTO UF (nome) VALUES ('GO');
INSERT INTO UF (nome) VALUES ('MA');
INSERT INTO UF (nome) VALUES ('MT');
INSERT INTO UF (nome) VALUES ('MS');
INSERT INTO UF (nome) VALUES ('MG');
INSERT INTO UF (nome) VALUES ('PA');
INSERT INTO UF (nome) VALUES ('PB');
INSERT INTO UF (nome) VALUES ('PR');
INSERT INTO UF (nome) VALUES ('PE');
INSERT INTO UF (nome) VALUES ('PI');
INSERT INTO UF (nome) VALUES ('RJ');
INSERT INTO UF (nome) VALUES ('RN');
INSERT INTO UF (nome) VALUES ('RS');
INSERT INTO UF (nome) VALUES ('RO');
INSERT INTO UF (nome) VALUES ('RR');
INSERT INTO UF (nome) VALUES ('SC');
INSERT INTO UF (nome) VALUES ('SP');
INSERT INTO UF (nome) VALUES ('SE');
INSERT INTO UF (nome) VALUES ('TO');

INSERT INTO Cidade (nome, uf)
VALUES ('Vitória', (SELECT id FROM UF WHERE nome='ES'));

INSERT INTO Cidade (nome, uf)
VALUES ('Belo Horizonte', (SELECT id FROM UF WHERE nome = 'MG'));

INSERT INTO Cidade (nome, uf)
VALUES ('São Paulo', (SELECT id FROM UF WHERE nome = 'SP'));

INSERT INTO Cidade (nome, uf)
VALUES ('Rio de Janeiro', (SELECT id FROM UF WHERE nome = 'RJ'));

-- Creating neighborhoods with correct city references
INSERT INTO Bairro (nome, cidade)
VALUES ('Jardim Camburi', (SELECT id FROM Cidade WHERE nome = 'Vitória'));

INSERT INTO Bairro (nome, cidade)
VALUES ('Savassi', (SELECT id FROM Cidade WHERE nome = 'Belo Horizonte' ));

INSERT INTO Bairro (nome, cidade)
VALUES ('Jardins', (SELECT id FROM Cidade WHERE nome = 'São Paulo' ));

INSERT INTO Bairro (nome, cidade)
VALUES ('Copacabana', (SELECT id FROM Cidade WHERE nome = 'Rio de Janeiro' ));