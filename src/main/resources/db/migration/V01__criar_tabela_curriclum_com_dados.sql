CREATE TABLE [dbo].[pessoa] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [VARCHAR](100) NOT NULL,
	[nacionalidade] [VARCHAR](30) NULL,
	[telefone] [VARCHAR](20) NOT NULL,
	[logradouro] [VARCHAR](100) NOT NULL,
	[numero] [VARCHAR](20) NULL,
	[estado] [VARCHAR](50) NULL,
	[cidade] [VARCHAR](50) NULL,
	[bairro] [VARCHAR](50) NULL,
	[data_nascimento] [DATE] NOT NULL,
	[estado_civil] [VARCHAR](30) NULL,
	[area_interesse] [VARCHAR](100) NULL,
	[formacao_academica] [VARCHAR](100) NULL,
	[experiencia_profissional] [VARCHAR](100) NOT NULL,
	[qualificacoes] [VARCHAR](100) NULL,
	[idiomas] [VARCHAR](100) NULL,
	[observacao] [VARCHAR](100) NULL,
	CONSTRAINT [pk_pessoa] PRIMARY KEY CLUSTERED
	([id] ASC)
);

INSERT INTO pessoa (nome, nacionalidade, telefone, logradouro, numero, estado, cidade, bairro, 
data_nascimento, estado_civil, area_interesse, formacao_academica, experiencia_profissional,
qualificacoes, idiomas, observacao) VALUES ('Josenilto Silva', 'Rio de Janeiro', '(21)99286-1298', 'Av. Dom expedito',
'AP-201', 'RJ', 'Rio de Janeiro', 'Alto Novo', '1984-12-21', 'CASADO', 'Programação', 'Analista de Sistemas',
'Experiências com Linux', 'Certificação em Linux', 'Inglês Avançado', 'Gosta de surfar');
INSERT INTO pessoa (nome, nacionalidade, telefone, logradouro, numero, estado, cidade, bairro, 
data_nascimento, estado_civil, area_interesse, formacao_academica, experiencia_profissional,
qualificacoes, idiomas, observacao) VALUES ('Antonio Luciano Lima da Silva', 'Ceará', '(88)98852-7485', 'Residencial Meruoca',
'38', 'CE', 'Sobral', 'Alto da Brasilia', '1989-11-23', 'SOLTEIRO', 'Programação Java', 'Analista de Sistemas',
'Experiências com Java EE', 'Certificação em OCA Java Programmer I', 'Inglês Intermediario', 'Ganhou premio de melhor funcionário do ano de 2013');