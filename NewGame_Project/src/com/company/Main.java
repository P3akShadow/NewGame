package com.company;

import com.company.Output.DynamicConsole;

public class Main {

    public static void main(String[] args) {
        DynamicConsole myConsole = new DynamicConsole();
        myConsole.println("Hello Word");
        myConsole.println("a\na\na\na\na\na\na");

        try {
            Thread.sleep(2_000);
        } catch(Exception e){}

        myConsole.revert();




    }
}
