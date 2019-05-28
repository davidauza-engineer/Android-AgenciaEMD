package engineer.davidauza.agenciaemd.models;

/**
 * {@link Location} represents a location to visit in Boyacá.
 * It contains an image resource ID, a String resource ID containing the name of the location, a
 * String resource ID containing a short description, and a String resource ID containing a long
 * description.
 */
public class Location {

    /**
     * Image resource ID for the location.
     */
    private int mPicture;

    /**
     * String resource ID for the name of the location.
     */
    private int mName;

    /**
     * String resource ID for a short description of the location.
     */
    private int mShortDescription;

    /**
     * String resource ID for a long description of the location.
     */
    private int mLongDescription;

    /**
     * Create a new {@link Location} object.
     *
     * @param pPicture          is the image resource ID of the location.
     * @param pName             is the name of the location.
     * @param pShortDescription is a short description of the location.
     * @param pLongDescription  is a long description of the location.
     */
    public Location(int pPicture,
                    int pName,
                    int pShortDescription,
                    int pLongDescription) {
        mPicture = pPicture;
        mName = pName;
        mShortDescription = pShortDescription;
        mLongDescription = pLongDescription;
    }

    /**
     * Returns the image resource ID of the location.
     */
    public int getPicture() {
        return mPicture;
    }

    /**
     * Returns the String resource ID which contains the name of the location.
     */
    public int getName() {
        return mName;
    }

    /**
     * Returns the String resource ID which contains a short description of the location.
     */
    public int getShortDescription() {
        return mShortDescription;
    }

    /**
     * Returns the String resource ID which contains a long description of the location.
     */
    public int getLongDescription() {
        return mLongDescription;
    }
}
