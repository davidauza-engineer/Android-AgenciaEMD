package engineer.davidauza.agenciaemd.models;

/**
 * {@link Song} represents a song that the user can listen to.
 * It contains an image, the name of the song, the lyrics author, the music author and an audio
 * resource ID.
 */
public class Song {

    /**
     * Image resource ID for the song
     */
    private int mImageResourceId;

    /**
     * The name of the song
     */
    private String mNameOfTheSong;

    /**
     * The author of the song's lyrics
     */
    private String mLyricsComposer;

    /**
     * The author of the song's music
     */
    private String mMusicComposer;

    /**
     * Audio resource ID for the song
     */
    private int mAudioResourceId;

    /**
     * Create a new Song object.
     *
     * @param pImageResourceId is the resource ID for the image file associated with this song
     * @param pNameOfTheSong   is the name of the song
     * @param pLyricsComposer  is the name of the composer of the song's lyrics
     * @param pMusicComposer   is the name of the composer of the song's music
     * @param pAudioResourceId is the resource ID for the audio file associated with this song
     */
    public Song(int pImageResourceId,
                String pNameOfTheSong,
                String pLyricsComposer,
                String pMusicComposer,
                int pAudioResourceId) {

        mImageResourceId = pImageResourceId;
        mNameOfTheSong = pNameOfTheSong;
        mLyricsComposer = pLyricsComposer;
        mMusicComposer = pMusicComposer;
        mAudioResourceId = pAudioResourceId;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the name of the song
     */
    public String getNameOfTheSong() {
        return mNameOfTheSong;
    }

    /**
     * Return the composer of the song's lyrics
     */
    public String getLyricsComposer() {
        return mLyricsComposer;
    }

    /**
     * Return the composer of the song's music
     */
    public String getMusicComposer() {
        return mMusicComposer;
    }

    /**
     * Get the audio resource ID of the song
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
