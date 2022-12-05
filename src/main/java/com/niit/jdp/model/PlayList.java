/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class PlayList {
    //attributes
    private int playlistId;
    private String playlistName;
    private List<Song> songs;
    public PlayList() {
    }

    public PlayList(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public PlayList(int playlistId, String playlistName, List<Song> songs) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }


    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return String.format("%s\t%-25s",playlistId,playlistName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayList)) return false;
        PlayList playList = (PlayList) o;
        return getPlaylistId() == playList.getPlaylistId() && getPlaylistName().equals(playList.getPlaylistName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaylistId(), getPlaylistName());
    }
}
