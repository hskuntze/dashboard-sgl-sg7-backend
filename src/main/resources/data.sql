INSERT INTO perfis (autorizacao) VALUES ('PERFIL_ADMIN');
INSERT INTO perfis (autorizacao) VALUES ('PERFIL_OPERADOR_NOC');
INSERT INTO perfis (autorizacao) VALUES ('PERFIL_OPERADOR_OM');
INSERT INTO perfis (autorizacao) VALUES ('PERFIL_SLI');

INSERT INTO postos (id, titulo) VALUES (1, 'Soldado');
INSERT INTO postos (id, titulo) VALUES (2, 'Cabo');
INSERT INTO postos (id, titulo) VALUES (3, 'Subtenente');
INSERT INTO postos (id, titulo) VALUES (4, '1º Sargento');
INSERT INTO postos (id, titulo) VALUES (5, '2º Sargento');
INSERT INTO postos (id, titulo) VALUES (6, '3º Sargento');
INSERT INTO postos (id, titulo) VALUES (7, 'Subtenente');
INSERT INTO postos (id, titulo) VALUES (8, '1º Tenente');
INSERT INTO postos (id, titulo) VALUES (9, '2º Tenente');
INSERT INTO postos (id, titulo) VALUES (10, 'Capitão');
INSERT INTO postos (id, titulo) VALUES (11, 'Major');
INSERT INTO postos (id, titulo) VALUES (12, 'Tenente-Coronel');
INSERT INTO postos (id, titulo) VALUES (13, 'Coronel');
INSERT INTO postos (id, titulo) VALUES (14, 'General de Brigada');
INSERT INTO postos (id, titulo) VALUES (15, 'General de Divisão');
INSERT INTO postos (id, titulo) VALUES (16, 'General de Exército');

INSERT INTO usuarios (cpf, email, habilitado, identidade, nomecompleto, nomeguerra, organizacao, password, registro_completo, telefone, tipo, username, postograduacao) VALUES
	('001.082.121-06', 'tiagobseb1985@gmail.com', 'TRUE', '22325445', 'Tiago Assunção', '', 'DESMIL', '$2a$10$Gmrd0.bXpqA4PYBT62zkvea6Ho.GZfqAUX9m6Eoqag/fBv1Spef5K', 'TRUE', '6198566898', 'Militar', 'admin', 10),
	('', 'operadorOM@gmail.com', 'TRUE', '', 'operadorOM', '', 'CAEx', '$2a$10$TciVSWE26vo6FN.k5TNUhOv7uRiHvhitmqhjHHp4Hrm49lgdo0dMO', 'TRUE', '61985868878', '', 'operadorOM', null),
	('', 'operadorNOC@GMAIL.COM', 'TRUE', '', 'operadorNOC', '', 'OCEx', '$2a$10$HL.uhEExeARSZa2H7YWyluuRyDxaZyypX.4irWGTcfXzqhyC3NvbC', 'TRUE', '61985868878', '', 'operadorNOC', null),
	('', 'melissa.doumid@embraer.com.br', 'TRUE', '', 'Melissa Moreira Doumid', '', 'Embraer', '$2a$10$Y7YDNQY4U.mBv6ocrPGYwex/.ZgVoXZpvHVrIYiRNRiiuMT/4KY1W', 'TRUE', '16 98100-3503', '', '6062276875', null),
	('', 'henrique.medeiros@embraer.com.br', 'TRUE', '', 'Henrique Medeiros Lima', '', 'Embraer', '$2a$10$6LhonTgnOZFiPBoruG6a4u.eHpUtU6Ao2Pzi99mv45dQb0UInK2/m', 'TRUE', '12 3927-1000', '', '719828', null),
	('', 'dayvison.santos@embraer.com.br', 'TRUE', '', 'Dayvison Carlos dos Santos', '', 'Embraer', '$2a$10$iJbIeaK4UUsDJY66aVtd0ukNuYwnZUgToAMPzCGQnj.N3Dv/d1iYW', 'TRUE', '19 99918-6299', '', '1856744', null),
	('', 'ana.cremonese@embraer.com.br', 'TRUE', '', 'Ana Beatriz Ramos de Souza Cremonese', '', 'Embraer', '$2a$10$NMGQTknAYGExJWfjHzku2.KiC/7pXd2HUketRgeu8veWzILvSGrkS', 'TRUE', '19 99886 6650', '', '201665395', null),
	('', 'andre.custodio@embraer.com.br', 'TRUE', '', 'Andre dos Santos Custodio', '', 'Embraer', '$2a$10$awi9NuIGX2h.V8Dzj80TN.UXdMIHswdSjhb99PoMopncBTv.Ig.y2', 'TRUE', '19 99845-8369', '', '329016660', null),
	('', 'neil.camargo@embraer.com.br', 'TRUE', '', 'Neil Peres Camargo', '', 'Embraer', '$2a$10$spvBVEhWtD7LtmwotKGIOeZ//y8W9EHAdFq.g.AfLMelTuRLxbv2q', 'TRUE', '12 3927-1000', '', '439614028', null),
	('', 'cesar.mendonca@embraer.com.br', 'TRUE', '', 'Cesar Santos Mendonça', '', 'Embraer', '$2a$10$8ONyes5bKY7oSwWMA8HLuON0bgubixMvn4E990P0LoJ2AXPb0aZI2', 'TRUE', '12 3927-1000', '', '7590643', null),
	('', 'paulo.celso@embraer.com.br', 'TRUE', '', 'Paulo Celso da Silva', '', 'Embraer', '$2a$10$3sO4F/r63AnVVaJuRvAwauwat/Gohs051r15n7pM12/ZK61TdSgKy', 'TRUE', '12 3927-1000', '', '10766558', null),
	('', 'joao.santis@embraer.com.br', 'TRUE', '', 'Joao Paulo de Santis', '', 'Embraer', '$2a$10$uGEYoCF6kcz0nkC1UaJ8TeDZeUxsBdy9jjGwocX6gUb1RTQDfR1EW', 'TRUE', '12 3927-8311', '', '410595135', null),
	('', 'cheistoncfs@ctcea.or.br', 'TRUE', '', 'Cheiston de Figueiredo Sena', '', 'Cmdo Com G Ex', '$2a$10$Y37RDdagsNmw7JeLv08AgetNCwQCWTAhFwxIP8tVh0nwNECga2L7y', 'TRUE', '61985252060', '', '2438997', null),
	('', 'emanuelbrito81@gmail.com', 'TRUE', '', 'Emanuel Jonata Oliveira de Brito', '', 'Cmdo Com G Ex', '$2a$10$FFVc2XQ7RFjJCEVK45G5muEQAyy4jj7Gc81j.JiTnAQGNC23nVy8O', 'TRUE', '(61) 98108-8662', '', '1514154', null);
	
INSERT INTO tb_perfil_usuario (id_usuario, id_perfil) VALUES (1, 1);

