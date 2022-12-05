/*
 * Author      : Masoom Vali
 * Date        :
 *Created with : IntelliJ IDEA Community Edition
 */

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlayListRepository;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayListRepositoryTest {
    PlayListRepository playListRepository=new PlayListRepository();

    public PlayListRepositoryTest() throws SQLException, ClassNotFoundException {
    }

    @Test
    public void getSongsFromPlaylistFailure() throws SQLException, ClassNotFoundException {
        //arrange
        List<Song> actualOutput= playListRepository.getSongsFromPlaylist(3);
        //assert
        assertNotEquals(2,actualOutput.get(0).getSongId());
    }

    @Test
    public void getSongsFromPlaylistSuccess() throws  SQLException, ClassNotFoundException {
        //arrange
        List<Song> actualOutput= playListRepository.getSongsFromPlaylist(3);
        //assert
        assertEquals(1,actualOutput.get(0).getSongId());
    }
}
