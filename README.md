# 🧩 Microserviços em Java (Spring Boot + Maven)

![Feito com Java](https://img.shields.io/badge/Feito%20com-Java-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Microservi%C3%A7os-green?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-important?style=for-the-badge&logo=apachemaven)


## 📖 Descrição

Este projeto é um **sistema de microserviços** desenvolvido em **Java 21** utilizando **Spring Boot**, with gerenciamento de dependências via **Maven**. O sistema inclui um servidor de descoberta de serviços (Eureka), um gateway API, um serviço de catálogo de produtos e um serviço de pedidos, todos integrados com autenticação Basic Auth.

O projeto foi desenvolvido para atender ao desafio da NTTDATA promovido pela DIO, demonstrando a implementação de um ecossistema de microserviços com roteamento, integração e segurança.

## 🎯 Funcionalidades

- ✅ Registro e descoberta de serviços via Eureka Server
- ✅ API Gateway com roteamento para `/api/products` e `/api/orders`
- ✅ Catálogo de produtos com persistência no MySQL (CRUD básico)
- ✅ Gerenciamento de pedidos em memória (sem persistência)
- ✅ Integração entre serviços usando OpenFeign
- ✅ Autenticação com Basic Auth (admin/1234)
- ✅ Deploy local com múltiplos serviços

## 📂 Estrutura do Projeto

```
.
├── pom.xml
├── eureka-server/
│   └── src/main/java/com/nttdata/microservices/eureka_server/
├── api-gateway/
│   └── src/main/java/com/nttdata/microservices/gateway/
├── catalog-service/
│   └── src/main/java/com/nttdata/microservices/catalog/
├── order-service/
│   └── src/main/java/com/nttdata/microservices/order/
└── target/
```

## 🚀 Como Executar

### 🖥️ Via IDE

- Abra cada módulo (`eureka-server`, `api-gateway`, `catalog-service`, `order-service`) em sua IDE.
- Execute cada aplicação Spring Boot na ordem:
  1. **EurekaServerApplication** (porta 8761)
  2. **CatalogServiceApplication** (porta 8100)
  3. **OrderServiceApplication** (porta 8200)
  4. **ApiGatewayApplication** (porta 8700)

### 🖥️ Via Terminal

```bash
cd microservices-challenge
mvn clean install

# Terminal 1
cd eureka-server && mvn spring-boot:run

# Terminal 2
cd ../catalog-service && mvn spring-boot:run

# Terminal 3
cd ../order-service && mvn spring-boot:run

# Terminal 4
cd ../api-gateway && mvn spring-boot:run
```

## 📦 Pré-requisitos

- **Java 21** ou superior instalado
- **Maven** instalado e configurado no PATH
- **MySQL** rodando com banco `catalogo_db` e usuário/senha `root/root`

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Cloud 2023.0.3**
- **Maven 3.9.6**
- **OpenFeign**
- **MySQL** (somente para catalog-service)
- **Eureka Server**

## 📖 Explicação das Principais Classes e Pacotes

### **Módulos**

- **eureka-server** → Servidor de descoberta de serviços
- **api-gateway** → Gateway com roteamento e segurança
- **catalog-service** → Gerencia produtos com persistência
- **order-service** → Gerencia pedidos em memória com integração via Feign

### **Classes Principais**

- **EurekaServerApplication** → Inicializa o servidor Eureka
- **ApiGatewayApplication** → Configura o gateway com Spring Cloud Gateway MVC
- **CatalogController** → Endpoint `/api/products` (CRUD)
- **OrderController** → Endpoint `/api/pedidos` (CRUD em memória)
- **CatalogClient** → Integração Feign com catalog-service

## 🧪 Exemplo de Uso

### Novo Produto em JSON

Para adicionar um novo produto via API:

```json
{
  "id": 2,
  "name": "Smartphone X",
  "price": 799.99
}
```

### Endpoints Disponíveis

- **Eureka Dashboard**: `http://localhost:8761`
- **API Gateway**: `http://localhost:8700`
- **Produtos**: `http://localhost:8700/api/products`
- **Pedidos**: `http://localhost:8700/api/pedidos`

### Vídeo
https://youtu.be/6it0xRXMgws

### Autenticação
Utilize as credenciais:
- **Usuário**: `admin`
- **Senha**: `1234`

## 📌 Dicas para Melhorar ou Expandir

- 🗄️ Adicionar persistência ao order-service com MySQL
- 🔒 Expandir segurança com JWT tokens
- 🧪 Adicionar testes unitários com JUnit
- 🐳 Containerização com Docker
- ☁️ Deploy em ambiente de nuvem

## 📄 Licença

Este projeto está sob a licença MIT.

## 👩‍💻 Autor(a)

<a href="https://github.com/Caroline-Teixeira">Caroline 💙</a>

---

📌 *Projeto desenvolvido para o desafio da DIO (Digital Innovation One).*
