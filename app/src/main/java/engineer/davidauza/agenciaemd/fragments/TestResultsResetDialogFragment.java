package engineer.davidauza.agenciaemd.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.activities.TestMainActivity;
import engineer.davidauza.agenciaemd.adapters.QuestionAdapter;

/**
 * This class handles the Dialog created when the user wants to reset its answers
 */
public class TestResultsResetDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.test_results_reset_title);
        builder.setMessage(R.string.test_results_reset_body);
        builder.setNegativeButton(R.string.test_results_reset_no,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        builder.setPositiveButton(R.string.test_results_reset_yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set back all the answers to its default state
                        SharedPreferences settings = getContext().
                                getSharedPreferences(QuestionAdapter.PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        // Company name
                        editor.putString("mCompanyName", "");
                        // Need to reflect changes immediately
                        editor.commit();
                        //MainTestQuestion One
                        editor.putBoolean("QuestionOneCheckBoxOne", false);
                        editor.putBoolean("QuestionOneCheckBoxTwo", false);
                        editor.putBoolean("QuestionOneCheckBoxThree", false);
                        editor.putBoolean("QuestionOneCheckBoxFour", false);
                        // MainTestQuestion Two
                        editor.putBoolean("QuestionTwoRadioButtonOne", false);
                        editor.putBoolean("QuestionTwoRadioButtonTwo", false);
                        //MainTestQuestion Three
                        editor.putBoolean("QuestionThreeRadioButtonOne", false);
                        editor.putBoolean("QuestionThreeRadioButtonTwo", false);
                        // MainTestQuestion Four
                        editor.putBoolean("QuestionFourCheckBoxOne", false);
                        editor.putBoolean("QuestionFourCheckBoxTwo", false);
                        editor.putBoolean("QuestionFourCheckBoxThree", false);
                        editor.putBoolean("QuestionFourCheckBoxFour", false);
                        editor.putBoolean("QuestionFourCheckBoxFive", false);
                        editor.putBoolean("QuestionFourCheckBoxSix", false);
                        // MainTestQuestion Five
                        editor.putBoolean("QuestionFiveCheckBoxOne", false);
                        editor.putBoolean("QuestionFiveCheckBoxTwo", false);
                        editor.putBoolean("QuestionFiveCheckBoxThree", false);
                        editor.putBoolean("QuestionFiveCheckBoxFour", false);
                        // MainTestQuestion Six
                        editor.putBoolean("QuestionSixRadioButtonOne", false);
                        editor.putBoolean("QuestionSixRadioButtonTwo", false);
                        // MainTestQuestion Seven
                        editor.putBoolean("QuestionSevenRadioButtonOne", false);
                        editor.putBoolean("QuestionSevenRadioButtonTwo", false);
                        // MainTestQuestion Eight
                        editor.putBoolean("QuestionEightCheckBoxOne", false);
                        editor.putBoolean("QuestionEightCheckBoxTwo", false);
                        editor.putBoolean("QuestionEightCheckBoxThree", false);
                        editor.putBoolean("QuestionEightCheckBoxFour", false);
                        editor.putBoolean("QuestionEightCheckBoxFive", false);
                        editor.putBoolean("QuestionEightCheckBoxSix", false);
                        // MainTestQuestion Nine
                        editor.putBoolean("QuestionNineCheckBoxOne", false);
                        editor.putBoolean("QuestionNineCheckBoxTwo", false);
                        editor.putBoolean("QuestionNineCheckBoxThree", false);
                        editor.putBoolean("QuestionNineCheckBoxFour", false);
                        // MainTestQuestion Ten
                        editor.putBoolean("QuestionTenRadioButtonOne", false);
                        editor.putBoolean("QuestionTenRadioButtonTwo", false);

                        editor.apply();

                        // Finish the TestResultsActivity Activity
                        getActivity().finish();

                        // Set reset to true in TestMainActivity so the Activity gets restarted when
                        // resumed
                        TestMainActivity.reset = true;
                    }
                });
        return builder.create();
    }
}
