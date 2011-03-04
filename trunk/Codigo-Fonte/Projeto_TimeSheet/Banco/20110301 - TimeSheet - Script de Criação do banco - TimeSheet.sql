create sequence S_Atividade;

create sequence S_AvaliacaoAtividade;

create sequence S_Calendario;

create sequence S_HistoricoTimeSheet;

create sequence S_Metodologia;

create sequence S_ProdutoServico;

create sequence S_Projeto;

create sequence S_SituacaoAtividade;

create sequence S_TimeSheet;

create sequence S_TipoAtividade;

/*==============================================================*/
/* User: TS                                                     */
/*==============================================================*/
create user TS;

/*==============================================================*/
/* Table: Atividade                                             */
/*==============================================================*/
create table TS.Atividade (
   CodigoAtividade      SERIAL not null,
   CodigoTipoAtividade  INT4                 null,
   Descricao            CHAR(10)             null,
   constraint PkcAtividade primary key (CodigoAtividade)
);

-- set table ownership
alter table TS.Atividade owner to TS
;
/*==============================================================*/
/* Table: AvaliacaoAtividade                                    */
/*==============================================================*/
create table TS.AvaliacaoAtividade (
   CodigoAvaliacaoTimeSheet SERIAL not null,
   CodigoSituacaoAtividade INT4                 null,
   CodigoFuncionarioAvaliador INT4                 null,
   CodigoTimeSheet      INT4                 null,
   Observacao           TEXT                 null,
   ObservacaoPrivada    TEXT                 null,
   DataInicio           DATE                 null,
   DataFim              DATE                 null,
   constraint PkcAvaliacaoAtividade primary key (CodigoAvaliacaoTimeSheet)
);

-- set table ownership
alter table TS.AvaliacaoAtividade owner to TS
;
/*==============================================================*/
/* Table: Calendario                                            */
/*==============================================================*/
create table TS.Calendario (
   CodigoCalendario     SERIAL not null,
   Data                 DATE                 null,
   CargaHoraria         INT4                 null,
   HoraInicio           INT4                 null,
   HoraFim              INT4                 null,
   constraint PkcCalendario primary key (CodigoCalendario)
);

-- set table ownership
alter table TS.Calendario owner to TS
;
/*==============================================================*/
/* Table: Cliente                                               */
/*==============================================================*/
create table TS.Cliente (
   CodigoCliente        SERIAL not null,
   Nome                 VARCHAR(100)         null,
   constraint PkcCliente primary key (CodigoCliente)
);

-- set table ownership
alter table TS.Cliente owner to TS
;
/*==============================================================*/
/* Table: Funcionario                                           */
/*==============================================================*/
create table TS.Funcionario (
   CodigoFuncionario    SERIAL not null,
   CodigoFuncionarioChefe INT4                 null,
   CodigoFuncionarioSubstituto INT4                 null,
   Nome                 VARCHAR(100)         null,
   Cargo                VARCHAR(100)         null,
   IndicaChefe          BOOL                 null,
   HoraTrabalhoInicio   INT4                 null,
   HoraTrabalhoFim      INT4                 null,
   HoraAlmocoInicio     INT4                 null,
   HoraAlmocoFim        INT4                 null,
   IndicaFerias         BOOL                 null,
   constraint PkcFuncionario primary key (CodigoFuncionario)
);

-- set table ownership
alter table TS.Funcionario owner to TS
;
/*==============================================================*/
/* Table: FuncionarioCliente                                    */
/*==============================================================*/
create table TS.FuncionarioCliente (
   CodigoFuncionario    INT4                 null,
   CodigoCliente        INT4                 null
);

-- set table ownership
alter table TS.FuncionarioCliente owner to TS
;
/*==============================================================*/
/* Table: HistoricoTimeSheet                                    */
/*==============================================================*/
create table TS.HistoricoTimeSheet (
   CodigoHistoricoTimeSheet SERIAL not null,
   CodigoUsuario        INT4                 null,
   CodigoTimeSheet      INT4                 not null,
   CodigoOP             INT4                 null,
   CodigoProdutoServico INT4                 null,
   CodigoMetodologia    INT4                 null,
   CodigoProjeto        INT4                 null,
   CodigoCliente        INT4                 null,
   CodigoFuncionario    INT4                 null,
   CodigoAtividade      INT4                 null,
   DataHoraInicio       DATE                 null,
   DataHoraFim          DATE                 null,
   Observacao           TEXT                 null,
   IndicaAlteracaoDataAvaliacao BOOL                 null,
   TipoOperacao         CHAR(1)              null,
   DataOperacao         DATE                 null,
   constraint PkcHistoricoTimeSheet primary key (CodigoHistoricoTimeSheet)
);

