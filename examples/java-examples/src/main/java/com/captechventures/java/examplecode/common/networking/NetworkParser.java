package com.captechventures.java.examplecode.common.networking;

import com.captechventures.java.examplecode.common.networking.NetworkResponse;

public interface NetworkParser {

    public <T extends NetworkResponse> T parseResponse(String responseBody, Class<T> tClass);
}
