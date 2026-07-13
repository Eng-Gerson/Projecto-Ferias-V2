-- =====================================================
-- SCRIPT DE CRIAÇÃO DE TABELAS
-- Base de dados: companhia
-- =====================================================

DROP DATABASE IF EXISTS companhia;
CREATE DATABASE companhia DEFAULT CHARACTER SET utf8mb4;
USE companhia;

-- -----------------------------------------------------
-- Tabela departamento
-- -----------------------------------------------------
CREATE TABLE departamento (
  codDepartamento INT(11) NOT NULL AUTO_INCREMENT,
  nome            VARCHAR(45) NOT NULL,
  PRIMARY KEY (codDepartamento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela empregado
-- -----------------------------------------------------
CREATE TABLE empregado (
  codEmpregado    INT(11) NOT NULL AUTO_INCREMENT,
  nome            VARCHAR(15) NOT NULL,
  apelido         VARCHAR(15) NOT NULL,
  salario         DECIMAL(18,2) NOT NULL,
  dataNascimento  DATE NULL,
  codDepartamento INT(11) NOT NULL,
  PRIMARY KEY (codEmpregado),
  INDEX idx_empregado_codDepartamento (codDepartamento),
  CONSTRAINT empregado_ibfk_1
    FOREIGN KEY (codDepartamento) REFERENCES departamento (codDepartamento)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela projecto
-- -----------------------------------------------------
CREATE TABLE projecto (
  codProjecto     INT(11) NOT NULL AUTO_INCREMENT,
  dataInicio      DATE NULL,
  localizacao     VARCHAR(15) NOT NULL,
  codDepartamento INT(11) NOT NULL,
  PRIMARY KEY (codProjecto),
  INDEX idx_projecto_codDepartamento (codDepartamento),
  CONSTRAINT projecto_ibfk_1
    FOREIGN KEY (codDepartamento) REFERENCES departamento (codDepartamento)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela chefia (chefe de departamento - relação 1:1)
-- -----------------------------------------------------
CREATE TABLE chefia (
  codEmpregado    INT(11) NOT NULL UNIQUE,
  codDepartamento INT(11) NOT NULL UNIQUE,
  dataInicio      DATE NULL,
  designacao      VARCHAR(15) NOT NULL,
  PRIMARY KEY (codEmpregado, codDepartamento),
  UNIQUE INDEX codEmpregado_UNIQUE (codEmpregado),
  UNIQUE INDEX codDepartamento_UNIQUE (codDepartamento),
  CONSTRAINT chefia_ibfk_1
    FOREIGN KEY (codEmpregado) REFERENCES empregado (codEmpregado)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT chefia_ibfk_2
    FOREIGN KEY (codDepartamento) REFERENCES departamento (codDepartamento)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela dependente
-- -----------------------------------------------------
CREATE TABLE dependente (
  codDependente   INT(11) NOT NULL AUTO_INCREMENT,
  nome            VARCHAR(15) NOT NULL,
  sexo            VARCHAR(15) NOT NULL,
  dataNascimento  DATE NULL,
  parentesco      VARCHAR(15) NOT NULL,
  codEmpregado    INT(11) NOT NULL,
  PRIMARY KEY (codDependente),
  INDEX idx_dependente_codEmpregado (codEmpregado),
  CONSTRAINT dependente_ibfk_1
    FOREIGN KEY (codEmpregado) REFERENCES empregado (codEmpregado)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela empregadoprojecto (relação empregado <-> projecto)
-- -----------------------------------------------------
CREATE TABLE empregadoprojecto (
  codEmpregado INT(11) NOT NULL,
  codProjecto  INT(11) NOT NULL,
  nrHoras      INT(11) NOT NULL,
  UNIQUE INDEX codEmpregado_UNIQUE (codEmpregado),
  UNIQUE INDEX codProjecto_UNIQUE (codProjecto),
  CONSTRAINT empregadoprojecto_ibfk_1
    FOREIGN KEY (codEmpregado) REFERENCES empregado (codEmpregado)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT empregadoprojecto_ibfk_2
    FOREIGN KEY (codProjecto) REFERENCES projecto (codProjecto)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela enderecoempregado
-- -----------------------------------------------------
CREATE TABLE enderecoempregado (
  nCasa        INT(11) NOT NULL AUTO_INCREMENT,
  rua          VARCHAR(15) NOT NULL,
  bairro       VARCHAR(15) NOT NULL,
  quarteirao   VARCHAR(15) NOT NULL,
  codEmpregado INT(11) NOT NULL,
  PRIMARY KEY (nCasa),
  INDEX idx_enderecoempregado_codEmpregado (codEmpregado),
  CONSTRAINT enderecoempregado_ibfk_1
    FOREIGN KEY (codEmpregado) REFERENCES empregado (codEmpregado)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela localizacaodepartamento
-- -----------------------------------------------------
CREATE TABLE localizacaodepartamento (
  codLocalizacao  INT(11) NOT NULL AUTO_INCREMENT,
  designacao      VARCHAR(15) NOT NULL,
  codDepartamento INT(11) NOT NULL,
  PRIMARY KEY (codLocalizacao),
  INDEX idx_localizacaodepartamento_codDepartamento (codDepartamento),
  CONSTRAINT localizacaodepartamento_ibfk_1
    FOREIGN KEY (codDepartamento) REFERENCES departamento (codDepartamento)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- -----------------------------------------------------
-- Tabela telefoneempregado
-- -----------------------------------------------------
CREATE TABLE telefoneempregado (
  Telefone               VARCHAR(30) NOT NULL,
  empregadoCodEmpregado  INT(11) NOT NULL,
  PRIMARY KEY (Telefone),
  INDEX idx_telefoneempregado_codEmpregado (empregadoCodEmpregado),
  CONSTRAINT telefoneempregado_ibfk_1
    FOREIGN KEY (empregadoCodEmpregado) REFERENCES empregado (codEmpregado)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;