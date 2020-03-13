package com.company.snake;

import com.company.output.DynamicConsole;

public class SnakeGame {
    public static final char GAME_CHAR = '~';
    public static final char FOOD_CHAR = 'O';

    private DynamicConsole dynamicConsole;
    private Snake snake;
    private Vector bound;
    private Vector food;
    private Vector[][] fields;

    public SnakeGame(DynamicConsole dynamicConsole){
        this.dynamicConsole = dynamicConsole;
        bound = new Vector(10, 10);

        fields = new Vector[bound.getX() + 1][bound.getY() + 1];

        for(int ix = 0; ix <= bound.getX(); ix++){
            for(int iy = 0; iy <= bound.getY(); iy++){
                fields[ix][iy] = new Vector(ix, iy);
            }
        }

        snake = new Snake(this);
        food = new Vector(bound.getX()/2, bound.getY());


        dynamicConsole.println(getCurrentGamestate());
    }

    public boolean nextFrame(){

        snake.move(new Vector(0, 0));
        String currentGameState = getCurrentGamestate();
        dynamicConsole.revert();
        dynamicConsole.println(currentGameState);
        return true;
    }

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
    public String getCurrentGamestate(){
        StringBuilder sb = new StringBuilder();

        for(int ix = 0; ix <= bound.getX(); ix++){
            for(int iy = 0; iy <= bound.getY(); iy++){
                if(fields[ix][iy].equals(food)){
                    sb.append(FOOD_CHAR);
                } else {
                    sb.append(snake.snakeAt(fields[ix][iy]));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
