package android.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOneAnswers(){
        CheckBox questionOneMichaelJordan = (CheckBox) findViewById(R.id.checkboxQuest1AnswerMichaelJordan);
        CheckBox questionOneShaquilleONeal = (CheckBox) findViewById(R.id.checkboxQuest1AnswerShaquilleONeal);
        CheckBox questionOneAbdulKareem = (CheckBox) findViewById(R.id.checkboxQuest1AnswerAbdulKareem);
        boolean isQuestionOneMichaelJordonChecked = questionOneMichaelJordan.isChecked();
        boolean isQuestionOneShaquilleONealChecked = questionOneShaquilleONeal.isChecked();
        boolean isQuestionOneAbdulKareemChecked = questionOneAbdulKareem.isChecked();

        if (isQuestionOneMichaelJordonChecked && isQuestionOneShaquilleONealChecked && !isQuestionOneAbdulKareemChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButton1947 = (RadioButton) findViewById(R.id.radio_1947);
        boolean isQuestionTwo1947Checked = radioButton1947.isChecked();
        if (isQuestionTwo1947Checked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userInputNationalGmae = (EditText) findViewById(R.id.answerNationalGame);
        String game = userInputNationalGmae.getText().toString();
        return game;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("hockey")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonJawaharlalNehru = (RadioButton) findViewById(R.id.radio_jawaharlalNehru);
        boolean isQuestionTwoJawaharlalNehruChecked = radioButtonJawaharlalNehru.isChecked();
        if (isQuestionTwoJawaharlalNehruChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveGameBoy = (CheckBox) findViewById(R.id.checkboxQuest5GameBoy);
        CheckBox questionFivePSP = (CheckBox) findViewById(R.id.checkboxQuestPSP);
        CheckBox questionFiveWii = (CheckBox) findViewById(R.id.checkboxQuest5Wii);
        boolean isQuestionFiveGameBoyChecked = questionFiveGameBoy.isChecked();
        boolean isQuestionFivePSPChecked = questionFivePSP.isChecked();
        boolean isQuestionFiveWiiChecked = questionFiveWii.isChecked();

        if (isQuestionFiveGameBoyChecked && !isQuestionFivePSPChecked && isQuestionFiveWiiChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            if(correctAnswers < 2)
            {
                Toast.makeText(MainActivity.this, "Your score is less than 40% ",
                        Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5 Congratulations you passed the test !!",
                        Toast.LENGTH_LONG).show();
            }

            resetCounterCorrectAnswers();
        }
    };
}
