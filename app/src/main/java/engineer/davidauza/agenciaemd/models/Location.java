package engineer.davidauza.agenciaemd.models;

/**
 * {@link Location} represents a location to visit in Boyacá.
 * It contains an image, a String containing the name of the location, and a String containing a
 * description.
 */
public class Location {

    /**
     * Image resource ID for the location.
     */
    private int mPicture;

    /**
     * Stores the name of the location.
     */
    private String mName;

    /**
     * Stores the description of the location.
     */
    private String mDescription;

    /**
     * Create a new {@link Location} object.
     *
     * @param pPicture     is a picture of the location.
     * @param pName        is the name of the location.
     * @param pDescription is a small description of the location.
     */
    public Location(int pPicture,
                    String pName,
                    String pDescription) {
        mPicture = pPicture;
        mName = pName;
        mDescription = pDescription;
    }

    /**
     * Return the image resource ID of the location.
     */
    public int getPicture() {
        return mPicture;
    }

    /**
     * Return the name of the location.
     */
    public String getName() {
        return mName;
    }

    /**
     * Return the description of the location.
     */
    public String getDescription() {
        return mDescription;
    }
}
