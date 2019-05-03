package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity {

    /**
     * SeekBar to show the progress of the song
     */
    private SeekBar mSeekBar;

    /**
     * Handler to be able to update the SeekBar once a song is being played
     */
    private Handler mHandler;

    /**
     * Handles playback of the sound file
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes (i.e., we lose or gain audio
     * focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                            // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio
                            // focus for a short amount of time.

                            // Pause playback
                            mMediaPlayer.pause();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            // The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that our app is
                            // allowed to continue playing sound but at a lower volume.
                            mMediaPlayer.setVolume(0.8f, 0.8f);
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            // The AUDIOFOCUS_GAIN case means we have regained focus and can resume
                            // playback.
                            if (mMediaPlayer.isPlaying()) {
                                mMediaPlayer.setVolume(1.0f, 1.0f);
                            } else {
                                mMediaPlayer.start();
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            // The AUDIOFOCUS_LOSS case means we've lost audio focus.

                            // Stop playback and clean up resources
                            resetSeekBar();
                            releaseMediaPlayer();
                            break;
                        default:
                            break;
                    }
                }
            };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio
     * file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Now that the sound file has finished playing, release the media player
                    // resources.
                    resetSeekBar();
                    releaseMediaPlayer();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        populateSongInfo();

        // Set up back ImageView
        ImageView backImageView = findViewById(R.id.back_image_view);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set up the play / pause ImageView
        final ImageView playPauseImageView = findViewById(R.id.play_pause);
        playPauseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer == null) {
                    // Request audio focus in order to play the audio file.
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audio focus now.

                        // Create and setup the {@link MediaPlayer} for the audio resource
                        // associated with the current song
                        mMediaPlayer = MediaPlayer.create(MusicPlayer.this, getSong());

                        // Start the audio file
                        mMediaPlayer.start();

                        // Set up a listener on the media player, so that we can stop and release
                        // the media player once the sound has finished playing.
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);

                        updatePlayPauseViews(R.drawable.pause_icon,
                                R.string.music_player_helper_pause);

                        setUpSeekBar();
                    } else {
                        // The focus was not granted for some reason, so display a toast letting
                        // the user know it is not possible to play music right now.
                        TejoCounter.createToastShort(MusicPlayer.this,
                                R.string.music_player_focus_not_granted);
                    }
                } else {
                    if (mMediaPlayer.isPlaying()) {
                        mMediaPlayer.pause();
                        updatePlayPauseViews(R.drawable.play_icon,
                                R.string.music_player_helper_play);
                    } else {
                        mMediaPlayer.start();
                        updatePlayPauseViews(R.drawable.pause_icon,
                                R.string.music_player_helper_pause);
                    }
                }
            }
        });

        // Set up reset ImageView
        ImageView resetImageView = findViewById(R.id.reset_image_view);
        resetImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    mMediaPlayer.seekTo(0);
                }
            }
        });

        // Set copyright text
        TextView copyrightTextView = findViewById(R.id.copyright);
        MainActivity.setCopyrightText(copyrightTextView);
    }

    /**
     * This method gets the intent extras passed when the user selected a song to be played. Based
     * on that it fills the corresponding TextViews and ImageView.
     */
    private void populateSongInfo() {
        // Song's name
        TextView songNameTextView = findViewById(R.id.song_name);
        songNameTextView.setText(getIntent().getStringExtra("SONG_NAME"));

        // Lyrics composer
        TextView lyricsComposerTextView = findViewById(R.id.song_lyrics_composer);
        lyricsComposerTextView.setText(getIntent().getStringExtra("SONG_LYRICS"));

        // Music composer
        TextView musicComposerTextView = findViewById(R.id.song_music_composer);
        musicComposerTextView.setText(getIntent().getStringExtra("SONG_MUSIC"));

        // Song's image
        ImageView songPictureImageView = findViewById(R.id.song_picture);
        songPictureImageView.
                setImageResource(getIntent().getIntExtra("SONG_PICTURE", R.drawable.logo));
    }

    /**
     * This method gets the intent related to the audio resource ID, passed when the user selected
     * a song in the MusicMenu Activity.
     *
     * @return The audio resource ID corresponding to the song previously selected by the user.
     */
    private int getSong() {
        return getIntent().getIntExtra("SONG_RESOURCE", -1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // If a song is currently being played pause it
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                updatePlayPauseViews(R.drawable.play_icon, R.string.music_player_helper_play);
            }
        }
    }

    @Override
    protected void onDestroy() {
        releaseMediaPlayer();
        super.onDestroy();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a song.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources because
            // we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code we have decided that setting the
            // media player to null is an easy way to tell that the media player is not configured
            // to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    //Todo orientation resume here
    //todo image resources
    //todo seek bar set by the user


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Set up the SeekBar so it is displayed according to the song's progress.
     */
    private void setUpSeekBar() {
        // Find the SeekBar
        mSeekBar = findViewById(R.id.bar);
        mSeekBar.setMax(mMediaPlayer.getDuration() / 1000);
        mHandler = new Handler();
        MusicPlayer.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //todo is running
                //Log.e("Log", "Running");
                if (mMediaPlayer != null) {
                    int mCurrentPosition = mMediaPlayer.getCurrentPosition() / 1000;
                    //Log.e("Updating", Integer.toString(mCurrentPosition));
                    mSeekBar.setProgress(mCurrentPosition);
                    mHandler.postDelayed(this, 1000);
                    //Log.e("Updating", "Scheduled");
                }
            }
        });
    }

    /**
     * This method resets the SeekBar to its initial status
     */
    private void resetSeekBar() {
        mSeekBar.setProgress(0);
        updatePlayPauseViews(R.drawable.play_icon, R.string.music_player_helper_play);
    }

    /**
     * This method updates the ImageView and helper TextView which serves as play/pause button
     *
     * @param pImageResource The image resource to setup.
     * @param pStringResorce The string ID to setup.
     */
    private void updatePlayPauseViews(int pImageResource, int pStringResorce) {
        ImageView playPauseImageView = findViewById(R.id.play_pause);
        playPauseImageView.setImageResource(pImageResource);
        TextView playPauseHelper = findViewById(R.id.play_pause_helper);
        playPauseHelper.setText(pStringResorce);
    }
}
