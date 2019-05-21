package com.agrigoriev.activity_and_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LettersActivity extends AppCompatActivity {

    public static final String EXTRA_RESPONSE =  "com.agrigoriev.activity_and_intents.extra.Response";

    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        int letters = countLetters(message);

        response = "Count of letters : " + letters;

        TextView textView = findViewById(R.id.textView_letters);

        textView.setText(response);
    }

    public int countLetters(String message) {
        char[] tmp = message.toCharArray();
        int spaces = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == ' ') {
                spaces++;
            }
        }
        return tmp.length - spaces;
    }

    public void responseLetters(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_RESPONSE, response);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
