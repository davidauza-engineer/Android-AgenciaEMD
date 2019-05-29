package engineer.davidauza.agenciaemd.utils;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * This class contains a static method that based on a given TextView and a given String, it sets
 * that String inside the TextView and enables any link that the String contains.
 */
public class LinkFormatter {

    /**
     * This method enables any links contained in the given String and sets that String in the given
     * TextView.
     *
     * @param pTextView is the TextView that will contain the given String.
     * @param pContent  is the String containing at least one link.
     */
    public static void format(TextView pTextView,
                              String pContent) {
        pTextView.setText(Html.fromHtml(pContent));
        pTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
