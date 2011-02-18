---------------------------------------------------------------
-- Criando usuario de BD --------------------------------------
---------------------------------------------------------------
CREATE ROLE suplementos LOGIN
  ENCRYPTED PASSWORD 'md55250f3cbf0c9a000a7354fe13b627f69'
  NOSUPERUSER INHERIT CREATEDB NOCREATEROLE;

--------------------------------------------------------------
-- Criando BD ------------------------------------------------
--------------------------------------------------------------
CREATE DATABASE "SuplementosNet"
  WITH OWNER = suplementos
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese, Brazil'
       LC_CTYPE = 'Portuguese, Brazil'
       CONNECTION LIMIT = -1;

-- ------------------------------------------------------------
-- Tabela com os arquivos feitos upload pelo usuário do sistema.
-- ------------------------------------------------------------

CREATE TABLE ARQUIVO (
  ID INTEGER,
  CONTEUDO bytea NOT NULL,
  TIPO VARCHAR(10) NULL,
  PRIMARY KEY(ID)
);

-- ------------------------------------------------------------
-- Tabela com as informações de usuários do sistema.
-- ------------------------------------------------------------

CREATE TABLE USUARIO (
  ID INTEGER  NOT NULL,
  USUARIO_CRIADOR INTEGER  NOT NULL,
  LOGIN VARCHAR(50) NOT NULL,
  SENHA CHAR(40) NOT NULL,
  NUMERO_TENTATIVAS SMALLINT  NOT NULL,
  DATA_ULTIMO_LOGIN DATE NULL,
  DATA_CRIACAO DATE NOT NULL,
  SITUACAO CHAR(1) NOT NULL,
  DATA_DESATIVACAO DATE NULL,
  NOME VARCHAR(250) NOT NULL,
  CPF CHAR(11) NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_USUARIO_CRIADOR FOREIGN KEY (USUARIO_CRIADOR) REFERENCES USUARIO(ID),
  UNIQUE(LOGIN)
);


-- ------------------------------------------------------------
-- Tabela com os perfis existentes no sistema.
-- ------------------------------------------------------------

CREATE TABLE PERFIL (
  ID INTEGER  NOT NULL ,
  TITULO VARCHAR(100) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO)
);

-- ------------------------------------------------------------
-- Tabela com as informações de todas as funcionalidades que compõe o sistema.
-- ------------------------------------------------------------

CREATE TABLE FUNCIONALIDADE (
  ID INTEGER  NOT NULL ,
  TITULO VARCHAR(100) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO)
);

-- ------------------------------------------------------------
-- Tabela que indica os perfis do usuário.
-- ------------------------------------------------------------

CREATE TABLE USUARIO_PERFIL (
  USUARIO_ID INTEGER NOT NULL,
  PERFIL_ID INTEGER NOT NULL,
  CRIADOR_ID INTEGER NOT NULL,
  DATA_CRIACAO DATE NOT NULL,
  ATIVO BOOLEAN NOT NULL,
  DATA_DESATIVACAO DATE NULL,
  PRIMARY KEY(USUARIO_ID, PERFIL_ID),
  CONSTRAINT In_USUARIO FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_PERFIL FOREIGN KEY (PERFIL_ID) REFERENCES PERFIL(ID),
  CONSTRAINT In_USUARIO_CRIADOR FOREIGN KEY (CRIADOR_ID) REFERENCES USUARIO(ID)
);


-- ------------------------------------------------------------
-- Tabela com as informações dos clientes da loja.
-- ------------------------------------------------------------

