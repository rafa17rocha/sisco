SELECT * FROM sistemapredial.empresa;
SELECT * FROM sistemapredial.usuario;

-- Tipo 0 = Funcionário
-- Tipo 1 = Atendente
-- Tipo 2 = Sindico

INSERT INTO sistemapredial.empresa VALUES (null, "Google", 11222333000144, 11, "09001600", "10001500", 21);
INSERT INTO sistemapredial.empresa VALUES (null, "Microsoft", 55777888000199, 12, "08301530", "09301430", 23);

INSERT INTO sistemapredial.usuario VALUES (null, 2, "Síndico", 12312312312, null, "00002359", true, true, "sindico", "sindico");
INSERT INTO sistemapredial.usuario VALUES (null, 1, "Rafael Carvalho", 11122233344, null, "00002359", true, true, "rafael", "rafael");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "Maria Madalena", 55566677788, 1, "09301530", false, false, "maria", "maria");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "José Silva", 99900011122, 1, "08301430", false, true, "jose", "jose");
INSERT INTO sistemapredial.usuario VALUES (null, 0, "Ana Maria", 32132132199, 2, "08451545", true, true, "ana", "ana");