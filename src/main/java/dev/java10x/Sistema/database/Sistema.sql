create database Sistema;
use Sistema;
show databases;
select *
from financas;
TRUNCATE TABLE financas;
TRUNCATE TABLE conta;

TRUNCATE TABLE usuarios;
ALTER TABLE usuarios MODIFY papel VARCHAR(50);

select * from usuarios;
insert into usuarios  (email, nome, senha, papel) values ("kaka@gmail", "kaka", "$2a$10$4pkBz1Nb/Bn7xp7JQACgj.OZWVKlmHifMVnO6bmcmtKO3AdzocvSe");
INSERT INTO usuarios (nome, senha, email, papel)
VALUES ('João Silva', '$2a$10$6JddCdm73mm94kOPqX.jDOhQKXEnntyjx4aK5FrNscEYdIp7RPGWu', 'joao@empresa.com', 0);

INSERT INTO usuarios (nome, senha, email, papel)
VALUES ('Maria Souza', '$2a$10$Mc0weK1.pMs2K0oA2ABIF.3.CnbWxOuTYeeToaDfoAfs6QZRppaVW', 'maria@empresa.com', 1);

INSERT INTO usuarios (nome, senha, email, papel)
VALUES ('Carlos Pereira', '$2a$10$kjGH8K4s9mxO89/6RmEkBO9TD4n2G.nPX2ByWBzIaxmxWPB3XOOpC', 'carlos@fornecedor.com', 2);
select * from financasFuncionario;


