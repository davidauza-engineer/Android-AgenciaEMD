package engineer.davidauza.agenciaemd;

import android.content.res.ColorStateList;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TejoCounter extends AppCompatActivity {

    // Tracks the score for team A
    int scoreTeamA = 0;

    // Tracks the score for team B
    int scoreTeamB = 0;

    // The TextView corresponding to team A's score
    TextView teamATextView;

    // The TextView corresponding to team B's score
    TextView teamBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tejo_counter);

        // Assign the corresponding TextView, to display score for team A
        teamATextView = findViewById(R.id.team_a_score);
        displayScore(scoreTeamA, teamATextView);

        // Assign the corresponding TextView, to display score for team B
        teamBTextView = findViewById(R.id.team_b_score);
        displayScore(scoreTeamB, teamBTextView);
    }

    /**
     * This method displays the score for teams based on the score and TextView indicated
     *
     * @param scoreToDisplay
     * @param teamTextView
     */
    private void displayScore(int scoreToDisplay, TextView teamTextView) {
        teamTextView.setText(Integer.toString(scoreToDisplay));
    }

    /**
     * This method add 9 points to Team A. This kind of scoring is called Moñona
     *
     * @param view
     */
    public void mononaTeamA(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamA += 9;
            displayScore(scoreTeamA, teamATextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 9 points to Team B. This kind of scoring is called Moñona
     *
     * @param view
     */
    public void mononaTeamB(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamB += 9;
            displayScore(scoreTeamB, teamBTextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 6 points to Team A. This kind of scoring is called Embocinada
     *
     * @param view
     */
    public void embocinadaTeamA(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamA += 6;
            displayScore(scoreTeamA, teamATextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 6 points to Team B. This kind of scoring is called Embocinada
     *
     * @param view
     */
    public void embocinadaTeamB(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamB += 6;
            displayScore(scoreTeamB, teamBTextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 3 points to Team A. This kind of scoring is called Mecha
     *
     * @param view
     */
    public void mechaTeamA(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamA += 3;
            displayScore(scoreTeamA, teamATextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 3 points to Team B. This kind of scoring is called Mecha
     *
     * @param view
     */
    public void mechaTeamB(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamB += 3;
            displayScore(scoreTeamB, teamBTextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 1 point to Team A. This kind of scoring is called Mano
     *
     * @param view
     */
    public void manoTeamA(View view) {
        // The game ends when a team scores 27 points
        if (scoreTeamA < 27 && scoreTeamB < 27) {
            scoreTeamA++;
            displayScore(scoreTeamA, teamATextView);
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method creates a toast to let the user know the game has ended as one of the teams has
     * scored 27 points.
     */
    private void createToastGameOver() {
        Toast toast = Toast.makeText(this, R.string.game_over, Toast.LENGTH_SHORT);
        // If the user is using a version of Android greater than 21, style the toast
        if (Build.VERSION.SDK_INT >= 21) {
            View viewToast = toast.getView();
            viewToast.setBackgroundTintList(ColorStateList.valueOf(getResources().
                    getColor(R.color.colorAccent)));
            TextView text = viewToast.findViewById(android.R.id.message);
            text.setTextColor(getResources().getColor(R.color.primaryText));
            text.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        toast.show();
    }

    //TODO Implementar mensaje de ganador
    //TODO Implementar botón reset
    //TODO Implementar botón deshacer
    //TODO Implementar botón compartir
}
