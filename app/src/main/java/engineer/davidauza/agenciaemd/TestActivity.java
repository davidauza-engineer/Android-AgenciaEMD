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
        final ArrayList<Question> questions = new ArrayList<Question>();
        // Question one
        questions.add(new Question(getString(R.string.test_question_one_header),
                R.drawable.question_one_picture, getString(R.string.test_question_one_body),
                getString(R.string.test_question_one_option_one),
                getString(R.string.test_question_one_option_two),
                getString(R.string.test_question_one_option_three),
                getString(R.string.test_question_one_option_four)));

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
}
