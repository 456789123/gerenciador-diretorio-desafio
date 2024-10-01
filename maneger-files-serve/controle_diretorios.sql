SELECT * FROM diretorio;
SELECT * FROM arquivo;


CREATE TABLE diretorio (
   id SERIAL PRIMARY KEY,
   nome VARCHAR(255) NOT NULL,
   parent_id INT REFERENCES diretorio(id) ON DELETE CASCADE
);


CREATE TABLE arquivo (
     id SERIAL PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     diretorio_id INT REFERENCES diretorio(id) ON DELETE CASCADE
);


-- Diretório raiz
INSERT INTO diretorio (nome, parent_id) VALUES ('pasta_raiz', NULL);

-- Subdiretório da raiz
INSERT INTO diretorio (nome, parent_id) VALUES ('pasta_1', 1);
INSERT INTO diretorio (nome, parent_id) VALUES ('pasta_2', 1);
INSERT INTO diretorio (nome, parent_id) VALUES ('pasta_3', 1);
INSERT INTO diretorio (nome, parent_id) VALUES ('pasta_4', 1);

-- Subdiretório da pasta_2
INSERT INTO diretorio (nome, parent_id) VALUES ('Sub_pasta', 3);

-- Subdiretório da Sub_pasta
INSERT INTO diretorio (nome, parent_id) VALUES ('New folder', 4);


-- Arquivos na pasta_raiz
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Comercial_ Johnnie Walker - Andróide (pt-br).mp4', 1);
INSERT INTO arquivo (nome, diretorio_id) VALUES ('foto_exemplo.jpg', 1);
INSERT INTO arquivo (nome, diretorio_id) VALUES ('foto_teste.jpg', 1);

-- Arquivos na pasta_1
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_1_pasta_1.txt', 2);
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_2_pasta_1.txt', 2);

-- Arquivos na pasta_2
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_1_pasta_2.txt', 3);
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_2_pasta_2.txt', 3);

-- Arquivos na Sub_pasta
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo.txt', 5);

-- Arquivos na New folder
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Gangster_tripa_seca.jpg', 6);

-- Arquivos na pasta_3
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_1_pasta_3.txt', 4);

-- Arquivos na pasta_4
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_1_pasta_4.txt', 5);
INSERT INTO arquivo (nome, diretorio_id) VALUES ('Teste_arquivo_2_pasta_4.txt', 5);
