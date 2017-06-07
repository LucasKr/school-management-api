# Academic Management

A RESTful API to manage a college application.

# What do I use

- Spring Boot
- Spring Data JPA

# DataBase configuration

You'll need to have an user in your database called `springuser` and set his password as `123`. After having this user you need to guarantee all previleges to change the database.

Now, just create the database `academic_management`, then you'll be able to build and run the project.

# First release

It should only respond to HTTP requests through tools like `curl` or [Postman](https://www.getpostman.com/).

# Casos de uso

CRUD:
- Descrição: Persiste dados no banco de dados.
- Cenário principal:
-- O ator envia informações correspondente ao model do dominio salvando no banco de dados.
-- O ator através de um identificador consegue alterar a informação.
-- O ator através de um identificador consegue deletar a informação.
-- O ator consegue obter os dados.
- Pós condição: Ter a informação da tabela manipulada.

1) Manter alunos: semelhante a CRUD.
* Descrição: Persistência das informações de alunos.
* Ator: Coordenador
2) Manter disciplinas: semelhante a CRUD.
* Descrição: Persistencia das informações de disciplina.
* Ator: Coordenador
3) Manter turmas: semelhante a CRUD.
* Descrição: Persistencia das informações de Turmas.
* Ator: Coordenador
4) Mater professores: semelhante a CRUD.
* Descrição: Persistencia das informações de professores;
* Ator: Coordenador.
5) Realizar matricula: Possibilita uma matricula no sistema.
* Descrição: Realiza uma matricula em uma Disciplina para um determinado Aluno.
* Ator: Aluno.
* Pré condição: Aluno estar identificado no sistema.
* Cenário principal:
-- O aluno informa a disciplina que está se matriculando.
-- O aluno informa o semestre que está atualmente.
-- Junto das informações de identificação do aluno serão enviadas informações de turma.
6) Consultar histórico disciplinas
* Descrição: Obtem o historico de disciplinas matriculadas para o aluno.
* Ator: Aluno
* Cenário principal:
-- Através de uma identifiação do aluno, é possível consultar informações de todas as matriculas já registradas para o aluno.
7) Solicitar trancamento da disciplina:
* Descrição: Possibilitar trancar a disciplina.
* Ator: Aluno
* Cenário principal:
-- Envia a informação da matricula, com a flag de trancada igual a verdadeiro.
8) Mater prova

# Later

It should have a client-side application built in a JS Framework (either Angular.js or React.js and its libraries)

# Contributors

- [Matheus Eduardo](https://github.com/eduardosmatheus)
- [Lucas Kruger](https://github.com/LucasKr)
