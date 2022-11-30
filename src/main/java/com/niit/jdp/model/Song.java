/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

public class Song {

    //attributes
    private int songId;
    private String songName;
    private String artist;
    private String songGenre;
    private String album;
    private double songDuration;
    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String artist, String songGenre, String album, double songDuration, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.songGenre = songGenre;
        this.album = album;
        this.songDuration = songDuration;
        this.songPath = songPath;
    }
}
