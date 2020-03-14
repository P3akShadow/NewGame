package com.company.snake;

import java.util.ArrayList;
import java.util.Queue;

public class Snake {
    static final char HEAD_CHAR = 'S';
    static final char BODY_CHAR = 's';

    private SnakeGame game;
    private Vector direction = new Vector(0, 1);
    private ArrayList<Vector> body = new ArrayList<>();

    public Snake(SnakeGame game){
        this.game = game;
        Vector head = new Vector(game.getBound().getX()/2, game.getBound().getY()/2);
        Vector snakeDir = new Vector(0, -1);

        body.add(head.clone());
        head.add(snakeDir);
        body.add(head.clone());
        head.add(snakeDir);
        body.add(head.clone());
    }

    private Vector getHead(){
        return body.get(0);
    }

    private void setHead(Vector head){body.set(0, head);};

    /**
     * Moves the snake by one square.
     * @param newDirection The direction to move (0,0) to keep the dir
     * @return 0 - nothing happens; 1 - Food eaten; 2 - lost
     */
    public int move(Vector newDirection){
        if(!newDirection.isNullVector()){
            direction = newDirection;
        }

        Vector possibleNewBodypart = body.get(body.size() - 1);

        //moves all parts of the body 1 square forward
        for(int i = body.size() - 1; i > 0; i--){
            body.set(i, body.get(i - 1).clone());
        }

        body.get(0).add(direction);

        Vector dirToRectangle = body.get(0).dirToRectangle(game.getBound());

        //handles out of bounds
        if(dirToRectangle.getX() != 0){
            int newX = dirToRectangle.getX() == 1 ? game.getBound().getX() : 0;

            Vector head = getHead();
            setHead(new Vector(newX, head.getY()));
        } else if(dirToRectangle.getY() != 0){
            int newY = dirToRectangle.getY() == 1 ? game.getBound().getY() : 0;

            Vector head = getHead();
            setHead(new Vector(head.getX(), newY));
        }



        //checks if the snake hit its head
        for(int i = 1; i < body.size(); i++){
            if(getHead().equals(body.get(i))){
                System.out.println("game over");
                return -1;
            }
        }

        //checks if the snake hit food
        if(getHead().equals(game.getFood())){
            body.add(possibleNewBodypart);
            return 1;
        }

        return 0;
    }

    public char snakeAt(Vector pos){
        if(pos.equals(getHead())){
            return HEAD_CHAR;
        }

        for(int i = 1; i < body.size(); i++){
            if(pos.equals(body.get(i))){
                return BODY_CHAR;
            }
        }

        return SnakeGame.GAME_CHAR;
    }
}
