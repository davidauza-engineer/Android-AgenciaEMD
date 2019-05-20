package engineer.davidauza.agenciaemd.models;

/**
 * This class represents a question.
 * It contains a question header, a picture related to the question, the body of the question, in
 * some cases two RadioButtons, in some cases four CheckBoxes, and in some other cases six
 * CheckBoxes.
 */
public class Question {

    /**
     * The header of each question
     */
    private String mQuestionHeader;
    /**
     * Image resource ID for the question
     */
    private int mImageResourceId;

    /**
     * The body of each question
     */
    private String mQuestionBody;

    /**
     * Text for RadioButton 1
     */
    private String mRadioButtonOneText;

    /**
     * Text for RadioButton 2
     */
    private String mRadioButtonTwoText;

    /**
     * Text for the first CheckBox
     */
    private String mCheckBoxOneText;

    /**
     * Text for the second CheckBox
     */
    private String mCheckBoxTwoText;

    /**
     * Text for the third CheckBox
     */
    private String mCheckBoxThreeText;

    /**
     * Text for the fourth CheckBox
     */
    private String mCheckBoxFourText;

    /**
     * Text for the fifth CheckBox
     */
    private String mCheckBoxFiveText;

    /**
     * Text for the sixth CheckBox
     */
    private String mCheckBoxSixText;

    /**
     * Create a new Question object, when the question uses RadioButtons.
     *
     * @param pQuestionHeader     The header of each question
     * @param pImageResourceId    Image resource ID for the question
     * @param pQuestionBody       The body of each question
     * @param pRadioButtonOneText Text for RadioButton 1
     * @param pRadioButtonTwoText Text for RadioButton 2
     */
    public Question(String pQuestionHeader,
                    int pImageResourceId,
                    String pQuestionBody,
                    String pRadioButtonOneText,
                    String pRadioButtonTwoText) {

        mQuestionHeader = pQuestionHeader;
        mImageResourceId = pImageResourceId;
        mQuestionBody = pQuestionBody;
        mRadioButtonOneText = pRadioButtonOneText;
        mRadioButtonTwoText = pRadioButtonTwoText;
    }

    /**
     * Create a new Question object, when the question uses CheckBoxes and four possible answers.
     *
     * @param pQuestionHeader    The header of each question
     * @param pImageResourceId   Image resource ID for the question
     * @param pQuestionBody      The body of each question
     * @param pCheckBoxOneText   Text for the first CheckBox
     * @param pCheckBoxTwoText   Text for the second CheckBox
     * @param pCheckBoxThreeText Text for the third CheckBox
     * @param pCheckBoxFourText  Text for the fourth CheckBox
     */
    public Question(String pQuestionHeader,
                    int pImageResourceId,
                    String pQuestionBody,
                    String pCheckBoxOneText,
                    String pCheckBoxTwoText,
                    String pCheckBoxThreeText,
                    String pCheckBoxFourText) {

        mQuestionHeader = pQuestionHeader;
        mImageResourceId = pImageResourceId;
        mQuestionBody = pQuestionBody;
        mCheckBoxOneText = pCheckBoxOneText;
        mCheckBoxTwoText = pCheckBoxTwoText;
        mCheckBoxThreeText = pCheckBoxThreeText;
        mCheckBoxFourText = pCheckBoxFourText;
    }

    /**
     * Create a new Question object, when the question uses CheckBoxes and six possible answers.
     *
     * @param pQuestionHeader    The header of each question
     * @param pImageResourceId   Image resource ID for the question
     * @param pQuestionBody      The body of each question
     * @param pCheckBoxOneText   Text for the first CheckBox
     * @param pCheckBoxTwoText   Text for the second CheckBox
     * @param pCheckBoxThreeText Text for the third CheckBox
     * @param pCheckBoxFourText  Text for the fourth CheckBox
     * @param pCheckBoxFiveText  Text for the fifth CheckBox
     * @param pCheckBoxSixText   Text for the sixth CheckBox
     */
    public Question(String pQuestionHeader,
                    int pImageResourceId,
                    String pQuestionBody,
                    String pCheckBoxOneText,
                    String pCheckBoxTwoText,
                    String pCheckBoxThreeText,
                    String pCheckBoxFourText,
                    String pCheckBoxFiveText,
                    String pCheckBoxSixText) {

        mQuestionHeader = pQuestionHeader;
        mImageResourceId = pImageResourceId;
        mQuestionBody = pQuestionBody;
        mCheckBoxOneText = pCheckBoxOneText;
        mCheckBoxTwoText = pCheckBoxTwoText;
        mCheckBoxThreeText = pCheckBoxThreeText;
        mCheckBoxFourText = pCheckBoxFourText;
        mCheckBoxFiveText = pCheckBoxFiveText;
        mCheckBoxSixText = pCheckBoxSixText;
    }

    /**
     * Get the header of the question.
     *
     * @return the header of the question.
     */
    public String getQuestionHeader() {
        return mQuestionHeader;
    }

    /**
     * Return the image resource ID of the question.
     *
     * @return the image resource ID of the question.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the body of the question.
     *
     * @return the body of the question.
     */
    public String getQuestionBody() {
        return mQuestionBody;
    }

    /**
     * Get the text of the first RadioButton
     *
     * @return the text of the first RadioButton
     */
    public String getRadioButtonOneText() {
        return mRadioButtonOneText;
    }

    /**
     * Get the text of the second RadioButton
     *
     * @return the text of the second RadioButton
     */
    public String getRadioButtonTwoText() {
        return mRadioButtonTwoText;
    }

    /**
     * Get the text of the first CheckBox
     *
     * @return the text of the first CheckBox
     */
    public String getCheckBoxOneText() {
        return mCheckBoxOneText;
    }

    /**
     * Get the text of the second CheckBox
     *
     * @return the text of the second CheckBox
     */
    public String getCheckBoxTwoText() {
        return mCheckBoxTwoText;
    }

    /**
     * Get the text of the third CheckBox
     *
     * @return the text of the third CheckBox
     */
    public String getCheckBoxThreeText() {
        return mCheckBoxThreeText;
    }

    /**
     * Get the text of the fourth CheckBox
     *
     * @return the text of the fourth CheckBox
     */
    public String getCheckBoxFourText() {
        return mCheckBoxFourText;
    }

    /**
     * Get the text of the fifth CheckBox
     *
     * @return the text of the fifth CheckBox
     */
    public String getCheckBoxFiveText() {
        return mCheckBoxFiveText;
    }

    /**
     * Get the text of the sixth CheckBox
     *
     * @return the text of the sixth CheckBox
     */
    public String getCheckBoxSixText() {
        return mCheckBoxSixText;
    }
}
