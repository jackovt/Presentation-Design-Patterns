package com.captechventures.java.examplecode.designprinciples.structural.adapter;

import com.captechventures.java.examplecode.common.audio.*;

public class MediaAdapter implements MediaPlayer {

    AudioMediaPlayer audioMediaPlayer;

    public MediaAdapter(@AudioFileType String fileType) {
        switch (fileType.toLowerCase()) {
            case AudioFileType.WAV:
                audioMediaPlayer = new WavMediaPlayer();
                break;
            case AudioFileType.MP3:
                audioMediaPlayer = new Mp3MediaPlayer();
                break;
            default:
                break;
        }
        this.audioMediaPlayer = audioMediaPlayer;
    }

    @Override
    public void play(String fileType, String filename) {
        switch (fileType.toLowerCase()) {
            case AudioFileType.WAV:
                audioMediaPlayer.playWavFile(filename);
                break;
            case AudioFileType.MP3:
                audioMediaPlayer.playMp3vFile(filename);
                break;
            default:
                break;
        }
    }
}
