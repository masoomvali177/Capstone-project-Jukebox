/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JukeboxService {
    Clip clip;
    AudioInputStream audioInputStream;
    public void play(String songPath) {
        Scanner scanner=new Scanner(System.in);
        File songFile = new File(songPath);
        try {
             audioInputStream = AudioSystem.getAudioInputStream(songFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            System.out.println("2 stop");
            int stop=scanner.nextInt();
            if(stop==2)
            {
                stop();
                System.out.println("Song has stopped");
            }
            long songLength = clip.getMicrosecondLength() / 10000L;
            Thread.sleep(songLength);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            System.err.println("The song was interrupted in between");
        }
    }

    public void stop(){
        try {
            clip.stop();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
