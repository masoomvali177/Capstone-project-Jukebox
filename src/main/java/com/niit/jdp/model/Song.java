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

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
