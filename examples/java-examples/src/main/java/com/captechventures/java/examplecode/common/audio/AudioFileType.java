package com.captechventures.java.examplecode.common.audio;

import com.captechventures.java.examplecode.common.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@StringDef({
        AudioFileType.WAV,
        AudioFileType.MP3
})
public @interface AudioFileType {
    String WAV = "wav";
    String MP3 = "mp3";
}
