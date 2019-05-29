package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.adapters.SongViewAdapter;
import engineer.davidauza.agenciaemd.models.Song;

public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<>();
        // First song
        songs.add(new Song(R.drawable.img_flag_colombia,
                getString(R.string.music_main_song_one_name),
                " " + getString(R.string.music_main_song_one_lyrics_composer),
                " " + getString(R.string.music_main_song_one_music_composer),
                R.raw.snd_anthem_colombia));
        // Second song
        songs.add(new Song(R.drawable.img_flag_boyaca,
                getString(R.string.music_main_song_two_name),
                " " + getString(R.string.music_main_song_two_lyrics_composer),
                " " + getString(R.string.music_main_song_two_music_composer),
                R.raw.snd_anthem_boyaca));
        // Third song
        songs.add(new Song(R.drawable.img_flag_tunja,
                getString(R.string.music_main_song_three_name),
                " " + getString(R.string.music_main_song_three_lyrics_composer),
                " " + getString(R.string.music_main_song_three_music_composer),
                R.raw.snd_anthem_tunja));
        // Fourth song
        songs.add(new Song(R.drawable.img_flag_sogamoso,
                getString(R.string.music_main_song_four_name),
                " " + getString(R.string.music_main_song_four_lyrics_composer),
                " " + getString(R.string.music_main_song_four_music_composer),
                R.raw.snd_anthem_sogamoso));

        // Create an {@link SongViewAdapter}, whose data source is a list of {@link Song}s. The adapter
        // knows how to create grid items for each item in the list.
        SongViewAdapter adapter = new SongViewAdapter(this, songs);

        // Find the {@link GridView} object in the View hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the View ID called grid, which is declared in
        // the activity_music_main.xml layout file.
        GridView gridView = findViewById(R.id.grid);

        // Make the {@link GridView use the {@link SongViewAdapter we created above, so that the
        // {@link GridView} will display grid items for each {@link Song} in the list.
        gridView.setAdapter(adapter);
    }
}
