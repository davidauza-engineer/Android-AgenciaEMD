package engineer.davidauza.agenciaemd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MusicMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.drawable.colombia_flag,
                getString(R.string.music_song_one_name),
                getString(R.string.music_song_one_lyrics_composer),
                getString(R.string.music_song_one_music_composer),
                R.raw.colombia_anthem));
    }
}
