package engineer.davidauza.agenciaemd.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.adapters.QuestionAdapter;
import engineer.davidauza.agenciaemd.models.Question;

public class TestMainActivity extends AppCompatActivity {

    // The name of the file to store the state so it can be recovered
    public static final String PREFS_NAME = "MyPrefsFile";
    // The text contained in the EditText
    private String mCompanyName = "";
    // EditText for company's name
    private EditText mCompanyNameEditText;

    // This variable becomes true if the user resets its results in the TestResultsResetDialogFragment
    public static boolean reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        // Set the EditText content
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        mCompanyName = settings.getString("mCompanyName", mCompanyName);
        mCompanyNameEditText = findViewById(R.id.company_name);
        if (!mCompanyName.equals("")) {
            mCompanyNameEditText.setText(mCompanyName);
        }

        // Set TextInputLayout for EditText mCompanyName
        final TextInputLayout textInputLayout = findViewById(R.id.text_input_layout);
        ColorStateList hintColor = mCompanyNameEditText.getHintTextColors();
        textInputLayout.setHelperTextColor(hintColor);
        textInputLayout.setDefaultHintTextColor(hintColor);

        // Listener to check if the keyboard is being displayed. Implemented for portrait mode.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Find the root View
            final View activityRootView = findViewById(R.id.root_view);
            // Set a Layout Listener which listens for changes in the layout
            activityRootView.getViewTreeObserver().
                    addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            // Calculates the difference between the root view and the window size
                            int heightDifference = activityRootView.getRootView().getHeight() -
                                    activityRootView.getHeight();
                            // Get the keyboard
                            InputMethodManager imm =
                                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            // If the difference is greater than 200 dp, probably the keyboard is
                            // being displayed
                            if (heightDifference > dpToPx(getApplicationContext(),
                                    200)) {
                                // Check if the keyboard is actually active
                                if (imm.isAcceptingText()) {
                                    // The keyboard has been opened, so place the cursor at the
                                    // last character and set it to visible.
                                    adjustCursor(mCompanyNameEditText.getText().length(),
                                            true);
                                }
                            } else {
                                // A change in the layout less than or equal to 200 dp has been
                                // detected, we need to verify if the keyboard is open
                                if (imm.isAcceptingText()) {
                                    // The keyboard is about to be closed, so move the cursor to
                                    // the start of the text and set it to not visible
                                    adjustCursor(0, false);
                                    // If the user did input some text, save it so it can be
                                    // recovered later
                                    saveEditTextContent();
                                }
                            }
                        }
                    });
        }

        // Listener to save the content of the EditText when the user hits the Done button on the
        // keyboard. Implemented specifically to work on landscape mode.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mCompanyNameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        saveEditTextContent();
                    }
                    return false;
                }
            });
        }

        // Create the list of questions
        final ArrayList<Question> questions = new ArrayList<Question>();
        // Question one
        questions.add(new Question(getString(R.string.test_main_question_one_header),
                R.drawable.img_question_one, getString(R.string.test_main_question_one_body),
                getString(R.string.test_main_question_one_option_one),
                getString(R.string.test_main_question_one_option_two),
                getString(R.string.test_main_question_one_option_three),
                getString(R.string.test_main_question_one_option_four)));
        // Question two
        questions.add(new Question(getString(R.string.test_main_question_two_header),
                R.drawable.img_question_two,
                getString(R.string.test_main_question_two_body),
                getString(R.string.test_main_question_two_option_one),
                getString(R.string.test_main_question_two_option_two)));
        // Question three
        questions.add(new Question(getString(R.string.test_main_question_three_header),
                R.drawable.img_question_three,
                getString(R.string.test_main_question_three_body),
                getString(R.string.test_main_question_three_option_one),
                getString(R.string.test_main_question_three_option_two)));
        // Question four
        questions.add(new Question(getString(R.string.test_main_question_four_header),
                R.drawable.img_question_four,
                getString(R.string.test_main_question_four_body),
                getString(R.string.test_main_question_four_option_one),
                getString(R.string.test_main_question_four_option_two),
                getString(R.string.test_main_question_four_option_three),
                getString(R.string.test_main_question_four_option_four),
                getString(R.string.test_main_question_four_option_five),
                getString(R.string.test_main_question_four_option_six)));
        // Question five
        questions.add(new Question(getString(R.string.test_main_question_five_header),
                R.drawable.img_question_five,
                getString(R.string.test_main_question_five_body),
                getString(R.string.test_main_question_five_option_one),
                getString(R.string.test_main_question_five_option_two),
                getString(R.string.test_main_question_five_option_three),
                getString(R.string.test_main_question_five_option_four)));
        // Question six
        questions.add(new Question(getString(R.string.test_main_question_six_header),
                R.drawable.img_question_six,
                getString(R.string.test_main_question_six_body),
                getString(R.string.test_main_question_six_option_one),
                getString(R.string.test_main_question_six_option_two)));
        // Question seven
        questions.add(new Question(getString(R.string.test_main_question_seven_header),
                R.drawable.img_question_seven,
                getString(R.string.test_main_question_seven_body),
                getString(R.string.test_main_question_seven_option_one),
                getString(R.string.test_main_question_seven_option_two)));
        // Question eight
        questions.add(new Question(getString(R.string.test_main_question_eight_header),
                R.drawable.img_question_eight,
                getString(R.string.test_main_question_eight_body),
                getString(R.string.test_main_question_eight_option_one),
                getString(R.string.test_main_question_eight_option_two),
                getString(R.string.test_main_question_eight_option_three),
                getString(R.string.test_main_question_eight_option_four),
                getString(R.string.test_main_question_eight_option_five),
                getString(R.string.test_main_question_eight_option_six)));
        // Question nine
        questions.add(new Question(getString(R.string.test_main_question_nine_header),
                R.drawable.img_question_nine,
                getString(R.string.test_main_question_nine_body),
                getString(R.string.test_main_question_nine_option_one),
                getString(R.string.test_main_question_nine_option_two),
                getString(R.string.test_main_question_nine_option_three),
                getString(R.string.test_main_question_nine_option_four)));
        // Question ten
        questions.add(new Question(getString(R.string.test_main_question_ten_header),
                R.drawable.img_question_ten,
                getString(R.string.test_main_question_ten_body),
                getString(R.string.test_main_question_ten_option_one),
                getString(R.string.test_main_question_ten_option_two)));


        // Create a QuestionAdapter, whose data source is a list of Questions. The adapter knows
        // how to create list items for each item in the list.
        QuestionAdapter adapter = new QuestionAdapter(this, questions);

        // Find the ListView object in the view hierarchy of the Activity. There should be a
        // ListView with the ID called list_of_questions, which is declared in the
        // activity_test_main.xmln.xml layout file.
        ListView listView = findViewById(R.id.list_of_questions);

        // Make the ListView use the QuestionAdapter created above, so that the ListView will
        // display list items for each Question in the list.
        listView.setAdapter(adapter);
    }

    /**
     * When onPause check if there is text in the EditText. If so, save it.
     */
    @Override
    protected void onPause() {
        super.onPause();
        saveEditTextContent();
    }

    /**
     * This method converts a value from dp to px
     *
     * @param pContext   The application's context
     * @param pValueInDp The value in dp
     * @return The corresponding value in px
     */
    public static float dpToPx(Context pContext, float pValueInDp) {
        DisplayMetrics metrics = pContext.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pValueInDp, metrics);
    }

    /**
     * This method starts the TestResultsActivity Activity. If the keyboard is open it sets the cursor to
     * the start of the text and sets it to not visible
     *
     * @param view The button calling the method
     */
    public void goToTestResultsActivity(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            adjustCursor(0, false);
        }
        // Create a toast with a thank you message
        TejoCounterActivity.createToastShort(this, R.string.test_results_toast);
        Intent intent = new Intent(this, TestResultsActivity.class);
        startActivity(intent);
    }

    /**
     * This method places the cursor at a specific position and sets its visibility
     *
     * @param pCursorPosition   The position to place the cursor
     * @param pCursorVisibility Either, true for visible, or false for not visible
     */
    private void adjustCursor(int pCursorPosition, boolean pCursorVisibility) {
        mCompanyNameEditText.setSelection(pCursorPosition);
        mCompanyNameEditText.setCursorVisible(pCursorVisibility);
    }

    /**
     * This method saves the EditText content
     */
    private void saveEditTextContent() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("mCompanyName", mCompanyNameEditText.getText().toString());
        editor.apply();
    }

    /**
     * This method checks if the user did reset its results. If so it restarts the activity
     */
    @Override
    protected void onResume() {
        // If the user did reset its results, set reset to false, update UI accordingly and restart
        // the activity
        if (reset) {
            reset = false;
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            mCompanyNameEditText.setText(settings.getString("mCompanyName", ""));
            mCompanyNameEditText.clearFocus();
            recreate();
        }
        super.onResume();
    }
}