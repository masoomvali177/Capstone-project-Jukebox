/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.InvalidArtistException;
import com.niit.jdp.exception.InvalidGenreException;
import com.niit.jdp.exception.InvalidNameException;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    Connection connection;
    DatabaseService databaseService;

    List<Song> songs=new ArrayList<>();

    public  SongRepository() throws SQLException, ClassNotFoundException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnectionDatabase();
    }

    public List<Song> displayAllSongs() {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * FROM `JUKEBOX`.`SONGS`";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String songName = resultSet.getString("songName");
                String artist = resultSet.getString("artist");
                String songGenre = resultSet.getString("songGenre");
                String album = resultSet.getString("album");
                Double songDuration = resultSet.getDouble("songDuration");
                String songPath=resultSet.getString("songPath");
                Song song = new Song(songId, songName, artist, songGenre, album, songDuration,songPath);
                songs.add(song);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public Song getSongById(int songId) throws SQLException {
        Song song = new Song();
        String selectQuery = "select * from `jukebox`.`songs` where `songId` = ?;";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setInt(1, songId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            song.setSongId(resultSet.getInt("songId"));
            song.setSongName(resultSet.getString("songName"));
            song.setArtist(resultSet.getString("artist"));
            song.setAlbum(resultSet.getString("album"));
            song.setSongGenre(resultSet.getString("songGenre"));
            song.setSongDuration(resultSet.getDouble("songDuration"));
            song.setSongPath(resultSet.getString("songPath"));
        }
        return song;
    }
    public List<Song> searchByArtist(String artist)throws InvalidArtistException {
        List<Song> songs = new ArrayList<>();
        if(artist==null){
            throw new InvalidArtistException("Given Artist name is Invalid");
        }
        String query = "SELECT * FROM `JUKEBOX`.`SONGS` WHERE (`ARTIST` = ?);";
        try (PreparedStatement preparedstatement = connection.prepareStatement(query)) {

            preparedstatement.setString(1, artist);
            ResultSet resultSet = preparedstatement.executeQuery(query);
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String songName = resultSet.getString("songName");
                String songArtist = resultSet.getString("artist");
                String songGenre = resultSet.getString("songGenre");
                String album = resultSet.getString("album");
                Double songDuration = resultSet.getDouble("songDuration");
                Song song = new Song(songId, songName, songArtist, songGenre, album, songDuration);
                songs.add(song);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public List<Song> searchByGenre(String songGenre)throws InvalidGenreException {
        if(songGenre==null){
            throw new InvalidGenreException("Given Genre name is Invalid");

        }
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * FROM `JUKEBOX`.`SONGS` WHERE (`SONGGENRE` = ?);";
        try (PreparedStatement preparedstatement = connection.prepareStatement(query)) {

            preparedstatement.setString(1, songGenre);
            ResultSet resultSet = preparedstatement.executeQuery(query);
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String songName = resultSet.getString("songName");
                String songArtist = resultSet.getString("artist");
                String Genre = resultSet.getString("songGenre");
                String album = resultSet.getString("album");
                Double songDuration = resultSet.getDouble("songDuration");
                Song song = new Song(songId, songName, songArtist, Genre, album, songDuration);
                songs.add(song);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public List<Song> searchByName(String songName) throws InvalidNameException {
        if(songName==null){
            throw new InvalidNameException("Given Song name is Invalid");

        }
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * FROM `JUKEBOX`.`SONGS` WHERE (`SONGNAME` = ?);";
        try (PreparedStatement preparedstatement = connection.prepareStatement(query)) {

            preparedstatement.setString(1, songName);
            ResultSet resultSet = preparedstatement.executeQuery(query);
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String songArtist = resultSet.getString("artist");
                String Genre = resultSet.getString("songGenre");
                String album = resultSet.getString("album");
                Double songDuration = resultSet.getDouble("songDuration");
                Song song = new Song(songId, name, songArtist, Genre, album, songDuration);
                songs.add(song);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public List<Song> searchByAlbum(String album) {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT * FROM `JUKEBOX`.`SONGS` WHERE (`ALBUM` = ?);";
        try (PreparedStatement preparedstatement = connection.prepareStatement(query)) {

            preparedstatement.setString(1, album);
            ResultSet resultSet = preparedstatement.executeQuery(query);
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String songArtist = resultSet.getString("artist");
                String Genre = resultSet.getString("songGenre");
                String albums = resultSet.getString("album");
                Double songDuration = resultSet.getDouble("songDuration");
                Song song = new Song(songId, name, songArtist, Genre, albums, songDuration);
                songs.add(song);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }



}
