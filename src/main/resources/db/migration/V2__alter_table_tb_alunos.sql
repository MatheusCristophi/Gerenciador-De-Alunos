ALTER TABLE tb_alunos ADD COLUMN email VARCHAR(255);
ALTER TABLE tb_alunos ADD COLUMN senha VARCHAR(255);

ALTER TABLE administrador RENAME COLUMN admin_id TO id;
ALTER TABLE administrador RENAME COLUMN admin_name TO nome;
ALTER TABLE administrador RENAME COLUMN admin_email TO email;
ALTER TABLE administrador RENAME COLUMN admin_password TO senha;