package com.company.snake;

import java.util.ArrayList;
import java.util.Queue;

public class Snake {
    private SnakeGame game;
    private Vector direction;
    private ArrayList<Vector> body;

    private Vector getHead(){
        return body.get(0);
    }

    /**
     * Moves the snake by one square.
     * @param newDirection The direction to move (0,0) to keep the dir
     * @return true if the game continues
     */
    public boolean move(Vector newDirection){
        if(!newDirection.isNullVector()){
            direction = newDirection;
        }

        Vector possibleNewBodypart = body.get(body.size() - 1);

        //moves all parts of the body 1 square forward
        for(int i = body.size() - 1; i > 0; i--){
            body.set(i, body.get(i + 1));
        }

        body.get(0).add(direction);

        Vector dirToRectangle = body.get(0).dirToRectangle(game.getBound());

        //handles out of bounds
        if(dirToRectangle.getX() != 0){
            int newX = dirToRectangle.getX() == 1 ? 0 : game.getBound().getX();

            Vector head = getHead();
            head = new Vector(newX, head.getY());
        } else if(dirToRectangle.getY() != 0){
            int newY = dirToRectangle.getY() == 1 ? 0 : game.getBound().getY();

            Vector head = getHead();
            head = new Vector(head.getX(), newY);
        }

        //checks if the snake hit food
        if(getHead().equals(game.getFood())){
            body.add(possibleNewBodypart);
        }

        //checks if the snake hit its head
        for(int i = 1; i < body.size(); i++){
            if(getHead().equals(body.get(i))){
                return false;
            }
        }

        return true;
    }
}
