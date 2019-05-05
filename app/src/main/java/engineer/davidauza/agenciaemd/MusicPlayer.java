package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import engineer.davidauza.agenciaemd.utils.TimeFormatter;

public class MusicPlayer extends AppCompatActivity {

    /**
     * SeekBar to show the progress of the song
     */
    private SeekBar mSeekBar;

    /**
     * Handler to be able to update the SeekBar once a song is being played
     */
    private Handler mHandler = new Handler();

    /**
     * Handles playback of the sound file
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    /**
     * Tracks if the audio focus has been granted
     */
    private boolean mHasAudioFocus;

    /**
     * The timer to the left of the SeekBar
     */
    private TextView leftTimerTextView;

    /**
     * Keeps track if the media player was playing a song before a orientation change
     */
    private boolean wasPlaying;

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
                            pausePlayback();
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
                                startPlayback();
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            // The AUDIOFOCUS_LOSS case means we've lost audio focus.

                            // Stop playback and clean up resources
                            resetSeekBar();
                            // Regardless of whether or not we were granted audio focus, abandon it.
                            // This also unregisters the AudioFocusChangeListener so we don't get
                            // anymore callbacks.
                            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
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
                    resetSeekBar();
                    // Regardless of whether or not we were granted audio focus, abandon it. This
                    // also unregisters the AudioFocusChangeListener so we don't get anymore
                    // callbacks.
                    mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        setUpMediaPlayer();

        populateSongInfo();

        setUpSeekBar();

        leftTimerTextView = findViewById(R.id.timer_left);

        // Set up back LinearLayout click behavior
        LinearLayout backLinearLayout = findViewById(R.id.back_linear_layout);
        backLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set up the play / pause Linear Layout
        final LinearLayout playPauseLinearLayout = findViewById(R.id.play_pause_linear_layout);
        playPauseLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mHasAudioFocus) {
                    requestAudioFocus();
                    if (mHasAudioFocus) {
                        startPlayback();
                    }
                } else {
                    // We already have audio focus
                    if (mMediaPlayer.isPlaying()) {
                        pausePlayback();
                    } else {
                        startPlayback();
                    }
                }
            }
        });

        // Set up reset LinearLayout
        LinearLayout resetLinearLayout = findViewById(R.id.reset_linear_layout);
        resetLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    mMediaPlayer.seekTo(0);
                    updateLeftTimer(getString(R.string.music_player_start_time));
                    mSeekBar.setProgress(0);
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

        // Song's duration
        TextView timerRightTextView = findViewById(R.id.timer_right);
        String songDurationInSeconds =
                TimeFormatter.toMmSs(mMediaPlayer.getDuration());
        timerRightTextView.setText(songDurationInSeconds);
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
                pausePlayback();
                wasPlaying = true;
            }
            // Abandon audio focus when paused to stop getting callbacks from the
            // AudioFocusChangeListener
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            mHasAudioFocus = false;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("wasPlaying", wasPlaying);
        outState.putInt("position", mMediaPlayer.getCurrentPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int position = savedInstanceState.getInt("position");
        boolean wasPlaying = savedInstanceState.getBoolean("wasPlaying");
        mMediaPlayer.seekTo(position);
        updateLeftTimer(position);
        mSeekBar.setProgress(position / 1000);
        if (wasPlaying) {
            requestAudioFocus();
            if (mHasAudioFocus) {
                startPlayback();
            }
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * This method sets up the SeekBar
     */
    private void setUpSeekBar() {
        mSeekBar = findViewById(R.id.bar);
        mSeekBar.setMax(mMediaPlayer.getDuration() / 1000);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mMediaPlayer != null && fromUser) {
                    mMediaPlayer.seekTo(progress * 1000);
                    updateLeftTimer(mMediaPlayer.getCurrentPosition());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * This method resets the SeekBar to its initial status
     */
    private void resetSeekBar() {
        updateLeftTimer(getString(R.string.music_player_start_time));
        mSeekBar.setProgress(0);
        updatePlayPauseViews(R.drawable.play_icon, R.string.music_player_helper_play);
        // Once the media player is reset, the screen is able to automatically turn off once again
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * This method updates the ImageView and helper TextView which serves as play/pause button
     *
     * @param pImageResource The image resource to setup.
     * @param pStringResorce The string ID to setup.
     */
    private void updatePlayPauseViews(int pImageResource, int pStringResorce) {
        ImageView playPauseImageView = findViewById(R.id.play_pause_icon);
        playPauseImageView.setImageResource(pImageResource);
        TextView playPauseHelper = findViewById(R.id.play_pause_helper);
        playPauseHelper.setText(pStringResorce);
    }

    /**
     * This method resumes the playback of the media player.
     */
    private void startPlayback() {
        mMediaPlayer.start();
        updatePlayPauseViews(R.drawable.pause_icon, R.string.music_player_helper_pause);
        // Prevent screen from turning off once the media player is playing
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        startUIUpdater();
    }

    /**
     * This method pauses the playback of the media player.
     */
    private void pausePlayback() {
        mMediaPlayer.pause();
        updatePlayPauseViews(R.drawable.play_icon, R.string.music_player_helper_play);
        // Once the media player is paused by some reason, the screen is able to automatically turn
        // off once again
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * This method sets up the media player.
     */
    private void setUpMediaPlayer() {
        // Create and setup the {@link MediaPlayer} for the audio resource
        // associated with the current song
        mMediaPlayer = MediaPlayer.create(MusicPlayer.this, getSong());

        // Set up a listener on the media player, so that we can stop and release
        // the media player once the sound has finished playing.
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }

    /**
     * This method updates the left timer TextView below the SeekBar.
     *
     * @param pCurrentPosition The current position of the media player.
     */
    private void updateLeftTimer(int pCurrentPosition) {
        leftTimerTextView.setText(TimeFormatter.toMmSs(pCurrentPosition));
    }

    /**
     * This method updates the left timer TextView below the SeekBar.
     *
     * @param pTime A String containing the time to be set up in the TextView in the format mm:ss
     */
    private void updateLeftTimer(String pTime) {
        leftTimerTextView.setText(pTime);
    }

    /**
     * This method updates the SeekBar and left timer TextView according to the media player
     * progress.
     */
    private void startUIUpdater() {
        MusicPlayer.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mMediaPlayer != null) {
                    if (mMediaPlayer.isPlaying()) {
                        int currentPosition = mMediaPlayer.getCurrentPosition();
                        updateLeftTimer(currentPosition);
                        currentPosition /= 1000;
                        mSeekBar.setProgress(currentPosition);
                        mHandler.postDelayed(this, 1000);
                    }
                }
            }
        });
    }

    /**
     * This method requests for audio focus.
     */
    private void requestAudioFocus() {
        // Request audio focus in order to play the audio file.
        int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // We have audio focus now.
            mHasAudioFocus = true;
        } else {
            // The focus was not granted for some reason, so display a toast letting the user
            // know it is not possible to play music right now.
            TejoCounter.createToastShort(MusicPlayer.this,
                    R.string.music_player_focus_not_granted);
        }
    }
}