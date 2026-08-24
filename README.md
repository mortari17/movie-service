# Movies Service API 🎬

API REST desenvolvida com Spring Boot para gerenciamento de filmes e atores, com persistência em MySQL, documentação Swagger/OpenAPI, configuração por profiles (`default` e `prd`) e empacotamento via Docker.

---

## Profiles

| Profile | Uso | Comportamento do banco |
|---|---|---|
| `default` | Desenvolvimento local | Cria o banco/tabelas automaticamente (`ddl-auto=update`) |
| `prd` | Produção | **Não** cria banco nem tabelas automaticamente (`ddl-auto=none`) |

O profile é selecionado pela variável de ambiente `SPRING_PROFILES_ACTIVE`.

---

## Variáveis de ambiente

| Variável | Obrigatória em `prd` | Padrão (`default`) | Descrição |
|---|---|---|---|
| `SPRING_PROFILES_ACTIVE` | não | `default` | Profile ativo (`default` ou `prd`) |
| `DB_HOST` | sim | `localhost` | Host do MySQL |
| `DB_PORT` | não | `3306` | Porta do MySQL |
| `DB_NAME` | sim | `api` | Nome do banco de dados |
| `DB_USER` | sim | `root` | Usuário do banco |
| `DB_PASSWORD` | sim | `root_pwd` | Senha do banco |

No profile `prd`, o banco e as tabelas devem já existir previamente (a aplicação não cria nada automaticamente).

---

## Executando via imagem publicada no Docker Hub

### 1. Baixar a imagem

```bash
docker pull mortari17/movie-service:latest
```

### 2. Subir um banco MySQL (se ainda não tiver um)

```bash
docker run -d \
  --name mysql-api \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_DATABASE=api \
  -p 3306:3306 \
  mysql:8.0
```

### 3. Rodar a aplicação (profile `default`, cria as tabelas automaticamente)

```bash
docker run -d \
  --name movie-service \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=default \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=3306 \
  -e DB_NAME=api \
  -e DB_USER=root \
  -e DB_PASSWORD=root_pwd \
  mortari17/movie-service:latest
```

### 4. Rodar a aplicação (profile `prd`, banco/tabelas já devem existir)

```bash
docker run -d \
  --name movie-service-prd \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prd \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=3306 \
  -e DB_NAME=api \
  -e DB_USER=root \
  -e DB_PASSWORD=root_pwd \
  mortari17/movie-service:latest
```

> `host.docker.internal` aponta para o host da máquina a partir do container. Se o MySQL rodar em outro container, use `--network` compartilhada e o nome do container (`mysql-api`) como `DB_HOST`.

---

## Acessando o Swagger/OpenAPI

Com a aplicação em execução, acesse:

👉 http://localhost:8080/

A documentação Swagger é exibida na raiz do projeto, com todas as rotas da API de filmes e atores.

---

## Build local da imagem (opcional)

```bash
docker build -t movie-service:local .
```

---

## Rodando o projeto localmente sem Docker

### 1. Subir o banco de dados

```bash
docker run -d \
  --name mysql-api \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_DATABASE=api \
  -p 3306:3306 \
  mysql:8.0
```

### 2. Rodar a aplicação via Maven

```bash
./mvnw spring-boot:run
```
