CREATE SCHEMA sistemapredial DEFAULT CHARACTER SET utf8;
USE sistemapredial;
SET SQL_SAFE_UPDATES = 0;

-- -----------------------------------------------------
-- Tabela `conjunto`
-- -----------------------------------------------------
CREATE TABLE `conjunto`
(
  `idConjunto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `numero` TINYINT(3) UNSIGNED UNIQUE KEY NOT NULL,
  PRIMARY KEY (`idConjunto`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `empresa`
-- -----------------------------------------------------
CREATE TABLE `empresa`
(
  `idEmpresa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `razaoSocial` NVARCHAR(80) NOT NULL,
  `cnpj` BIGINT(14) UNSIGNED UNIQUE KEY NOT NULL,
  `conjuntoOcupado` TINYINT(3) UNSIGNED UNIQUE KEY NOT NULL,
  `horarioFuncionamento` INT(8) UNSIGNED ZEROFILL NOT NULL,
  `horarioAr` INT(8) UNSIGNED ZEROFILL NOT NULL,
  `temperaturaAr` TINYINT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`idEmpresa`),
  CONSTRAINT `fk_empresa_conjunto`
	FOREIGN KEY (`conjuntoOcupado`)
    REFERENCES `conjunto` (`numero`)
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `usuario`
-- -----------------------------------------------------
CREATE TABLE `usuario`
(
  `idUsuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tipo` TINYINT(1) UNSIGNED NOT NULL,
  `nome` NVARCHAR(80) NOT NULL,
  `cpf` BIGINT(11) UNSIGNED UNIQUE KEY NOT NULL,
  `idEmpresa` INT UNSIGNED,
  `expediente` INT(8) UNSIGNED ZEROFILL DEFAULT 00002359,
  `livreAcesso` TINYINT(1) UNSIGNED NOT NULL,
  `alteraAr` TINYINT(1) UNSIGNED,
  `usuario` NVARCHAR(50) UNIQUE KEY NOT NULL,
  `senha` NVARCHAR(50) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `fk_usuario_empresa`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `empresa` (`idEmpresa`)
)
ENGINE = InnoDB;

INSERT INTO conjunto VALUES(null, 11);
INSERT INTO conjunto VALUES(null, 12);
INSERT INTO conjunto VALUES(null, 21);
INSERT INTO conjunto VALUES(null, 22);
INSERT INTO conjunto VALUES(null, 31);
INSERT INTO conjunto VALUES(null, 32);