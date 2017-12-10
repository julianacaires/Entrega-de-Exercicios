CREATE DATABASE RESTAURANTE;
USE RESTAURANTE;

CREATE TABLE `restaurante`.`mercadoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod_mercadoria` INT NOT NULL, 
  `descricao` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(45),
  `preco` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`));
  
	INSERT INTO MERCADORIAS (id, cod_mercadoria, descricao , preco, tipo) VALUES (0, 1, 'Bife a Parmegiana', 23.00, 'Prato Principal');
    INSERT INTO MERCADORIAS (id, cod_mercadoria, descricao , preco, tipo) VALUES (1, 2, 'Risoto com cupim assado', 40.00, 'Prato');