package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive = true; //defined as true to start the game
    private static LinkedList<Position> body; //body to return the method
    private Position position;

    public Snake() {
        this.direction = Direction.RIGHT;

        body = new LinkedList<>();

        for (int i = 0; i < SNAKE_INITIAL_SIZE; i++) {
            body.add(new Position(25 - i, 10));
        }
    }


    public void increaseSize() { //if snakes heats apple, then grows 1 size
        body.add(new Position(getTail().getCol(), getTail().getRow()));
    }

    public void move(Direction direction) { //BUG DIMINUI NA MUDANÇA DE DIREÇÃO
        Position head = getHead();

        switch (direction) { //add first
            case Direction.UP:
                if(this.direction == Direction.DOWN) {
                    move();
                    break;
                }
                body.removeLast();
                    head = new Position(getHead().getCol(), getHead().getRow() - 1);
                    this.direction = direction;
                body.addFirst(head);
                    break;
            case Direction.DOWN:
                if(this.direction == Direction.UP) {
                    move();
                    break;
                }
                body.removeLast();
                    head = new Position(getHead().getCol(), getHead().getRow() + 1);
                    this.direction = direction;
                body.addFirst(head);
                    break;
            case Direction.LEFT:
                if(this.direction == Direction.RIGHT) {
                    move();
                    break;
                }
                body.removeLast();
                    head = new Position(getHead().getCol() - 1, getHead().getRow());
                    this.direction = direction;
                body.addFirst(head);
                    break;
            case Direction.RIGHT:
                if(this.direction == Direction.LEFT) {
                    move();
                    break;
                }
                body.removeLast();
                    head = new Position(getHead().getCol() + 1, getHead().getRow());
                    this.direction = direction;
                body.addFirst(head);
                    break;
        }
    }

    public void move() {
        move(direction);
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return body.getFirst();
    }

    public Position getTail() {
        return body.getLast();
    }

    public LinkedList<Position> getFullSnake() {
        return body;
    }

    public int getSnakeSize() {
        return body.size();
    }

    public List<Position> getBody () {
        return body.subList(1,body.size());
    }
}

