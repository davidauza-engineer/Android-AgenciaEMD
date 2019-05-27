package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.adapters.SongAdapter;
import engineer.davidauza.agenciaemd.models.MusicMenuSong;

public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_menu);

        // Create a list of songs
        final ArrayList<MusicMenuSong> songs = new ArrayList<>();
        // First song
        songs.add(new MusicMenuSong(R.drawable.img_colombia_flag,
                getString(R.string.music_menu_song_one_name),
                " " + getString(R.string.music_menu_song_one_lyrics_composer),
                " " + getString(R.string.music_menu_song_one_music_composer),
                R.raw.snd_colombia_anthem));
        // Second song
        songs.add(new MusicMenuSong(R.drawable.img_boyaca_flag,
                getString(R.string.music_menu_song_two_name),
                " " + getString(R.string.music_menu_song_two_lyrics_composer),
                " " + getString(R.string.music_menu_song_two_music_composer),
                R.raw.snd_boyaca_anthem));
        // Third song
        songs.add(new MusicMenuSong(R.drawable.img_tunja_flag,
                getString(R.string.music_menu_song_three_name),
                " " + getString(R.string.music_menu_song_three_lyrics_composer),
                " " + getString(R.string.music_menu_song_three_music_composer),
                R.raw.snd_tunja_anthem));
        // Fourth song
        songs.add(new MusicMenuSong(R.drawable.img_sogamoso_flag,
                getString(R.string.music_menu_song_four_name),
                " " + getString(R.string.music_menu_song_four_lyrics_composer),
                " " + getString(R.string.music_menu_song_four_music_composer),
                R.raw.snd_sogamoso_anthem));

        // Create an {@link SongAdapter}, whose data source is a list of {@link MusicMenuSong}s. The adapter
        // knows how to create grid items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link GridView} object in the View hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the View ID called grid, which is declared in
        // the activity_music_menu.xml layout file.
        GridView gridView = findViewById(R.id.grid);

        // Make the {@link GridView use the {@link SongAdapter we created above, so that the
        // {@link GridView} will display grid items for each {@link MusicMenuSong} in the list.
        gridView.setAdapter(adapter);
    }
}