CREATE TABLE CLIENTE (
  ID INTEGER  NOT NULL ,
  ALTERADOR_ID INTEGER  NULL,
  CADASTRADOR_ID INTEGER  NOT NULL,
  RECEBER_INFORMACOES BOOLEAN NOT NULL,
  TOTAL_DESCONTO_ACUMULADO FLOAT NULL,
  DATA_CRIACAO DATE NOT NULL,
  DATA_ALTERACAO DATE NULL,
  NOME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NULL,
  ENDERECO VARCHAR(500) NULL,
  CEP CHAR(8) NULL,
  SEXO CHAR(1) NULL,
  DDD CHAR(2) NULL,
  CPF CHAR(11) NULL,
  UF CHAR(2) NULL,
  TELEFONE VARCHAR(10) NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_USUARIO_CADASTRO FOREIGN KEY (CADASTRADOR_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_USUARIO_ALTERACAO FOREIGN KEY (ALTERADOR_ID) REFERENCES USUARIO(ID)
);


-- ------------------------------------------------------------
-- Tabela que representa a realização de um atendimento de um vendedor para um cliente.
-- ------------------------------------------------------------

CREATE TABLE ATENDIMENTO (
  ID INTEGER,
  VENDEDOR_ID INTEGER NOT NULL,
  CLIENTE_ID INTEGER NULL,
  DATA_ATENDIMENTO DATE NOT NULL,
  SITUACAO CHAR(1) NOT NULL,
  IDENTIFICADOR VARCHAR(250) NOT NULL,
  DATA_CRIACAO DATE NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_VENDEDOR FOREIGN KEY (VENDEDOR_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_CLIENTE FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)
);


-- ------------------------------------------------------------
-- Tabela com as categorias dos produtos. Exemplo: barra de cereal, repositor energético, etc. 
-- ------------------------------------------------------------

CREATE TABLE CATEGORIA (
  ID INTEGER  NOT NULL ,
  TITULO VARCHAR(100) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  ATIVO BOOLEAN NOT NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO)
);


-- ------------------------------------------------------------
-- Tabela com as informações de despesas da loja.
-- ------------------------------------------------------------

CREATE TABLE DESPESA (
  ID INTEGER  NOT NULL ,
  NOME VARCHAR(250) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  DATA_VENCIMENTO DATE NOT NULL,
  DATA_PAGAMENTO DATE NULL,
  VALOR_TOTAL FLOAT NOT NULL,
  VALOR_DESCONTO FLOAT NULL,
  DESCONTO_PAGAMENTO_ATENCIPADO BOOLEAN NULL,
  DATA_PAGAMENTO_ATENCIPADO DATE NULL,
  CONTA_PAGA BOOLEAN NOT NULL,
  VALOR_PAGO FLOAT NULL,
  PRIMARY KEY(ID)
);


-- ------------------------------------------------------------
-- Tabela com informações de formas de pagamento disponíveis na loja ou oferecidos pelos fornecedore
-- ------------------------------------------------------------

CREATE TABLE FORMA_PAGAMENTO (
  ID INTEGER  NOT NULL ,
  TITULO VARCHAR(100) NOT NULL,
  FORNECEDOR BOOLEAN NULL,
  CLIENTE BOOLEAN NULL,
  ATIVO BOOLEAN NOT NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO)
);


-- ------------------------------------------------------------
-- Tabela com as informações de marcas comercializadas pela loja.
-- ------------------------------------------------------------

CREATE TABLE MARCA (
  ID INTEGER  NOT NULL ,
  TITULO VARCHAR(100) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  ATIVO BOOLEAN NOT NULL,
  SITE VARCHAR(250) NULL,
  EMAIL VARCHAR(250) NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO)
);

-- ------------------------------------------------------------
-- Tabela com parametros do sistema. Ela conterá o conjunto de informações básicas parametrizáveis do sistema, como or exemplo as configurações de servidor de e-mail.
-- ------------------------------------------------------------

CREATE TABLE PARAMETRO_SISTEMA (
  CODIGO CHAR(6) NOT NULL ,
  VALOR VARCHAR(100) NOT NULL,
  NOME VARCHAR(250) NOT NULL,
  PRIMARY KEY(CODIGO)
);


-- ------------------------------------------------------------
-- Tabela com as informações dos fornecedores da loja.
-- ------------------------------------------------------------

CREATE TABLE FORNECEDOR (
  ID INTEGER  NOT NULL ,
  NOME VARCHAR(250) NOT NULL,
  ENDERECO VARCHAR(500) NULL,
  EMAIL VARCHAR(250) NULL,
  TELEFONE VARCHAR(10) NULL,
  DDD CHAR(2) NULL,
  CNPJ CHAR(14) NULL,
  INSCRICAO_ESTADUAL CHAR(11) NULL,
  UF CHAR(2) NULL,
  CONTATO VARCHAR(250) NULL,
  SITE VARCHAR(250) NULL,
  ATIVO BOOLEAN NOT NULL,
  PRIMARY KEY(ID)
);


-- ------------------------------------------------------------
-- Tabela de relaciomento muitos-para-muitos entre fornecedor e forma de pagamento.
-- ------------------------------------------------------------

