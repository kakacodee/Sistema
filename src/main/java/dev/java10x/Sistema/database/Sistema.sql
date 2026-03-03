create database Sistema;
use Sistema;
show databases;
select *
from financas;
TRUNCATE TABLE financas;
TRUNCATE TABLE conta;
TRUNCATE TABLE usuarios;
select * from usuarios;
insert into usuarios  (email, nome, senha) values ("kaka@gmail", "kaka", "$2a$10$4pkBz1Nb/Bn7xp7JQACgj.OZWVKlmHifMVnO6bmcmtKO3AdzocvSe");