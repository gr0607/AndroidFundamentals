package com.agrigoriev.activity_and_intents;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.agrigoriev.activity_and_intents.extra.MESSAGE";
    public static final int LETTERS_REQUEST = 1;
    public static final int SPACES_REQUEST = 2;

    private EditText mMessageText;
    private TextView mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageText = findViewById(R.id.edit_input_text);
        mHello = findViewById(R.id.tv_hello);
    }

    public void launchLettersActivity(View view) {
        launchActivity(LettersActivity.class, LETTERS_REQUEST);
    }

    public void launchSpacesActivity(View view) {
        launchActivity(SpacesActivity.class, SPACES_REQUEST);
    }

    public void launchActivity(Class clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        String message = mMessageText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case LETTERS_REQUEST :
                    String response = data.getStringExtra(SpacesActivity.EXTRA_RESPONSE);
                    mHello.setText(response);
                case SPACES_REQUEST :
                    String response_ = data.getStringExtra(LettersActivity.EXTRA_RESPONSE);
                    mHello.setText(response_);
            }
        }
    }
}