-- set table ownership
alter table TS.HistoricoTimeSheet owner to TS
;
/*==============================================================*/
/* Table: Metodologia                                           */
/*==============================================================*/
create table TS.Metodologia (
   CodigoMetodologia    SERIAL not null,
   Descricao            VARCHAR(250)         null,
   constraint PkcMetodologia primary key (CodigoMetodologia)
);

-- set table ownership
alter table TS.Metodologia owner to TS
;
/*==============================================================*/
/* Table: OP                                                    */
/*==============================================================*/
create table TS.OP (
   CodigoOP             SERIAL not null,
   CodigoCliente        INT4                 null,
   Descricao            VARCHAR(250)         null,
   constraint PkcOP primary key (CodigoOP)
);

-- set table ownership
alter table TS.OP owner to TS
;
/*==============================================================*/
/* Table: ProdutoServico                                        */
/*==============================================================*/
create table TS.ProdutoServico (
   CodigoProdutoServico SERIAL not null,
   CodigoMetodologia    INT4                 null,
   Descricao            VARCHAR(250)         null,
   constraint PkcProdutoServico primary key (CodigoProdutoServico)
);

-- set table ownership
alter table TS.ProdutoServico owner to TS
;
/*==============================================================*/
/* Table: Projeto                                               */
/*==============================================================*/
create table TS.Projeto (
   CodigoProjeto        SERIAL not null,
   CodigoMetodologia    INT4                 null,
   NumeroProjeto        INT4                 null,
   Nome                 VARCHAR(100)         null,
   constraint PkcProjeto primary key (CodigoProjeto)
);

-- set table ownership
alter table TS.Projeto owner to TS
;
/*==============================================================*/
/* Table: SituacaoAtividade                                     */
/*==============================================================*/
create table TS.SituacaoAtividade (
   CodigoSituacaoAtividade SERIAL not null,
   Descricao            VARCHAR(250)         null,
   constraint PkcSituacaoAtividade primary key (CodigoSituacaoAtividade)
);

-- set table ownership
alter table TS.SituacaoAtividade owner to TS
;
/*==============================================================*/
/* Table: TimeSheet                                             */
/*==============================================================*/
create table TS.TimeSheet (
   CodigoTimeSheet      SERIAL not null,
   CodigoOP             INT4                 null,
   CodigoProdutoServico INT4                 null,
   CodigoMetodologia    INT4                 null,
   CodigoProjeto        INT4                 null,
   CodigoCliente        INT4                 null,
   CodigoFuncionario    INT4                 null,
   CodigoAtividade      INT4                 null,
   DataHoraInicio       DATE                 null,
   DataHoraFim          DATE                 null,
   Observacao           TEXT                 null,
   IndicaAlteracaoDataAvaliacao BOOL                 null,
   OutrasAtividades     VARCHAR(255)         null,
   constraint PkcTimeSheet primary key (CodigoTimeSheet)
);

-- set table ownership
alter table TS.TimeSheet owner to TS
;
/*==============================================================*/
/* Table: TipoAtividade                                         */
/*==============================================================*/
create table TS.TipoAtividade (
   CodigoTipoAtividade  SERIAL not null,
   Descricao            VARCHAR(250)         null,
   constraint PkcTipoAtividade primary key (CodigoTipoAtividade)
);

-- set table ownership
alter table TS.TipoAtividade owner to TS
;
/*==============================================================*/
/* Table: Usuario                                               */
/*==============================================================*/
create table TS.Usuario (
   CodigoUsuario        SERIAL not null,
   CodigoFuncionario    INT4                 null,
   Login                VARCHAR(100)         null,
   Senha                VARCHAR(40)          null,
   IndicaBloqueado      BOOL                 null,
   DataUltimoLogin      DATE                 null,
   IndicaAlterarSenha   BOOL                 null,
   constraint PkcUsuario primary key (CodigoUsuario)
);

/*==============================================================*/

/* Table: Configuracao                                          */

/*==============================================================*/

