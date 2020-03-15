package com.company;

import com.company.output.DynamicConsole;
import com.company.snake.SnakeGame;
import com.company.snake.Vector;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();

        myConsole.println("Press enter to start");
        myConsole.nextStringIfPossible();
        myConsole.revert();

        SnakeGame sg = new SnakeGame(myConsole);

        boolean keepGoing = true;
        while (keepGoing) {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
            }

            keepGoing = sg.nextFrame();
        }
    }
}
