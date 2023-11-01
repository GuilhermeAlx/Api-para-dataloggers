# Api-para-dataloggers


Como rodar esse repositório
---
-Instale o Docker e rode o comando `docker run --name postgres_container -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 -v postgres_data:/var/lib/postgresql/data postgres`.
-Tenha o java sdk 17;
- No terminal com o caminho do repositório execute o comando `.\gradlew bootrun`.