CREATE TABLE FORNECEDOR_FORMA_PAGAMENTO (
  FORNECEDOR_ID INTEGER  NOT NULL,
  FORMA_PAGAMENTO_ID INTEGER  NOT NULL,
  PRIMARY KEY(FORNECEDOR_ID, FORMA_PAGAMENTO_ID),
  CONSTRAINT In_FORNECEDOR FOREIGN KEY (FORNECEDOR_ID) REFERENCES FORNECEDOR(ID),
  CONSTRAINT In_FORMA_PAGAMENTO FOREIGN KEY (FORMA_PAGAMENTO_ID) REFERENCES FORMA_PAGAMENTO(ID)
);


-- ------------------------------------------------------------
-- Tabela com as promoções criadas para loja.
-- ------------------------------------------------------------

CREATE TABLE PROMOCAO (
  ID INTEGER  NOT NULL ,
  ARQUIVO_ID INTEGER  NULL,
  CRIADOR_PROMOCAO_ID INTEGER  NOT NULL,
  TITULO VARCHAR(100) NOT NULL,
  TEXTO TEXT NULL,
  PERCENTUAL_DESCONTO FLOAT NULL,
  VALOR_DESCONTO FLOAT NULL,
  CONDICIONAL_VALOR_COMPRA BOOLEAN NULL,
  VALOR_COMPRA_DESCONTO FLOAT NULL,
  DATA_CRIACAO DATE NOT NULL,
  DATA_FIM_PROMOCAO DATE NULL,
  DATA_INICIO_PROMOCAO DATE NOT NULL,
  ENVIO_AUTOMATICO BOOLEAN NOT NULL,
  PRIMARY KEY(ID),
  UNIQUE(TITULO),
  CONSTRAINT In_CRIADOR FOREIGN KEY (CRIADOR_PROMOCAO_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_Folder FOREIGN KEY (ARQUIVO_ID) REFERENCES ARQUIVO(ID)
);


-- ------------------------------------------------------------
-- Tabela de relaciomento muitos-para-muitos entre fornecedor e marca.
-- ------------------------------------------------------------

CREATE TABLE FORNECEDOR_MARCA (
  FORNECEDOR_ID INTEGER  NOT NULL,
  MARCA_ID INTEGER  NOT NULL,
  PRIMARY KEY(FORNECEDOR_ID, MARCA_ID),
  CONSTRAINT In_FORNECEDOR FOREIGN KEY (FORNECEDOR_ID) REFERENCES FORNECEDOR(ID),
  CONSTRAINT In_MARCA FOREIGN KEY (MARCA_ID) REFERENCES MARCA(ID)
);


-- ------------------------------------------------------------
-- Tabela de relaciomento muitos-para-muitos entre funcionalidade e perfil.
-- ------------------------------------------------------------

CREATE TABLE PERFIL_FUNCIONALIDADE (
  PERFIL_ID INTEGER  NOT NULL,
  FUNCIONALIDADE_ID INTEGER  NOT NULL,
  PRIMARY KEY(PERFIL_ID, FUNCIONALIDADE_ID),
  CONSTRAINT In_PERFIL FOREIGN KEY (PERFIL_ID) REFERENCES PERFIL(ID),
  CONSTRAINT In_FUNCIONALIDADE FOREIGN KEY (FUNCIONALIDADE_ID) REFERENCES FUNCIONALIDADE(ID)
);

-- ------------------------------------------------------------
-- Tabela com as informações de produtos comercializados pela loja. Cada registro representa a definição de um produto que existe ou já existiu na loja.
-- ------------------------------------------------------------

CREATE TABLE PRODUTO (
  ID INTEGER  NOT NULL ,
  ARQUIVO_ID INTEGER  NULL,
  PRODUTO_ANTERIOR INTEGER,
  CATEGORIA_ID INTEGER  NOT NULL,
  MARCA_ID INTEGER  NOT NULL,
  NOME VARCHAR(250) NOT NULL,
  DESCRICAO VARCHAR(500) NULL,
  VALOR FLOAT NOT NULL,
  ORIGINAL BIT NOT NULL,
  ATIVO BOOLEAN NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_MARCA FOREIGN KEY (MARCA_ID) REFERENCES MARCA(ID),
  CONSTRAINT In_PRODUTO_ANTERIOR FOREIGN KEY (PRODUTO_ANTERIOR) REFERENCES PRODUTO(ID),
  CONSTRAINT In_CATEGORIA FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID),
  CONSTRAINT In_IMAGEM FOREIGN KEY (ARQUIVO_ID) REFERENCES ARQUIVO(ID)
);


