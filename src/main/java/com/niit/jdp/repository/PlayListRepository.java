/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.InvalidNameException;
import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListRepository {

    Connection connection;
    DatabaseService databaseService;
    Scanner scanner=new Scanner(System.in);

    public  PlayListRepository() throws SQLException, ClassNotFoundException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnectionDatabase();
    }
    public PlayList createPlaylist(String playlistName) {
        PlayList playlist = new PlayList();
        String insertQuery = "insert into `jukebox`.`playlist` (`playlistName`) values (?);";
        try(PreparedStatement statement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, playlistName);
            int result = statement.executeUpdate();
            if (result > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    playlist.setPlaylistId(keys.getInt(1));
                    playlist.setPlaylistName(playlistName);
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return playlist;


    }
    public boolean addSongsToPlayList(int playlistId,String songIds){
        int result=0;
        String query="update jukebox.playlist set songids= ? where playlistid =?;";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setString(1,songIds);
            preparedStatement.setInt(2,playlistId);
            result=preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return result>0;
    }
    public List<Song> getSongsFromPlaylist(int playlistId) throws SQLException, ClassNotFoundException {
        List<Song> songs = new ArrayList<>();
        String query = "select * from `jukebox`.`playlist` where `playlistId` = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playlistId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String songIds = resultSet.getString("songIds");
                String[] songIdArray = songIds.split(",");
                for (String songId : songIdArray) {
                    Song song = new SongRepository().getSongById(Integer.parseInt(songId));
                    songs.add(song);
                }
            }

        }catch(Exception exception){
            exception.printStackTrace();
        }
        return songs;
    }
    public int getPlaylistIdByName(String PlaylistName) throws SQLException {
        int playlistId=0;
        String query = "select * from `jukebox`.`playlist` where `playlistName` = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setString(1, "playlistName");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                playlistId = resultSet.getInt("playlistId");
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return playlistId;
    }

    public List<PlayList> getAllPlayList( ) throws SQLException {
        List<PlayList> playLists=new ArrayList<>();
        String query="select * from `jukebox`.`playlist`;";
        try(Statement statement=connection.createStatement()){

        }
        return playLists;
    }


}
