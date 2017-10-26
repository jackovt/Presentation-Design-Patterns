package com.captechventures.java.examplecode.designprinciples.behavioral.factory.networking;

import com.captechventures.java.examplecode.designprinciples.behavioral.builder.networking.NetworkResponse;

public interface NetworkParser<T extends NetworkResponse> {

    public T parseResponse(String responseBody, Class<T> tClass);
}