-- ------------------------------------------------------------
-- Tabela que representa o estoque da loja.
-- ------------------------------------------------------------

CREATE TABLE ESTOQUE (
  PRODUTO_ID INTEGER  NOT NULL,
  QUANTIDADE INTEGER  NOT NULL,
  PRIMARY KEY(PRODUTO_ID),
  CONSTRAINT In_PRODUTO FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(ID)
);


-- ------------------------------------------------------------
-- Tabela com as informações de produtos baixados (removidos) do estoque.
-- ------------------------------------------------------------

CREATE TABLE BAIXA_PRODUTO (
  ID INTEGER  NOT NULL,
  ESTOQUE_PRODUTO_ID INTEGER  NOT NULL,
  DATA_CRIACAO DATE NOT NULL ,
  MOTIVO VARCHAR(500) NOT NULL,
  QUANTIDADE SMALLINT  NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_ESTOQUE FOREIGN KEY (ESTOQUE_PRODUTO_ID) REFERENCES ESTOQUE(PRODUTO_ID)
);

-- ------------------------------------------------------------
-- Tabela com as informações dos lotes de produtos contidos no estoque.
-- ------------------------------------------------------------

CREATE TABLE LOTE (
  ID INTEGER  NOT NULL ,
  ESTOQUE_PRODUTO_ID INTEGER  NOT NULL,
  NUMERO_LOTE VARCHAR(100) NOT NULL,
  DATA_RECEBIMENTO DATE NOT NULL,
  DATA_VALIDADE DATE NOT NULL,
  DATA_CRIACAO DATE NOT NULL,
  QUANTIDADE INTEGER NOT NULL,
  PRIMARY KEY(ID),
  CONSTRAINT In_ESTOQUE FOREIGN KEY (ESTOQUE_PRODUTO_ID) REFERENCES ESTOQUE(PRODUTO_ID)
);


-- ------------------------------------------------------------
-- Tabelas com as informações dos produtos que compõe uma venda.
-- ------------------------------------------------------------

CREATE TABLE PRODUTO_ATENDIMENTO (
  ATENDIMENTO_ID INTEGER  NOT NULL,
  PRODUTO_ID INTEGER  NOT NULL,
  QUANTIDADE_PRODUTO INTEGER  NOT NULL,
  PRIMARY KEY(ATENDIMENTO_ID, PRODUTO_ID),
  CONSTRAINT In_ATENDIMENTO FOREIGN KEY (ATENDIMENTO_ID) REFERENCES ATENDIMENTO(ID),
  CONSTRAINT In_PRODUTO FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(ID)
);


-- ------------------------------------------------------------
-- Tabela de relaciomento muitos-para-muitos entre produto e fornecedor.
-- ------------------------------------------------------------

CREATE TABLE PRODUTO_FORNECEDOR (
  PRODUTO_ID INTEGER  NOT NULL,
  FORNECEDOR_ID INTEGER  NOT NULL,
  PRIMARY KEY(PRODUTO_ID, FORNECEDOR_ID),
  CONSTRAINT In_PRODUTO FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(ID),
  CONSTRAINT In_FORNECEDOR FOREIGN KEY (FORNECEDOR_ID) REFERENCES FORNECEDOR(ID)
);


-- ------------------------------------------------------------
-- Tabela com as informações de venda.
-- ------------------------------------------------------------

