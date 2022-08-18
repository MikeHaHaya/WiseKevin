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
    private final int[] posX = new int[GAME_UNITS];
    private final int[] posY = new int[GAME_UNITS];

    /**
     * Moves the snake.
     */
    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            posX[i] = posX[i - 1];
            posY[i] = posY[i - 1];
        }

        switch (direction) {
            case 'U' -> posY[0] = posY[0] - UNIT_SIZE;
            case 'D' -> posY[0] = posY[0] + UNIT_SIZE;
            case 'L' -> posX[0] = posX[0] - UNIT_SIZE;
            case 'R' -> posX[0] = posX[0] + UNIT_SIZE;
        }

    }

    /**
     * Adds another body part to the snake.
     * */
    public void addOneBodyPart() {
        this.bodyParts++;
    }

    /**
     * Makes the snake eat the apple.
     * */
    public void eatApple() {
        bodyParts++;
        applesEaten++;
    }

}
