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
        System.out.println("\tWelcome to Jukebox");
        System.out.println("\n=============================================");
            do {
                System.out.println("\nChoose the option Between 1 to 7");
                System.out.println("1. Name of song");
                System.out.println("2. Genre of song");
                System.out.println("3. Artist of song");
                System.out.println("4. View song list");
                System.out.println("5. Create or view or add songs in playlist");
                System.out.println("6. Jukebox operations");
                System.out.println("7. Exit");
                System.out.println("\nEnter choice: ");
                System.out.println("\n=============================================");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Name Of Song");
                        String name = scanner.next();
                        songRepository.searchByName(name).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        break;
                    case 2:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Genre of Song");
                        String genre = scanner.next();
                        songRepository.searchByGenre(genre).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        break;
                    case 3:
                        System.out.println("\n=============================================");
                        System.out.println("Enter the Artist name of song");
                        String artist = scanner.next();
                        songRepository.searchByArtist(artist).forEach(System.out::println);
                        System.out.println("\n=============================================");
                        break;
                    case 4:
                        System.out.println("\n=============================================");
                        System.out.println("All songs");
                        System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                        songRepository.displayAllSongs().forEach(System.out::println);
                        System.out.println("\n=============================================");
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
                        System.out.println("Exiting\n");
                        exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 7);

    }


    public static void playListOperations() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PlayListRepository playlistRepository = new PlayListRepository();
        int option=0;

        System.out.println("PlayList Operations");
        System.out.println("======================");
        do {
            System.out.println("1 Create a playList");
            System.out.println("2 Add songs to playlist");
            System.out.println("3 view the songs in given playlist");
            System.out.println("4 exit");
            option=scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("===============================");
                    System.out.println("enter the name of the playlist to be created: ");
                    String playlistName = scanner.nextLine();
                    PlayList playlist = playlistRepository.createPlaylist(playlistName);
                    System.out.println("Your playlist has been created with id: " + playlist.getPlaylistId());
                    System.out.println("===============================");
                    break;

                case 2:
                    System.out.println("================================");
                    //i have to add get id using name
                    System.out.println("Enter the playlist id to add songs to: ");
                    playlistRepository.getAllPlayList().forEach(System.out::println);
                    int playlistId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the song ids to add to the playlist separated by comma: ");
                    String songIds = scanner.nextLine();
                    boolean songsAdded = playlistRepository.addSongsToPlayList(playlistId, songIds);
                    if(songsAdded) {
                        System.out.println("Songs added to the playlist");
                    }
                    else{
                        System.out.println("Something went wrong");
                    }
                    System.out.println("================================");
                    break;
                case 3:
                    System.out.println("================================");
                    playlistRepository.getAllPlayList().forEach(System.out::println);
                    System.out.println("Enter the playlist id to get songs from: ");
                    int playlistIdToGetSongsFrom = scanner.nextInt();
                    System.out.println(String.format("%s\t%-25s\t\t%-15s\t%-25s\t%-25s\t%-25s","SONG ID","SONG NAME","SONG DURATION","SONG GENRE","ARTIST","ALBUM"));
                    List<Song> songsFromPlaylist = playlistRepository.getSongsFromPlaylist(playlistIdToGetSongsFrom);
                    for (Song song : songsFromPlaylist) {

                        System.out.println(song);
                    }
                    System.out.println("================================");
                    break;
                case 4:
                    System.out.println("================================");
                    System.out.println("Exiting");
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
        System.out.println("Enter the playlist id to play songs songs from: ");
        int playlistIdToGetSongsFrom = scanner.nextInt();
        List<Song> songsFromPlaylist = playlistRepository.getSongsFromPlaylist(playlistIdToGetSongsFrom);
        Iterator<Song> iterator=songsFromPlaylist.iterator();
        int flag=0;
        while (iterator.hasNext()){
            if(flag==1){
                break;
            }
            System.out.println("1 play");
            System.out.println("2 stop");
            System.out.println("3 return to main method");
            option=scanner.nextInt();
            switch (option)
            {
                case 1:
                      // dosti,x=playlist
                    jukeboxService.play(iterator.next().getSongPath());
                    break;
                case 2:
                    System.out.println("Song has stopped");
                    jukeboxService.stop();
                    break;
                case 3:
                    flag=1;
                    break;
                default:
                    System.out.println("enter valid Input");


            }
        }

    }


       /* try {
            songRepository.displayAllSongs().forEach(System.out::println);
            System.out.println("enter the name of the playlist to be created: ");
            String playlistName = scanner.nextLine();
            PlayList playlist = playlistRepository.createPlaylist(playlistName);
            System.out.println("Your playlist has been created with id: " + playlist.getPlaylistId());
            System.out.println("Enter the playlist id to add songs to: ");
            int playlistId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the song ids to add to the playlist separated by comma: ");
            String songIds = scanner.nextLine();
            boolean songsAdded = playlistRepository.addSongsToPlayList(playlistId, songIds);
            if(songsAdded) {
                System.out.println("Songs added to the playlist");
            }
            else{
                System.out.println("Something went wrong");
            }
            System.out.println("Enter the playlist id to get songs from: ");
            int playlistIdToGetSongsFrom = scanner.nextInt();
            List<Song> songsFromPlaylist = playlistRepository.getSongsFromPlaylist(playlistIdToGetSongsFrom);
            for (Song song : songsFromPlaylist) {

                System.out.println(song);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/

}


