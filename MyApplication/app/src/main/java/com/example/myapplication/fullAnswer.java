package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fullAnswer extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_answer);
        TextView ansName = findViewById(R.id.ansName);
        ansName.setTextSize(22);
        TextView bodyName = findViewById(R.id.bodyName);
        bodyName.setTextSize(20);
        ansName.setText(getIntent().getStringExtra("ansName"));
        bodyName.setText(getIntent().getStringExtra("bodyName"));
        Button backList=findViewById(R.id.backList);
        final SharedPreferences prefs =getSharedPreferences("settings", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        backList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("MASS",prefs.getString("MASs"," ")).apply();
                startActivity(new Intent(fullAnswer.this, ListAda.class));finish();
            }
        });


    }
}
