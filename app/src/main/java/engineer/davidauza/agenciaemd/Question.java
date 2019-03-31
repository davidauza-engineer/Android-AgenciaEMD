package engineer.davidauza.agenciaemd;

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
}
