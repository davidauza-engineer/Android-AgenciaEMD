package engineer.davidauza.agenciaemd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * QuestionAdapter is an ArrayAdapter that can provide the layout for each list item based on a
 * data source, which is a list of Question objects.
 */
public class QuestionAdapter extends ArrayAdapter {

    /**
     * Create a new QuestionAdapter object.
     *
     * @param pContext   is the current context (i.e. Activity) that the adapter is being created
     *                   in.
     * @param pQuestions is the list of Questions to be displayed.
     */
    public QuestionAdapter(Context pContext, ArrayList<Question> pQuestions) {
        super(pContext, 0, pQuestions);
    }

    @Override
    public View getView(int pPosition, View pConvertView, ViewGroup pParent) {

        View listItemView = pConvertView;

        // Inflate the View
        listItemView = LayoutInflater.from(getContext()).
                inflate(R.layout.question_layout, pParent, false);

        // Get the Question object located at this position in the list
        Question currentQuestion = (Question) getItem(pPosition);

        // Find the header TextView in the question_layout.xml layout with the ID question_header.
        TextView headerTextView = listItemView.findViewById(R.id.question_header);
        // Get the Question header from the currentQuestion object and set this text on the header
        // TextView.
        headerTextView.setText(currentQuestion.getQuestionHeader());

        // Find the ImageView in the question_layout.xml layout with the ID question_picture.
        ImageView imageView = listItemView.findViewById(R.id.question_picture);
        // Display the provided image based on the resource ID.
        imageView.setImageResource(currentQuestion.getImageResourceId());

        // Find the body TextView in the question_layout.xml layout with the ID question_body.
        TextView bodyTextView = listItemView.findViewById(R.id.question_body);
        // Get the Question body from the currentQuestion object and set this text on the body
        // TextView.
        bodyTextView.setText(currentQuestion.getQuestionBody());
        // If API is greater than or equal to 26, justify the text
        MainActivity.justifyText(bodyTextView);

        // Find the first RadioButton in the question_layout.xml layout with the ID
        // yes_radio_button.
        RadioButton firstRadioButton = listItemView.findViewById(R.id.yes_radio_button);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getRadioButtonOneText() == null) {
            // If text has not been provided, hide the RadioButton
            firstRadioButton.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            firstRadioButton.setText(currentQuestion.getRadioButtonOneText());
        }

        // Find the second RadioButton in the question_layout.xml layout with the ID
        // no_radio_button.
        RadioButton secondRadioButton = listItemView.findViewById(R.id.no_radio_button);
        // Check if a String has been provided for field or not
        if (currentQuestion.getRadioButtonTwoText() == null) {
            // If text has not been provided, hide the RadioButton
            secondRadioButton.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            secondRadioButton.setText(currentQuestion.getRadioButtonTwoText());
        }

        // Find the first CheckBox in the question_layout.xml layout with the ID checkbox_one.
        CheckBox firstCheckBox = listItemView.findViewById(R.id.checkbox_one);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxOneText() == null) {
            // If text has not been provided, hide the CheckBox
            firstCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            firstCheckBox.setText(currentQuestion.getCheckBoxOneText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(firstCheckBox);
        }

        // Find the second CheckBox in the question_layout.xml layout with the ID checkbox_two.
        CheckBox secondCheckBox = listItemView.findViewById(R.id.checkbox_two);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxTwoText() == null) {
            // If text has not been provided, hide the CheckBox
            secondCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            secondCheckBox.setText(currentQuestion.getCheckBoxTwoText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(secondCheckBox);
        }

        // Find the third CheckBox in the question_layout.xml layout with the ID checkbox_three.
        CheckBox thirdCheckBox = listItemView.findViewById(R.id.checkbox_three);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxThreeText() == null) {
            // If text has not been provided, hide the CheckBox
            thirdCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            thirdCheckBox.setText(currentQuestion.getCheckBoxThreeText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(thirdCheckBox);
        }

        // Find the fourth CheckBox in the question_layout.xml layout with the ID checkbox_four.
        CheckBox fourthCheckBox = listItemView.findViewById(R.id.checkbox_four);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxFourText() == null) {
            // If text has not been provided, hide the CheckBox
            fourthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            fourthCheckBox.setText(currentQuestion.getCheckBoxFourText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(fourthCheckBox);
        }

        // Find the fifth CheckBox in the question_layout.xml layout with the ID checkbox_five.
        CheckBox fifthCheckBox = listItemView.findViewById(R.id.checkbox_five);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxFiveText() == null) {
            // If text has not been provided, hide the CheckBox
            fifthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            fifthCheckBox.setText(currentQuestion.getCheckBoxFiveText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(fifthCheckBox);
        }

        // Find the sixth CheckBox in the question_layout.xml layout with the ID checkbox_six.
        CheckBox sixthCheckBox = listItemView.findViewById(R.id.checkbox_six);
        // Check if a String has been provided for this field or not
        if (currentQuestion.getCheckBoxSixText() == null) {
            // If text has not been provided, hide the CheckBox
            sixthCheckBox.setVisibility(View.GONE);
        } else {
            // If text has been provided, get the text and display it
            sixthCheckBox.setText(currentQuestion.getCheckBoxSixText());
            // If API is greater than or equal to 26, justify the text
            MainActivity.justifyText(sixthCheckBox);
        }

        // Return the whole question layout layout so that it can be shown in the ListView
        return listItemView;
    }
}