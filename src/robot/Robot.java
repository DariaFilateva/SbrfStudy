package robot;

import java.nio.file.Paths;

/**
 * Created by Dasha on 13.01.2018.
 */
public class Robot {

    private int x;
    private int y;

    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        if (this.direction == Direction.DOWN) this.direction = Direction.RIGHT;
        if (this.direction == Direction.RIGHT) this.direction = Direction.UP;
        if (this.direction == Direction.UP) this.direction = Direction.LEFT;
        if (this.direction == Direction.LEFT) this.direction = Direction.DOWN;
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        if (this.direction == Direction.DOWN) this.direction = Direction.LEFT;
        if (this.direction == Direction.RIGHT) this.direction = Direction.DOWN;
        if (this.direction == Direction.UP) this.direction = Direction.RIGHT;
        if (this.direction == Direction.LEFT) this.direction = Direction.UP;
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        if (this.direction == Direction.DOWN) y -= 1;
        if (this.direction == Direction.UP) y += 1;
        if (this.direction == Direction.RIGHT) x = x + 1;
        if (this.direction == Direction.LEFT) x -= 1;

    }
}
