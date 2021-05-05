package com.streamliners.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int qty = 0;
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing the binding

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
         // Handle click events
        setUpEventHandlers();
    }
    /**
     * Trigger event handler to listen the action
     */

    private void setUpEventHandlers() {
        b.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To increase quantity
                incQty();
            }
        });

        b.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // To decrease quantity
                decQty();
            }
        });
    }


}
