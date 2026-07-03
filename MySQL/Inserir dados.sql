-- =====================================================
-- SCRIPT DE INSERÇÃO DE DADOS (10 registos por tabela)
-- Base de dados: companhia
-- =====================================================

USE companhia;

-- -----------------------------------------------------
-- departamento (10 registos)
-- -----------------------------------------------------
INSERT INTO departamento (nome) VALUES
('Direcção Geral'),
('Recursos Humanos'),
('Finanças'),
('Tecnologias de Informação'),
('Marketing'),
('Vendas'),
('Produção'),
('Logística'),
('Jurídico'),
('Qualidade');

-- -----------------------------------------------------
-- empregado (10 registos)
-- -----------------------------------------------------
INSERT INTO empregado (nome, apelido, salario, dataNascimento, codDepartamento) VALUES
('Ana',     'Macuácua', 45000.00, '1990-03-12', 1),
('Carlos',  'Tembe',     38000.50, '1988-07-25', 2),
('Beatriz', 'Sitoe',     32000.00, '1992-11-03', 3),
('David',   'Cossa',     41500.75, '1985-01-19', 4),
('Elsa',    'Mondlane',  29000.00, '1995-05-30', 5),
('Filipe',  'Nhantumbo', 36000.00, '1991-09-14', 6),
('Graça',   'Matsinhe',  33500.25, '1989-12-08', 7),
('Hélder',  'Chissano',  47000.00, '1983-04-22', 8),
('Inês',    'Massingue', 31000.00, '1994-02-17', 9),
('João',    'Bila',      39500.00, '1987-08-06', 10);

-- -----------------------------------------------------
-- projecto (10 registos)
-- -----------------------------------------------------
INSERT INTO projecto (dataInicio, localizacao, codDepartamento) VALUES
('2023-01-10', 'Maputo',     1),
('2023-02-15', 'Matola',     2),
('2023-03-01', 'Beira',      3),
('2023-03-20', 'Maputo',     4),
('2023-04-05', 'Nampula',    5),
('2023-05-12', 'Quelimane',  6),
('2023-06-18', 'Maputo',     7),
('2023-07-22', 'Tete',       8),
('2023-08-09', 'Xai-Xai',    9),
('2023-09-30', 'Pemba',      10);

-- -----------------------------------------------------
-- chefia (10 registos - relação 1:1 empregado/departamento)
-- -----------------------------------------------------
INSERT INTO chefia (codEmpregado, codDepartamento, dataInicio, designacao) VALUES
(1,  1,  '2020-01-01', 'Director'),
(2,  2,  '2020-02-01', 'Chefe RH'),
(3,  3,  '2020-03-01', 'Chefe Fin.'),
(4,  4,  '2020-04-01', 'Chefe TI'),
(5,  5,  '2020-05-01', 'Chefe Mkt'),
(6,  6,  '2020-06-01', 'Chefe Vendas'),
(7,  7,  '2020-07-01', 'Chefe Prod.'),
(8,  8,  '2020-08-01', 'Chefe Log.'),
(9,  9,  '2020-09-01', 'Chefe Jur.'),
(10, 10, '2020-10-01', 'Chefe Qual.');

-- -----------------------------------------------------
-- dependente (10 registos)
-- -----------------------------------------------------
INSERT INTO dependente (nome, sexo, dataNascimento, parentesco, codEmpregado) VALUES
('Mário',   'M', '2015-06-10', 'Filho',  1),
('Sara',    'F', '2017-09-22', 'Filha',  2),
('Pedro',   'M', '2012-03-14', 'Filho',  3),
('Lúcia',   'F', '2019-11-05', 'Filha',  4),
('Tiago',   'M', '2010-07-19', 'Filho',  5),
('Rita',    'F', '2016-02-28', 'Filha',  6),
('Nelson',  'M', '2013-12-01', 'Filho',  7),
('Vanda',   'F', '2018-04-17', 'Filha',  8),
('Bruno',   'M', '2011-08-09', 'Filho',  9),
('Cíntia',  'F', '2014-10-30', 'Filha',  10);

-- -----------------------------------------------------
-- empregadoprojecto (10 registos - relação 1:1 empregado/projecto)
-- -----------------------------------------------------
INSERT INTO empregadoprojecto (codEmpregado, codProjecto, nrHoras) VALUES
(1,  1,  40),
(2,  2,  35),
(3,  3,  20),
(4,  4,  45),
(5,  5,  30),
(6,  6,  25),
(7,  7,  38),
(8,  8,  42),
(9,  9,  15),
(10, 10, 33);

-- -----------------------------------------------------
-- enderecoempregado (10 registos)
-- -----------------------------------------------------
INSERT INTO enderecoempregado (rua, bairro, quarteirao, codEmpregado) VALUES
('Av. Julius', 'Polana',    'Q1',  1),
('Rua 25',     'Sommerschield', 'Q2',  2),
('Av. Karl',   'Maxaquene', 'Q3',  3),
('Rua 10',     'Malanga',   'Q4',  4),
('Av. Mao Tse', 'Coop',     'Q5',  5),
('Rua 7',      'Hulene',    'Q6',  6),
('Av. Eduardo', 'Bairro Central', 'Q7', 7),
('Rua 3',      'Triunfo',   'Q8',  8),
('Av. FPLM',   'Mafalala',  'Q9',  9),
('Rua 1',      'Aeroporto', 'Q10', 10);

-- -----------------------------------------------------
-- localizacaodepartamento (10 registos)
-- -----------------------------------------------------
INSERT INTO localizacaodepartamento (designacao, codDepartamento) VALUES
('Edifício A', 1),
('Edifício B', 2),
('Edifício C', 3),
('Edifício D', 4),
('Edifício E', 5),
('Edifício F', 6),
('Edifício G', 7),
('Edifício H', 8),
('Edifício I', 9),
('Edifício J', 10);

-- -----------------------------------------------------
-- telefoneempregado (10 registos)
-- -----------------------------------------------------
INSERT INTO telefoneempregado (Telefone, empregadoCodEmpregado) VALUES
('+258840000001', 1),
('+258840000002', 2),
('+258840000003', 3),
('+258840000004', 4),
('+258840000005', 5),
('+258840000006', 6),
('+258840000007', 7),
('+258840000008', 8),
('+258840000009', 9),
('+258840000010', 10);