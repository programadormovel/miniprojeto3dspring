USE master IF EXISTS
(select * from sys.databases where name='miniprojeto3d') 
DROP DATABASE miniprojeto3d
GO 
-- CRIAR UM BANCO DE DADOS
CREATE DATABASE miniprojeto3d
GO
-- ACESSAR O BANCO DE DADOS
USE miniprojeto3d
GO

CREATE TABLE TipoProduto
(
	id		 INT IDENTITY,
	nomeTipo VARCHAR(100) NOT NULL,  -- ÁGUA, REFRIGERANTE, LANCHE, SALGADO, SALGADINHO, DOCE ou SOBREMESA

	PRIMARY KEY(id)
)
GO
INSERT TipoProduto (nomeTipo) VALUES ('Água')
INSERT TipoProduto (nomeTipo) VALUES ('Refrigerante')
INSERT TipoProduto (nomeTipo) VALUES ('Lanche')
INSERT TipoProduto (nomeTipo) VALUES ('Salgado')
INSERT TipoProduto (nomeTipo) VALUES ('Salgadinho')
INSERT TipoProduto (nomeTipo) VALUES ('Doce')
INSERT TipoProduto (nomeTipo) VALUES ('Sobremesa')

CREATE TABLE Produto
(
	id			 INT IDENTITY,
	nome	     VARCHAR(100) NOT NULL,
	descricao	 VARCHAR(400) NOT NULL,
	codigoBarras VARCHAR(100) NOT NULL,
	foto		 varbinary(max) NULL,
	preco		 DECIMAL(8,2) NOT NULL,
	tipoProd_id  INT	      NOT NULL,
	statusProd	 VARCHAR(10)  NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id),
	FOREIGN KEY (tipoProd_id) REFERENCES TipoProduto (id)
)
GO
INSERT Produto (nome, descricao, codigoBarras, foto, preco, tipoProd_id, statusProd) 
VALUES ('Garrafa de Água Mineral de 510ml - Boa-água ', 'Garrafa de água mineral de 510ml', '7899001234', NULL, 2.00, 1, 'ATIVO')

GO
SELECT * FROM Produto

