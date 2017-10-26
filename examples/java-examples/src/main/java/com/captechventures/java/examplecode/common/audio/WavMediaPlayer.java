package com.captechventures.java.examplecode.common.audio;

public class WavMediaPlayer implements AudioMediaPlayer {
    public void playWavFile(String wavFilename) {
        System.out.println(String.format("Playing WAV file: %1$s", wavFilename));
    }

    @Override
    public void playMp3vFile(String mp3Filename) {
        throw new UnsupportedOperationException("playMp3vFile not supported");
    }
}
