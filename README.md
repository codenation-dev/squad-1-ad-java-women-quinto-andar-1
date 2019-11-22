# QUINTO-LOG
Neste projeto vamos implementar um sistema para centralizar registros de erros de aplicações.

A aplicação integrada com o front pode ser vista em: https://quinto-log.herokuapp.com.

As Apis podem ser testadas em: https://quinto-log-back.herokuapp.com/swagger-ui.html.

Documentação completa em: https://github.com/codenation-dev/squad-1-ad-java-women-quinto-andar-1/wiki

## BUILD DO PROJETO
Execute a linha de comando maven:

`sh`

`mvn clean package`

## ARQUITETURA

Um esquema da arquitetura com o front, as requisições realizadas e as APIs existentes pode ser visto abaixo:
![](https://i.pinimg.com/originals/9d/43/cd/9d43cd75c1585c05013f5d1b9ec56948.png)


## Coverage
Execute a linha de comando maven:

`sh`

`mvn clean verify`

### A cobertura atual é 43%


## Teste Unitário
Execute a linha de comando maven:

`sh`

`mvn test`


## Swagger
- http://localhost:8080/v1/swagger-ui.html

Contexto: Quinto-Log

## RODAR A APLICAÇÃO
Execute a linha de comando maven:

`sh`

`mvn spring-boot:run`
