package com.example.rateapponplaystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Initialize variable
    Button btRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asign variable
        btRate = findViewById(R.id.bt_rate);
        btRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // When playstore avalable
                    // Initialize uri
                    Uri uri = Uri.parse("market://details?id" + getPackageName());
                    // Initialize intent
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    // Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    // Start activity
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Whenplay store unavailable
                    // Initialize uri
                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    // Initialize intent
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    // Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    // Start activity
                    startActivity(intent);
                }
            }
        });
    }
}