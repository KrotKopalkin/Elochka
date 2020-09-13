package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener {
    // объект говорилки
    static TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
    //непонятный метод, не трогать, озвучиватель умрет
    @Override
    public void onInit(int status) {}
}