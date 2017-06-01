INSERT INTO conjunto VALUES(null, 11);
INSERT INTO conjunto VALUES(null, 12);
INSERT INTO conjunto VALUES(null, 21);
INSERT INTO conjunto VALUES(null, 22);
INSERT INTO conjunto VALUES(null, 31);
INSERT INTO conjunto VALUES(null, 32);

INSERT INTO sistemapredial.empresa VALUES (null, "Google", 11222333000144, 11, "09:00 - 16:00", "10:00 - 15:00", 21);
INSERT INTO sistemapredial.empresa VALUES (null, "Microsoft", 55777888000199, 12, "08:30 - 15:30", "09:30 - 14:30", 23);

INSERT INTO sistemapredial.usuario VALUES (null, 2, "Síndico", 12312312312, null, "00:00 - 23:59", true, true, "sindico", "sindico");
INSERT INTO sistemapredial.usuario VALUES (null, 1, "Rafael Carvalho", 11122233344, null, "00:00 - 23:59", true, true, "rafael", "rafael");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "Maria Madalena", 55566677788, 1, "09:30 - 15:30", false, false, "maria", "maria");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "José Silva", 99900011122, 1, "08:30 - 14:30", false, true, "jose", "jose");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "Ana Maria", 32132132199, 2, "08:45 - 15:45", true, true, "ana", "ana");

-- Tipo 0 = Funcionário
-- Tipo 1 = Atendente
-- Tipo 2 = Sindico

SELECT * FROM sistemapredial.empresa;
SELECT * FROM sistemapredial.usuario;
SELECT * FROM sistemapredial.conjunto;