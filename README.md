# 🌍 ORBIS — Conectando Solidariedade em Tempos de Emergência

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Spring](https://img.shields.io/badge/SpringBoot-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600.svg?style=for-the-badge&logo=rabbitmq&logoColor=white)

## ✨ Sobre

A ORBIS é uma aplicação desenvolvida com foco em situações de emergência, como enchentes, deslizamentos e falhas de infraestrutura. O sistema permite que pessoas em risco façam pedidos de ajuda geolocalizados, conectando-as a doadores, voluntários e ONGs da região. Leve, resiliente e com suporte a mensagens assíncronas via RabbitMQ, a ORBIS é ideal para operar mesmo em locais com conectividade limitada.

A plataforma é composta por duas aplicações Spring Boot independentes: uma produtora e outra consumidora de mensagens, integradas via mensageria para garantir agilidade no fluxo de informações. Além disso, a API oferece suporte a bancos de dados Oracle (relacional) e MongoDB (não relacional), internacionalização e dashboard com Spring Boot Actuator.

### Vídeo Pitch
[Clique aqui](https://www.youtube.com/watch?v=A1gLzrINBCg&feature=youtu.be) para conhecer melhor sobre o Orbis.

---

## 👩‍💻 Desenvolvedores

- [Juliana Mo.](https://github.com/julianamo93) - Solutions Data Architect & Cloud - RM554113
- [Sabrina Couto](https://github.com/sabrinacouto) - Backend Developer & QA - RM552728
- [Kevin Nobre](https://github.com/KevinNobre) - FullStack Developer - RM552590

---

## Arquitetura Pipeline YAML - Azure
![image](https://github.com/user-attachments/assets/01c18aae-de47-491f-933a-a9a6642ba59f)


## Pipeline YAML CI/CD Azure

Pipeline YAML CI/CD criado com Azure DevOps; Foi criada uma infraestrutura, build e deploy da aplicação java com .JAR, 
além da criação de um banco de dados Azure SQL Database para inserção e persistência de dados na nuvem, validados via Postman.

### Etapas do Pipeline
🔁 Trigger
Acionada automaticamente em pushs para a branch main.

🛠️ 1. Criar Infraestrutura (Stage: criarInfra)
Azure CLI é utilizado para:
- Criar o Resource Group.
- Criar o App Service Plan Linux (F1 – gratuito).
- Criar o Web App com runtime Java 17.

🔨 2. Build da Aplicação (Stage: BuildApp)
- Compila o projeto usando o Gradle.
- Lista arquivos para verificação.
Copia o .jar gerado e publica como artefato.

🚀 3. Deploy da Aplicação (Stage: deployApp)
- Faz o download do artefato publicado.
- Lista os arquivos para conferência.
Usa o AzureRmWebAppDeployment para fazer deploy no Azure Web App.

---

## 💾 Rodando o Projeto Localmente

### Clonar o repositório

```bash
https://github.com/sabrinacouto/OrbisApplication.git
```

## 🌐 Endpoints da API

### 📍 Usuário

| Método  | Endpoint                  | Descrição                       |
|---------|---------------------------|----------------------------------|
| GET     | `/usuario`                | Lista todos os usuários         |
| POST    | `/usuario/cadastro`       | Cadastra novo usuário           |
| GET     | `/usuario/editar/{id}`    | Formulário de edição            |
| PATCH   | `/usuario/editar/{id}`    | Atualiza dados do usuário       |
| DELETE  | `/usuario/deletar/{id}`   | Remove usuário                  |


## 📬 Mensageria com RabbitMQ

O ORBIS utiliza RabbitMQ para comunicação assíncrona entre serviços, garantindo escalabilidade e desacoplamento. A aplicação produtora envia mensagens para uma fila específica, e a aplicação consumidora escuta e processa essas mensagens.

### 🔧 Configuração no `application.properties` (rodando localmente)

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

orbis.broker.queue.usuario=usuarioQueue
orbis.broker.exchange.usuario=usuarioExchange
orbis.broker.routingkey.usuario.created=usuario.created.routingkey
```

ou acesse o link https://fly.rmq.cloudamqp.com/#/

### Link YouTube

[Global Solution Protech the Future - DevOps Tools & Cloud Computing - 2TDSZ-2025](https://youtu.be/YC0S45zxolo)

