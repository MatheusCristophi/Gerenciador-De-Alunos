ALTER TABLE administradores RENAME TO tb_administradores;

ALTER TABLE tb_administradores ADD COLUMN role VARCHAR(20);
ALTER TABLE tb_alunos ADD COLUMN role VARCHAR(20);
ALTER TABLE tb_professores ADD COLUMN role VARCHAR(20);
