CREATE TABLE tb_alunos(
    aluno_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    periodo SMALLINT NOT NULL
);

CREATE TABLE tb_notas_alunos (
    aluno_id UUID NOT NULL,
    nota FLOAT4,
    CONSTRAINT fk_notas_aluno FOREIGN KEY (aluno_id) REFERENCES tb_alunos(aluno_id) ON DELETE CASCADE
);

CREATE TABLE tb_professores (
    professor_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
);

CREATE TABLE alunos_professores (
    professor_id UUID NOT NULL,
    aluno_id UUID NOT NULL,
    PRIMARY KEY (professor_id, aluno_id),
    CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES tb_professores(professor_id),
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES tb_alunos(aluno_id)
);

CREATE TABLE administrador (
    admin_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    admin_name VARCHAR(255) NOT NULL,
    admin_email VARCHAR(255) UNIQUE NOT NULL,
    admin_password VARCHAR(255) NOT NULL
);