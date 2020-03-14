package com.company.output;

import java.util.Scanner;
import java.util.Stack;

/**
 * This class allows to write on the console and gives the user the ability to revert the changes.
 * Also, the user should not use System.out.print(ln)() outside of this class.
 * It's best to just create one instance of this console (Maybe the methods should be static)
 */
public class DynamicConsole {

    /**
     * History saves everything that has been written on the console
     */
    private Stack<String> history;

    /**
     * Scanner to handle input
     */
    private Scanner cin;


    public DynamicConsole(){
        history = new Stack<>();
        cin = new Scanner(System.in);
    }

    /**
     * Equivalent of System.out.println();
     * If you are using the dynamic console class, make sure to replace all System.out.println(); with this method.
     * @param output String to print
     */
    public void println(String output){
        output += "\n";
        history.push(output);
        System.out.print(output);
    }

    /**
     * Replaces a String in history and leaves the rest as it is
     * @param printsBefore
     */
    public void replace(int printsBefore, String replacingString){
        Stack<String> inverseStack = new Stack();
        int linesToClear = 0;

        for(int i = 0; i <= printsBefore; i++){
            String stringToPop = history.pop();
            linesToClear += lines(stringToPop);
            inverseStack.push(stringToPop);
        }

        clearLines(linesToClear);

        StringBuilder sb = new StringBuilder(replacingString + "\n");

        inverseStack.pop();         //pops the vale to delete from the inverse stack
        history.push(replacingString + "\n");

        for(int i = 0; i < printsBefore; i++){
            sb.append(inverseStack.peek());
            history.push(inverseStack.pop());
        }

        System.out.print(sb);
    }

    /**
         * Equivalent of scanner.nextInt(); Saves the int in history, however
         * @return
         */
        public int nextInt(){
            int i = 0;
            boolean rep = true;

            while (rep) {
                try {
                    String in = cin.nextLine();
                    i = Integer.parseInt(in);
                    rep = false;
                } catch(NumberFormatException e){
                    System.out.print("Integer expected, try again after this message disappears!\n");

                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    clearLines(2);
                }
            }

        history.push(i + "\n");

        return i;
    }

    /**
     * Equivalent of scanner.nextDouble(); Saves the int in history, however
     * @return
     */
    public double nextDouble(){
        double d = 0;
        boolean rep = true;

        while (rep) {
            try {
                String in = cin.nextLine();
                d = Double.parseDouble(in);
                rep = false;
            } catch(NumberFormatException e){
                System.out.print("Double expected, try again after this message disappears!\n");

                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                clearLines(2);
            }
        }

        history.push(d + "\n");

        return d;
    }

    public boolean hasNextLine(){
        return cin.hasNextLine();
    }

    /**
     * Equivalent of scanner.nextLine(); saves the line in history, however saves the String.
     */
    public String nextLine(){
        String in = cin.nextLine();
        history.push(in + "\n");
        return in;
    }

    /**
     * Deletes the last print from the history from the console
     */
    public void revert(){
        clearLines(lines(history.pop()));
    }

    /**
     * Deletes the last prints from the history from the console
     * @param printsToRevert The number of prints that should be reverted
     */
    public void revert(int printsToRevert){
        for(int i = 0; i < printsToRevert; i++){
            revert();
        }
    }

    /**
     * Returns the amount of lines in a string
     * @param str the string to quantify
     * @return number of lines
     */
    private int lines(String str){
        char newLine = (char) 10;
        int lines = 0;                   //if a stirng has no \n, there is still a line

        for(char c : str.toCharArray()){
            if(c == newLine){
                lines ++;
            }
        }

        return lines;
    }

    /**
     * Clears multiple above the cursor.
     * "\033[1A" jumps one line up
     * @param lines lines to clear
     */
    void clearLines(int lines){
        for(int i = 0; i< lines; i++) {
            System.out.print("\033[1A");
            clearLine();
        }
    }

    /**
     * Clears multiple above the cursor.
     * "\033[1A" jumps one line up
     * @param lines lines to jump
     */
    void jumpLines(int lines){
        for(int i = 0; i< lines; i++) {
            System.out.print("\033[1A");
        }
    }

    /**
     * Clears the line the cursor is currently in
     * "\r" jumps to the beginning of the line
     * "\033[K" clears everything right of the line
     */
    public void clearLine(){
        System.out.print("\r\033[K");
    }
}
