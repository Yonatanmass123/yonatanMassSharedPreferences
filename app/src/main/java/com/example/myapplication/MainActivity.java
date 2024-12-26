package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;
    Button  btn;
    EditText etABC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences( "ExampleApp", MODE_PRIVATE);
        tvHello = findViewById(R.id.tvHello);
        btn = findViewById(R.id.btn);
        etABC = findViewById(R.id.etABC);
        tvHello.setText(sharedPreferences.getString("Hello", "###"));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Hello", etABC.getText().toString());
                editor.apply();
                tvHello.setText(editor.toString());
            }
        });

    }
}