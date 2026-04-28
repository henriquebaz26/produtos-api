# Produtos API

API REST para gerenciamento de produtos, desenvolvida com Java e Spring Boot.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker

## Como rodar

**1. Suba o banco de dados:**

```bash
docker-compose up -d
```

**2. Suba o servidor:**

```bash
.\mvnw.cmd spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | /produtos | Lista todos os produtos |
| POST | /produtos | Cria um novo produto |
| PUT | /produtos/{id} | Atualiza um produto |
| DELETE | /produtos/{id} | Deleta um produto |

## Exemplo de requisição

```json
{
    "nome": "Teclado Mecânico",
    "preco": 299.90,
    "quantidade": 10
}
```