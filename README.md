## 📚 Gerenciador de Alunos

API REST desenvolvida com Spring Boot para gerenciamento de alunos.

Permite realizar operações de:

- ✅ Criar aluno
- ✅ Listar todos os alunos
- ✅ Buscar aluno por ID
- ✅ Atualizar aluno
- ✅ Deletar aluno

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Jakarta Persistence (JPA)
- Lombok
- Banco de Dados (MySQL)

- ## 📌 Endpoints da API

### 🔹 Listar todos os alunos
```http
GET /api/leraluno

GET /api/leralunoporid/{id}

GET /api/leralunoporid/1

POST /api/salvaraluno

{
  "nome": "Matheus",
  "periodo": 5,
  "notaFinal": 8.5
}

PUT /api/atualizaraluno/{id}

{
  "nome": "Matheus Atualizado",
  "periodo": 6,
  "notaFinal": 9.0
}

DELETE /api/deletealuno/{id}

```
## 🧠 Regras de Negócio

-O ID é gerado automaticamente.

-Caso o aluno não exista, o sistema lança exceção.

-Atualizações são feitas apenas se o ID existir.

▶️ Como Executar o Projeto

-Clone o repositório:

```http

git clone https://github.com/seuusuario/seurepositorio.git

```
-Abra no IntelliJ ou VS Code

-Configure o banco de dados no application.properties

-Execute a classe principal do Spring Boot

👨‍💻 Autor

Matheus Cristopher

Projeto desenvolvido para fins de estudo e evolução como Desenvolvedor Backend Java.

