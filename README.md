# Snake Game Skeleton

Este projeto é um esqueleto para um jogo da cobrinha (Snake) em Java, utilizando a biblioteca Lanterna para interface de terminal.

## Estrutura do Projeto

- `src/academy/mindswap/` - Código principal do jogo.
  - `Game.java` - Lógica principal do jogo.
  - `Main.java` - Classe de entrada (main).
  - `field/` - Componentes do campo de jogo.
    - `Field.java` - Representação do campo.
    - `Obstacle.java` - Obstáculos no campo.
    - `Position.java` - Posições no campo.
  - `gameobjects/` - Objetos do jogo.
    - `fruit/`
      - `Fruit.java` - Frutas que a cobra pode comer.
    - `snake/`
      - `Direction.java` - Direções possíveis da cobra.
      - `Snake.java` - Lógica da cobra.

## Dependências

- [Lanterna 2.1.7](https://github.com/mabe02/lanterna) (já incluída na configuração do projeto)

## Como executar

1. Certifique-se de ter o JDK instalado (Java 8 ou superior).
2. Compile o projeto:
   ```sh
   javac -d out src/academy/mindswap/**/*.java
   ```
3. Execute o jogo:
   ```sh
   java -cp out:lanterna-2.1.7.jar academy.mindswap.Main
   ```
   > Ajuste o caminho do JAR do Lanterna conforme necessário.

## Objetivo

O objetivo do jogo é controlar a cobra, comer frutas e evitar colidir com obstáculos ou com o próprio corpo.

## Notas

- Este projeto é um ponto de partida e pode ser expandido com novas funcionalidades, como placar, níveis, ou diferentes tipos de frutas.
- Sinta-se à vontade para modificar e melhorar o código!


