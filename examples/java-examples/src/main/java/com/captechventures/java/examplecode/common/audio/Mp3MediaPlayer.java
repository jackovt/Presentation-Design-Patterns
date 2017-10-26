package com.captechventures.java.examplecode.common.audio;

public class Mp3MediaPlayer implements AudioMediaPlayer {

    @Override
    public void playWavFile(String wavFilename) {
        throw new UnsupportedOperationException("playWavFile not supported");
    }

    public void playMp3vFile(String mp3Filename) {
        System.out.println(String.format("Playing MP3 file: %1$s", mp3Filename));
    }
}
