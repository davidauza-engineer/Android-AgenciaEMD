package engineer.davidauza.agenciaemd;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If the API is greater than or equal to 26 justify the text
        if (Build.VERSION.SDK_INT >= 26) {
            TextView description = findViewById(R.id.description);
            description.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }

        // Set copyright text
        TextView copyrightTextView = findViewById(R.id.copyright);
        setCopyrightText(copyrightTextView);
    }

    /**
     * This method sets the copyright text and links
     */
    public static void setCopyrightText(TextView pCopyrightTextView) {
        String copyrightText = "Copyright 2019 <a href=\"https://davidauza.engineer\">David Auza</a>" +
                "<br /><a href=\"http://agenciaemd.com\">Agencia EMD</a> " +
                "<br />Todos los derechos reservados" +
                "<br />Íconos hechos por <a href=\"https://www.freepik.com\">Freepik</a>" +
                " de <a href=\"https://www.flaticon.com\">www.flaticon.com</a>";

        pCopyrightTextView.setText(Html.fromHtml(copyrightText));
        pCopyrightTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * This method starts the tejo counter's activity
     */
    public void goToTejoActivity(View pView) {
        Intent intent = new Intent(this, TejoCounter.class);
        startActivity(intent);
    }
}
