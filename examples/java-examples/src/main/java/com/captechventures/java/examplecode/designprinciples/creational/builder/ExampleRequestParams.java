package com.captechventures.java.examplecode.designprinciples.creational.builder;

import com.captechventures.java.examplecode.common.networking.NetworkParams;

class ExampleRequestParams extends NetworkParams {
    private String objectId;

    public ExampleRequestParams() {
        super();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
