package com.streamliners.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.streamliners.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private int qty = 0;
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

    }
    private void eventHandler() {
        b.decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                increaseQuantity();
            }
        });
    }

    // To increase the quantity
    private void increaseQuantity() {
        b.qty.setText(++qty + " ");
    }

    // To decrease the quantity
    private void decreaseQuantity() {
        if (qty == 0) {
            Toast.makeText(this, "Quantity is already 0", Toast.LENGTH_SHORT).show();
            return;
        }
        b.qty.setText(--qty + " ");
    }
}



