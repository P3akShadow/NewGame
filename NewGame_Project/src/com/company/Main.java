package com.company;

import com.company.output.DynamicConsole;
import com.company.snake.SnakeGame;
import com.company.snake.Vector;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();

        Vector v1 = new Vector(1, 1);
        Vector v2 = new Vector(2, 2);

        /*
        SnakeGame sg = new SnakeGame(myConsole);

        while (true) {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {};
            sg.nextFrame();
        }
         */
    }
}
