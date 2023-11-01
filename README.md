# Api-para-dataloggers

#README em construção.

Como rodar esse repositório
---
-Instale o Docker e rode o comando `docker run --name postgres_container -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 -v postgres_data:/var/lib/postgresql/data postgres` . Ele é necessário para criar o container do banco de dados PostgreSQL.
-Instale o Java sdk 17 e o Gradle;
-No terminal, dentro do caminho do repositório, execute o comando `.\gradlew bootrun`.

  O que foi feito até agora:
  ---
  -Foi feito o crud do microcontrolador. o Crud de dados ainda não foi testado.
