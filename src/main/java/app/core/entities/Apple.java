package app.core.entities;

import static app.core.statics.Globals.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Apple {

    // TODO -- Check Apple class has all it's properties in the class itself
    private int posX;
    private int posY;
    private Color color = Color.RED;

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