create table TS.Configuracao (

   CodigoConfiguracao   SERIAL not null,
   HoraInicio           INT4                 null,
   HoraFim              INT4                 null,
   HoraAlmocoInicio     INT4                 null,
   HoraAlmocoFim        INT4                 null,
   MinimoAlmoco         INT4                 null,
   TotalHorasMes        INT4                 null,
   constraint PkcConfiguracao primary key (CodigoConfiguracao)

);


-- set table ownership
alter table TS.Usuario owner to TS
;
alter table TS.Atividade
   add constraint FkcTipoAtividadeAtividade foreign key (CodigoTipoAtividade)
      references TS.TipoAtividade (CodigoTipoAtividade)
      

alter table TS.AvaliacaoAtividade
   add constraint FkcSituacaoAtividadeAvaliacaoAtividade foreign key (CodigoSituacaoAtividade)
      references TS.SituacaoAtividade (CodigoSituacaoAtividade)
      

alter table TS.AvaliacaoAtividade
   add constraint FkcFuncionarioAvaliacaoAtividade foreign key (CodigoFuncionarioAvaliador)
      references TS.Funcionario (CodigoFuncionario)
      

alter table TS.AvaliacaoAtividade
   add constraint FkcTimeSheetAvaliacaoAtividade foreign key (CodigoTimeSheet)
      references TS.TimeSheet (CodigoTimeSheet)
      

alter table TS.Funcionario
   add constraint FkcFuncionarioChefe foreign key (CodigoFuncionarioChefe)
      references TS.Funcionario (CodigoFuncionario)
      

alter table TS.Funcionario
   add constraint FkcFuncionarioSubstituto foreign key (CodigoFuncionarioSubstituto)
      references TS.Funcionario (CodigoFuncionario)
      

alter table TS.FuncionarioCliente
   add constraint FkcFuncionarioFuncionarioCliente foreign key (CodigoFuncionario)
      references TS.Funcionario (CodigoFuncionario)
      

alter table TS.FuncionarioCliente
   add constraint FkcClienteFuncionarioCliente foreign key (CodigoCliente)
      references TS.Cliente (CodigoCliente)
      

alter table TS.HistoricoTimeSheet
   add constraint FkcUsuarioHistoricoTimeSheet foreign key (CodigoUsuario)
      references TS.Usuario (CodigoUsuario)
      

alter table TS.HistoricoTimeSheet
   add constraint FkcTimeSheetHistoricoTimeSheet foreign key (CodigoTimeSheet)
      references TS.TimeSheet (CodigoTimeSheet)
      

alter table TS.OP
   add constraint FkcClienteOP foreign key (CodigoCliente)
      references TS.Cliente (CodigoCliente)
      

alter table TS.ProdutoServico
   add constraint FkcProdutoServicoMetodologia foreign key (CodigoMetodologia)
      references TS.Metodologia (CodigoMetodologia)
      

alter table TS.Projeto
   add constraint FkcMetodologiaProjeto foreign key (CodigoMetodologia)
      references TS.Metodologia (CodigoMetodologia)
      

alter table TS.TimeSheet
   add constraint FkcMetodologiaTimeSheet foreign key (CodigoMetodologia)
      references TS.Metodologia (CodigoMetodologia)
      

alter table TS.TimeSheet
   add constraint FkcProjetoTimeSheet foreign key (CodigoProjeto)
      references TS.Projeto (CodigoProjeto)
      

alter table TS.TimeSheet
   add constraint FkcClienteTimeSheet foreign key (CodigoCliente)
      references TS.Cliente (CodigoCliente)
      

alter table TS.TimeSheet
   add constraint FkcFuncionarioTimeSheet foreign key (CodigoFuncionario)
      references TS.Funcionario (CodigoFuncionario)
      

alter table TS.TimeSheet
   add constraint FkcAtividadeTimeSheet foreign key (CodigoAtividade)
      references TS.Atividade (CodigoAtividade)
      

alter table TS.TimeSheet
   add constraint FkcTimeSheetOP foreign key (CodigoOP)
      references TS.OP (CodigoOP)
      

alter table TS.TimeSheet
   add constraint FkcProdutoServicoTimeSheet foreign key (CodigoProdutoServico)
      references TS.ProdutoServico (CodigoProdutoServico)
      

alter table TS.Usuario
   add constraint FkcFuncionarioUsuario foreign key (CodigoFuncionario)
      references TS.Funcionario (CodigoFuncionario)

alter table Configuracao owner to TS;
      
