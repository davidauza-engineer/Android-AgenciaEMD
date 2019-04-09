package engineer.davidauza.agenciaemd;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This class calculates the results based on the results provided by the user
 */
public class TestResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);

        // Each question has a total of 10 points
        // The following array stores the corresponding score for each question. e.g.
        // scoreArray[0][0] stores the score for the question 1, option 1, and so on
        byte[][] scoreArray = new byte[10][6];
        // Score for question 1
        //Option 1
        scoreArray[0][0] = 3;
        // Option 2
        scoreArray[0][1] = 3;
        // Option 3a
        scoreArray[0][2] = 2;
        // Option 4
        scoreArray[0][3] = 2;
        // Score for question 2
        // Option 1
        scoreArray[1][0] = 10;
        // Option 2
        scoreArray[1][1] = 0;
        // Score for question 3
        // Option 1
        scoreArray[2][0] = 10;
        // Option 2
        scoreArray[2][1] = 0;
        // Score for question 4
        // Option 1
        scoreArray[3][0] = 3;
        // Option 2
        scoreArray[3][1] = 3;
        // Option 3
        scoreArray[3][2] = 1;
        // Option 4
        scoreArray[3][3] = 1;
        // Option 5
        scoreArray[3][4] = 1;
        // Option 6
        scoreArray[3][5] = 1;
        // Score for question 5
        // Option 1
        scoreArray[4][0] = 3;
        // Option 2
        scoreArray[4][1] = 3;
        // Option 3
        scoreArray[4][2] = 2;
        // Option 4
        scoreArray[4][3] = 2;
        // Score for question 6
        // Option 1
        scoreArray[5][0] = 10;
        // Option 2
        scoreArray[5][1] = 0;
        // Score for question 7
        // Option 1
        scoreArray[6][0] = 10;
        // Option 2
        scoreArray[6][1] = 0;
        // Score for question 8
        // Option 1
        scoreArray[7][0] = 3;
        // Option 2
        scoreArray[7][1] = 3;
        // Option 3
        scoreArray[7][2] = 1;
        // Option 4
        scoreArray[7][3] = 1;
        // Option 5
        scoreArray[7][4] = 1;
        // Option 6
        scoreArray[7][5] = 1;
        // Score for question 9
        // Option 1
        scoreArray[8][0] = 3;
        // Option 2
        scoreArray[8][1] = 3;
        // Option 3
        scoreArray[8][2] = 2;
        // Option 4
        scoreArray[8][3] = 2;
        // Score for question 10
        // Option 1
        scoreArray[9][0] = 10;
        // Option 2
        scoreArray[9][1] = 0;


        // Get the company name
        SharedPreferences settings = getSharedPreferences(TestActivity.PREFS_NAME, 0);
        TextView companyName = findViewById(R.id.company_name);
        companyName.setText(settings.getString("mCompanyName", ""));

        // Set Copyright TextView
        TextView copyright = findViewById(R.id.copyright);
        MainActivity.setCopyrightText(copyright);
    }
}
