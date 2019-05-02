package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class calculates the results of the test based on the answers provided by the user
 */
public class TestResults extends AppCompatActivity {

    /**
     * Each question has a total of 10 points
     * The following array stores the corresponding score for each question. e.g.
     * scoreArray[0][0] stores the score for the question 1, option 1, and so on
     *
     * IMPORTANT: This property should never be accessed directly
     */
    byte[][] scoreArray = new byte[10][6];

    /**
     * This method creates an email intent
     *
     * @param pContext        The context of the activity trying to create the email
     * @param pTo             The email address to send the email
     * @param pCc             The email address to send the email in CC mode
     * @param pSubject        The subject of the email
     * @param pBody           The body text of the email
     * @param pErrorMessageId The error message in case the user does not have an email app
     */
    public static void sendEmail(Context pContext,
                                 String[] pTo,
                                 String[] pCc,
                                 String pSubject,
                                 String pBody,
                                 int pErrorMessageId) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, pTo);
        intent.putExtra(Intent.EXTRA_CC, pCc);
        intent.putExtra(Intent.EXTRA_SUBJECT, pSubject);
        intent.putExtra(Intent.EXTRA_TEXT, pBody);
        if (intent.resolveActivity(pContext.getPackageManager()) != null) {
            pContext.startActivity(intent);
        } else {
            TejoCounter.createToastShort(pContext, pErrorMessageId);
        }
    }

    /**
     * This function will only fill the array if it hasn't been fille before
     * @return byte[][] -- Multidimensional array with question/answer indexes and scores
     */
    private byte[][] getScoreArray()
    {
        // Pretty simple way to check if the array has been filled or not
        if (scoreArray[0][0] == 0) {
            // Score for question 1
            //Option 1
            scoreArray[0][0] = 3;
            // Option 2
            scoreArray[0][1] = 3;
            // Option 3
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
        }

        return scoreArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);

        // Tracks the score based on the answers of the user
        byte score = 0;

        // Get the SharedPreferences file from TestActivity class to be able to access its data
        SharedPreferences settings = getSharedPreferences(QuestionAdapter.PREFS_NAME, 0);

        // Add the score corresponding to question One
        score += getScore((byte) 0,
                settings.getBoolean("QuestionOneCheckBoxOne", false),
                settings.getBoolean("QuestionOneCheckBoxTwo", false),
                settings.getBoolean("QuestionOneCheckBoxThree", false),
                settings.getBoolean("QuestionOneCheckBoxFour", false));
        // Add the score corresponding to question Two
        score += getScore((byte) 1,
                settings.getBoolean("QuestionTwoRadioButtonOne", false));
        // Add the score corresponding to question Three
        score += getScore((byte) 2,
                settings.getBoolean("QuestionThreeRadioButtonOne", false));
        // Add the score corresponding to question Four
        score += getScore((byte) 3,
                settings.getBoolean("QuestionFourCheckBoxOne", false),
                settings.getBoolean("QuestionFourCheckBoxTwo", false),
                settings.getBoolean("QuestionFourCheckBoxThree", false),
                settings.getBoolean("QuestionFourCheckBoxFour", false),
                settings.getBoolean("QuestionFourCheckBoxFive", false),
                settings.getBoolean("QuestionFourCheckBoxSix", false));
        // Add the score corresponding to question Five
        score += getScore((byte) 4,
                settings.getBoolean("QuestionFiveCheckBoxOne", false),
                settings.getBoolean("QuestionFiveCheckBoxTwo", false),
                settings.getBoolean("QuestionFiveCheckBoxThree", false),
                settings.getBoolean("QuestionFiveCheckBoxFour", false));
        // Add the score corresponding to question Six
        score += getScore((byte) 5,
                settings.getBoolean("QuestionSixRadioButtonOne", false));
        // Add the score corresponding to question Seven
        score += getScore((byte) 6,
                settings.getBoolean("QuestionSevenRadioButtonOne", false));
        // Add the score corresponding to question Eight
        score += getScore((byte) 7,
                settings.getBoolean("QuestionEightCheckBoxOne", false),
                settings.getBoolean("QuestionEightCheckBoxTwo", false),
                settings.getBoolean("QuestionEightCheckBoxThree", false),
                settings.getBoolean("QuestionEightCheckBoxFour", false),
                settings.getBoolean("QuestionEightCheckBoxFive", false),
                settings.getBoolean("QuestionEightCheckBoxSix", false));
        // Add the score corresponding to question Nine
        score += getScore((byte) 8,
                settings.getBoolean("QuestionNineCheckBoxOne", false),
                settings.getBoolean("QuestionNineCheckBoxTwo", false),
                settings.getBoolean("QuestionNineCheckBoxThree", false),
                settings.getBoolean("QuestionNineCheckBoxFour", false));
        // Add the score corresponding to question Ten
        score += getScore((byte) 9,
                settings.getBoolean("QuestionTenRadioButtonOne", false));

        // Get the company name and set it up
        TextView companyName = findViewById(R.id.company_name);
        companyName.setText(settings.getString("mCompanyName", ""));

        // Set the score in its corresponding TextView
        TextView scoreTextView = findViewById(R.id.company_score);
        scoreTextView.setText(Byte.toString(score));

        // Set the results text
        TextView resultsBodyTextView = findViewById(R.id.results_body);
        if (score <= 40) {
            resultsBodyTextView.setText(R.string.results_under_forty_one);
        } else if (score <= 80) {
            resultsBodyTextView.setText(R.string.results_under_eighty_one);
        } else {
            resultsBodyTextView.setText(R.string.results_under_one_hundred_one);
        }
        MainActivity.justifyText(resultsBodyTextView);

        // Set the reset button
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        // Set Copyright TextView
        TextView copyright = findViewById(R.id.copyright);
        MainActivity.setCopyrightText(copyright);
    }

    /**
     * This method returns the score for a given question. It is used for questions with four
     * CheckBoxes.
     *
     * @param pQuestionIndex The index of the question related to the scoreArray
     * @param pOptionOne     True if the CheckBox One is checked, false if it is not
     * @param pOptionTwo     True if the CheckBox Two is checked, false if it is not
     * @param pOptionThree   True if the CheckBox Three is checked, false if it is not
     * @param pOptionFour    True if the CheckBox Four is checked, false if it is not
     * @return The score according to the options selected by the user
     */
    public byte getScore(byte pQuestionIndex,
                          boolean pOptionOne,
                          boolean pOptionTwo,
                          boolean pOptionThree,
                          boolean pOptionFour) {
        byte scoreToReturn = 0;
        byte optionIndex = 0;

        // If the user selected the first CheckBox, add its corresponding score
        if (pOptionOne) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the second CheckBox, add its corresponding score
        if (pOptionTwo) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the third CheckBox, add its corresponding score
        if (pOptionThree) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the fourth CheckBox, add its corresponding score
        if (pOptionFour) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }

        return scoreToReturn;
    }

    /**
     * This method returns the score for a given question. It is used for questions with six
     * CheckBoxes.
     *
     * @param pQuestionIndex The index of the question related to the scoreArray
     * @param pOptionOne     True if the CheckBox One is checked, false if it is not
     * @param pOptionTwo     True if the CheckBox Two is checked, false if it is not
     * @param pOptionThree   True if the CheckBox Three is checked, false if it is not
     * @param pOptionFour    True if the CheckBox Four is checked, false if it is not
     * @param pOptionFive    True if the CheckBox Five is checked, false if it is not
     * @param pOptionSix     True if the CheckBox Six is checked, false if it is not
     * @return The score according to the options selected by the user
     */
    public byte getScore(byte pQuestionIndex,
                          boolean pOptionOne,
                          boolean pOptionTwo,
                          boolean pOptionThree,
                          boolean pOptionFour,
                          boolean pOptionFive,
                          boolean pOptionSix) {
        byte scoreToReturn = 0;
        byte optionIndex = 0;

        // If the user selected the first CheckBox, add its corresponding score
        if (pOptionOne) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the second CheckBox, add its corresponding score
        if (pOptionTwo) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the third CheckBox, add its corresponding score
        if (pOptionThree) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the fourth CheckBox, add its corresponding score
        if (pOptionFour) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the fifth CheckBox, add its corresponding score
        if (pOptionFive) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }
        optionIndex++;

        // If the user selected the sixth CheckBox, add its corresponding score
        if (pOptionSix) {
            scoreToReturn += getScoreArray()[pQuestionIndex][optionIndex];
        }

        return scoreToReturn;
    }

    /**
     * This method finishes the Activity
     *
     * @param pView The back button
     */
    public void goBack(View pView) {
        finish();
    }

    /**
     * This method opens a dialog to confirm if the user really wants to reset its results
     */
    public void openDialog() {
        ResultsResetDialog dialog = new ResultsResetDialog();
        dialog.show(getSupportFragmentManager(), "ResultsDialog");
    }

    /**
     * This method returns the score for a given question. It is used for questions with two
     * RadioButtons.
     *
     * @param pQuestionIndex The index of the question related to the scoreArray
     * @param pOptionOne     True if the RadioButton One is checked, false if it is not. As there
     *                       are only two RadioButtons per question, and the first one is always a
     *                       Yes option which add 10 points, we only need to check if the
     *                       first one is checked to be able to decide which value to return
     * @return The score according to the options selected by the user
     */
    public byte getScore(byte pQuestionIndex,
                          boolean pOptionOne) {
        byte optionIndex = 0;

        if (pOptionOne) {
            return getScoreArray()[pQuestionIndex][optionIndex];
        } else {
            optionIndex++;
            return getScoreArray()[pQuestionIndex][optionIndex];
        }
    }

    /**
     * This method creates an email to share the results of the test with the company
     *
     * @param pView The send button
     */
    public void sendTestResults(View pView) {
        TextView companyName = findViewById(R.id.company_name);
        boolean hasName = !companyName.getText().equals("");
        TextView scoreTextView = findViewById(R.id.company_score);
        TextView resultsBodyTextView = findViewById(R.id.results_body);
        String body = getString(R.string.results_email_intro) +
                "\n\n\n" + getString(R.string.results_to);
        if (hasName) {
            body += "\n\n" + companyName.getText();
        } else {
            body += "\n\n" + getString(R.string.results_company_name_hint);
        }
        body += "\n\n" + getString(R.string.results_score) + " " + scoreTextView.getText() + " " +
                getString(R.string.results_total_score) +
                "\n\n" + resultsBodyTextView.getText() +
                "\n\n\n" + getString(R.string.results_email_regards);
        if (hasName) {
            body += "\n\n" + companyName.getText();
        } else {
            body += "\n\n" + getString(R.string.results_company_name_hint);
        }
        sendEmail(this,
                new String[]{getString(R.string.results_email_to)},
                new String[]{getString(R.string.results_email_cc)},
                getString(R.string.results_email_subject),
                body,
                R.string.results_error_email);
    }
}
