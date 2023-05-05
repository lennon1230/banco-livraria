CREATE SCHEMA IF NOT EXISTS bd_livraria DEFAULT CHARACTER SET utf8mb4;
USE bd_livraria;

-- -----------------------------------------------------
-- Tabela Estado
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Estado (
	idEstado SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    sigla VARCHAR(2) NOT NULL,
    PRIMARY KEY (idEstado)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Cidade
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cidade (
	idCidade INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    Estado_idEstado SMALLINT UNSIGNED NOT NULL,
    ibge INT UNSIGNED NULL,
    PRIMARY KEY (idCidade),
    FOREIGN KEY (Estado_idEstado) REFERENCES Estado (idEstado)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Endereço
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Endereco (
	idEndereco INT UNSIGNED NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(100) NOT NULL,
    rua VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cep VARCHAR(8) NULL,
    Cidade_idCidade INT UNSIGNED NOT NULL,
    PRIMARY KEY (idEndereco),
    FOREIGN KEY (Cidade_idCidade) REFERENCES Cidade (idCidade)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Telefone
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Telefone (
	idTelefone INT UNSIGNED NOT NULL AUTO_INCREMENT,
    telefone1 VARCHAR(11) NOT NULL,
    telefone2 VARCHAR(11) NULL,
    PRIMARY KEY (idTelefone)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
	idCliente INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    Telefone_idTelefone INT UNSIGNED NOT NULL,
    Endereco_idEndereco INT UNSIGNED NOT NULL,
    PRIMARY KEY (idCliente),
    UNIQUE KEY (email),
    FOREIGN KEY (Telefone_idTelefone) REFERENCES Telefone (idTelefone),
    FOREIGN KEY (Endereco_idEndereco) REFERENCES Endereco (idEndereco)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela CPF
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CPF (
  cpf VARCHAR(11) NOT NULL,
  Cliente_idCliente INT UNSIGNED NOT NULL,
  PRIMARY KEY (cpf),
  FOREIGN KEY (Cliente_idCliente) REFERENCES Cliente (idCliente)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela CNPJ
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS CNPJ (
  cnpj VARCHAR(14) NOT NULL,
  Cliente_idCliente INT UNSIGNED NOT NULL,
  PRIMARY KEY (cnpj),
  FOREIGN KEY (Cliente_idCliente) REFERENCES Cliente (idCliente)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Editora
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Editora (
  idEditora INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  Endereco_idEndereco INT UNSIGNED NOT NULL,
  PRIMARY KEY (idEditora),
  UNIQUE KEY (nome),
  FOREIGN KEY (Endereco_idEndereco) REFERENCES Endereco (idEndereco)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Livro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Livro (
  idLivro INT UNSIGNED NOT NULL AUTO_INCREMENT,
  isbn VARCHAR(17) NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  subtitulo VARCHAR(100) NULL,
  categoria VARCHAR(45) NOT NULL,
  ano DATE NOT NULL,
  quantidade INT UNSIGNED NOT NULL,
  preco DECIMAL(7,2) UNSIGNED NOT NULL,
  Editora_idEditora INT UNSIGNED NOT NULL,
  PRIMARY KEY (idLivro),
  FOREIGN KEY (Editora_idEditora) REFERENCES Editora (idEditora)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Autor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Autor (
  idAutor INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (idAutor)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Pedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Pedido (
  idPedido INT UNSIGNED NOT NULL AUTO_INCREMENT,
  quantidade INT UNSIGNED NOT NULL,
  valor DECIMAL(9,2) NOT NULL,
  data_pedido DATETIME NOT NULL,
  Editora_idEditora INT UNSIGNED NOT NULL,
  Cliente_idCliente INT UNSIGNED NOT NULL,
  PRIMARY KEY (idPedido),
  FOREIGN KEY (Editora_idEditora) REFERENCES Editora (idEditora),
  FOREIGN KEY (Cliente_idCliente) REFERENCES Cliente (idCliente)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Autor_has_Livro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Autor_has_Livro (
  Autor_idAutor INT UNSIGNED NOT NULL,
  Livro_idLivro INT UNSIGNED NOT NULL,
  FOREIGN KEY (Autor_idAutor) REFERENCES Autor (idAutor),
  FOREIGN KEY (Livro_idLivro) REFERENCES Livro (idLivro)
) DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Tabela Pedido_has_Livro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Pedido_has_Livro (
  Pedido_idPedido INT UNSIGNED NOT NULL,
  Livro_idLivro INT UNSIGNED NOT NULL,
  FOREIGN KEY (Pedido_idPedido) REFERENCES Pedido (idPedido),
  FOREIGN KEY (Livro_idLivro) REFERENCES Livro (idLivro)
) DEFAULT CHARACTER SET = utf8mb4;