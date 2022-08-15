package app.core.game;

import app.core.entities.Apple;
import app.core.entities.Snake;

import static app.core.statics.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private static final int DELAY = 75;
    private boolean running = false;
    private Snake snake;
    private Apple apple;
    private Timer timer;
    // TODO -- Implement scoreboard


    /**
     * Creates the basic game panel and launches 'startGame' method.
     */
    GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    /**
     * Starts the base game functions:
     * apples, 'running' boolean, and a timer.
     */
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Paints the panel and launches 'draw' method.
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    /**
     * Draws objects on the panel:
     * Optional grid, apples, snake
     */
    public void draw(Graphics graphics) {
        // TODO -- Fill out body
    }

    /**
     * Creates new random apples.
     */
    public void newApple() {
        // TODO -- Fill out body
    }

    /**
     * Moves the snake.
     */
    public void move() {
        // TODO -- Fill out body
    }

    /**
     * Checks if any apples have been eaten
     * and if so adds body parts to the snake, randomize another apple and
     * adds another apple eaten.
     */
    public void checkApple() {
        // TODO -- Fill out body
    }

    /**
     * Checks to see any collisions with the walls or itself.
     */
    public void checkCollisions() {
        // TODO -- Fill out body
    }

    /**
     * Draws 'Game Over' on the screen when it's game over.
     */
    public void gameOver(Graphics graphics) {
        // TODO -- Fill out body
    }

    /**
     * Constantly checks if the game is running or not.
     * If running: actives move, checkApples and checkCollisions methods.
     * Else: actives repaint method.
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    /**
     * Checks if any button is pressed and order the snake what to do in each case.
     */
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            // TODO -- Fill out body
        }
    }
}
