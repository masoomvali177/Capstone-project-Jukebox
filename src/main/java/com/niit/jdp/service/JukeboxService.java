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
    public static void play(String songPath) {
        //1. path of the song file to be played

        //2. create a File object to represent the song file
        File songFile = new File(songPath);
        //3. create an object of AudioInputStream class
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);

            //4. get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();

            //5. open the clip and load the audio input stream
            clip.open(audioInputStream);

            //6. set a loop for the sound file
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            //7. start the clip
            clip.start();

            //8. get the exact length of the song
            long songLength = clip.getMicrosecondLength() / 1000L;

            //9. Pause the current thread for the time the song is playing
            Thread.sleep(songLength);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        } catch (InterruptedException exception) {
            System.err.println("The song was interrupted in between");
        }


}

}
