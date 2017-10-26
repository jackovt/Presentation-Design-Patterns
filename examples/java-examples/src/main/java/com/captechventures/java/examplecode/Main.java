package com.captechventures.java.examplecode;

import com.captechventures.java.examplecode.common.networking.NetworkParser;
import com.captechventures.java.examplecode.designprinciples.behavioral.builder.ExampleNetworkRequest;
import com.captechventures.java.examplecode.common.networking.NetworkRequest;
import com.captechventures.java.examplecode.designprinciples.behavioral.builder.ExampleNetworkResponse;
import com.captechventures.java.examplecode.designprinciples.behavioral.factory.NetworkParserFactory;
import com.captechventures.java.examplecode.designprinciples.structural.adapter.AudioPlayer;

public class Main {

    public static void main(String[] args) {

        // Creational Design Patters
        // Example of the Factory Pattern
        NetworkParserFactory networkParserFactory = new NetworkParserFactory();
        NetworkParser networkParser = networkParserFactory.getNetworkParser(NetworkParserFactory.ParserType.JSON);
        String responseBody = "{'objectId': 'bfg7-hfk770-hh92687ds', 'title': 'A Title'}";
        ExampleNetworkResponse exampleNetworkResponse = networkParser.parseResponse(responseBody, ExampleNetworkResponse.class);

        // Example of the Builder Pattern
        ExampleNetworkRequest.Builder builder = new ExampleNetworkRequest.Builder(Main.class.getSimpleName());
        ExampleNetworkRequest networkRequest = builder.setPriority(NetworkRequest.Priority.NORMAL)
                .setConcurrencyType(NetworkRequest.ConcurrencyType.ASYNCHRONOUS)
                .setObjectId("bfg7-hfk770-hh92687ds")
                .build();
        networkRequest.sendNetworkRequest();

        // Structural Design Patterns
        // Adapter Design Pattern
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "./path/to/audio-file.mp3");
        audioPlayer.play("wav", "./path/to/audio-file.wav");
        audioPlayer.play("vlc", "./path/to/audio-file.vlc");

    }
}
