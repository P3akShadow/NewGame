package com.company.Output;

import java.util.ArrayList;

public class DynamicConsole {

    /**
     * History saves everything that has been written on the console
     */
    private ArrayList<String> history;

    /**
     * indicates, how many lines have been deleted
     */
    private int historyPointer;

    public DynamicConsole(){
        history = new ArrayList<>();
        historyPointer = 0;
    }

    /**
     * Equivalent of System.out.print();
     * If you are using the dynamic console class, make sure to replace all System.out.print(); with this method.
     * @param output String to print
     */
    public void print(String output){
        assert (historyPointer == history.size());
        history.add(output);
        historyPointer++;
        System.out.print(output);
    }

    /**
     * Equivalent of System.out.println();
     * If you are using the dynamic console class, make sure to replace all System.out.println(); with this method.
     * @param output String to print
     */
    public void println(String output){
        assert (historyPointer == history.size());
        assert (historyPointer == history.size());
        output += "\n";
        System.out.print(output);
        output += " ";         //this is necessary to get the correct number of lines (lines is implemented with .split)
        history.add(output);
        historyPointer++;
    }

    /**
     * Deletes the last print from the history from the console
     */
    public void revert(){
        String stringToClear = history.get(history.size() - 1);
        int linesToClear = lines(stringToClear);
        clearLines(linesToClear);
        historyPointer--;
        dump();
    }

    /**
     * Deletes all Strings after historyPointer form history
     */
    public void dump(){
        for(int i = history.size() - 1; i > historyPointer; i--){
            history.remove(i);
        }
    }

    /**
     * Returns the amount of lines in a string
     * @param str the string to quantify
     * @return number of lines
     */
    private int lines(String str){
        return str.split("\n").length;
    }

    /**
     * Clears multiple above the cursor.
     * "\033[1A" jumps one line up
     * @param lines lines to clear
     */
    void clearLines(int lines){
        for(int i = 0; i< lines; i++) {
            clearLine();
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
