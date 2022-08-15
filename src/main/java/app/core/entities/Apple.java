package app.core.entities;

import static app.core.Globals.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple {

    private int posX;
    private int posY;

    public Apple() {
        ranPositions();
    }

    /**
     * Randomizes x and y in the boundaries of the game to get a new position for the apple*/
    public void ranPositions() {
        posX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        posY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
}
