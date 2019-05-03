package engineer.davidauza.agenciaemd.utils;

/**
 * This class contains a method to convert a given time in milliseconds to a String in the format
 * mm:ss
 */
public class TimeFormatter {
    /**
     * Converts a given time in milliseconds to the format mm:dd
     *
     * @param pTimeInMilliseconds The given time in milliseconds
     * @return A string with the format mm:ss
     */
    public static String toMmSs(int pTimeInMilliseconds) {
        float timeInSecondsFloat = (float) pTimeInMilliseconds / 1000;
        int timeInSeconds = Math.round(timeInSecondsFloat);
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds - (minutes * 60);
        String stringToReturn = "";
        if (minutes < 10) {
            stringToReturn += "0" + minutes;
        } else {
            stringToReturn += minutes;
        }
        stringToReturn += ":";
        if (seconds < 10) {
            stringToReturn += "0" + seconds;
        } else {
            stringToReturn += seconds;
        }
        return stringToReturn;
    }
}