CREATE TABLE VENDA (
  ATENDIMENTO_ID INTEGER  NOT NULL,
  PROMOCAO_ID INTEGER  NULL,
  GERENTE_ID INTEGER  NULL,
  CAIXA_ID INTEGER  NOT NULL,
  VALOR_TOTAL FLOAT NOT NULL,
  VALOR_DESCONTO FLOAT NULL,
  VALOR_FINAL FLOAT NOT NULL,
  DESCONTO_AUTORIZADO BIT NULL,
  DATA_VENDA DATE NOT NULL,
  SITUACAO CHAR(1) NOT NULL,
  PRIMARY KEY(ATENDIMENTO_ID),
  CONSTRAINT In_GERENTE FOREIGN KEY (GERENTE_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_ATENDIMENTO FOREIGN KEY (ATENDIMENTO_ID) REFERENCES ATENDIMENTO(ID),
  CONSTRAINT In_CAIXA FOREIGN KEY (CAIXA_ID) REFERENCES USUARIO(ID),
  CONSTRAINT In_PROMOCAO FOREIGN KEY (PROMOCAO_ID) REFERENCES PROMOCAO(ID)
);

-- ------------------------------------------------------------
-- Tabela que indica as formas de pagamento utilizadas em um venda e valor correspondente a forma escolhida no total da venda.
-- ------------------------------------------------------------

CREATE TABLE VENDA_FORMA_PAGAMENTO_CLIENTE (
  FORMA_PAGAMENTO_ID INTEGER  NOT NULL,
  VENDA_ATENDIMENTO_ID INTEGER  NOT NULL,
  VALOR FLOAT NOT NULL,
  PRIMARY KEY(FORMA_PAGAMENTO_ID, VENDA_ATENDIMENTO_ID),
  CONSTRAINT In_FORMA_PAGAMENTO FOREIGN KEY (FORMA_PAGAMENTO_ID) REFERENCES FORMA_PAGAMENTO(ID),
  CONSTRAINT In_VENDA FOREIGN KEY (VENDA_ATENDIMENTO_ID) REFERENCES VENDA(ATENDIMENTO_ID)
);

-- ------------------------------------------------------------
-- Tabelas com as informações dos estornos realizados pelo sistema.
-- ------------------------------------------------------------

CREATE TABLE ESTORNO (
  VENDA_ID INTEGER  NOT NULL,
  CAIXA_ID INTEGER  NOT NULL,
  DATA_ESTORNO DATE NOT NULL ,
  VALOR_ESTORNO FLOAT NOT NULL,
  PRIMARY KEY(VENDA_ID),
  CONSTRAINT In_VENDA FOREIGN KEY (VENDA_ID) REFERENCES VENDA(ATENDIMENTO_ID),
  CONSTRAINT In_CAIXA FOREIGN KEY (CAIXA_ID) REFERENCES USUARIO(ID)
);


---------------------------------------------------------------------------
-- CRIANDO AS SEQUENCES ---------------------------------------------------
---------------------------------------------------------------------------

CREATE SEQUENCE ARQUIVO_SEQ;
CREATE SEQUENCE USUARIO_SEQ;
CREATE SEQUENCE CLIENTE_SEQ;
CREATE SEQUENCE ATENDIMENTO_SEQ;
CREATE SEQUENCE CATEGORIA_SEQ;
CREATE SEQUENCE DESPESA_SEQ;
CREATE SEQUENCE FORMA_PAGAMENTO_SEQ;
CREATE SEQUENCE MARCA_SEQ;
CREATE SEQUENCE FORNECEDOR_SEQ;
CREATE SEQUENCE PROMOCAO_SEQ;
CREATE SEQUENCE PRODUTO_SEQ;
CREATE SEQUENCE BAIXA_PRODUTO_SEQ;
CREATE SEQUENCE LOTE_SEQ;


--------------------------------------------------------------------------
-- Acesso ---------------------------------------------------------------
--------------------------------------------------------------------------
ALTER TABLE arquivo OWNER TO suplementos;
GRANT ALL ON TABLE arquivo TO suplementos;

ALTER TABLE USUARIO OWNER TO suplementos;
GRANT ALL ON TABLE USUARIO TO suplementos;

ALTER TABLE PERFIL OWNER TO suplementos;
GRANT ALL ON TABLE PERFIL TO suplementos;

ALTER TABLE FUNCIONALIDADE OWNER TO suplementos;
GRANT ALL ON TABLE FUNCIONALIDADE TO suplementos;

ALTER TABLE USUARIO_PERFIL OWNER TO suplementos;
GRANT ALL ON TABLE USUARIO_PERFIL TO suplementos;

ALTER TABLE CLIENTE OWNER TO suplementos;
GRANT ALL ON TABLE CLIENTE TO suplementos;

ALTER TABLE ATENDIMENTO OWNER TO suplementos;
GRANT ALL ON TABLE ATENDIMENTO TO suplementos;

ALTER TABLE CATEGORIA OWNER TO suplementos;
GRANT ALL ON TABLE CATEGORIA TO suplementos;

ALTER TABLE DESPESA OWNER TO suplementos;
GRANT ALL ON TABLE DESPESA TO suplementos;

ALTER TABLE FORMA_PAGAMENTO OWNER TO suplementos;
GRANT ALL ON TABLE FORMA_PAGAMENTO TO suplementos;

ALTER TABLE MARCA OWNER TO suplementos;
GRANT ALL ON TABLE MARCA TO suplementos;

ALTER TABLE PARAMETRO_SISTEMA OWNER TO suplementos;
GRANT ALL ON TABLE FORNECEDOR TO suplementos;

ALTER TABLE FORNECEDOR_FORMA_PAGAMENTO OWNER TO suplementos;
GRANT ALL ON TABLE FORNECEDOR_FORMA_PAGAMENTO TO suplementos;

ALTER TABLE PROMOCAO OWNER TO suplementos;
GRANT ALL ON TABLE PROMOCAO TO suplementos;

ALTER TABLE FORNECEDOR_MARCA OWNER TO suplementos;
GRANT ALL ON TABLE FORNECEDOR_MARCA TO suplementos;

ALTER TABLE PERFIL_FUNCIONALIDADE OWNER TO suplementos;
GRANT ALL ON TABLE PERFIL_FUNCIONALIDADE TO suplementos;

ALTER TABLE PRODUTO OWNER TO suplementos;
GRANT ALL ON TABLE PRODUTO TO suplementos;

ALTER TABLE ESTOQUE OWNER TO suplementos;
GRANT ALL ON TABLE ESTOQUE TO suplementos;

ALTER TABLE BAIXA_PRODUTO OWNER TO suplementos;
GRANT ALL ON TABLE BAIXA_PRODUTO TO suplementos;

ALTER TABLE LOTE OWNER TO suplementos;
GRANT ALL ON TABLE LOTE TO suplementos;

ALTER TABLE PRODUTO_ATENDIMENTO OWNER TO suplementos;
GRANT ALL ON TABLE PRODUTO_ATENDIMENTO TO suplementos;

ALTER TABLE PRODUTO_FORNECEDOR OWNER TO suplementos;
GRANT ALL ON TABLE PRODUTO_FORNECEDOR TO suplementos;

ALTER TABLE VENDA OWNER TO suplementos;
GRANT ALL ON TABLE VENDA TO suplementos;

ALTER TABLE VENDA_FORMA_PAGAMENTO_CLIENTE OWNER TO suplementos;
GRANT ALL ON TABLE VENDA_FORMA_PAGAMENTO_CLIENTE TO suplementos;

ALTER TABLE ESTORNO OWNER TO suplementos;
GRANT ALL ON TABLE ESTORNO TO suplementos;

ALTER SEQUENCE ARQUIVO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE ARQUIVO_SEQ TO suplementos;

ALTER SEQUENCE USUARIO_SEQ OWNER TO suplementos;
GRANT ALL ON TABLE USUARIO_SEQ TO suplementos;

ALTER SEQUENCE ATENDIMENTO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE ATENDIMENTO_SEQ TO suplementos;

ALTER SEQUENCE CLIENTE_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE CLIENTE_SEQ TO suplementos;

ALTER SEQUENCE CATEGORIA_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE CATEGORIA_SEQ TO suplementos;

ALTER SEQUENCE DESPESA_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE DESPESA_SEQ TO suplementos;

ALTER SEQUENCE FORMA_PAGAMENTO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE FORMA_PAGAMENTO_SEQ TO suplementos;

ALTER TABLE MARCA_SEQ OWNER TO suplementos;
GRANT ALL ON TABLE MARCA_SEQ TO suplementos;

ALTER SEQUENCE FORNECEDOR_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE FORNECEDOR_SEQ TO suplementos;

ALTER SEQUENCE PROMOCAO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE PROMOCAO_SEQ TO suplementos;

ALTER SEQUENCE PRODUTO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE PRODUTO_SEQ TO suplementos;

ALTER SEQUENCE BAIXA_PRODUTO_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE BAIXA_PRODUTO_SEQ TO suplementos;

ALTER SEQUENCE LOTE_SEQ OWNER TO suplementos;
GRANT ALL ON SEQUENCE LOTE_SEQ TO suplementos;



