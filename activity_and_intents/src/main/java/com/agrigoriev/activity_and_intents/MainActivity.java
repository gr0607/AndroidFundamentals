package com.agrigoriev.activity_and_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.agrigoriev.activity_and_intents.extra.MESSAGE";

    private EditText mMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageText = findViewById(R.id.edit_input_text);
    }

    public void launchLettersActivity(View view) {
        launchActivity(LettersActivity.class);
    }

    public void launchSpacesActivity(View view) {
        launchActivity(SpacesActivity.class);
    }

    public void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        String message = mMessageText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
