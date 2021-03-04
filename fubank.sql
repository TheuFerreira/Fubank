DROP DATABASE IF EXISTS fubank;
CREATE DATABASE fubank;
USE fubank;

CREATE TABLE cliente(
cpf BIGINT NOT NULL PRIMARY KEY,
senha VARCHAR(11) NOT NULL,
nome VARCHAR(25) NOT NULL,
sobrenome VARCHAR(25) NOT NULL,
saldo DECIMAL(10,2) NOT NULL DEFAULT 0,
limite DECIMAL(10,2) NOT NULL DEFAULT 500,
fatura DECIMAL(10,2) NOT NULL DEFAULT 0
);

CREATE TABLE pix_tipo(
id_pix_tipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(15) NOT NULL
);

INSERT INTO pix_tipo (descricao) VALUES
('E-mail'), ('CPF'), ('Chave aleatória'), ('Celular');

CREATE TABLE pix(
chave VARCHAR(50) NOT NULL PRIMARY KEY,
cpf BIGINT NOT NULL,
id_pix_tipo INT NOT NULL,

FOREIGN KEY (cpf) REFERENCES cliente(cpf),
FOREIGN KEY (id_pix_tipo) REFERENCES pix_tipo(id_pix_tipo)
);

CREATE TABLE tipo(
id_tipo SMALLINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titulo VARCHAR(50) NOT NULL
);

CREATE TABLE saldo(
id_saldo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_tipo SMALLINT NOT NULL,
descricao VARCHAR(150) NOT NULL,
valor DECIMAL(10,2) NOT NULL,
data DATETIME NOT NULL,
cpf BIGINT NOT NULL,

FOREIGN KEY (cpf) REFERENCES cliente (cpf),
FOREIGN KEY (id_tipo) REFERENCES tipo (id_tipo)
);

DELIMITER $$
CREATE PROCEDURE calcularSaldo(_cpf BIGINT) 
BEGIN
	DECLARE valorFinal DECIMAL(10,2) DEFAULT 0;
    DECLARE _valor DECIMAL(10,2) DEFAULT 0;
    DECLARE _tipo INT DEFAULT 0;
    DECLARE _done INT DEFAULT 0;
    DECLARE _cursor CURSOR FOR SELECT id_tipo, valor FROM saldo WHERE cpf = _cpf ORDER BY data;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done = 1; 
    
    OPEN _cursor;
    FETCH _cursor INTO _tipo, _valor;
    
    WHILE _done = 0 DO
		IF _tipo = 1 OR _tipo = 3 THEN
			SET valorFinal = valorFinal + _valor;
		ELSE 
			SET valorFinal = valorFinal - _valor;
		END IF ;
    
		FETCH _cursor INTO _tipo, _valor;
    END WHILE ;
    CLOSE _cursor;
    
    UPDATE cliente SET saldo = valorFinal WHERE cpf = _cpf;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER updateSaldo
AFTER INSERT ON saldo
FOR EACH ROW
BEGIN
    CALL calcularSaldo(NEW.cpf);
END $$
DELIMITER ;

CREATE TABLE fatura(
id_fatura BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_tipo SMALLINT NOT NULL,
descricao VARCHAR(150) NOT NULL,
valor DECIMAL(10,2) NOT NULL,
data DATETIME NOT NULL,
cpf BIGINT NOT NULL,

FOREIGN KEY (cpf) REFERENCES cliente (cpf),
FOREIGN KEY (id_tipo) REFERENCES tipo (id_tipo)
);

DELIMITER $$
CREATE TRIGGER calcularFatura
AFTER INSERT ON FATURA
FOR EACH ROW
BEGIN
	DECLARE _cpf BIGINT DEFAULT 0;
    DECLARE _fatura DECIMAL(10,2) DEFAULT 0;
    DECLARE _tipo INT DEFAULT 0;
    SET _cpf = NEW.cpf;
    SET _fatura = (SELECT fatura FROM cliente WHERE cpf = _cpf);
    SET _tipo = NEW.id_tipo;
    
    IF _tipo = 5 THEN 
		SET _fatura = _fatura - NEW.valor;
    ELSE 
		SET _fatura = _fatura + NEW.valor;
	END IF;
    
    UPDATE cliente SET fatura = _fatura WHERE cpf = _cpf;
    
END $$
DELIMITER ;

INSERT INTO tipo(titulo) VALUES
('Depósito Recebido'),
('Transferência Enviada'),
('Transferência Recebida'),
('Recarga Efetuada'),
('Fatura Paga'),
('Supermercado'),
('Saúde'), 
('Educação'),
('Restaurante'),
('Serviços'),
('Eletrônicos'),
('Outros');