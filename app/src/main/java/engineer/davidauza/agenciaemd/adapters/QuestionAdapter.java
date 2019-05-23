package engineer.davidauza.agenciaemd.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.activities.MainActivity;
import engineer.davidauza.agenciaemd.models.MainTestQuestion;

/**
 * QuestionAdapter is an ArrayAdapter that can provide the layout for each list item based on a
 * data source, which is a list of MainTestQuestion objects.
 */
public class QuestionAdapter extends ArrayAdapter<MainTestQuestion> {

    // The name of the file to store the state so it can be recovered
    public static final String PREFS_NAME = "MyPrefsFile";

    // Create SharedPreferences to restore the state of the activity
    private SharedPreferences mSettings = getContext().getSharedPreferences(PREFS_NAME, 0);

    /**
     * Listener for the first RadioButton. It saves the state of the first RadioButton of each
     * question once the state of the RadioGroup is changed.
     */
    private CompoundButton.OnCheckedChangeListener mRadioButtonOneListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneRadioButtonOne", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoRadioButtonOne", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeRadioButtonOne", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourRadioButtonOne", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveRadioButtonOne", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixRadioButtonOne", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenRadioButtonOne", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightRadioButtonOne", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineRadioButtonOne", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenRadioButtonOne", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the second RadioButton. It saves the state of the second RadioButton of each
     * question once the state of the RadioGroup is changed.
     */
    private CompoundButton.OnCheckedChangeListener mRadioButtonTwoListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneRadioButtonTwo", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoRadioButtonTwo", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeRadioButtonTwo", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourRadioButtonTwo", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveRadioButtonTwo", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixRadioButtonTwo", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenRadioButtonTwo", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightRadioButtonTwo", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineRadioButtonTwo", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenRadioButtonTwo", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the first CheckBox. It saves the state of the first CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxOneListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxOne", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxOne", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxOne", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxOne", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxOne", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxOne", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxOne", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxOne", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxOne", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxOne", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the second CheckBox. It saves the state of the second CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxTwoListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxTwo", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxTwo", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxTwo", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxTwo", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxTwo", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxTwo", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxTwo", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxTwo", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxTwo", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxTwo", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the third CheckBox. It saves the state of the third CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxThreeListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxThree", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxThree", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxThree", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxThree", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxThree", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxThree", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxThree", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxThree", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxThree", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxThree", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the fourth CheckBox. It saves the state of the fourth CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxFourListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxFour", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxFour", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxFour", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxFour", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxFour", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxFour", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxFour", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxFour", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxFour", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxFour", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the fifth CheckBox. It saves the state of the fifth CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxFiveListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxFive", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxFive", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxFive", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxFive", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxFive", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxFive", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxFive", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxFive", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxFive", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxFive", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Listener for the sixth CheckBox. It saves the state of the sixth CheckBox of each
     * question once the state of that CheckBox is changed.
     */
    private CompoundButton.OnCheckedChangeListener mCheckBoxSixListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SharedPreferences.Editor editor = mSettings.edit();
                    switch (buttonView.getTag().toString()) {
                        case "0":
                            editor.putBoolean("QuestionOneCheckBoxSix", isChecked);
                            break;
                        case "1":
                            editor.putBoolean("QuestionTwoCheckBoxSix", isChecked);
                            break;
                        case "2":
                            editor.putBoolean("QuestionThreeCheckBoxSix", isChecked);
                            break;
                        case "3":
                            editor.putBoolean("QuestionFourCheckBoxSix", isChecked);
                            break;
                        case "4":
                            editor.putBoolean("QuestionFiveCheckBoxSix", isChecked);
                            break;
                        case "5":
                            editor.putBoolean("QuestionSixCheckBoxSix", isChecked);
                            break;
                        case "6":
                            editor.putBoolean("QuestionSevenCheckBoxSix", isChecked);
                            break;
                        case "7":
                            editor.putBoolean("QuestionEightCheckBoxSix", isChecked);
                            break;
                        case "8":
                            editor.putBoolean("QuestionNineCheckBoxSix", isChecked);
                            break;
                        case "9":
                            editor.putBoolean("QuestionTenCheckBoxSix", isChecked);
                            break;
                    }
                    editor.apply();
                }
            };

    /**
     * Create a new QuestionAdapter object.
     *
     * @param pContext   is the current context (i.e. Activity) that the adapter is being created
     *                   in.
     * @param pQuestions is the list of Questions to be displayed.
     */
    public QuestionAdapter(Context pContext, ArrayList<MainTestQuestion> pQuestions) {
        super(pContext, 0, pQuestions);
    }

    @Override
    public View getView(final int pPosition, View pConvertView, ViewGroup pParent) {

        // Inflate the View
        pConvertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_test_main_question, pParent, false);

        // Get the MainTestQuestion object located at this position in the list
        MainTestQuestion currentQuestion = (MainTestQuestion) getItem(pPosition);

        // Find the header TextView in the item_test_main_question.xmlayout with the ID question_header.
        TextView headerTextView = pConvertView.findViewById(R.id.question_header);
        // Get the MainTestQuestion header from the currentQuestion object and set this text on the header
        // TextView.
        headerTextView.setText(currentQuestion.getQuestionHeader());

        // Find the ImageView in the item_questionml layout with the ID question_picture.
        ImageView imageView = pConvertView.findViewById(R.id.question_picture);
        // Display the provided image based on the resource ID.
        imageView.setImageResource(currentQuestion.getImageResourceId());

        // Find the body TextView in the item_questionml layout with the ID question_body.
        TextView bodyTextView = pConvertView.findViewById(R.id.question_body);
        // Get the MainTestQuestion body from the currentQuestion object and set this text on the body
        // TextView.
        bodyTextView.setText(currentQuestion.getQuestionBody());
        // If API is greater than or equal to 26, justify the text
        MainActivity.justifyText(bodyTextView);

        // Find the first RadioButton in the item_test_main_question.xmlayout with the ID
        // yes_radio_button.
        RadioButton firstRadioButton = pConvertView.findViewById(R.id.yes_radio_button);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getRadioButtonOneText() == null) {
            // If text has not been provided, hide the RadioButton
            firstRadioButton.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            firstRadioButton.setText(currentQuestion.getRadioButtonOneText());

            // Set a tag to the RadioButton so it can be recognized by the listener
            firstRadioButton.setTag(pPosition);

            // Set the proper listener
            firstRadioButton.setOnCheckedChangeListener(mRadioButtonOneListener);

            // Update the UI by loading the state of the button
            firstRadioButton.setChecked(loadRadioButtonOne(firstRadioButton.getTag().toString()));
        }

        // Find the second RadioButton in the item_test_main_question.xmlayout with the ID
        // no_radio_button.
        RadioButton secondRadioButton = pConvertView.findViewById(R.id.no_radio_button);
        // Check if a String has been provided for field or not
        if (currentQuestion.getRadioButtonTwoText() == null) {
            // If text has not been provided, hide the RadioButton
            secondRadioButton.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            secondRadioButton.setText(currentQuestion.getRadioButtonTwoText());

            // Set a tag to the RadioButton so it can be recognized by the listener
            secondRadioButton.setTag(pPosition);

            // Set the proper listener
            secondRadioButton.setOnCheckedChangeListener(mRadioButtonTwoListener);

            // Update the UI by loading the state of the button
            secondRadioButton.setChecked(loadRadioButtonTwo(secondRadioButton.getTag().toString()));
        }

        // Find the first CheckBox in the item_questionml layout with the ID checkbox_one.
        CheckBox firstCheckBox = pConvertView.findViewById(R.id.checkbox_one);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxOneText() == null) {
            // If text has not been provided, hide the CheckBox
            firstCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            firstCheckBox.setText(currentQuestion.getCheckBoxOneText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(firstCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            firstCheckBox.setTag(pPosition);

            // Set the proper listener
            firstCheckBox.setOnCheckedChangeListener(mCheckBoxOneListener);

            // Update the UI by loading the state of the CheckBox
            firstCheckBox.setChecked(loadCheckBoxOne(firstCheckBox.getTag().toString()));
        }

        // Find the second CheckBox in the item_test_main_question.xmlayout with the ID checkbox_two.
        CheckBox secondCheckBox = pConvertView.findViewById(R.id.checkbox_two);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxTwoText() == null) {
            // If text has not been provided, hide the CheckBox
            secondCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            secondCheckBox.setText(currentQuestion.getCheckBoxTwoText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(secondCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            secondCheckBox.setTag(pPosition);

            // Set the proper listener
            secondCheckBox.setOnCheckedChangeListener(mCheckBoxTwoListener);

            // Update the UI by loading the state of the CheckBox
            secondCheckBox.setChecked(loadCheckBoxTwo(secondCheckBox.getTag().toString()));
        }

        // Find the third CheckBox in the item_questionml layout with the ID checkbox_three.
        CheckBox thirdCheckBox = pConvertView.findViewById(R.id.checkbox_three);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxThreeText() == null) {
            // If text has not been provided, hide the CheckBox
            thirdCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            thirdCheckBox.setText(currentQuestion.getCheckBoxThreeText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(thirdCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            thirdCheckBox.setTag(pPosition);

            // Set the proper listener
            thirdCheckBox.setOnCheckedChangeListener(mCheckBoxThreeListener);

            // Update the UI by loading the state of the CheckBox
            thirdCheckBox.setChecked(loadCheckBoxThree(thirdCheckBox.getTag().toString()));
        }

        // Find the fourth CheckBox in the item_questionml layout with the ID checkbox_four.
        CheckBox fourthCheckBox = pConvertView.findViewById(R.id.checkbox_four);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxFourText() == null) {
            // If text has not been provided, hide the CheckBox
            fourthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            fourthCheckBox.setText(currentQuestion.getCheckBoxFourText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(fourthCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            fourthCheckBox.setTag(pPosition);

            // Set the proper listener
            fourthCheckBox.setOnCheckedChangeListener(mCheckBoxFourListener);

            // Update the UI by loading the state of the CheckBox
            fourthCheckBox.setChecked(loadCheckBoxFour(fourthCheckBox.getTag().toString()));
        }

        // Find the fifth CheckBox in the item_questionml layout with the ID checkbox_five.
        CheckBox fifthCheckBox = pConvertView.findViewById(R.id.checkbox_five);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxFiveText() == null) {
            // If text has not been provided, hide the CheckBox
            fifthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            fifthCheckBox.setText(currentQuestion.getCheckBoxFiveText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(fifthCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            fifthCheckBox.setTag(pPosition);

            // Set the proper listener
            fifthCheckBox.setOnCheckedChangeListener(mCheckBoxFiveListener);

            // Update the UI by loading the state of the CheckBox
            fifthCheckBox.setChecked(loadCheckBoxFive(fifthCheckBox.getTag().toString()));
        }

        // Find the sixth CheckBox in the item_test_main_question.xmlayout with the ID checkbox_six.
        CheckBox sixthCheckBox = pConvertView.findViewById(R.id.checkbox_six);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxSixText() == null) {
            // If text has not been provided, hide the CheckBox
            sixthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            sixthCheckBox.setText(currentQuestion.getCheckBoxSixText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(sixthCheckBox);

            // Set a tag to the CheckBox so it can be recognized by the listener
            sixthCheckBox.setTag(pPosition);

            // Set the proper listener
            sixthCheckBox.setOnCheckedChangeListener(mCheckBoxSixListener);

            // Update the UI by loading the state of the CheckBox
            sixthCheckBox.setChecked(loadCheckBoxSix(sixthCheckBox.getTag().toString()));
        }

        // Return the whole question layout layout so that it can be shown in the ListView
        return pConvertView;
    }


    /**
     * This method returns the saved value for the first RadioButton
     *
     * @param pTag The tag associated with the button loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadRadioButtonOne(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneRadioButtonOne", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoRadioButtonOne", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeRadioButtonOne", false);
            case "3":
                return mSettings.getBoolean("QuestionFourRadioButtonOne", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveRadioButtonOne", false);
            case "5":
                return mSettings.getBoolean("QuestionSixRadioButtonOne", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenRadioButtonOne", false);
            case "7":
                return mSettings.getBoolean("QuestionEightRadioButtonOne", false);
            case "8":
                return mSettings.getBoolean("QuestionNineRadioButtonOne", false);
            case "9":
                return mSettings.getBoolean("QuestionTenRadioButtonOne", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the second RadioButton
     *
     * @param pTag The tag associated with the button loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadRadioButtonTwo(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneRadioButtonTwo", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoRadioButtonTwo", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeRadioButtonTwo", false);
            case "3":
                return mSettings.getBoolean("QuestionFourRadioButtonTwo", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveRadioButtonTwo", false);
            case "5":
                return mSettings.getBoolean("QuestionSixRadioButtonTwo", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenRadioButtonTwo", false);
            case "7":
                return mSettings.getBoolean("QuestionEightRadioButtonTwo", false);
            case "8":
                return mSettings.getBoolean("QuestionNineRadioButtonTwo", false);
            case "9":
                return mSettings.getBoolean("QuestionTenRadioButtonTwo", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the first CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxOne(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxOne", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxOne", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxOne", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxOne", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxOne", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxOne", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxOne", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxOne", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxOne", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxOne", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the second CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxTwo(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxTwo", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxTwo", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxTwo", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxTwo", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxTwo", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxTwo", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxTwo", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxTwo", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxTwo", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxTwo", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the third CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxThree(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxThree", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxThree", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxThree", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxThree", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxThree", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxThree", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxThree", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxThree", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxThree", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxThree", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the fourth CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxFour(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxFour", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxFour", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxFour", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxFour", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxFour", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxFour", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxFour", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxFour", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxFour", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxFour", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the fifth CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxFive(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxFive", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxFive", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxFive", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxFive", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxFive", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxFive", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxFive", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxFive", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxFive", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxFive", false);
            default:
                return false;
        }
    }

    /**
     * This method returns the saved value for the sixth CheckBox
     *
     * @param pTag The tag associated with the CheckBox loading the information
     * @return The value stored for the tag indicated. If the value is not found, it returns false
     */
    private boolean loadCheckBoxSix(String pTag) {
        switch (pTag) {
            case "0":
                return mSettings.getBoolean("QuestionOneCheckBoxSix", false);
            case "1":
                return mSettings.getBoolean("QuestionTwoCheckBoxSix", false);
            case "2":
                return mSettings.getBoolean("QuestionThreeCheckBoxSix", false);
            case "3":
                return mSettings.getBoolean("QuestionFourCheckBoxSix", false);
            case "4":
                return mSettings.getBoolean("QuestionFiveCheckBoxSix", false);
            case "5":
                return mSettings.getBoolean("QuestionSixCheckBoxSix", false);
            case "6":
                return mSettings.getBoolean("QuestionSevenCheckBoxSix", false);
            case "7":
                return mSettings.getBoolean("QuestionEightCheckBoxSix", false);
            case "8":
                return mSettings.getBoolean("QuestionNineCheckBoxSix", false);
            case "9":
                return mSettings.getBoolean("QuestionTenCheckBoxSix", false);
            default:
                return false;
        }
    }
}