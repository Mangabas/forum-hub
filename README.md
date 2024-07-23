# Forum-Hub API
![Static Badge](https://img.shields.io/badge/Spring-Green)
![Static Badge](https://img.shields.io/github/license/Mangabas/forum-hub.svg)


* [Sobre](#Sobre)
* [Funcionalidades](#Funcionalidades)
* [Pré-requisitos](#Pré-requisitos)
* [Acessando a Documentação da API](Acessando-a-Documentação-da-API)
* [Tecnologias](#Tecnologias)
* [Badge](#Badge)
  
    
  
## Sobre
Esse projeto é um desafio da Alura juntamente da Oracle Next Education, seu objetivo é desenvolver o back end de uma aplicação web com
API Rest que seja responsável por manejar posts de um fórum, utilizando recursos de CRUD e autenticação Stateless.

## Funcionalidades
- Login: Para receber o bearer token, que será necessário enviar nas outras requisições, o usuario tem que fazer a autenticação por meio da url `/login` utilizando a requisição POST
  . por padrão o usuario cadastrado no banco
  de dados é:  
  {  
  "login":"test.login@forumhub.com",  
  "password": "123"
  }  
  Detalhe: A senha cadastrada pelo usuário será criptografada utilizando a tecnologia BCrypt.

- Novo tópico: Dentro da url `/topics` com o método POST, será necessário enviar um Json contendo três Strings: title, message e group. Caso apareça o código de status 201 (Created), será retornado outro Json contendo: id, title, message, group, date, status e authorId.

- Listar tópicos: Dentro da url `/topics` dessa vez com o método GET, será retornado um page com o tamanho de 10 tópicos.

- Tópico específico: Dentro da url `/topics/{id}` também com GET, você poderá escolhar o id de algum tópico específico para pesquisar.

- Editar tópico: Dentro da url `/topics/{id}` com o método PUT, será necessário enviar um Json contendo três Strings: title, message e group. Caso apareça o código de status 200 o post será editado e vai ser retornado outro Json contendo: id, title, message, group, date, status e authorId.  
Detalhe: O usurário tem que ter criado o post para edita-lo.

- Excluir tópico: Dentro da url `/topics/{id}` com o método DELETE, o usuário deixará o código com o status: false.  
Detalhe: O usurário tem que ter criado o post para desativa-lo.

- Ativar tópico: Dentro da url `/topics/active/{id}` com o método PUT, o usuário deixará o código com o status: true.  
Detalhe: O usurário tem que ter criado o post para ativa-lo.

## Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado para construção do projeto.
- Variáveis de ambiente `DB_HOST`, `DB_NAME`, `DB_USER`, `DB_PASSWORD` e `JWT_SECRET`.
- Configure um banco de dados `PostgreSQL` com o nome e credenciais especificadas em application.properties.

## Acessando a Documentação da API
- Após iniciar o projeto, acesse http://localhost:8080/swagger-ui.html para visualizar a documentação interativa da API gerada pelo Swagger.

## Tecnologias
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Spring Validation**
- **Flyway**
- **PostgreSQL**
- **Swagger**
- **Java JWT (Auth0)**

## Badge
Este é um badge conquistado por ter desenvolvido este projeto com a Alura no programa ONE - "Oracle Next Education" em parceria com a Oracle:  
![Badge-Spring](https://github.com/user-attachments/assets/e91c17d2-e3c8-49f3-94d7-d130fbef63e2)


