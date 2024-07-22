# Forum-Hub
![Static Badge](https://img.shields.io/badge/Spring-Green)
![Static Badge](https://img.shields.io/github/license/Mangabas/forum-hub.svg)


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

- Novo tópico: Dentro da url `/topics` com o método POST, será necessário enviar um Json contendo três Strings: title, message e group. Caso apareça
  o código de status 201 (Created), será retornado outro Json contendo: id, title, message, group, date, status e authorId.

- Listar tópicos: Dentro da url `/topics` dessa vez com o método GET, será retornado um page com o tamanho de 10 tópicos.

- Tópico específico: Dentro da url `/topics/{id}` também com GET, você poderá escolhar o id de algum tópico específico para pesquisar.

- Editar tópico

## Tecnologias
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Spring Validation**
- **Flyway**
- **PostgreSQL**
- **Swagger**
- **Java JWT (Auth0)**