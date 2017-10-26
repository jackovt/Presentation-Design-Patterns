package com.captechventures.java.examplecode.designprinciples.creational.factory;

import com.captechventures.java.examplecode.common.StringDef;
import com.captechventures.java.examplecode.common.networking.HalJsonNetworkParser;
import com.captechventures.java.examplecode.common.networking.JsonNetworkParser;
import com.captechventures.java.examplecode.common.networking.NetworkParser;
import com.captechventures.java.examplecode.common.networking.XmlNetworkParser;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class NetworkParserFactory {

    public NetworkParser getNetworkParser(@ParserType String parserType) {
        switch (parserType) {
            case ParserType.JSON:
                return new JsonNetworkParser();
            case ParserType.XML:
                return new XmlNetworkParser();
            case ParserType.HAL_JSON:
                return new HalJsonNetworkParser();
            default:
                return null;
        }
    }

    @Retention(RUNTIME)
    @StringDef({
            ParserType.JSON,
            ParserType.XML,
            ParserType.HAL_JSON
    })
    public @interface ParserType {
        String JSON = "json";
        String XML = "xml";
        String HAL_JSON = "hal+json";
    }

}
