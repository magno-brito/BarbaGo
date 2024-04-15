INSERT INTO UF(nome) VALUES('ES');
INSERT INTO UF(nome) VALUES('MG');
INSERT INTO UF(nome) VALUES('SP');
INSERT INTO UF(nome) VALUES('RJ');

SELECT id FROM UF WHERE nome = 'ES'; -- Assuming 'ES' corresponds to the UF 'Espírito Santo'
SELECT id FROM UF WHERE nome = 'MG'; -- Assuming 'MG' corresponds to the UF 'Minas Gerais'
-- Similar SELECT statements for 'SP' and 'RJ'

-- Get the Cidade ID for 'Cachoeiro de Itapemirim'
SELECT id FROM Cidade WHERE nome = 'Cachoeiro de Itapemirim';

-- Get the Bairro ID for 'BNH' in 'Cachoeiro de Itapemirim'
SELECT id FROM Bairro WHERE nome = 'BNH' AND cidade_id = (SELECT id FROM Cidade WHERE nome = 'Cachoeiro de Itapemirim');

-- Use the retrieved IDs in the INSERT statements
INSERT INTO Pessoa (nome, email, senha, bairro_id) VALUES ('João', 'joao@gmail.com', '1234', id);

-- Replace 'ID_DO_BAIRRO' with the actual Bairro ID retrieved from the previous query