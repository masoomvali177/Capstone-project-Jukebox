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
    public void createPlaylist(PlayList playList) {
        String playlistName=scanner.nextLine();
        String query="insert into `jukebox`.`playlist`(playlistName) values (?)";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setString(1,playlistName);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void addSongsToPlayList(){
        String query="select playlistId,playlistName from playlist";
        try(Statement statement=connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
                System.out.println("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertIntoPlayList(PlayList playList)throws SQLException,ClassNotFoundException{
        int rows;
        String sql="insert into playlist";
    }











}
