package com.niit.jdp;
import com.niit.jdp.exception.InvalidArtistException;
import com.niit.jdp.exception.InvalidGenreException;
import com.niit.jdp.exception.InvalidNameException;
import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.service.JukeboxService;

import java.sql.SQLException;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvalidNameException, InvalidGenreException, InvalidArtistException {
        Scanner scanner = new Scanner(System.in);
        JukeboxService jukeboxService = new JukeboxService();
        DatabaseService databaseService = new DatabaseService();
        SongRepository songRepository = new SongRepository();
        int choice = 0;
        PlayListRepository playlistRepository = new PlayListRepository();
        System.out.println("\n=============================================");
        System.out.println("\t\tWelcome to Jukebox");
        System.out.println("\n=============================================");
            do {
                System.out.println("\nChoose the option Between 1 to 7");
                System.out.println("1. Search Song By Name");
                System.out.println("2. Search Song By Genre");
                System.out.println("3. Search Song By Artist");
                System.out.println("4. View Song List");
                System.out.println("5. Playlist Operations ");
                System.out.println("6. Jukebox Operations");
                System.out.println("7. Exit");
                System.out.println("\nEnter Choice: ");
                System.out.println("\n=============================================");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Name Of Song");
                        String name = scanner.next();
                        System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                        System.out.println("===================================================================================================================");
                        songRepository.searchByName(name).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        System.out.println("Enter 1 to Play Song");
                        System.out.println("enter 2 to goto Main Method");
                        int number1=scanner.nextInt();
                        if(number1==1){
                            System.out.println("Enter the Song Id from Above List");
                            int songId=scanner.nextInt();
                            Song song=songRepository.getSongById(songId);
                            jukeboxService.play(song.getSongPath());
                        }
                        else{
                            System.out.println("Going To Main Menu......");
                        }
                        System.out.println("Going To Main Menu......");
                        break;
                    case 2:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Genre of Song");
                        String genre = scanner.next();
                        System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                        System.out.println("===================================================================================================================");
                        songRepository.searchByGenre(genre).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        System.out.println("Enter 1 to Play Song");
                        System.out.println("enter 2 to goto Main Method");
                        int number2=scanner.nextInt();
                        if(number2==1){
                            System.out.println("Enter the Song Id from Above List");
                            int songId=scanner.nextInt();
                            Song song=songRepository.getSongById(songId);
                            jukeboxService.play(song.getSongPath());
                        }
                        else{
                            System.out.println("Going To Main Menu......");
                        }
                        System.out.println("Going To Main Menu......");
                        break;
                    case 3:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Artist name of Song");
                        String artist = scanner.next();
                        System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                        System.out.println("===================================================================================================================");
                        songRepository.searchByArtist(artist).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        System.out.println("Enter 1 to Play Song");
                        System.out.println("enter 2 to goto Main Method");
                        int number3=scanner.nextInt();
                        if(number3==1){
                            System.out.println("Enter the Song Id from Above List");
                            int songId=scanner.nextInt();
                            Song song=songRepository.getSongById(songId);
                            jukeboxService.play(song.getSongPath());
                        }
                        else{
                            System.out.println("Going To Main Menu......");
                        }
                        System.out.println("Going To Main Menu......");
                        break;
                    case 4:
                        System.out.println("\n=============================================");
                        System.out.println("All songs");
                        System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                        System.out.println("============================================================================================================");
                        songRepository.displayAllSongs().forEach(System.out::println);
                        System.out.println("\n=============================================");
                        System.out.println("Enter 1 to Play Song");
                        System.out.println("enter 2 to goto Main Method");
                        int number4=scanner.nextInt();
                        if(number4==1){
                            System.out.println("Enter the Song Id from Above List");
                            int songId=scanner.nextInt();
                            Song song=songRepository.getSongById(songId);
                            jukeboxService.play(song.getSongPath());
                        }
                        else{
                            System.out.println("Going To Main Menu......");
                        }
                        System.out.println("Going To Main Menu......");
                        break;
                    case 5:
                        System.out.println("\n=============================================");
                        playListOperations();
                        System.out.println("\n=============================================");
                        break;
                    case 6:
                        System.out.println("\n=============================================");
                        jukeboxOperations();
                        System.out.println("\n=============================================");
                        break;
                    case 7:
                        System.out.println("Exiting.....\n");
                        exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }

            } while (choice != 7);

    }


    public static void playListOperations() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PlayListRepository playlistRepository = new PlayListRepository();
        SongRepository songRepository=new SongRepository();
        int option=0;

        System.out.println("PlayList Operations");
        System.out.println("======================");
        do {
            System.out.println("1 Create a PlayList");
            System.out.println("2 Add Songs to Playlist");
            System.out.println("3 View the Songs in given Playlist");
            System.out.println("4 Go To Main Menu");
            option=scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("===============================");
                    System.out.println("Enter the Name of the Playlist to be Created: ");
                    String playlistName = scanner.nextLine();
                    PlayList playlist = playlistRepository.createPlaylist(playlistName);
                    System.out.println("Your Playlist has been Created with Id: " + playlist.getPlaylistId());
                    System.out.println("===============================");
                    break;

                case 2:
                    System.out.println("================================");
                    //i have to add get id using name
                    System.out.println(String.format("%s\t%-25s","IDS","NAMES"));
                    System.out.println("============================");
                    playlistRepository.getAllPlayList().forEach(System.out::println);
                    System.out.println("Enter the Playlist Id to Add Songs : ");
                    int playlistId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("All songs");
                    System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                    System.out.println("============================================================================================================");
                    songRepository.displayAllSongs().forEach(System.out::println);
                    System.out.println("\n=============================================");
                    System.out.println("Enter the Song Ids to Add to the Playlist Separated by comma: ");
                    String songIds = scanner.nextLine();
                    boolean songsAdded = playlistRepository.addSongsToPlayList(playlistId, songIds);
                    if(songsAdded) {
                        System.out.println("Songs Added to the Playlist");
                    }
                    else{
                        System.out.println("Something went wrong");
                    }
                    System.out.println("================================");
                    break;
                case 3:
                    System.out.println("================================");
                    System.out.println(String.format("%s\t%-25s","IDS","NAMES"));
                    System.out.println("============================");
                    playlistRepository.getAllPlayList().forEach(System.out::println);
                    System.out.println("Enter the Playlist Id to get Songs from: ");
                    int playlistIdToGetSongsFrom = scanner.nextInt();
                    System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                    System.out.println("=================================================================================================================");
                    List<Song> songsFromPlaylist = playlistRepository.getSongsFromPlaylist(playlistIdToGetSongsFrom);
                    for (Song song : songsFromPlaylist) {

                        System.out.println(song);
                    }
                    System.out.println("================================");
                    break;
                case 4:
                    System.out.println("================================");
                    System.out.println("Going To Main Menu");
                    break;
                default:
                    System.out.println("Invalid Option");


            }

        }while (option!=4);

    }
    public static void jukeboxOperations() throws SQLException, ClassNotFoundException {
        JukeboxService jukeboxService=new JukeboxService();
        Scanner scanner=new Scanner(System.in);
        PlayListRepository playlistRepository=new PlayListRepository();
        int option=0;
        System.out.println("Jukebox Operations");
        System.out.println("All PlayLists");
        System.out.println(String.format("%s\t%-25s","IDS","NAMES"));
        System.out.println("============================");
        playlistRepository.getAllPlayList().forEach(System.out::println);
        System.out.println("==============================");
        System.out.println("Enter the Playlist Id to Play songs from: ");
        int playlistIdToGetSongsFrom = scanner.nextInt();
        List<Song> songsFromPlaylist = playlistRepository.getSongsFromPlaylist(playlistIdToGetSongsFrom);
        Iterator<Song> iterator=songsFromPlaylist.iterator();
        int flag=0;
        while (iterator.hasNext()){
            if(flag==1){
                break;
            }
            System.out.println("1 Play");
            System.out.println("2 Stop");
            System.out.println("3 Return to Main Menu");
            option=scanner.nextInt();
            switch (option)
            {
                case 1:
                      // dosti,x=playlist
                    jukeboxService.play(iterator.next().getSongPath());
                    break;
                case 2:
                    System.out.println("Song has Stopped");
                    jukeboxService.stop();
                    break;
                case 3:
                    flag=1;
                    break;
                default:
                    System.out.println("Enter Valid Input");


            }
        }

    }



}


