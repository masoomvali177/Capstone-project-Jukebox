/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class JukeboxService {
    public void play(String songPath) {
        File songFile = new File(songPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            long songLength = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songLength);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            System.err.println("The song was interrupted in between");
        }
    }

    public void stop(){
        try {
            Clip clip=AudioSystem.getClip();
            clip.stop();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
