﻿--------------------------------------------------------------
-- CRIANDO BD ------------------------------------------------
--------------------------------------------------------------
CREATE DATABASE "DBA"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       CONNECTION LIMIT = -1;

---------------------------------------------------------------------------
-- CRIANDO USUARIO DE BANCO -----------------------------------------------
---------------------------------------------------------------------------
CREATE ROLE timesheet_DBA LOGIN ENCRYPTED PASSWORD 'md589333d45f51cca665b75b347d678c623' VALID UNTIL 'infinity';

---------------------------------------------------------------------------
-- CRIANDO AS TABELAS -----------------------------------------------------
---------------------------------------------------------------------------
CREATE TABLE CALENDARIO (
  ID INTEGER NOT NULL,
  DATA_CALENDARIO DATE NOT NULL,
  CARGA_HORARIA INTEGER NOT NULL,
  HORA_INICIO INTEGER NULL,
  HORA_FIM INTEGER NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE CLIENTE (
  ID INTEGER  NOT NULL,
  NOME VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE FUNCIONARIO (
  ID INTEGER  NOT NULL,
  SUBSTITUTO_ID INTEGER  NULL,
  CHEFE_ID INTEGER  NULL,
  NOME VARCHAR(100) NOT NULL,
  CARGO VARCHAR(100) NULL,
  CHEFE BIT NULL,
  HORA_TRABALHO_INICIO INTEGER  NULL DEFAULT 8,
  HORA_TRABALHO_FIM INTEGER  NULL DEFAULT 18,
  HORA_ALMOCO_INICIO INTEGER  NULL DEFAULT 12,
  HORA_ALMOCO_FIM INTEGER  NULL DEFAULT 14,
  FERIAS BIT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT CHEFE_Index FOREIGN KEY (CHEFE_ID) REFERENCES FUNCIONARIO(ID),
  CONSTRAINT SUBSTITUTO_Index FOREIGN KEY (SUBSTITUTO_ID) REFERENCES FUNCIONARIO(ID)
);

CREATE TABLE FUNCIONARIO_CLIENTE (
  FUNCIONARIO_ID INTEGER  NOT NULL,
  CLIENTE_ID INTEGER  NOT NULL,
  PRIMARY KEY(FUNCIONARIO_ID, CLIENTE_ID),
  CONSTRAINT FUNCIONARIO_CLIENTE_Index FOREIGN KEY(FUNCIONARIO_ID) REFERENCES FUNCIONARIO(ID),
  CONSTRAINT CLIENTE_FUNCIONARIO_Index FOREIGN KEY(CLIENTE_ID) REFERENCES CLIENTE(ID)
);

CREATE TABLE METODOLOGIA (
  ID INTEGER  NOT NULL ,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE OP (
  ID INTEGER  NOT NULL ,
  CLIENTE_ID INTEGER  NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT CLIENTE_Index FOREIGN KEY(CLIENTE_ID) REFERENCES CLIENTE(ID)
);

CREATE TABLE PRODUTO_SERVICO (
  ID INTEGER  NOT NULL ,
  METODOLOGIA_ID INTEGER  NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT METODOLOGIA_Index FOREIGN KEY (METODOLOGIA_ID) REFERENCES METODOLOGIA(ID)
);

CREATE TABLE PROJETO (
  ID INTEGER  NOT NULL ,
  METODOLOGIA_ID INTEGER  NOT NULL,
  NUMERO_PROJETO INTEGER  NOT NULL,
  NOME VARCHAR(100) NULL,
  PRIMARY KEY(ID),
  CONSTRAINT METODOLOGIA_Index FOREIGN KEY(METODOLOGIA_ID) REFERENCES METODOLOGIA(ID)
);

CREATE TABLE SITUACAO_ATIVIDADE (
  ID INTEGER  NOT NULL ,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE TIPO_ATIVIDADE (
  ID INTEGER  NOT NULL ,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE USUARIO (
  FUNCIONARIO_ID INTEGER  NOT NULL,
  LOGIN VARCHAR(100) NOT NULL,
  SENHA VARCHAR(40) NULL,
  BLOQUEADO BIT NULL,
  ULTIMO_LOGIN DATE NULL,
  ALTERAR_SENHA BIT NULL,
  PRIMARY KEY(FUNCIONARIO_ID),
  UNIQUE (LOGIN),
  CONSTRAINT FUNCIONARIO_Index FOREIGN KEY(FUNCIONARIO_ID) REFERENCES FUNCIONARIO(ID)
);

CREATE TABLE ATIVIDADE (
  ID INTEGER NOT NULL,
  ATIVIDADE_ORIGINAL_ID INTEGER NOT NULL,
  TIPO_ATIVIDADE_ID INTEGER NOT NULL,
  PRODUTO_SERVICO_ID INTEGER NOT NULL,
  PROJETO_ID INTEGER NULL,
  METODOLOGIA_ID INTEGER NOT NULL,
  OP_ID INTEGER NOT NULL,
  CLIENTE_ID INTEGER NOT NULL,
  FUNCIONARIO_ID INTEGER NOT NULL,
  DATA_HORA_INICIO TIMESTAMP NOT NULL,
  DATA_HORA_FIM TIMESTAMP NULL,
  OBSERVACAO TEXT NULL,
  ALTERACAO_DATA_AVALIACAO BIT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT FUNCIONARIO_Index FOREIGN KEY(FUNCIONARIO_ID) REFERENCES FUNCIONARIO(ID),
  CONSTRAINT CLIENTE_Index FOREIGN KEY(CLIENTE_ID) REFERENCES CLIENTE(ID),
  CONSTRAINT OP_Index FOREIGN KEY(OP_ID) REFERENCES OP(ID),
  CONSTRAINT METODOLOGIA_Index FOREIGN KEY(METODOLOGIA_ID) REFERENCES METODOLOGIA(ID),
  CONSTRAINT PROJETO_Index FOREIGN KEY(PROJETO_ID) REFERENCES PROJETO(ID),
  CONSTRAINT PRODUTO_SERVICO_Index FOREIGN KEY(PRODUTO_SERVICO_ID) REFERENCES PRODUTO_SERVICO(ID),
  CONSTRAINT TIPO_ATIVIDADE_Index FOREIGN KEY(TIPO_ATIVIDADE_ID) REFERENCES TIPO_ATIVIDADE(ID),
  CONSTRAINT ATIVIDADE_ORIGINAL_Index FOREIGN KEY(ATIVIDADE_ORIGINAL_ID) REFERENCES ATIVIDADE(ID)
);

CREATE TABLE AVALIACAO_ATIVIDADE (
  ATIVIDADE_ID INTEGER  NOT NULL,
  AVALIADOR_ID INTEGER  NOT NULL,
  SITUACAO_ATIVIDADE_ID INTEGER  NOT NULL,
  OBSERVACAO TEXT NULL,
  OBSERVACAO_PRIVADA TEXT NULL,
  PRIMARY KEY(ATIVIDADE_ID),
  CONSTRAINT ATIVIDADE_Index FOREIGN KEY(ATIVIDADE_ID) REFERENCES ATIVIDADE(ID),
  CONSTRAINT SITUACAO_ATIVIDADE_Index FOREIGN KEY(SITUACAO_ATIVIDADE_ID) REFERENCES SITUACAO_ATIVIDADE(ID),
  CONSTRAINT AVALIADOR_Index FOREIGN KEY(AVALIADOR_ID) REFERENCES FUNCIONARIO(ID)
);

CREATE TABLE FUNCIONALIDADE (
  ID INTEGER  NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE PERFIL (
  ID INTEGER  NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE FUNCIONALIDADE_PERFIL (
  PERFIL_ID INTEGER  NOT NULL,
  FUNCIONALIDADE_ID INTEGER  NOT NULL,
  PRIMARY KEY(PERFIL_ID, FUNCIONALIDADE_ID),
  CONSTRAINT FUNCIONALIDADE_PERFIL_Index FOREIGN KEY(FUNCIONALIDADE_ID) REFERENCES FUNCIONALIDADE(ID),
  CONSTRAINT PERFIL_FUNCIONALIDADE_Index FOREIGN KEY(PERFIL_ID) REFERENCES PERFIL(ID)
);

CREATE TABLE USUARIO_PERFIL (
  PERFIL_ID INTEGER  NOT NULL,
  USUARIO_ID INTEGER  NOT NULL,
  PRIMARY KEY(PERFIL_ID, USUARIO_ID),
  CONSTRAINT USUARIO_PERFIL_Index FOREIGN KEY(USUARIO_ID) REFERENCES USUARIO(FUNCIONARIO_ID),
  CONSTRAINT PERFIL_USUARIO_Index FOREIGN KEY(PERFIL_ID) REFERENCES PERFIL(ID)
);

---------------------------------------------------------------------------
-- CRIANDO AS SEQUENCES ---------------------------------------------------
---------------------------------------------------------------------------

CREATE SEQUENCE CLIENTE_SEQ;
CREATE SEQUENCE FUNCIONARIO_SEQ;
CREATE SEQUENCE OP_SEQ;
CREATE SEQUENCE ATIVIDADE_SEQ;
CREATE SEQUENCE CALENDARIO_SEQ;
CREATE SEQUENCE PRODUTO_SERVICO_SEQ;
CREATE SEQUENCE METODOLOGIA_SEQ;
CREATE SEQUENCE PROJETO_SEQ;
CREATE SEQUENCE TIPO_ATIVIDADE_SEQ;
CREATE SEQUENCE SITUACAO_ATIVIDADE_SEQ;
---------------------------------------------------------------------------
-- PERMISSÕES -------------------------------------------------------------
---------------------------------------------------------------------------
GRANT ALL ON TABLE CALENDARIO TO timesheet_DBA;
GRANT ALL ON TABLE CLIENTE TO timesheet_DBA;
GRANT ALL ON TABLE FUNCIONARIO TO timesheet_DBA;
GRANT ALL ON TABLE FUNCIONARIO_CLIENTE TO timesheet_DBA;
GRANT ALL ON TABLE METODOLOGIA TO timesheet_DBA;
GRANT ALL ON TABLE OP TO timesheet_DBA;
GRANT ALL ON TABLE PRODUTO_SERVICO TO timesheet_DBA;
GRANT ALL ON TABLE PROJETO TO timesheet_DBA;
GRANT ALL ON TABLE SITUACAO_ATIVIDADE TO timesheet_DBA;
GRANT ALL ON TABLE TIPO_ATIVIDADE TO timesheet_DBA;
GRANT ALL ON TABLE USUARIO TO timesheet_DBA;
GRANT ALL ON TABLE ATIVIDADE TO timesheet_DBA;
GRANT ALL ON TABLE AVALIACAO_ATIVIDADE TO timesheet_DBA;
GRANT ALL ON TABLE FUNCIONALIDADE TO timesheet_DBA;
GRANT ALL ON TABLE PERFIL TO timesheet_DBA;
GRANT ALL ON TABLE FUNCIONALIDADE_PERFIL TO timesheet_DBA;
GRANT ALL ON TABLE USUARIO_PERFIL TO timesheet_DBA;
GRANT ALL ON SEQUENCE CLIENTE_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE FUNCIONARIO_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE OP_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE ATIVIDADE_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE CALENDARIO_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE PRODUTO_SERVICO_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE METODOLOGIA_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE PROJETO_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE TIPO_ATIVIDADE_SEQ TO timesheet_DBA;
GRANT ALL ON SEQUENCE SITUACAO_ATIVIDADE_SEQ TO timesheet_DBA;

GRANT ALL ON SCHEMA public TO timesheet_DBA;

GRANT ALL ON SCHEMA information_schema TO timesheet_DBA;
GRANT ALL ON SCHEMA pg_catalog TO timesheet_DBA;