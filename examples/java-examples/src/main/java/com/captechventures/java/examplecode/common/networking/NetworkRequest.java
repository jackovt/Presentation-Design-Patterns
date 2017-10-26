package com.captechventures.java.examplecode.common.networking;

import com.captechventures.java.examplecode.common.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public abstract class NetworkRequest<T extends NetworkResponse> {
    @Priority
    private final int priority;
    @ConcurrencyType
    private final int concurrencyType;
    private final String senderTag;
    private final String requestTag;
    private Long timeOfRequest;
    private final NetworkParams networkParams;

    /**
     * Constructor to create a network request object.
     *
     * @param senderTag       the unique tag of the sender
     * @param priority        the priority of the request
     * @param concurrencyType if the request should be processed asynchronously with other requests, otherwise it
     *                        will process synchronously and block subsequent requests until it finishes
     * @param networkParams   optional set of parameters needed to make the request
     */
    protected NetworkRequest(String senderTag, @Priority int priority, @ConcurrencyType int concurrencyType, NetworkParams networkParams) {
        this.senderTag = senderTag;
        requestTag = NetworkUtils.generateUniqueTag(getClass());
        this.priority = priority;
        this.concurrencyType = concurrencyType;
        this.networkParams = networkParams;
    }

    public void sendNetworkRequest() {
        timeOfRequest = System.currentTimeMillis();
        startNetworkRequest();
    }

    protected abstract void startNetworkRequest();

    protected abstract void handleSuccess(NetworkResponse networkResponse);

    protected abstract void handleFailure(T response);

    /**
     * @return the RequestTag
     */
    public String getRequestTag() {
        return requestTag;
    }

    /**
     * @return the ConcurrencyType
     */
    @ConcurrencyType
    protected int getConcurrencyType() {
        return concurrencyType;
    }

    /**
     * @return the Priority
     */
    @Priority
    protected int getPriority() {
        return priority;
    }

    /**
     * @return the NetworkParams
     */
    protected NetworkParams getNetworkParams() {
        return networkParams;
    }

    /**
     * @return the SenderTag
     */
    protected String getSenderTag() {
        return senderTag;
    }

    /**
     * @return the TimeOfRequest
     */
    protected Long getTimeOfRequest() {
        return timeOfRequest;
    }

    /**
     * Concurrency type to be used with the request. If synchronous, the request
     * will block subsequent requests. If asynchronous, subsequent requests will
     * be called at the same time as the request.
     */
    @Retention(SOURCE)
    @IntDef({ConcurrencyType.SYNCHRONOUS, ConcurrencyType.ASYNCHRONOUS})
    public @interface ConcurrencyType {
        int SYNCHRONOUS = 0;
        int ASYNCHRONOUS = 1;
    }

    /**
     * Priority used to determine the order that a network request is processed.
     */
    @Retention(SOURCE)
    @IntDef({Priority.VERY_HIGH, Priority.HIGH, Priority.NORMAL, Priority.LOW, Priority.VERY_LOW})
    public @interface Priority {
        int VERY_HIGH = 1;
        int HIGH = 2;
        int NORMAL = 3;
        int LOW = 4;
        int VERY_LOW = 5;
    }

}
