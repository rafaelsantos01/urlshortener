# URL Shortener

Este projeto é um encurtador de URLs simples, desenvolvido com Spring Boot e MongoDB.

Ele expõe dois endpoints principais: um para encurtar URLs e outro para redirecionar URLs encurtadas.

## Como rodar o projeto

1. Clonar o repositório

git clone https://github.com/rafaelsantos01/urlshortener 


2. Subir o MongoDB com Docker Compose

docker-compose up -d

3. Rodar a aplicação Spring Boot

Execute o projeto usando sua IDE ou via terminal.

## Endpoints

### 1. Criar URL encurtada

POST /api/v1/shortener-url

Request Body:

{
"url": "https://exemplo.com/minha-pagina"
}

Response:

{
"url": "http://localhost:8080/abc123"
}

### 2. Redirecionar para a URL original

GET /{id}

Exemplo:

GET http://localhost:8080/abc123

Redireciona automaticamente (HTTP 302 Found) para a URL original.

## Tecnologias utilizadas

- Java 21+
- Spring Boot
- MongoDB
- Docker / Docker Compose
- Lombok


## Notas

- O ID gerado é aleatório, com comprimento entre 5 e 10 caracteres.
- O projeto utiliza validações (@Valid) para garantir a integridade dos dados.
- As URLs são armazenadas no MongoDB.
