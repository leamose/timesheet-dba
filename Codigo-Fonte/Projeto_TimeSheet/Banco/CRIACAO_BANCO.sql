CREATE TABLE ATIVIDADE (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ATIVIDADE_ORIGINAL_ID INTEGER UNSIGNED NOT NULL,
  TIPO_ATIVIDADE_ID INTEGER UNSIGNED NOT NULL,
  PRODUTO_SERVICO_ID INTEGER UNSIGNED NOT NULL,
  PROJETO_ID INTEGER UNSIGNED NULL,
  METODOLOGIA_ID INTEGER UNSIGNED NOT NULL,
  OP_ID INTEGER UNSIGNED NOT NULL,
  CLIENTE_ID INTEGER UNSIGNED NOT NULL,
  FUNCIONARIO_ID INTEGER UNSIGNED NOT NULL,
  DATA_HORA_INICIO TIMESTAMP NOT NULL,
  DATA_HORA_FIM TIMESTAMP NULL,
  OBSERVACAO TEXT NULL,
  ALTERACAO_DATA_AVALIACAO BIT NULL,
  PRIMARY KEY(ID),
  INDEX FUNCIONARIO_Index(FUNCIONARIO_ID),
  INDEX CLIENTE_Index(CLIENTE_ID),
  INDEX OP_Index(OP_ID),
  INDEX METODOLOGIA_Index(METODOLOGIA_ID),
  INDEX PROJETO_Index(PROJETO_ID),
  INDEX PRODUTO_SERVICO_Index(PRODUTO_SERVICO_ID),
  INDEX TIPO_ATIVIDADE_Index(TIPO_ATIVIDADE_ID),
  INDEX ATIVIDADE_ORIGINAL_Index(ATIVIDADE_ORIGINAL_ID)
);

CREATE TABLE AVALIACAO_ATIVIDADE (
  ATIVIDADE_ID INTEGER UNSIGNED NOT NULL,
  AVALIADOR_ID INTEGER UNSIGNED NOT NULL,
  SITUACAO_ATIVIDADE_ID INTEGER UNSIGNED NOT NULL,
  OBSERVACAO TEXT NULL,
  OBSERVACAO_PRIVADA TEXT NULL,
  PRIMARY KEY(ATIVIDADE_ID),
  INDEX ATIVIDADE_Index(ATIVIDADE_ID),
  INDEX SITUACAO_ATIVIDADE_Index(SITUACAO_ATIVIDADE_ID),
  INDEX AVALIADOR_Index(AVALIADOR_ID)
);

CREATE TABLE CALENDARIO (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DATA_CALENDARIO DATE NOT NULL,
  CARGA_HORARIA INTEGER UNSIGNED NOT NULL,
  HORA_INICIO INTEGER UNSIGNED NULL,
  HORA_FIM INTEGER UNSIGNED NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE CLIENTE (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE FUNCIONARIO (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  SUBSTITUTO_ID INTEGER UNSIGNED NULL,
  CHEFE_ID INTEGER UNSIGNED NULL,
  NOME VARCHAR(100) NOT NULL,
  CARGO VARCHAR(100) NULL,
  CHEFE BIT NULL,
  HORA_TRABALHO_INICIO INTEGER UNSIGNED NULL DEFAULT 8,
  HORA_TRABALHO_FIM INTEGER UNSIGNED NULL DEFAULT 18,
  HORA_ALMOCO_INICIO INTEGER UNSIGNED NULL DEFAULT 12,
  HORA_ALMOCO_FIM INTEGER UNSIGNED NULL DEFAULT 14,
  FERIAS BIT NULL,
  PRIMARY KEY(ID),
  INDEX CHEFE_Index(CHEFE_ID),
  INDEX SUBSTITUTO_Index(SUBSTITUTO_ID)
);

CREATE TABLE FUNCIONARIO_CLIENTE (
  FUNCIONARIO_ID INTEGER UNSIGNED NOT NULL,
  CLIENTE_ID INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(FUNCIONARIO_ID, CLIENTE_ID),
  INDEX FUNCIONARIO_CLIENTE_Index(FUNCIONARIO_ID),
  INDEX CLIENTE_FUNCIONARIO_Index(CLIENTE_ID)
);

CREATE TABLE METODOLOGIA (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE OP (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  CLIENTE_ID INTEGER UNSIGNED NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID),
  INDEX CLIENTE_Index(CLIENTE_ID)
);

CREATE TABLE PRODUTO_SERVICO (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  METODOLOGIA_ID INTEGER UNSIGNED NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID),
  INDEX METODOLOGIA_Index(METODOLOGIA_ID)
);

CREATE TABLE PROJETO (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  METODOLOGIA_ID INTEGER UNSIGNED NOT NULL,
  NUMERO_PROJETO INTEGER UNSIGNED NOT NULL,
  NOME VARCHAR(100) NULL,
  PRIMARY KEY(ID),
  INDEX METODOLOGIA_Index(METODOLOGIA_ID)
);

CREATE TABLE SITUACAO_ATIVIDADE (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE TIPO_ATIVIDADE (
  ID INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE USUARIO (
  FUNCIONARIO_ID INTEGER UNSIGNED NOT NULL,
  LOGIN VARCHAR(100) NOT NULL,
  SENHA VARCHAR(40) NULL,
  BLOQUEADO BIT NULL,
  ULTIMO_LOGIN DATE NULL,
  ALTERAR_SENHA BIT NULL,
  PRIMARY KEY(FUNCIONARIO_ID),
  UNIQUE INDEX LOGIN_UK(LOGIN),
  INDEX FUNCIONARIO_Index(FUNCIONARIO_ID)
);


