#  MyMusic - Gerenciador de Artistas e Músicas

Um aplicativo backend interativo de linha de comando (CLI) desenvolvido em **Java** com **Spring Boot**. O projeto permite que você busque e gerencie seus artistas e músicas favoritas, consumindo dados diretamente da API pública **TheAudioDb** e salvando-os em um banco de dados **PostgreSQL**.

---

##  Funcionalidades

O sistema possui um menu interativo no console com as seguintes opções:
- **Buscar e Adicionar Artistas:** Consulta a API TheAudioDb e salva o artista (com seu gênero musical) no banco de dados local.
- **Buscar e Adicionar Músicas:** Busca faixas específicas de um artista na API e as relaciona ao artista salvo no seu banco.
- **Listar Músicas:** Visualize todas as músicas cadastradas ou filtre pelas músicas de um artista específico.
- **Apagar Registros:** Remova artistas ou músicas do seu banco de dados a qualquer momento.
- **Validação de Entrada:** Sistema robusto de tratamento de erros para garantir que o usuário não digite valores incorretos (como letras em campos de números).

---

##  Tecnologias Utilizadas

Este projeto foi construído com as melhores práticas do ecossistema Java:

* **[Java 17](https://www.oracle.com/java/)** - Linguagem principal.
* **[Spring Boot](https://spring.io/projects/spring-boot) (4.0.5)** - Framework para inicialização rápida e injeção de dependências.
* **[Spring Data JPA & Hibernate](https://spring.io/projects/spring-data-jpa)** - Mapeamento Objeto-Relacional (ORM) e persistência de dados.
* **[PostgreSQL](https://www.postgresql.org/)** - Banco de dados relacional.
* **[Lombok](https://projectlombok.org/)** - Redução de código boilerplate (Getters, Setters, etc.).
* **[Jackson](https://github.com/FasterXML/jackson)** - Desserialização das respostas JSON da API externa.
* **Java `HttpClient`** - Para realizar chamadas HTTP à API do *TheAudioDb*.

---

##  Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado em sua máquina:
- **Java 17** (JDK)
- **Maven**
- **PostgreSQL** (rodando localmente)

---

## Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/yanmaia12/mymusic.git](https://github.com/yanmaia12/mymusic.git)
   cd mymusic