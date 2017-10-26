package com.captechventures.java.examplecode.designprinciples.behavioral.command;

public interface StringCommand {
    String execute(String input);
    String undo(String input);
}
