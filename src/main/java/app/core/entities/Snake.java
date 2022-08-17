package app.core.entities;

import static app.core.statics.Globals.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@NoArgsConstructor
@Getter
@Setter
public class Snake {

    private int bodyParts = 6;
    private char direction = 'R';
    private int applesEaten = 0;
    private Color color = Color.GREEN; // TODO -- Consider painting the snake in the Class itself
    private final int[] x = new int[GAME_UNITS];
    private final int[] y = new int[GAME_UNITS];

    /**
     * Moves the snake.
     */
    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }

    }

    /**
     * Makes the snake eat the apple.
     * */
    public void eatApple() {
        bodyParts++;
        applesEaten++;
    }

}
