# 🏢 Sistema de Gestão de Grupos Econômicos

<p align="justify">
  Este projeto foi desenvolvido para uma atividade avaliativa da disciplina de Programação Orientada a Objetos, no curso de Ciência da Computação do CESUPA. Trata-se de uma aplicação em Java, executada pelo terminal, que permite registrar vendas de produtos e prestações de serviços de entidades pertencentes a um grupo econômico, além de consultar informações e gerar relatórios de arrecadação.
</p>

<br>

## 👥 Autoria

<p align="justify">
  Este trabalho foi desenvolvido em conjunto por <strong>Hugo Brasil</strong> e <strong>Rafael Dessbesell</strong>. Os autores acordaram a publicação deste trabalho em suas respectivas contas do GitHub, com atribuição conjunta do código desenvolvido para esta atividade avaliativa específica.
</p>

<br>

## 📦 Tecnologias

- Java 17;
- Maven, para organização do projeto e gerenciamento de dependências;
- JUnit 5, utilizado em um teste básico de cadastro de entidade.

<br>

## ⚙️ Funcionalidades

- Cadastro de produtos no estoque de cada entidade, informando tipo, nome e preço;
- Cadastro dos serviços disponíveis em cada entidade, informando tipo e preço;
- Registro de vendas com um ou mais produtos e identificação do cliente, retirando os itens vendidos do estoque;
- Registro de atendimentos com um ou mais serviços previamente cadastrados e identificação do cliente;
- Listagem de produtos vendidos, serviços prestados e entidades do grupo econômico;
- Pesquisa de produtos em estoque pelo tipo;
- Consulta do produto de maior preço no estoque de uma entidade;
- Relatórios de arrecadação por entidade e pelo grupo, com os valores de vendas e de serviços;
- Cálculo da média de arrecadação por entidade, incluindo as entidades que ainda não arrecadaram;
- Ranking das entidades por arrecadação, da maior para a menor, com posições compartilhadas em caso de empate;
- Consulta da quantidade de vendas realizadas por uma entidade;
- Edição do nome e da cidade das entidades, além da possibilidade de remoção;
- Geração de um arquivo com a relação de entidades, contendo nome e cidade.

<p align="justify">
  O cadastro de um serviço apenas o disponibiliza para contratação. Seu valor entra no cálculo da arrecadação quando o atendimento é registrado. Da mesma forma, o valor de um produto em estoque somente integra a arrecadação após a venda. Neste projeto, a arrecadação corresponde à soma dos preços das operações registradas.
</p>

<br>

## 🧩 Organização do Código

| Classe | Responsabilidade principal |
| --- | --- |
| `GrupoEconomico` | Reunir as entidades e oferecer consultas, relatórios, média e ranking de arrecadação. |
| `Entidade` | Manter os dados da entidade, seu estoque, o cadastro de serviços e os históricos de vendas e atendimentos. |
| `Estoque` | Armazenar os produtos disponíveis e permitir sua inclusão e remoção. |
| `Produto` e `Servico` | Representar os dados dos produtos e dos serviços. |
| `Venda` e `Prestacao` | Reunir os itens de cada operação, identificar o cliente e calcular o respectivo total. |
| `Cliente` | Representar o nome do cliente associado à operação. |
| `VendasGrupoEconomico` e `PrestacaoGrupoEconomico` | Reunir grupos para listar suas vendas e prestações de serviços. |
| `Main` | Iniciar o programa e apresentar o menu de interação com o usuário. |

<br>

## ⏳ O Processo de Criação

<p align="justify">
  Desenvolvemos este projeto em dupla, procurando aplicar os conhecimentos trabalhados na disciplina de Programação 
  Orientada a Objetos, disciplina do 2° semestre do curso de bacharelado em Ciência da Computação, ministrada no Centro Universitário 
  do Estado do Pará (CESUPA). Acordamos em dispor as informações de um grupo econômico em classes e estabelecer 
  relações entre entidades, produtos, serviços, clientes e operações.
</p>

<p align="justify">
  Durante o desenvolvimento, trabalhamos a distinção entre cadastrar um item e registrar uma operação, a organização dos históricos de vendas e atendimentos e a soma dos valores em diferentes níveis: primeiro em cada operação, depois na entidade e, por fim, no grupo. Também revisamos a seleção dos itens por índice e a leitura das informações digitadas pelo usuário.
</p>

<br>

## 📚 Aprendizados

Neste projeto, praticamos:

- A criação de classes, objetos, construtores e métodos;
- O uso de atributos privados e de métodos de acesso, como getters e setters;
- A associação entre objetos para representar as relações do sistema;
- O armazenamento e a consulta de objetos em listas com `ArrayList`;
- A utilização de estruturas condicionais e de repetição para organizar o menu e percorrer as listas;
- O uso de acumuladores e de métodos com retorno para calcular totais e médias;
- A busca do maior valor em uma lista e a construção de um ranking com uma lista temporária, preservando os índices originais;
- A diferença entre o cadastro de um serviço e o registro de uma prestação, preservando o preço de cada atendimento;
- A leitura de dados pelo terminal com `Scanner` e o cuidado ao combinar entradas numéricas com `nextLine()`;
- A escrita de informações em arquivo com `FileWriter`;
- A elaboração de um teste básico com JUnit para verificar a inclusão de uma entidade no grupo.

<br>

## 🌨️ Como este Projeto pode ser Melhorado?

<p align="justify">
  O projeto foi construído com finalidade acadêmica e apresenta possibilidades de aperfeiçoamento, como:
</p>

- Permitir o cadastro de novos grupos e entidades diretamente pelo menu;
- Salvar e recuperar os dados das operações entre as execuções do programa;
- Acrescentar o controle de quantidade de produtos no estoque;
- Ampliar as validações das entradas e o tratamento de situações como consultas a estoques vazios;
- Aprimorar a representação e a apresentação dos valores monetários;
- Padronizar a exportação em CSV, incluindo a extensão do arquivo, os cabeçalhos e o separador dos dados;
- Ampliar os testes para contemplar vendas, prestações, cálculos e situações de empate no ranking.

<br>

## 🛞 Rodando o Projeto

1. Faça o download deste repositório ou clone o projeto para seu computador;
2. Instale o JDK 17 ou uma versão compatível com a configuração do projeto;
3. Abra, na IDE de sua preferência, a pasta `Sistema_de_Gestao_de_Grupos_Economicos` que contém o arquivo `pom.xml`;
4. Execute o método `main` da classe `Main`, localizada em `src/main/java/com/gerenciamento/Main.java`;
5. Utilize os números apresentados no menu para escolher as operações. Para encerrar, selecione `0`.

Também é possível compilar e executar pelo terminal. Na pasta que contém o arquivo `pom.xml`, utilize:

```bash
javac -encoding UTF-8 -d out src/main/java/com/gerenciamento/*.java
java -cp out com.gerenciamento.Main
```

<p align="justify">
  O programa inicia com um grupo econômico e duas entidades definidos na classe <code>Main</code>. Na versão atual, novas entidades são adicionadas pelo código. Os dados das operações permanecem em memória durante a execução e precisam ser cadastrados novamente quando o programa é reiniciado.
</p>
