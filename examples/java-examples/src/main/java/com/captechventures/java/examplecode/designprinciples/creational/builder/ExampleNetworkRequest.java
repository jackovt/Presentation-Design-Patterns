package com.captechventures.java.examplecode.designprinciples.creational.builder;

import com.captechventures.java.examplecode.common.networking.NetworkParams;
import com.captechventures.java.examplecode.common.networking.NetworkRequest;
import com.captechventures.java.examplecode.common.networking.NetworkResponse;

public class ExampleNetworkRequest extends NetworkRequest<ExampleNetworkResponse> {

    private ExampleNetworkRequest(String senderTag, int priority, int concurrencyType, NetworkParams networkParams) {
        super(senderTag, priority, concurrencyType, networkParams);
    }

    public static class Builder {
        private ExampleRequestParams networkParams;
        private String senderTag;
        @Priority
        private int priority;
        @ConcurrencyType
        private int concurrencyType;

        public Builder(String senderTag) {
            this.senderTag = senderTag;
            this.networkParams = new ExampleRequestParams();
        }

        /**
         * [OPTIONAL] Set a priority on the request. This is only necessary if there are multiple
         * requests being queued and sent at once. The requests will be sent in order, depending on
         * their priority level. By default requests are set to {@code Priority.NORMAL}.
         *
         * @param priority the {@link Priority}
         * @return
         */
        public Builder setPriority(@Priority int priority) {
            this.priority = priority;
            return this;
        }

        /**
         * [OPTIONAL] Set if the request should be run asynchronously, and process requests at the same
         * time. By default requests are run synchronously, blocking the next request until it
         * completes.
         * <p/>
         * Note: All network requests occur off the of the main UI thread, this setting simply affects
         * whether subsequent requests will be blocked or not.
         *
         * @param concurrencyType the {@link ConcurrencyType}
         *                        that specifies if the request should be asynchronous, otherwise it is synchronous
         * @return
         */
        public Builder setConcurrencyType(@ConcurrencyType int concurrencyType) {
            this.concurrencyType = concurrencyType;
            return this;
        }

        public Builder setObjectId(String objectId) {
            this.networkParams.setObjectId(objectId);
            return this;
        }

        public ExampleNetworkRequest build() {
            return new ExampleNetworkRequest(senderTag, priority, concurrencyType, networkParams);
        }
    }

    @Override
    protected void startNetworkRequest() {
        // Do work to actually send the request; maybe attach listener for response.
    }

    @Override
    protected void handleSuccess(NetworkResponse networkResponse) {
        // Handle the response for the requests
    }

    @Override
    protected void handleFailure(ExampleNetworkResponse response) {
        // Handle and failures from the response.
    }
}
