package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.question.contrast;


public class MainActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener {
    // объект говорилки
    static TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!contrast)
            setContentView(R.layout.activity_main);
        else
            setContentView(R.layout.contr_activity_main);
        //кнопочка перехода к тесту
        Button test = findViewById(R.id.test);
        // создние озвучивателя
        mTTS = new TextToSpeech(this, this);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, question.class));
            }
        });
        Button all=findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs =getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("MASS"," ").apply();
                startActivity(new Intent(MainActivity.this, ListAda.class));
            }
        });
        Button prev=findViewById(R.id.history);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs =getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("MASS",prefs.getString("MASs"," ")).apply();
                startActivity(new Intent(MainActivity.this,ListAda.class));
            }
        });
    }
    //непонятный метод, не трогать, озвучиватель умрет
    @Override
    public void onInit(int status) {}
}