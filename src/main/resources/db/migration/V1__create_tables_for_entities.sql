CREATE TABLE tb_alunos(
    aluno_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    role SMALLINT NULL,
    periodo INTEGER NOT NULL
);

CREATE TABLE tb_notas_alunos (
    aluno_id UUID NOT NULL,
    nota FLOAT4 NULL,
    CONSTRAINT fk_notas_aluno FOREIGN KEY (aluno_id) REFERENCES tb_alunos(aluno_id) ON DELETE CASCADE
);

CREATE TABLE tb_professores (
    professor_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    role SMALLINT NULL,
    idade INTEGER NOT NULL
);

CREATE TABLE alunos_professores (
    professor_id UUID NOT NULL,
    aluno_id UUID NOT NULL,
    PRIMARY KEY (professor_id, aluno_id),
    CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES tb_professores(professor_id),
    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES tb_alunos(aluno_id)
);

CREATE TABLE tb_administradores (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role SMALLINT NULL,
    password VARCHAR(255) NOT NULL
);