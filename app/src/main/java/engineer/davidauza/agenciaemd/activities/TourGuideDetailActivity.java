package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import engineer.davidauza.agenciaemd.R;

public class TourGuideDetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide_detail);
        setUpBackdrop();
        setUpToolBar();
        setUpTitle();
    }

    private void setUpBackdrop() {
        ImageView backdrop = findViewById(R.id.img_backdrop);
        backdrop.setImageResource(getIntent().getIntExtra(EXTRA_IMAGE, -1));
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.ly_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(EXTRA_NAME));
    }

    private void setUpTitle() {
        TextView title = findViewById(R.id.lbl_title);
        title.setText(getIntent().getStringExtra(EXTRA_DESCRIPTION));
    }
}
