package engineer.davidauza.agenciaemd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class MusicMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<>();
        // First song
        songs.add(new Song(R.drawable.colombia_flag,
                getString(R.string.music_song_one_name),
                " " + getString(R.string.music_song_one_lyrics_composer),
                " " + getString(R.string.music_song_one_music_composer),
                R.raw.colombia_anthem));
        // Second song
        songs.add(new Song(R.drawable.boyaca_flag,
                getString(R.string.music_song_two_name),
                " " + getString(R.string.music_song_two_lyrics_composer),
                " " + getString(R.string.music_song_two_music_composer),
                R.raw.boyaca_anthem));
        // Third song
        songs.add(new Song(R.drawable.tunja_flag,
                getString(R.string.music_song_three_name),
                " " + getString(R.string.music_song_three_lyrics_composer),
                " " + getString(R.string.music_song_three_music_composer),
                R.raw.tunja_anthem));
        // Fourth song
        songs.add(new Song(R.drawable.sogamoso_flag,
                getString(R.string.music_song_four_name),
                " " + getString(R.string.music_song_four_lyrics_composer),
                " " + getString(R.string.music_song_four_music_composer),
                R.raw.sogamoso_anthem));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The adapter
        // knows how to create grid items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link GridView} object in the View hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the View ID called grid, which is declared in
        // the activity_music_menu.xml layout file.
        GridView gridView = findViewById(R.id.grid);

        // Make the {@link GridView use the {@link SongAdapter we created above, so that the
        // {@link GridView} will display grid items for each {@link Song} in the list.
        gridView.setAdapter(adapter);
    }
}
