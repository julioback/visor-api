create table dbo.Cliente 
    (
	   id int identity primary key,
	   nome varchar(1000) not null,
	   apelido varchar(1000) not null,
	   ativo bit,
	   dtCriacao datetime2 
    )
go
create table dbo.Usuario
	(
	id int identity primary key,
	nome varchar(1000) not null,
	apelido varchar(1000) not null,
	email varchar(1000) not null,
	senha varchar(1000) not null,
	atualizacaoTela int not null,
	perfil varchar(1000) not null,
	dataCriacao datetime2,
	dataAtualizacao datetime2
	)
go
create table dbo.Evento
	(
	id int identity primary key
	)
go
create table dbo.servidor
	(
	id int identity primary key,
	idCliente int not null,
	hostname varchar(1000) not null,
	apelido varchar(1000) not null,
	port int,
	descricao varchar(1000),
	dataCadastro datetime2,
	ultimaAtualizacao datetime2,
	ultimoContato datetime2,
	FOREIGN KEY (idCliente) REFERENCES cliente(id)
	)