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
![Use case Aluno](/path/to/img.jpg)
![Use case Professor](/path/to/img.jpg)
![Use case Coordenador](/path/to/img.jpg)

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
1. O aluno informa a disciplina que está se matriculando.
2. O aluno informa o semestre que está atualmente.
3. Junto das informações de identificação do aluno serão enviadas informações de turma.
* Pós condição: Associa o aluno a uma disciplina.

6) Consultar histórico disciplinas
* Descrição: Obtem o historico de disciplinas matriculadas para o aluno.
* Ator: Aluno
* Cenário principal:
1. Através de uma identifiação do aluno, é possível consultar informações de todas as matriculas já registradas para o aluno.
* Pós condição: Consulta todas as matriculas registradas para o aluno.

7) Solicitar trancamento da disciplina:
* Descrição: Possibilitar trancar a disciplina.
* Ator: Aluno
* Cenário principal:
1. Envia a informação da matricula, com a flag de trancada igual a verdadeiro.
* Pós condição: Tranca a matricula para a disciplina

8) Agendar trabalhos
* Descrição: Agenda trabalhos
* Ator: Professor
* Cenário principal:
1. Professor informa a descrição do trabalho
2. Informa a data de entrega
3. Indica como não obrigatorio
* Pós condição: Agenda o trabalho

9) Agendar provas
* Descrição: Agenda prova
* Ator: Professor
* Cenário principal:
1. Professor informa a descrição do trabalho
2. Informa data para o trabalho
3. Indica como obrigatorio
* Pós condição: Agenda o trabalho como sendo obrigatorio

10) Cadastrar notas: Semelhante a crud.
* Descrição: Salva uma nota para um trabalho
* Ator: Professor
* Cenário principal:
1. Identifica o trabalho
2. Envia informações do trabalho com a nova nota
* Pós condição: Nota é alterada

11) Manter presenças
* Descrição: Da presença ou falta para um aluno
* Ator: Professor
* Cenário principal:
1. Identifica o aluno
2. Identifica a disciplina
3. Informa a data
4. Indica como presente
* Cenário secundário:
4. Indica como não presente.
* Pós condição: Marca presença para o aluno.

# Later

It should have a client-side application built in a JS Framework (either Angular.js or React.js and its libraries)

# Contributors

- [Matheus Eduardo](https://github.com/eduardosmatheus)
- [Lucas Kruger](https://github.com/LucasKr)
