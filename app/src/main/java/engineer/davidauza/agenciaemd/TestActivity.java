package engineer.davidauza.agenciaemd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Create the list of questions
        ArrayList<Question> questions = new ArrayList<Question>();
        // Question one
        questions.add(new Question(getString(R.string.test_question_one_header),
                R.drawable.question_one, getString(R.string.test_question_one_body),
                getString(R.string.test_question_one_option_one),
                getString(R.string.test_question_one_option_two),
                getString(R.string.test_question_one_option_three),
                getString(R.string.test_question_one_option_four)));
        // Question two
        questions.add(new Question(getString(R.string.test_question_two_header),
                R.drawable.question_two,
                getString(R.string.test_question_two_body),
                getString(R.string.test_question_two_option_one),
                getString(R.string.test_question_two_option_two)));
        // Question three
        questions.add(new Question(getString(R.string.test_question_three_header),
                R.drawable.question_three,
                getString(R.string.test_question_three_body),
                getString(R.string.test_question_three_option_one),
                getString(R.string.test_question_three_option_two)));
        // Question four
        questions.add(new Question(getString(R.string.test_question_four_header),
                R.drawable.question_four,
                getString(R.string.test_question_four_body),
                getString(R.string.test_question_four_option_one),
                getString(R.string.test_question_four_option_two),
                getString(R.string.test_question_four_option_three),
                getString(R.string.test_question_four_option_four),
                getString(R.string.test_question_four_option_five),
                getString(R.string.test_question_four_option_six)));
        // Question five
        questions.add(new Question(getString(R.string.test_question_five_header),
                R.drawable.question_five,
                getString(R.string.test_question_five_body),
                getString(R.string.test_question_five_option_one),
                getString(R.string.test_question_five_option_two),
                getString(R.string.test_question_five_option_three),
                getString(R.string.test_question_five_option_four)));
        // Question six
        questions.add(new Question(getString(R.string.test_question_six_header),
                R.drawable.question_six,
                getString(R.string.test_question_six_body),
                getString(R.string.test_question_six_option_one),
                getString(R.string.test_question_six_option_two)));
        // Question seven
        questions.add(new Question(getString(R.string.test_question_seven_header),
                R.drawable.question_seven,
                getString(R.string.test_question_seven_body),
                getString(R.string.test_question_seven_option_one),
                getString(R.string.test_question_seven_option_two)));
        // Question eight
        questions.add(new Question(getString(R.string.test_question_eight_header),
                R.drawable.question_eight,
                getString(R.string.test_question_eight_body),
                getString(R.string.test_question_eight_option_one),
                getString(R.string.test_question_eight_option_two),
                getString(R.string.test_question_eight_option_three),
                getString(R.string.test_question_eight_option_four),
                getString(R.string.test_question_eight_option_five),
                getString(R.string.test_question_eight_option_six)));
        // Question nine
        questions.add(new Question(getString(R.string.test_question_nine_header),
                R.drawable.question_nine,
                getString(R.string.test_question_nine_body),
                getString(R.string.test_question_nine_option_one),
                getString(R.string.test_question_nine_option_two),
                getString(R.string.test_question_nine_option_three),
                getString(R.string.test_question_nine_option_four)));

        // Question ten
        questions.add(new Question(getString(R.string.test_question_ten_header),
                R.drawable.question_ten,
                getString(R.string.test_question_ten_body),
                getString(R.string.test_question_ten_option_one),
                getString(R.string.test_question_ten_option_two)));
        

        // Create a QuestionAdapter, whose data source is a list of Questions. The adapter knows
        // how to create list items for each item in the list.
        QuestionAdapter adapter = new QuestionAdapter(this, questions);

        // Find the ListView object in the view hierarchy of the Activity. There should be a
        // ListView with the ID called list_of_questions, which is declared in the
        // activity_test.xml layout file.
        ListView listView = findViewById(R.id.list_of_questions);

        // Make the ListView use the QuestionAdapter created above, so that the ListView will
        // display list items for each Question in the list.
        listView.setAdapter(adapter);
    }

    // TODO Fix the orientation change
}
