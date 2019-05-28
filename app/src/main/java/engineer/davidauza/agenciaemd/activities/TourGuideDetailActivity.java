package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import engineer.davidauza.agenciaemd.R;

public class TourGuideDetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_SHORT_DESCRIPTION = "extra_short_description";
    public static final String EXTRA_LONG_DESCRIPTION = "extra_long_description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide_detail);
        setUpBackdrop();
        setUpToolBar();
        setUpTitle();
        setUpMainContent();
        setCredits();
    }

    private void setUpBackdrop() {
        ImageView backdrop = findViewById(R.id.img_backdrop);
        backdrop.setImageResource(getIntent().getIntExtra(EXTRA_IMAGE, -1));
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.ly_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getIntExtra(EXTRA_NAME, -1));
    }

    private void setUpTitle() {
        TextView title = findViewById(R.id.lbl_title);
        title.setText(getIntent().getIntExtra(EXTRA_SHORT_DESCRIPTION, -1));
    }

    private void setUpMainContent() {
        TextView mainContentTextView = findViewById(R.id.lbl_long_description);
        mainContentTextView.setText(getIntent().getIntExtra(EXTRA_LONG_DESCRIPTION, -1));
    }

    private void setCredits() {
        TextView creditsTextView = findViewById(R.id.lbl_credits);
        String creditsText = "Contenido adaptado de " +
                "<a href=\"https://www.google.com/destination?dest_mid=/m/019cr3#dest_mid=/m/019cr3&tcfs=EhMKCS9tLzAxOWNyMxIGQm95YWNh\">Google</a>" +
                " y " + "<a href=\"https://es.wikipedia.org/wiki/Boyacá\">Wikipedia</a>" + ".";
        creditsTextView.setText(Html.fromHtml(creditsText));
        creditsTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // todo up button = back button
}
