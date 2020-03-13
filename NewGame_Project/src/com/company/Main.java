package com.company;

import com.company.output.DynamicConsole;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();
        myConsole.println("Hello Word");
        myConsole.println("a\naa\naaa");
        myConsole.println("b\nbb\nbbb");
        myConsole.println("c\ncc\nccc");

        try {
            Thread.sleep(2_000);
        } catch(Exception e){}

        myConsole.replace(1, "d\ndd\nddd");

        myConsole.nextDouble();

        myConsole.revert(3);

        try {
            Thread.sleep(2_000);
        } catch(Exception e){}

    }
}
