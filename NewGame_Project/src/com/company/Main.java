package com.company;

import com.company.output.DynamicConsole;
import com.company.snake.SnakeGame;
import com.company.snake.Vector;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();

        SnakeGame sg = new SnakeGame(myConsole);

        boolean keepGoing = true;
        while (keepGoing) {
            try {
                Thread.sleep(1_00);
            } catch (Exception e) {
            }

            keepGoing = sg.nextFrame();
        }
    }
}
