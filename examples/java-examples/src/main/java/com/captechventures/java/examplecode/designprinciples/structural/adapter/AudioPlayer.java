package com.captechventures.java.examplecode.designprinciples.structural.adapter;

import com.captechventures.java.examplecode.common.audio.AudioFileType;
import com.captechventures.java.examplecode.common.audio.MediaPlayer;

public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String fileType, String filename) {
        if (fileType.equalsIgnoreCase(AudioFileType.WAV) || fileType.equalsIgnoreCase(AudioFileType.MP3)) {
            mediaAdapter = new MediaAdapter(fileType);
            mediaAdapter.play(fileType, filename);
        } else {
            System.out.println(String.format("Filetype: %1$s is not supported", fileType));
        }
    }
}
