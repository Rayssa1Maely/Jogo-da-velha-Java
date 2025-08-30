# Jogo da Velha em Java: Uma Análise Didática do Meu Primeiro Projeto com GUI 

## 1. Apresentação do Projeto

Bem-vindo! Este repositório contém um Jogo da Velha. Ele é o registro prático da minha jornada ao sair do console e construir minha primeira aplicação com uma interface gráfica (GUI) funcional e interativa, utilizando Java e a biblioteca Swing.

O objetivo foi criar um jogo clássico e familiar para focar no aprendizado dos componentes visuais, na manipulação de eventos e na estruturação de um programa que reage às ações do usuário em tempo real.

---

## 2. A Arquitetura: Separando o "Cérebro" da "Aparência"

A decisão mais importante do projeto foi separar a lógica do jogo da sua representação visual. Isso torna o código mais organizado, mais fácil de entender e de dar manutenção.

### O Cérebro: A Lógica do Jogo

* **A Matriz `char[][] tabuleiro`**: Esta é a "fonte da verdade". Uma simples matriz de caracteres 3x3 que guarda o estado real do jogo. Cada posição pode conter 'X', 'O' ou um valor nulo/vazio. Toda a lógica de verificação de vitória, empate ou jogada válida é feita lendo e escrevendo nesta matriz.
* **A Variável `char jogadorAtual`**: Um controlador simples que alterna entre 'X' e 'O', garantindo que cada um jogue na sua vez.

### A Aparência: Construindo a Interface com a Biblioteca Swing

A biblioteca **Swing** possui um conjunto de "componentes" pré-fabricados para montar nossa janela. Para este projeto, as peças fundamentais foram:

* **`JFrame`**: O Palco Principal. É a janela raiz da aplicação. É nela que configuramos o título, o tamanho e a ação de fechamento padrão (`setDefaultCloseOperation`). Sem um `JFrame`, nossa aplicação não teria onde "morar".

* **`JPanel`**: Os Organizadores. Pense nos painéis como recipientes que ajudam a organizar o espaço dentro do `JFrame`. Eu usei dois `JPanel`s de forma estratégica:
    1.  Um painel principal com `BorderLayout` para dividir a janela em áreas (Norte para mensagens, Centro para o tabuleiro).
    2.  Um segundo painel, específico para o tabuleiro, com `GridLayout` para criar a grade de 3x3 onde os botões se encaixam.

* **`JButton`**: As Peças Interativas. Os 9 botões são a ponte entre o jogador e o código. Em vez de o usuário digitar coordenadas, ele clica. Para espelhar a lógica do "cérebro", criei uma matriz `JButton[][]` que corresponde visualmente à matriz `char[][]`.

* **`JLabel`**: O Placar Informativo. Um componente simples para dar feedback ao jogador, mostrando de quem é a vez ou quem venceu a partida.

---

## 3. A Conexão: A Programação Orientada a Eventos

Como os cliques nos botões (`JButton`) conversam com a lógica do jogo (`char[][]`)? A resposta é o **`ActionListener`**.

O programa não segue mais um fluxo linear. Em vez disso, ele fica em "modo de espera" até que um evento aconteça.

1.  **O Ouvinte (`ActionListener`)**: Cada um dos 9 botões recebeu um "ouvinte". Ele é como um espião que tem apenas uma missão: esperar por um clique.

2.  **A Ação (`actionPerformed` method)**: Quando um botão é clicado, o ouvinte dispara este método. É aqui que o fluxo de lógica acontece:
    * O código identifica qual botão foi a fonte do clique.
    * Ele consulta a matriz `char[][]` para verificar se aquela posição está vazia.
    * Se estiver, a jogada é válida! O código então:
        * Atualiza o texto do `JButton` para "X" ou "O".
        * Atualiza a matriz `char[][]` na posição correspondente.
        * Chama a função para verificar se houve um vencedor.
        * Atualiza o `JLabel` com uma nova mensagem.
        * Passa a vez para o próximo jogador.

---

## 4. Tecnologias e Ferramentas

* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
* ![Swing](https://img.shields.io/badge/Java_Swing-596D78?style=for-the-badge)
* ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
* ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)
* ![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)

---

## 5. Como Executar

1.  Clone este repositório para a sua máquina local.
2.  Importe o projeto em uma IDE Java, como o Eclipse.
3.  Localize e execute o arquivo `TelaJogoDaVelha.java`.
4.  A janela do jogo deverá aparecer.
