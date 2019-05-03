package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each grid item
 * based on a data source, which is a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param pContext is the current context (i.e. Activity) that the adapter is being created in.
     * @param pSongs   is the list of {@link Song}s to be displayed.
     */
    public SongAdapter(Context pContext,
                       ArrayList<Song> pSongs) {
        super(pContext, 0, pSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing View is being reused, otherwise inflate the View
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.song_layout, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the ImageView in the song_layout.xml layout with the ID song_picture.
        ImageView imageView = gridItemView.findViewById(R.id.song_picture);
        // Display the provided image based on the resource ID
        imageView.setImageResource(currentSong.getImageResorceId());

        // Find the first TextView in the song_layout.xml layout with the ID song_name.
        TextView songNameTextView = gridItemView.findViewById(R.id.song_name);
        // Get the name of the song from the currentSong object and set this text on the
        // songNameTextView.
        songNameTextView.setText(currentSong.getNameOfTheSong());

        // Find the second TextView in the song_layout.xml layout with the ID song_lyrics_composer.
        TextView songLyricsComposerTextView = gridItemView.findViewById(R.id.song_lyrics_composer);
        // Get the name of the song's lyrics composer from the currentSong object and set this text
        // on the songLyricsComposerTextView.
        songLyricsComposerTextView.setText(currentSong.getLyricsComposer());

        // Find the third TextView in the song_layout.xml layout with the ID song_music_composer.
        TextView songMusicComposerTextView = gridItemView.findViewById(R.id.song_music_composer);
        // Get the name of the song's music composer from the currentSong object and set this text
        // on the songMusicComposerTextView
        songMusicComposerTextView.setText(currentSong.getMusicComposer());

        // Set a Click listener to the CardView to be able to open the MusicPlayer Activity,
        // passing the data of the song that had been selected
        final CardView cardView = gridItemView.findViewById(R.id.card);
        cardView.setTag(position);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) cardView.getTag();
                Song currentSong = getItem(position);
                // Create the intent to open the MusicPlayer Activity
                Intent intent = new Intent(getContext(), MusicPlayer.class);
                // Put the name of the song
                intent.putExtra("SONG_NAME", currentSong.getNameOfTheSong());
                // Put the lyrics composer of the song
                intent.putExtra("SONG_LYRICS", currentSong.getLyricsComposer());
                // Put the music composer of the song
                intent.putExtra("SONG_MUSIC", currentSong.getMusicComposer());
                // Put the image of the song
                intent.putExtra("SONG_PICTURE", currentSong.getImageResorceId());
                // Put the audio resource of the song
                intent.putExtra("SONG_RESOURCE", currentSong.getAudioResourceId());
                getContext().startActivity(intent);
            }
        });

        // Return the whole song layout (containing an ImageView and 3 TextViews) so that it can be
        // shown in the GridView.
        return gridItemView;
    }
}
