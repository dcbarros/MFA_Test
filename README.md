# ﻿Teste Autentição Dois Fatores (MFA)

## Objetivo do Projeto
O projeto tem como objetivo exemplificar um teste de login em uma plataforma com uma autenticação de dois fatores que se utiliza do método TOTP para a geração de um token.

## Configuração do Ambiente

### Requisitos:

- Java 8+
- Maven 3+
- IDE de sua preferência (ex.: IntelliJ IDEA, Eclipse, VS Code)

### Tecnologias

- Selenium Webdriver 3+
- Webdriver Maneger 5.6.2
- Google Auth 1.4.0
- Junit 4.X
- 
### Montagem do ambiente de teste

Seguiu como exemplo o código do [Bouali Ali](https://github.com/ali-bouali/tfa-spring-boot-3-angular), a montagem dessa parte basta acompanhar o vídeo do mesmo.

Após a montagem da plataforma do teste.

1. Clone o repositório do projeto:
```
  git clone https://github.com/dcbarros/MFA_Test.git
```
2. Importe o projeto como um projeto Maven na sua IDE.
3. Baixe as dependências executando:
```
  mvn clean install
```
4. Antes de executar o teste crie um registro no site e adicione no arquivo ```com.teste.mfa.tests.MFATest.java```:
```java
public class MFATest extends BaseTest {
    
    private LoginPage lp = new LoginPage();
    private ValidationPage vp = new ValidationPage();
    
    @Test
    public void test1() throws InterruptedException{

        lp.doLogin("Email Cadastro", "Senha Cadastro");

//Resto do código
```
5. Acesse o banco de dados e verifique o atributo ```secret``` da classe ```User``` e adicione em no mesmo arquivo:

```java
// Outras Linhas
    try {
        vp.setValidateCodeAndCompleteLogin(TotpGenerator.generateTotpCode("Seu Segredo"));
    } catch (Exception e) {
        e.printStackTrace();
    }
// Outras Linhas

```
6. Inicie o teste:

```
  mvn test
```
## Estrutura do Projeto

### Principais Diretórios:

- src/main: Contém o código-fonte principal do projeto, dividido em pacotes organizados por responsabilidade.

- com.teste.mfa.core: Camada onde contém as classes básicas da estrutura de teste.

- com.teste.mfa.pages: Camada de abstração de comandos para as páginas acessadas no teste.

- com.teste.mfa.tests: Camada dos testes realizados na plataforma.

- com.teste.mfa.utils: Contém classes utilitárias para os testes.

- pom.xml: Arquivo de configuração do Maven, onde estão especificadas as dependências e plugins necessários.
