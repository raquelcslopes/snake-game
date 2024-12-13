package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Obstacle;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Game {

    private Snake snake;
    private Fruit fruit;
    private int delay;
    private Obstacle obstacle;
    LinkedList<Obstacle> obstacles = new LinkedList<>();

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        snake = new Snake();
        this.delay = delay;
    }

    public void start() throws InterruptedException {

        generateFruit();
        generateObstacle();

        while (snake.isAlive()) {
            Thread.sleep(delay);
            Field.clearTail(snake);
            moveSnake();
            eatFruit();
            checkCollisions();
            Field.drawSnake(snake);
        }
    }

    private void generateFruit() {
        if (!snake.getBody().contains(objectPosition())) {
            fruit = new Fruit(objectPosition());
            Field.drawFruit(fruit);
        }
    }

    private static Position objectPosition() {
        int minCol = 1;
        int maxCol = 99;

        int minRow = 1;
        int maxRow = 24;

        int col = (int) (Math.random() * (maxCol - minCol) + minCol);
        int row = (int) (Math.random() * (maxRow - minRow) + minCol);

        return new Position(col, row);
    }

    public void eatFruit() {
        if (snake.getHead().equals(fruit.getPosition())) {
            snake.increaseSize();
            generateFruit();
            generateObstacle();
        }
    }

    private void moveSnake() {
        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;

                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;

                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;

                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }

    private boolean checkCollisions() {
        Position head = snake.getHead();
        List<Position> body = snake.getBody();

        if (head.getCol() < 1 || head.getCol() >= 99) {
            snake.die();
            Field.drawGameOver();
            return true;
        }

        if (head.getRow() < 1 || head.getRow() >= 24) {
            snake.die();
            Field.drawGameOver();
            return true;
        }

        Iterator<Position> iterator = body.iterator();

        while (iterator.hasNext()) {
            Position element = iterator.next();
            if (head.getCol() == element.getCol() && head.getRow() == element.getRow()) {
                snake.die();
                Field.drawGameOver();
                return true;
            }
        }

        Iterator<Obstacle> iterator1 = obstacles.iterator();

        while (iterator1.hasNext()) {
            Obstacle obstacle1 = iterator1.next();

            if (snake.getHead().getCol() == obstacle1.getPosition().getCol() && snake.getHead().getRow() == obstacle1.getPosition().getRow()) {
                snake.die();
                Field.drawGameOver();
            }
        }
        return false;
    }

    public void generateObstacle() {


        if (!snake.getBody().contains(objectPosition())) {
            obstacle = new Obstacle(objectPosition());
            obstacles.add(obstacle);
            Field.drawObstacle(obstacle);
        }
    }
}