package com.company.snake;

public class SnakeGame {

    private Snake snake;
    private Vector bound;
    private Vector food;

    /**
     *  allows access to bound to let the snake check if its inside
     */
    public Vector getBound(){
        return bound;
    }

    /**
     *  allows access to food to let the snake check if it hit it
     */
    public Vector getFood(){
        return food;
    }

    /**
     * Prints the current gamestate to the console
     */
    public void printCurrentGamestate(){

    }
}
