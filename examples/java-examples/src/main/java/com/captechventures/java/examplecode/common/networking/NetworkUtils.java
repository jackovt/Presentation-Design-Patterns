package com.captechventures.java.examplecode.common.networking;

import java.util.UUID;

public class NetworkUtils {
    public static String generateUniqueTag(Class<? extends NetworkRequest> aClass) {
        return aClass.getName() + UUID.randomUUID();
    }
}
