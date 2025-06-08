# Prefeito do Caos - API REST Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-4695EB?style=for-the-badge&logo=quarkus&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![FIAP](https://img.shields.io/badge/FIAP-ED145B?style=for-the-badge)

API REST desenvolvida em Java com Quarkus como parte do projeto **Prefeito do Caos**, permitindo a criação de sessões de jogo, manipulação de usuários, cenários, cartas e medalhas.

A aplicação é **segura**, com autenticação baseada em **JWT**, e fornece uma estrutura robusta para a progressão do jogo e gerenciamento de pontuação, sessões e conquistas.

---

## 💡 Sobre o Projeto

O **Prefeito do Caos** é um jogo narrativo de tomada de decisões, no qual o jogador assume o papel de um prefeito diante de uma grande crise que ameaça sua cidade — como uma enchente, uma tempestade ou outro desastre de grandes proporções.

O jogo é dividido em duas partes: primeiro, o jogador passa por uma fase de preparação, em que precisa escolher quais medidas tomar para se antecipar aos problemas. Ele pode, por exemplo, investir em treinamentos, comprar equipamentos ou reforçar estruturas. Essas decisões vão influenciar diretamente os recursos disponíveis no momento da crise.

Na segunda fase, o desastre acontece. A cada rodada, novos problemas surgem, e o jogador precisa decidir como agir com base nos recursos que conseguiu reunir anteriormente. Cada escolha tem impacto direto na quantidade de vidas salvas, no controle da crise e na confiança da população.

O principal objetivo do projeto é **demonstrar a importância de uma gestão pública eficaz**, especialmente em contextos de emergência. O jogador experimenta, na prática, como decisões mal planejadas podem agravar uma crise, enquanto boas estratégias podem salvar vidas e preservar a ordem.

A proposta é provocar reflexão sobre responsabilidade, prioridades e planejamento, por meio de uma experiência interativa e envolvente.

Este projeto foi desenvolvido como parte da **Global Solution** da FIAP, com o objetivo de combinar lógica de programação, pensamento estratégico e temas sociais relevantes como gestão pública e enfrentamento de emergências.

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Quarkus 3.22.3
- Oracle Database (via JDBC)
- JWT (Java Web Token) com SmallRye
- JAX-RS (Jakarta REST)
- Jackson (serialização JSON)
- BCrypt (hash de senhas)
- dotenv-java (configuração via `.env` no ambiente de desenvolvimento)

---

## 🚀 Como Rodar

### Pré-requisitos

- Java 17+
- Maven 3.8+
- Variáveis de ambiente `.env` (ver `.env.example`)

### Clonar o projeto

```bash
git clone https://github.com/prefeito-do-caos/java.git
cd java
```

### Configurar variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes informações para conectar ao banco de dados:

```
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
DB_URL=jdbc:oracle:thin:@host:porta/sid
JWT_ISSUER=http://localhost:8080
```

As chaves utilizadas para assinatura e validação dos tokens JWT (arquivos `.pem`) devem ser armazenadas na pasta `resources/` com os seguintes nomes:

- `private_key.pem` – chave privada para assinar os tokens
- `public_key.pem` – chave pública para validar os tokens

> ⚠️ Certifique-se de que esses arquivos estejam corretamente formatados no padrão PEM e incluídos no pacote ao fazer o build do projeto.

### 🔐 Gerar arquivos `.pem` para JWT

Para que o sistema funcione corretamente com autenticação JWT, você precisa gerar um par de chaves (privada e pública) no formato PEM.

Execute os comandos abaixo no terminal a partir da raiz do projeto:

```bash
# Gerar chave privada (RSA 2048 bits)
openssl genpkey -algorithm RSA -out ./src/main/resources/private_key.pem -pkeyopt rsa_keygen_bits:2048

# Gerar chave pública a partir da privada
openssl rsa -pubout -in ./src/main/resources/private_key.pem -out ./src/main/resources/public_key.pem
```

### 📌 Resultado esperado

Você terá dois arquivos criados na pasta `src/main/resources/`:

- `private_key.pem` — utilizada para assinar os tokens JWT
- `public_key.pem` — utilizada para validar os tokens JWT

Esses arquivos devem conter chaves válidas no formato PEM, como nos exemplos:

```text
-----BEGIN PRIVATE KEY-----
MIIEvQIBADANBgkq...
-----END PRIVATE KEY-----
```

```text
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG...
-----END PUBLIC KEY-----
```

### Executar localmente

```bash
./mvnw quarkus:dev
```

Acesse: `http://localhost:8080`

---

