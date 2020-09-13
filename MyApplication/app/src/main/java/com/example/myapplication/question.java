package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.myapplication.MainActivity.mTTS;

public class question extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        final TextView qwest=findViewById(R.id.textView);
        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "А Васька слушает да ест";
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                qwest.setText("Херняяяя");
            }
        });

        Button button_back= findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(question.this, MainActivity.class));
            }
        });

    }
}
