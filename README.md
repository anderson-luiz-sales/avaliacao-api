# Avaliacão Api
API responsável por gerenciar crud de cursos.

### Pré-requisitos 
O que você precisa instalar para rodar o projeto? 
* [Gradle](https://https://gradle.org//) 
* [JDK-8](https://www.oracle.com/technetwork/pt/java/javase/downloadsjdk8-downloads-2133151.html) 
* [JRE-8](https://www.oracle.com/technetwork/pt/java/javase/downloadsjre8-downloads-2133155.html) 

### Instalação 
```
github.com/anderson-luiz-sales/avaliacao-api.git
```
### Como rodar a API 
```
./gradlew bootRun 
```
## Como rodar a API em dev 
 ```
* sh docker-compose-dev.sh 
 ```
### Como rodar os teste? 
```
./gradlew clean test 
```
### Para validar se foi instalado corretamente: 
```
http://localhost:8080/healthcheck 
```
### Para acessar a documentação do Swagger: 
```
http://localhost:8080/swagger-ui.html#/ 
```
## Tecnologias utilizadas 
* [Gradle](https://gradle.org/) - Gerenciamento de Dependência 
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) - Starter para construção de web, incluindo aplicativos RESTful, usando o Spring MVC. Usa o Tomcat como o contêiner incorporado padrão 
* [Swagger](https://https://swagger.io/) - Simplifique o desenvolvimento de API para usuários, equipes e empresas com o software livre Swagger e o conjunto de ferramentas profissionais. Descubra como o Swagger pode ajudá-lo a projetar e documentar suas APIs em escala.
* [Lombok](https://projectlombok.org/) - O Projeto Lombok é uma biblioteca java que se conecta automaticamente ao seu editor e cria ferramentas, apimentando seu java. Nunca escreva outro método getter ou equals novamente, com uma anotação sua classe tem um construtor com todos os recursos, Automatize suas variáveis de registro e muito mais. 
* [Spring Boot Test Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test) - Starter para testar aplicativos Spring Boot com bibliotecas, incluindo JUnit, Hamcrest e Mockito. 
* [Spring Boot Actuator Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator) - Iniciador para usar o Atuador do Spring Boot, que fornece recursos prontos para produção para ajudá-lo a monitorar e gerenciar seu aplicativo. 
* [MongoDB](https://https://www.mongodb.com//) - O MongoDB é um banco de dados distribuído, baseado em documentos e de propósito geral, criado para desenvolvedores de aplicativos modernos e para a era da nuvem.

## Scripts de Inserts:

Primeiro Scripts na coleção course
```
{
  "category": [
    {
      "description": "Comportamental",
      "id": "1"
    },
    {
      "description": "Qualidade",
      "id": "2"
    }
  ],
  "endDate": "2020-09-19",
  "id": "1",
  "startDate": "2020-09-16",
  "studentQuantity": 4,
  "subjectDescription": "Curso de relação comportamental e qualidade"
}
```

Segundo Scripts na coleção course
```
{
  "category": [
    {
      "description": "Processos",
      "id": "4"
    }
  ],
  "endDate": "2020-09-20",
  "id": "2",
  "startDate": "2020-09-19",
  "studentQuantity": 40,
  "subjectDescription": "Curso de processos"
}
```

Terceiro Scripts na coleção course
 ```
{
  "category": [
    {
      "description": "Programação",
      "id": "2"
    }
  ],
  "endDate": "2020-10-15",
  "id": "3",
  "startDate": "2020-09-20",
  "studentQuantity": 60,
  "subjectDescription": "Curso de lógica de programção"
}
 ```
