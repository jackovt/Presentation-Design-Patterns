package com.captechventures.java.examplecode.designprinciples.behavioral.command;

public class ConcatCommand implements StringCommand {

    private final String stringToAdd = "X";

    @Override
    public String execute(String input) {
        return input.concat(stringToAdd);
    }

    @Override
    public String undo(String input) {
        int stringToAddLength = this.stringToAdd.length();
        int beginIndex = 0;
        int endIndex = input.length() - stringToAddLength;
        return input.substring(beginIndex, endIndex);
    }
}
