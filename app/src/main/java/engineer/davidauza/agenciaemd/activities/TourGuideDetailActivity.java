package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.utils.LinkFormatter;

/**
 * This Activity displays a location with more detail.
 */
public class TourGuideDetailActivity extends AppCompatActivity {

    /**
     * Stores the name of the extra data related to the image resource ID of the location to
     * display.
     */
    public static final String EXTRA_IMAGE = "engineer.davidauza.agenciaemd.activities.ExtraImage";

    /**
     * Stores the name of the extra data related to the String resource ID containing the name of
     * the location to display.
     */
    public static final String EXTRA_NAME = "engineer.davidauza.agenciaemd.activities.ExtraName";

    /**
     * Stores the name of the extra data related to the String resource ID containing a short
     * description of the location to display.
     */
    public static final String EXTRA_SHORT_DESCRIPTION =
            "engineer.davidauza.agenciaemd.ExtraShortDescription";

    /**
     * Stores the name of the extra data related to the String resource ID containing a long
     * description of the location to display.
     */
    public static final String EXTRA_LONG_DESCRIPTION =
            "engineer.davidauza.agenciaemd.ExtraLongDescription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide_detail);
        setUpBackdrop();
        setUpToolbar();
        setUpTitle();
        setUpMainContent();
        setCredits();
    }

    /**
     * This method sets up the image used as a backdrop in the AppBarLayout.
     */
    private void setUpBackdrop() {
        ImageView backdrop = findViewById(R.id.img_backdrop);
        int locationImageResourceId = getIntent().getIntExtra(EXTRA_IMAGE, -1);
        if (locationImageResourceId != -1) {
            backdrop.setImageResource(locationImageResourceId);
        }
    }

    /**
     * This method sets up the Toolbar by adding the UP button and configuring its behavior, and by
     * adding the name of the location as the title.
     */
    private void setUpToolbar() {
        // Set up "UP" button
        Toolbar toolbar = findViewById(R.id.ly_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Set up title
        int toolbarTitleResourceId = getIntent().getIntExtra(EXTRA_NAME, -1);
        if (toolbarTitleResourceId != -1) {
            getSupportActionBar().setTitle(toolbarTitleResourceId);
        }
    }

    /**
     * This method sets up the title inside the CardView of the layout.
     */
    private void setUpTitle() {
        TextView titleTextView = findViewById(R.id.lbl_title);
        int titleResourceId = getIntent().getIntExtra(EXTRA_SHORT_DESCRIPTION, -1);
        if (titleResourceId != -1) {
            titleTextView.setText(titleResourceId);
        }
    }

    /**
     * This method sets up the content paragraph inside the CardView of the layout.
     */
    private void setUpMainContent() {
        TextView mainContentTextView = findViewById(R.id.lbl_long_description);
        int contentResourceId = getIntent().getIntExtra(EXTRA_LONG_DESCRIPTION, -1);
        if (contentResourceId != -1) {
            mainContentTextView.setText(contentResourceId);
        }
    }

    /**
     * This method sets up the text that will be used as the credits in the CardView of the layout.
     */
    private void setCredits() {
        TextView creditsTextView = findViewById(R.id.lbl_credits);
        String creditsText = getString(R.string.tour_guide_detail_credits_one) +
                " <a href=\"https://tinyurl.com/yya3glf7\">Google</a> " +
                getString(R.string.tour_guide_detail_credits_two) +
                " <a href=\"https://es.wikipedia.org/wiki/Boyacá\">Wikipedia</a>" +
                getString(R.string.tour_guide_detail_credits_three);
        LinkFormatter.format(creditsTextView, creditsText);
    }
}
