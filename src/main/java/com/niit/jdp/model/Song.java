/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

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

    public Song(int songId, String songName, String artist, String songGenre, String album, double songDuration) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.songGenre = songGenre;
        this.album = album;
        this.songDuration = songDuration;
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



    @Override
    public String toString() {
        return String.format("%s\t\t%-30s\t%-15s\t%-25s\t%-25s\t%-25s",songId,songName,songDuration,songGenre,artist,album);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return getSongId() == song.getSongId() && Double.compare(song.getSongDuration(), getSongDuration()) == 0 && getSongName().equals(song.getSongName()) && getArtist().equals(song.getArtist()) && getSongGenre().equals(song.getSongGenre()) && getAlbum().equals(song.getAlbum()) && getSongPath().equals(song.getSongPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSongId(), getSongName(), getArtist(), getSongGenre(), getAlbum(), getSongDuration(), getSongPath());
    }
}
