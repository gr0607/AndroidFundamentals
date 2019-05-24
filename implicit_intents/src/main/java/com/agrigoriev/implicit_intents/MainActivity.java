package com.agrigoriev.implicit_intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String WARNING  = "Can't handle this!";

    private EditText mWebSiteEditText;

    private EditText mLocationEditText;

    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebSiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareEditText = findViewById(R.id.share_edit_text);
    }

    public void openWebSite(View view) {
        String url =  mWebSiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, WARNING, Toast.LENGTH_SHORT ).show();
        }
    }

    public void openLocation(View view) {
        String location = mLocationEditText.getText().toString();

        Uri locationUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, WARNING, Toast.LENGTH_SHORT ).show();
        }
    }

    public void shareText(View view) {
        String text = mShareEditText.getText().toString();

        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_title)
                .setText(text)
                .startChooser();
    }
}
