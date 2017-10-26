package com.captechventures.java.examplecode;

import com.captechventures.java.examplecode.designprinciples.behavioral.builder.ExampleNetworkRequest;
import com.captechventures.java.examplecode.designprinciples.behavioral.builder.networking.NetworkRequest;

public class Main {

    public static void main(String[] args) {

        // Example of the Builder Pattern
        ExampleNetworkRequest.Builder builder = new ExampleNetworkRequest.Builder(Main.class.getSimpleName());
        ExampleNetworkRequest networkRequest = builder.setPriority(NetworkRequest.Priority.NORMAL)
                .setConcurrencyType(NetworkRequest.ConcurrencyType.ASYNCHRONOUS)
                .setObjectId("bfg7-hfk770-hh92687ds")
                .build();
        networkRequest.sendNetworkRequest();

    }
}
