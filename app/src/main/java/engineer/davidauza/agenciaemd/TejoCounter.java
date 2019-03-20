package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TejoCounter extends AppCompatActivity {

    // Tracks the score for team A
    private int scoreTeamA = 0;

    // Tracks the previous state for scoreTeamA
    private int previousScoreTeamA = scoreTeamA;

    // Tracks the score for team B
    private int scoreTeamB = 0;

    // Tracks the previous state for scoreTeamB
    private int previousScoreTeamB = scoreTeamB;

    // Tracks if the game is still running, meaning none of the teams have reached 27 points
    private boolean gameOver = false;

    // Tracks the previous state for gameOver
    private boolean previousGameOver = gameOver;

    // Tracks if there is a previous state saved
    private boolean previousStateSaved = false;

    // The TextView corresponding to team A's score
    private TextView teamATextView;

    // The TextView corresponding to team B's score
    private TextView teamBTextView;

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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
        if (!gameOver) {
            saveState();
        }
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
            changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 1);
            gameOver = true;
            createToastGameOver();
        } else if (scoreTeamB >= 27 && !gameOver) {
            //This TextView is below the teamBTextView and it is shown if team B wins the game
            changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 1);
            gameOver = true;
            createToastGameOver();
        }
    }

    /**
     * This method save the state of the variables scoreTeamA, scoreTeamB and gameOver
     */
    private void saveState() {
        previousScoreTeamA = scoreTeamA;
        previousScoreTeamB = scoreTeamB;
        previousGameOver = gameOver;
        if (!previousStateSaved) {
            changeUndoButtonAlpha(1.0f);
            previousStateSaved = true;
        }

    }

    /**
     * This method returns to the previous state the variables: scoreTeamA, scoreTeamB, and gameOver
     * and displays them accordingly
     *
     * @param view
     */
    public void undo(View view) {
        if (previousStateSaved) {
            changeUndoButtonAlpha(0.25f);
            previousStateSaved = false;
        }
        // If the winner (¡Ganador!) TextView is visible for any of the teams, set it to not visible
        if (gameOver) {
            if (scoreTeamA >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 0);
            } else if (scoreTeamB >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 0);
            }
        }
        scoreTeamA = previousScoreTeamA;
        displayScore(scoreTeamA, teamATextView);
        scoreTeamB = previousScoreTeamB;
        displayScore(scoreTeamB, teamBTextView);
        gameOver = previousGameOver;
    }

    /**
     * This method changes the alpha of the undo button (Deshacer)
     */
    private void changeUndoButtonAlpha(float pAlpha) {
        Button undoButton = findViewById(R.id.undo_button);
        undoButton.setAlpha(pAlpha);
    }

    /**
     * This method changes the alpha of the winner (¡Ganador!) TextView
     */
    private void changeWinnerTextViewAlpha(int pResourceId, float pAlpha) {
        TextView textView = findViewById(pResourceId);
        textView.setAlpha(pAlpha);
    }

    /**
     * This method let the user share the scores by email
     */
    public void share(View view) {
        String body = getString(R.string.body_part_one) + "  " + scoreTeamA;
        if (gameOver && scoreTeamA >= 27) {
            body += "  " + getString(R.string.winner);
        }
        body += getString(R.string.body_part_two) + "  " + scoreTeamB;
        if (gameOver && scoreTeamB >= 27) {
            body += "  " + getString(R.string.winner);
        }
        body += getString(R.string.body_part_three);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_LONG)
                    .show();
        }
        Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_LONG)
                .show();
    }

    //TODO Implementar botón reset
    //TODO Implementar botón compartir
    // TODO Cambio de orientación y cambio de actividad, necesito persistir los datos
}
