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

    // Tracks if the game is still running, meaning none of the teams have reached 27 points
    boolean gameOver = false;

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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamA += 9;
            displayScore(scoreTeamA, teamATextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamB += 9;
            displayScore(scoreTeamB, teamBTextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamA += 6;
            displayScore(scoreTeamA, teamATextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamB += 6;
            displayScore(scoreTeamB, teamBTextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamA += 3;
            displayScore(scoreTeamA, teamATextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamB += 3;
            displayScore(scoreTeamB, teamBTextView);
            checkForGameOver();
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
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamA++;
            displayScore(scoreTeamA, teamATextView);
            checkForGameOver();
        } else {
            createToastGameOver();
        }
    }

    /**
     * This method add 1 point to Team B. This kind of scoring is called Mano
     *
     * @param view
     */
    public void manoTeamB(View view) {
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!gameOver) {
            scoreTeamB++;
            displayScore(scoreTeamB, teamBTextView);
            checkForGameOver();
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

    /**
     * This method checks if the game has ended, by checking if either team has reached 27 points.
     * If so it activates the corresponding TextView to let the user know which team had won the
     * game.
     */
    private void checkForGameOver() {
        if (scoreTeamA >= 27 && !gameOver) {
            // This TextView is below the teamATextView and it is shown if team A wins the game
            TextView winnerTeamA = findViewById(R.id.winner_team_a_text_view);
            winnerTeamA.setAlpha(1);
            gameOver = true;
            createToastGameOver();
        } else if (scoreTeamB >= 27 && !gameOver) {
            //This TextView is below the teamBTextView and it is shown if team B wins the game
            TextView winnerTeamB = findViewById(R.id.winner_team_b_text_view);
            winnerTeamB.setAlpha(1);
            gameOver = true;
            createToastGameOver();
        }
    }

    //TODO Implementar botón reset
    //TODO Implementar botón deshacer
    //TODO Implementar botón compartir
    // TODO Cambio de orientación y cambio de actividad, necesito persistir los datos
}
