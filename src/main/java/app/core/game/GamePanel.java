package app.core.game;

import app.core.entities.Apple;
import app.core.entities.Snake;

import static app.core.statics.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    private static final int DELAY = 75;
    private boolean running = false;
    private Snake snake;
    private ArrayList<Apple> apples;
    private Timer timer;
    private int applesEaten;
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

        if (running) {

            // Grid
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            // Apples
            Apple apple = apples.get(apples.size() - 1);
            graphics.setColor(apple.getColor());
            graphics.fillOval(apple.getPosX(), apple.getPosY(), UNIT_SIZE, UNIT_SIZE);


            // Snake
            for (int i = 0; i < snake.getBodyParts(); i++) {
                if (i == 0) {
                    // The snake's head.
                    graphics.setColor(snake.getColor());
                    graphics.fillRect(snake.getPosX()[i], snake.getPosY()[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    // The snake's body.
                    graphics.setColor(new Color(45, 180, 0));
                    // Random snake colors
                    graphics.setColor
                            (new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    graphics.fillRect(snake.getPosX()[i], snake.getPosY()[i], UNIT_SIZE, UNIT_SIZE);
                }

            }

            // Score
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + applesEaten,
                    (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, graphics.getFont().getSize());

        } else {
            gameOver(graphics);
        }
    }

    /**
     * Creates new random apples.
     */
    public void newApple() {
        apples.add(new Apple());
    }

    /**
     * Moves the snake.
     */
    public void move() {
        snake.move();
    }

    /**
     * Checks if any apples have been eaten
     * and if so adds body parts to the snake, randomize another apple and
     * adds another apple eaten.
     */
    public void checkApple() {

        Apple apple = apples.get(apples.size() - 1);

        // If the head of the snake is in the same location as the apple (has eaten the apple).
        if (snake.getPosX()[0] == apple.getPosX() && snake.getPosY()[0] == apple.getPosY()) {
            snake.addOneBodyPart();
            applesEaten++;
            newApple();
        }
    }

    /**
     * Checks to see any collisions with the walls or itself.
     */
    public void checkCollisions() {

        /** TODO -- Fix fast button mash causing game over
         * Maybe create a delay that makes the method move in the game's speed. */

        int bodyParts = snake.getBodyParts();
        int[] x = snake.getPosX();
        int[] y = snake.getPosY();

        // Checks if head collides with body.
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }

        // Checks if head touches left border.
        if (x[0] < 0) {
            running = false;
        }

        // Checks if head touches right border.
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }

        // Checks if head touches up border.
        if (y[0] < 0) {
            running = false;
        }

        // Checks if head touches bottom border.
        if (y[0] > SCREEN_WIDTH) {
            running = false;
        }

        // Stops the timer when the game is over.
        if (!running) {
            timer.stop();
        }
    }

    /**
     * Draws 'Game Over' on the screen when it's game over.
     */
    public void gameOver(Graphics graphics) {
        
        // TODO -- Implement the scoreboard here 
        
        // 'Score' text
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: " + applesEaten,
                (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, graphics.getFont().getSize());

        // 'Game Over' text
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over",
                (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        
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
            
            // Sets the direction the snake will go when a button is pressed
            switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != 'R') {
                        snake.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != 'L') {
                        snake.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != 'D') {
                        snake.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != 'U') {
                        snake.setDirection('D');
                    }
                    break;
            }
        }
    }
}
