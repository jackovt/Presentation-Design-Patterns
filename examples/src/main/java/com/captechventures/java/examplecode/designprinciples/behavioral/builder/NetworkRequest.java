package com.captechventures.java.examplecode.designprinciples.behavioral.builder;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public abstract class NetworkRequest<T extends NetworkResponse> {

    

    /**
     * Concurrency type to be used with the request. If synchronous, the request
     * will block subsequent requests. If asynchronous, subsequent requests will
     * be called at the same time as the request.
     */
    @Retention(SOURCE)
    public @interface ConcurrencyType {
        int SYNCHRONOUS = 0;
        int ASYNCHRONOUS = 1;
    }

    /**
     * Priority used to determine the order that a network request is processed.
     */
    @Retention(SOURCE)
    public @interface Priority {
        int VERY_HIGH = 1;
        int HIGH = 2;
        int NORMAL = 3;
        int LOW = 4;
        int VERY_LOW = 5;
    }

}
