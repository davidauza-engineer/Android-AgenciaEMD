package engineer.davidauza.agenciaemd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    }
}