## 📍 Endpoints da API

| Método | Rota                           | Descrição                                                 |
| ------ | ------------------------------ | --------------------------------------------------------- |
| GET    | `/scenarios`                   | Lista todos os cenários                                   |
| GET    | `/scenarios/{id}`              | Detalhes de um cenário específico                         |
| GET    | `/leaderboard/{scenario_id}`   | Ranking de jogadores por cenário                          |
| POST   | `/auth/token`                  | Gera token JWT a partir de login                          |
| POST   | `/auth/refresh`                | Atualiza o token JWT                                      |
| POST   | `/users`                       | Cria novo usuário                                         |
| GET    | `/users`                       | Lista usuários                                            |
| GET    | `/users/me`                    | Retorna dados do usuário logado                           |
| PUT    | `/users/me`                    | Atualiza dados do próprio usuário                         |
| PUT    | `/users/me/password`           | Altera senha do próprio usuário                           |
| GET    | `/medals`                      | Lista todas as medalhas disponíveis                       |
| GET    | `/medals/{id}`                 | Detalha uma medalha específica                            |
| GET    | `/medals/me`                   | Lista medalhas obtidas pelo usuário                       |
| POST   | `/game-sessions`               | Cria uma nova sessão de jogo                              |
| GET    | `/game-sessions/{code}`        | Detalha uma sessão a partir do código                     |
| GET    | `/game-sessions/{code}/next`   | Retorna a próxima carta da sessão                         |
| GET    | `/game-sessions/me`            | Lista sessões do usuário autenticado                      |
| POST   | `/game-sessions/{code}/play`   | Registra a escolha do jogador na carta atual _(em breve)_ |
| GET    | `/game-sessions/{code}/report` | Gera o relatório final da sessão _(em breve)_             |

---

## ✅ Funcionalidades

- Autenticação JWT
- CRUD completo de usuários
- Criação e gerenciamento de sessões de jogo
- Histórico e progresso baseado em código único
- Sistema de medalhas por desempenho
- Proteção de rotas com `Authenticated`
- Validação e tratamento de exceções com `ExceptionMapper`

---

## 🧪 Usuários de Teste

O sistema conta com alguns usuários de teste pré-cadastrados, utilizados para simular sessões, partidas e atribuição de medalhas.

> As senhas foram definidas de forma simples para facilitar testes durante o desenvolvimento.

### 👤 Alice Costa

- 🔐 **Senha:** `alice123`
- ✅ Participou de 2 sessões:
    - `m3tI0fvV-9cfZh2LQ0BJ` – em andamento (turno 4)
    - `kEFJn5V4WDKlbUbwNr3T` – finalizada (turno 16)
- 🏅 Medalhas conquistadas:
    - 🥉 Sobrevivente de Tempestade no Vale
    - 🥈 Estrategista de Maré Tóxica

### 👤 Carla Menezes

- 🔐 **Senha:** `carla2024`
- ✅ Participou de 1 sessão:
    - `lpUZ_JIUz_uvM8lUtnd7` – em andamento (turno 3)
- 🏅 Medalhas conquistadas:
    - 🥇 Herói de Olho do Furacão
    - 🥈 Estrategista de Fumaça na Linha do Horizonte
    - 🥇 Herói de Maré Tóxica

### 👤 Diego Ramos

- 🔐 **Senha:** `diego321`
- ✅ Participou de 1 sessão:
    - `P-0DG1thuyMWEEY9gCL9` – em andamento (turno 2)
- 🏅 Medalhas conquistadas:
    - 🥇 Herói de Pressão Sob a Terra
    - 🥉 Sobrevivente de Maré Tóxica
    - 🥈 Estrategista de Olho do Furacão

### 👤 Eduarda Lima

- 🔐 **Senha:** `eduarda10`
- ✅ Participou de 1 sessão:
    - `nzFj0hlLJ-NMVBUdl-NH` – em andamento (turno 6)
- 🏅 Medalhas conquistadas:
    - 🥈 Estrategista de Tempestade no Vale
    - 🥉 Sobrevivente de Pressão Sob a Terra

### 👤 Bruno Silva

- 🔐 **Senha:** `bruno456`
- ✅ Ainda não participou de sessões
- 🏅 Nenhuma medalha (ainda)

---

## 👨‍💻 Equipe de Desenvolvimento

Angelo Antonio Recke Ricieri — RM: 560299 — 1-TSDQ  
Antônio de Luca Ribeiro Silva — RM: 560169 — 1-TSDQ  
Paulo Sérgio França Barbosa — RM: 559914 — 1-TSDQ
