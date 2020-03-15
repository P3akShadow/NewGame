package com.company;

import com.company.output.DynamicConsole;
import com.company.snake.SnakeGame;
import com.company.snake.Vector;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        DynamicConsole myConsole = new DynamicConsole();

        myConsole.println("Press enter to start");

        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
        }

        myConsole.nextStringNonBlocking();

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
