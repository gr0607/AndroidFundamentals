package com.agrigoriev.activity_and_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        int letters = countLetters(message);

        String receive = "Count of letters : " + letters;

        TextView textView = findViewById(R.id.textView_letters);

        textView.setText(receive);
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
}
