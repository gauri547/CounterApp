package com.streamliners.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.streamliners.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int qty = 0;
    ActivityMainBinding b;

    private String COUNT_VALUE = "countValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializing the binding
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Handel click events
        eventHandler();

        handelConfigurationChanges(savedInstanceState);
    }

    /**
     * Handle data on configuration change
     * @param savedInstanceState To get data from bundle
     */
    private void handelConfigurationChanges(Bundle savedInstanceState) {
        //Check savedInstanceState not null
        if (savedInstanceState != null) {
            qty = savedInstanceState.getInt(COUNT_VALUE);
        } else {
            //Get data from sharedPreference
            qty = getPreferences(MODE_PRIVATE)
                    .getInt(COUNT_VALUE, 0);

        }
        b.qty.setText(qty + "");
    }

    /**
     * Trigger Event handlers to listen the actions
     */
    private void eventHandler() {
        //click listener on Decrease button
        b.decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To decrease quantity
                decreaseQuantity();
            }
        });

        //click listener on Increase button
        b.incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To increase quantity
                increaseQuantity();
            }
        });
    }

    /**
     * Increase the quantity
     * update TextView
     */
    private void increaseQuantity() {
        //update quantity and textView
        b.qty.setText(++qty + "");
    }

    /**
     * Decrease the quantity
     * update TextView
     */
    private void decreaseQuantity() {

        //check quantity
        if (qty == 0) {
            //show toast message
            Toast.makeText(this, "Quantity is already 0", Toast.LENGTH_SHORT).show();
            return;
        }

        //update quantity and textView
        b.qty.setText(--qty + "");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_VALUE, qty);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferences(MODE_PRIVATE).edit().putInt(COUNT_VALUE, qty).apply();
    }
}