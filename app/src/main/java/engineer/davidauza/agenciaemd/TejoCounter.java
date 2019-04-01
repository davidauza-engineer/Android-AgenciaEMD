package engineer.davidauza.agenciaemd;

import android.content.Intent;
import android.content.SharedPreferences;
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

    // The name of the file to store the state so it can be recovered
    public static final String PREFS_NAME = "MyPrefsFile";
    // Tracks the score for team A
    private int mScoreTeamA = 0;
    // Tracks the previous state for scoreTeamA
    private int mPreviousScoreTeamA = mScoreTeamA;
    // Tracks the score for team B
    private int mScoreTeamB = 0;
    // Tracks the previous state for scoreTeamB
    private int mPreviousScoreTeamB = mScoreTeamB;
    // Tracks if the game is still running, meaning none of the teams have reached 27 points
    private boolean mGameOver = false;
    // Tracks the previous state for gameOver
    private boolean mPreviousGameOver = mGameOver;
    // Tracks if there is a previous state saved
    private boolean mPreviousStateSaved = false;
    // Tracks if it is possible to reset the game
    private boolean mResetAvailable = false;
    // The TextView corresponding to team A's score
    private TextView mTeamATextView;
    // The TextView corresponding to team B's score
    private TextView mTeamBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tejo_counter);

        // Create SharedPreferences to restore the state of the activity
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        // Load the state of the app and update UI accordingly
        mScoreTeamA = settings.getInt("mScoreTeamA", mScoreTeamA);
        mPreviousScoreTeamA = settings.getInt("mPreviousScoreTeamA", mPreviousScoreTeamA);
        mScoreTeamB = settings.getInt("mScoreTeamB", mScoreTeamB);
        mPreviousScoreTeamB = settings.getInt("mPreviousScoreTeamB", mPreviousScoreTeamB);
        mGameOver = settings.getBoolean("mGameOver", mGameOver);
        if (mGameOver) {
            // Display winner TextView
            if (mScoreTeamA >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 1);
            } else if (mScoreTeamB >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 1);
            }
        }
        mPreviousGameOver = settings.getBoolean("mPreviousGameOver", mPreviousGameOver);
        mPreviousStateSaved = settings.getBoolean("mPreviousStateSaved", mPreviousStateSaved);
        // Adjust undo button (Deshacer) alpha
        if (mPreviousStateSaved) {
            changeButtonAlpha(R.id.undo_button, 1);
        }
        mResetAvailable = settings.getBoolean("mResetAvailable", mResetAvailable);
        // Adjust reset button (Reiniciar) alpha
        if (mResetAvailable) {
            changeButtonAlpha(R.id.reset_button, 1);
        }

        // Assign the corresponding TextView, to display score for team A
        mTeamATextView = findViewById(R.id.team_a_score);
        displayScore(mScoreTeamA, mTeamATextView);

        // Assign the corresponding TextView, to display score for team B
        mTeamBTextView = findViewById(R.id.team_b_score);
        displayScore(mScoreTeamB, mTeamBTextView);

        // Set copyright text
        TextView copyrightTextView = findViewById(R.id.copyright);
        MainActivity.setCopyrightText(copyrightTextView);
    }

    /**
     * This method saves the state of the app
     */
    @Override
    protected void onPause() {
        super.onPause();
        // Store the state of the app
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("mScoreTeamA", mScoreTeamA);
        editor.putInt("mPreviousScoreTeamA", mPreviousScoreTeamA);
        editor.putInt("mScoreTeamB", mScoreTeamB);
        editor.putInt("mPreviousScoreTeamB", mPreviousScoreTeamB);
        editor.putBoolean("mGameOver", mGameOver);
        editor.putBoolean("mPreviousGameOver", mPreviousGameOver);
        editor.putBoolean("mPreviousStateSaved", mPreviousStateSaved);
        editor.putBoolean("mResetAvailable", mResetAvailable);
        editor.commit();
    }

    /**
     * This method displays the score for teams based on the score and TextView indicated
     *
     * @param pScoreToDisplay
     * @param pTeamTextView
     */
    private void displayScore(int pScoreToDisplay, TextView pTeamTextView) {
        pTeamTextView.setText(Integer.toString(pScoreToDisplay));
    }

    /**
     * This method add 9 points to Team A. This kind of scoring is called Moñona
     *
     * @param pView
     */
    public void mononaTeamA(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamA += 9;
            displayScore(mScoreTeamA, mTeamATextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 9 points to Team B. This kind of scoring is called Moñona
     *
     * @param pView
     */
    public void mononaTeamB(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamB += 9;
            displayScore(mScoreTeamB, mTeamBTextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 6 points to Team A. This kind of scoring is called Embocinada
     *
     * @param pView
     */
    public void embocinadaTeamA(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamA += 6;
            displayScore(mScoreTeamA, mTeamATextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 6 points to Team B. This kind of scoring is called Embocinada
     *
     * @param pView
     */
    public void embocinadaTeamB(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamB += 6;
            displayScore(mScoreTeamB, mTeamBTextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 3 points to Team A. This kind of scoring is called Mecha
     *
     * @param pView
     */
    public void mechaTeamA(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamA += 3;
            displayScore(mScoreTeamA, mTeamATextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 3 points to Team B. This kind of scoring is called Mecha
     *
     * @param pView
     */
    public void mechaTeamB(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamB += 3;
            displayScore(mScoreTeamB, mTeamBTextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 1 point to Team A. This kind of scoring is called Mano
     *
     * @param pView
     */
    public void manoTeamA(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamA++;
            displayScore(mScoreTeamA, mTeamATextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method add 1 point to Team B. This kind of scoring is called Mano
     *
     * @param pView
     */
    public void manoTeamB(View pView) {
        if (!mGameOver) {
            saveState();
        }
        // The game ends when a team reaches 27 points
        checkForGameOver();
        if (!mGameOver) {
            mScoreTeamB++;
            displayScore(mScoreTeamB, mTeamBTextView);
            checkForGameOver();
        } else {
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method checks if the game has ended, by checking if either team has reached 27 points.
     * If so it activates the corresponding TextView to let the user know which team had won the
     * game.
     */
    private void checkForGameOver() {
        if (mScoreTeamA >= 27 && !mGameOver) {
            // This TextView is below the teamATextView and it is shown if team A wins the game
            changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 1);
            mGameOver = true;
            createToastShort(R.string.tejo_game_over);
        } else if (mScoreTeamB >= 27 && !mGameOver) {
            //This TextView is below the teamBTextView and it is shown if team B wins the game
            changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 1);
            mGameOver = true;
            createToastShort(R.string.tejo_game_over);
        }
    }

    /**
     * This method save the state of the variables scoreTeamA, scoreTeamB and gameOver for the undo
     * button (Deshacer)
     */
    private void saveState() {
        mPreviousScoreTeamA = mScoreTeamA;
        mPreviousScoreTeamB = mScoreTeamB;
        mPreviousGameOver = mGameOver;
        if (!mPreviousStateSaved) {
            changeButtonAlpha(R.id.undo_button, 1.0f);
            mPreviousStateSaved = true;
        }
        if (!mResetAvailable) {
            changeButtonAlpha(R.id.reset_button, 1.0f);
            mResetAvailable = true;
        }
    }

    /**
     * This method returns to the previous state the variables: scoreTeamA, scoreTeamB, and gameOver
     * and displays them accordingly
     *
     * @param pView
     */
    public void undo(View pView) {
        if (!mResetAvailable && mPreviousStateSaved) {
            changeButtonAlpha(R.id.reset_button, 1.0f);
            mResetAvailable = true;
        }
        // If the winner (¡Ganador!) TextView is visible for any of the teams, set it to not visible
        if (mGameOver && mPreviousStateSaved) {
            if (mScoreTeamA >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 0);
            } else if (mScoreTeamB >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 0);
            }
        }
        if (mPreviousStateSaved) {
            changeButtonAlpha(R.id.undo_button, 0.25f);
            mPreviousStateSaved = false;
        }
        mScoreTeamA = mPreviousScoreTeamA;
        displayScore(mScoreTeamA, mTeamATextView);
        mScoreTeamB = mPreviousScoreTeamB;
        displayScore(mScoreTeamB, mTeamBTextView);
        checkForGameOver();
        mGameOver = mPreviousGameOver;
    }

    /**
     * This method changes the alpha of the undo button (Deshacer)
     */
    private void changeButtonAlpha(int pIdButton, float pAlpha) {
        Button button = findViewById(pIdButton);
        button.setAlpha(pAlpha);
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
    public void share(View pView) {
        String body = getString(R.string.tejo_body_part_one) + "  " + mScoreTeamA;
        if (mGameOver && mScoreTeamA >= 27) {
            body += "  " + getString(R.string.tejo_winner);
        }
        body += getString(R.string.tejo_body_part_two) + "  " + mScoreTeamB;
        if (mGameOver && mScoreTeamB >= 27) {
            body += "  " + getString(R.string.tejo_winner);
        }
        body += getString(R.string.tejo_body_part_three);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.tejo_email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Inform the user there is no email app installed on the phone
            createToastShort(R.string.tejo_error_email);
        }
    }

    /**
     * This method creates and styles a short toast
     */
    private void createToastShort(int pMessage) {
        Toast toast = Toast.makeText(this, pMessage, Toast.LENGTH_SHORT);
        // If the user is using a version of Android greater than 21, style the toast
        if (Build.VERSION.SDK_INT >= 21) {
            View viewToast = toast.getView();
            viewToast.setBackgroundTintList(ColorStateList.valueOf(getResources().
                    getColor(R.color.colorAccent)));
            TextView text = viewToast.findViewById(android.R.id.message);
            text.setTextColor(getResources().getColor(R.color.colorPrimaryText));
            text.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        toast.show();
    }

    /**
     * This method resets the game
     *
     * @param pView
     */
    public void reset(View pView) {
        // If the winner (¡Ganador!) TextView is visible for any of the teams, set it to not visible
        if (mGameOver) {
            if (mScoreTeamA >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_a_text_view, 0);
            } else if (mScoreTeamB >= 27) {
                changeWinnerTextViewAlpha(R.id.winner_team_b_text_view, 0);
            }
        }
        if (mResetAvailable) {
            saveState();
        }
        mScoreTeamA = 0;
        displayScore(mScoreTeamA, mTeamATextView);
        mScoreTeamB = 0;
        displayScore(mScoreTeamB, mTeamBTextView);
        mGameOver = false;
        mResetAvailable = false;
        changeButtonAlpha(R.id.reset_button, 0.25f);
    }
}
