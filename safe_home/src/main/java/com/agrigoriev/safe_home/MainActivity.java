package com.agrigoriev.safe_home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;

    public static final String EXTRA_MESSAGE = "com.agrigoriev.safe_home.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startOrderActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       switch (item.getItemId()) {
           case R.id.action_contact :
               displayToast(getString(R.string.action_contact_message));
               break;
           case R.id.action_favorites :
               displayToast(getString(R.string.action_favorites_message));
               break;
           case R.id.action_status :
               displayToast(getString(R.string.action_status_message));
               break;
           case R.id.action_order :
               startOrderActivity();
               break;
           default:
               break;
       }

        return super.onOptionsItemSelected(item);
    }

    public void showIntercomOrder(View view) {
        mOrderMessage = getString(R.string.intercom_order_message);
        displayToast(getString(R.string.intercom_order_message));
    }

    public void showVideoSystemOrder(View view) {
        mOrderMessage = getString(R.string.video_order_message);
        displayToast(getString(R.string.video_order_message));
    }

    public void showSecuritySystemOrder(View view) {
        mOrderMessage = getString(R.string.security_order_message);
        displayToast(getString(R.string.security_order_message));
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void startOrderActivity() {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
}
