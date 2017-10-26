package com.captechventures.java.examplecode;

import com.captechventures.java.examplecode.common.networking.NetworkParser;
import com.captechventures.java.examplecode.designprinciples.behavioral.command.ConcatCommand;
import com.captechventures.java.examplecode.designprinciples.creational.builder.ExampleNetworkRequest;
import com.captechventures.java.examplecode.common.networking.NetworkRequest;
import com.captechventures.java.examplecode.designprinciples.creational.builder.ExampleNetworkResponse;
import com.captechventures.java.examplecode.designprinciples.creational.factory.NetworkParserFactory;
import com.captechventures.java.examplecode.designprinciples.structural.adapter.AudioPlayer;

public class Main {

    public static void main(String[] args) {

        // Creational Design Patters
        // Example of the Factory Pattern
        runFactoryExample();

        // Example of the Builder Pattern
        runBuilderExample();

        // Structural Design Patterns
        // Adapter Design Pattern
        runAdapterExample();

        // Behavioral Design Patterns
        // Command Pattern
        runCommandExample();

    }

    private static void runFactoryExample() {
        NetworkParserFactory networkParserFactory = new NetworkParserFactory();
        NetworkParser networkParser = networkParserFactory.getNetworkParser(NetworkParserFactory.ParserType.JSON);
        String responseBody = "{'objectId': 'bfg7-hfk770-hh92687ds', 'title': 'A Title'}";
        ExampleNetworkResponse exampleNetworkResponse = networkParser.parseResponse(responseBody, ExampleNetworkResponse.class);
    }

    private static void runBuilderExample() {
        ExampleNetworkRequest.Builder builder = new ExampleNetworkRequest.Builder(Main.class.getSimpleName());
        ExampleNetworkRequest networkRequest = builder.setPriority(NetworkRequest.Priority.NORMAL)
                .setConcurrencyType(NetworkRequest.ConcurrencyType.ASYNCHRONOUS)
                .setObjectId("bfg7-hfk770-hh92687ds")
                .build();
        networkRequest.sendNetworkRequest();
    }

    private static void runAdapterExample() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "./path/to/audio-file.mp3");
        audioPlayer.play("wav", "./path/to/audio-file.wav");
        audioPlayer.play("vlc", "./path/to/audio-file.vlc");
    }

    private static void runCommandExample() {
        String exampleString = "OOO";
        ConcatCommand concatCommand = new ConcatCommand();
        String result = concatCommand.execute(exampleString);
        String previousString = concatCommand.undo(result);
        System.out.println(String.format("Concating String \"%1$s\": \"%2$s\"", exampleString, result));
        System.out.println(String.format("Undoing Concating String \"%1$s\": \"%2$s\"", result, previousString));
    }
}
