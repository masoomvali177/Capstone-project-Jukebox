/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

import com.niit.jdp.exception.InvalidArtistException;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.repository.SongRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Jukeboxtest {

    Song song;
    PlayListRepository playListRepository;
    SongRepository songRepository;

    public Jukeboxtest() throws SQLException, ClassNotFoundException {
        playListRepository = new PlayListRepository();
        songRepository = new SongRepository();
    }

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        song = new Song(1, "dosti", "keravani", "dance", "rrr", 04.00, "src/main/resources/songs/Dosti.wav");
        songRepository = new SongRepository();
        playListRepository = new PlayListRepository();

    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        playListRepository = null;
    }

    @Test
    public void displayAllSongsSuccess() {
        //act
        Song expectedOutput = new Song(1, "dosti", "keravani", "dance", "rrr", 04.00, "src/main/resources/songs/Dosti.wav");
        //arrange
        List<Song> actualOutput = songRepository.displayAllSongs();
        //assert
        assertEquals(expectedOutput, actualOutput.get(0));

    }

    @Test
    public void displayAllSongsFailure() {
        Song song1 = new Song(1, "dosti", "keravani", "dance", "rrr", 04.00, "src/main/resources/songs/Dosti.wav");

        //act
        List<Song> expectedOutput = new ArrayList<>();
        expectedOutput.add(song1);
        //arrange
        List<Song> actualOutput = songRepository.displayAllSongs();
        //assert
        assertNotEquals(expectedOutput, actualOutput.get(0));

    }
    @Test
    public void displayAllSongsByArtistSuccess() throws InvalidArtistException, SQLException {
        //act
        Song song1 = new Song(1, "dosti", "keravani", "dance", "rrr", 04.00, "src/main/resources/songs/Dosti.wav");

        //act
        List<Song> expectedOutput = new ArrayList<>();
        expectedOutput.add(song1);


        List<Song> actualOutput = songRepository.searchByArtist("keravani");
        //assert
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void displayAllSongsByArtistfailure() throws InvalidArtistException, SQLException {
        //act
        Song song1 = new Song(1, "natu natu", "akon", "dance", "rrr", 04.00, "src/main/resources/songs/Dosti.wav");

        //act
        List<Song> expectedOutput = new ArrayList<>();
        expectedOutput.add(song1);


        List<Song> actualOutput = songRepository.searchByArtist("keravani");
        //assert
        Assert.assertNotEquals(expectedOutput, actualOutput);

    }



}
