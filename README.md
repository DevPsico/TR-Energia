# Ericson TR Energia

Este projeto é um backend desenvolvido em Java utilizando o Spring Boot. 
O objetivo principal é fornecer uma API para gerenciar informações relacionadas à TR Energia.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **JPA/Hibernate**
- **H2 Database (para desenvolvimento)**
- **MySQL (para produção)**
- **Lombok**
- **SpringDoc OpenAPI (para documentação da API)**

## Dependências

As principais dependências do projeto incluem:

- `spring-boot-starter-data-jpa`: Para integração com JPA e Hibernate.
- `spring-boot-starter-web`: Para criação de APIs REST.
- `spring-boot-starter-validation`: Para validação de dados.
- `spring-boot-devtools`: Para recarregamento automático durante o desenvolvimento.
- `h2`: Banco de dados em memória para desenvolvimento.
- `mysql-connector-j`: Conector MySQL para acesso ao banco de dados.
- `spring-boot-starter-test`: Ferramentas de teste.
- `lombok`: Para reduzir o boilerplate de código.
- `springdoc-openapi-ui`: Para gerar documentação OpenAPI.

## Configuração

### Banco de Dados

O projeto utiliza H2 em memória para desenvolvimento e MySQL para produção. Abaixo estão as configurações para cada perfil:

- **Desenvolvimento (H2)**:
  ```properties
  spring.datasource.url=jdbc:h2:~/testtrenergia
  spring.datasource.username=sa
  spring.datasource.password=
  spring.h2.console.enabled=true


- **Produção (MySQL)**:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/trenergia?createDatabaseIfNotExist=true
  spring.datasource.username=root
  spring.datasource.password=
  spring.jpa.hibernate.ddl-auto=create-drop
