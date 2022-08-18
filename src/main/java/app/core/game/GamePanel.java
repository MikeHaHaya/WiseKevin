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
        if (running) {

            // Grid
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            // Apples
            Apple apple = new Apple();
            graphics.setColor(apple.getColor());
            graphics.fillOval(apple.getPosX(), apple.getPosY(), UNIT_SIZE, UNIT_SIZE);


            // Snake
            for (int i = 0; i < snake.getBodyParts(); i++) {
                if (i == 0) {
                    // The snake's head.
                    graphics.setColor(snake.getColor());
                    graphics.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    // The snake's body.
                    graphics.setColor(new Color(45, 180, 0));
                    // Random snake colors
                    graphics.setColor
                            (new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    graphics.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
                }

                // Score
                graphics.setColor(Color.RED);
                graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
                FontMetrics metrics = getFontMetrics(graphics.getFont());
//                graphics.drawString("Score: " + applesEaten,
//                        (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, graphics.getFont().getSize());
            }

        }
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
