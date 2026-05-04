# Movies Service API 🎬

API REST desenvolvida com Spring Boot para gerenciamento de filmes e atores.

---

### 1. Subir o banco de dados com Docker

Execute o comando abaixo para iniciar o MySQL:

```bash
docker run -d \
  --name mysql-api \
  -e MYSQL_ROOT_PASSWORD=root_pwd \
  -e MYSQL_DATABASE=api \
  -p 3306:3306 \
  mysql:8.0 \
  --default-authentication-plugin=mysql_native_password
```

---

### 2. Rodar a aplicação

Via Maven:

```bash
./mvnw spring-boot:run
```

---

### 5. Acessar a documentação (Swagger)

Após subir a aplicação:

👉 http://localhost:8080/

O Swagger estará disponível na raiz do projeto e exibirá todas as rotas da API.

---
