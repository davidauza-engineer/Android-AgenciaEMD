package engineer.davidauza.agenciaemd.utils;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class LinkFormatter {

    public static void format(TextView pTextView,
                              String pContent) {
        pTextView.setText(Html.fromHtml(pContent));
        pTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
