package com.agrigoriev.androidfundamental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mCountTextView;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountTextView = findViewById(R.id.tvCount);

        counter = Integer.valueOf(mCountTextView.getText().toString());
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_msg, Toast.LENGTH_SHORT).show();
    }

    public void decrement(View view) {
        counter++;
        mCountTextView.setText(String.valueOf(counter));
    }

    public void increment(View view) {
        counter--;
        mCountTextView.setText(String.valueOf(counter));
    }
}
