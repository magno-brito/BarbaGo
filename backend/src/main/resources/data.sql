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

-- Adding services
INSERT INTO servicos (nome, valor) VALUES ('Corte de Cabelo', 30.00);
INSERT INTO servicos (nome, valor) VALUES ('Barba', 20.00);
INSERT INTO servicos (nome, valor) VALUES ('Corte e Barba', 45.00);
INSERT INTO servicos (nome, valor) VALUES ('Hidratação Capilar', 50.00);

-- Creating people and assigning neighborhoods
INSERT INTO Pessoa (nome, email, senha, bairro_id)
VALUES ('Carlos Silva', 'carlos.silva@example.com', 'senha123',
       (SELECT id FROM Bairro WHERE nome = 'Jardim Camburi'));

INSERT INTO Pessoa (nome, email, senha, bairro_id)
VALUES ('Ana Souza', 'ana.souza@example.com', 'minhasenha',
       (SELECT id FROM Bairro WHERE nome = 'Jardim Camburi'));

INSERT INTO Pessoa (nome, email, senha, bairro_id)
VALUES ('Pedro Lima', 'pedro.lima@example.com', '123456',
       (SELECT id FROM Bairro WHERE nome = 'Jardins'));

INSERT INTO Pessoa (nome, email, senha, bairro_id)
VALUES ('Mariana Castro', 'mariana.castro@example.com', 'castro123',
       (SELECT id FROM Bairro WHERE nome = 'Copacabana'));
-- Creating users and barbers from people
INSERT INTO usuario (id) VALUES ((SELECT id FROM pessoa WHERE email = 'carlos.silva@example.com'));
INSERT INTO usuario (id) VALUES ((SELECT id FROM pessoa WHERE email = 'ana.souza@example.com'));

-- Fixing the barber insert
INSERT INTO barbeiro (id) VALUES ((SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'));

-- Creating appointments
SELECT * FROM agendamento
WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
  AND data = '2024-05-11 09:30:00';

-- If there's no conflict, proceed with insert
INSERT INTO agendamento (barbeiro_id, usuario_id, data)
VALUES (
  (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com')),
  (SELECT id FROM usuario WHERE id = (SELECT id FROM pessoa WHERE email = 'ana.souza@example.com')),
  '2024-05-11 09:30:00'
);



-- Get the Agendamento ID for the given date and barber
SELECT id
FROM agendamento
WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
  AND data = '2024-05-11 09:30:00';

-- Get IDs of the services to be added
SELECT id FROM servicos WHERE nome = 'Corte de Cabelo';  -- example service
SELECT id FROM servicos WHERE nome = 'Barba';            -- example service

-- Insert into Atendimento with the Agendamento ID
INSERT INTO atendimento (preco, agendamento_id)
VALUES (
  50.00,  -- Example price
  (SELECT id FROM agendamento
   WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
     AND data = '2024-05-11 09:30:00')
);


-- Get the ID of the inserted Atendimento
SELECT id
FROM atendimento
WHERE agendamento_id = (SELECT id
                        FROM agendamento
                        WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
                          AND data = '2024-05-11 09:30:00');

-- Update Servicos with the correct Atendimento ID
UPDATE servicos
SET atendimento_id = (SELECT id
                       FROM atendimento
                       WHERE agendamento_id = (SELECT id
                                               FROM agendamento
                                               WHERE barbeiro_id = (SELECT id
                                                                    FROM barbeiro
                                                                    WHERE id = (SELECT id
                                                                                FROM pessoa
                                                                                WHERE email = 'pedro.lima@example.com'))
                                                 AND data = '2024-05-11 09:30:00'))
WHERE nome IN ('Corte de Cabelo', 'Barba');



-- Get the Agendamento ID
SELECT id
FROM agendamento
WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
  AND data = '2024-05-11 09:30:00';


-- Insert into Multa with a specific Agendamento and Valor
INSERT INTO multa (agendamento_id, valor)
VALUES (
  (SELECT id
   FROM agendamento
   WHERE barbeiro_id = (SELECT id FROM barbeiro WHERE id = (SELECT id FROM pessoa WHERE email = 'pedro.lima@example.com'))
     AND data = '2024-05-11 09:30:00'),
  25.00  -- Example penalty value
);
