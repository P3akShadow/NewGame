package com.company;

import com.company.Output.DynamicConsole;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();
        myConsole.println("Hello Word");
        myConsole.println("a\na\na\na\na\na\na");
        myConsole.println("b\nb\nb\nb\nb\nb\nb");
        myConsole.println("c\nc\nc\nc\nc\nc\nc");

        try {
            Thread.sleep(2_000);
        } catch(Exception e){}

        myConsole.replace(1, "d\nd\nd\nd\nd\nd\nd");

        try {
            Thread.sleep(2_000);
        } catch(Exception e){}

    }
}
