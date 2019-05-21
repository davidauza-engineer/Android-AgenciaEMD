package engineer.davidauza.agenciaemd.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import engineer.davidauza.agenciaemd.R;

public class TourGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

        setUpToolBar();
    }

    /**
     * This method sets the ToolBar to display the UP button
     */
    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.ly_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
