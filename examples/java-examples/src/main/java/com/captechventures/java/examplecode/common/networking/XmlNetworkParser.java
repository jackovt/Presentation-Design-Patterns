package com.captechventures.java.examplecode.common.networking;

public class XmlNetworkParser implements NetworkParser {

    @Override
    public <T extends NetworkResponse> T parseResponse(String responseBody, Class<T> tClass) {
        return null;
    }
}
