package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.myapplication.MainActivity.mTTS;

public class question extends AppCompatActivity {
    SharedPreferences prefs;
    int i = 0;
    boolean check = true;
    public String mass = "";
    String[] name;
    String[] n;
    String[] var;
    String[] var_num;
    String[] var_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
         prefs=getSharedPreferences("settings", Context.MODE_PRIVATE);
        Context context = this.getApplicationContext();
        final TextView qwest = findViewById(R.id.textView);

        //--Scriptt--
        name = getResources().getStringArray(R.array.name);//name+n
        n = getResources().getStringArray(R.array.n);
        var_start = getResources().getStringArray(R.array.var_start);
        var = getResources().getStringArray(R.array.var);
        var_num = getResources().getStringArray(R.array.var_num);
        var_start = getResources().getStringArray(R.array.var_start);


        //--Scriptt--
        qwest.setText(var[i]);
        Button no=findViewById(R.id.button_no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i != 36) {i++;} else {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("MASS",mass).apply();
                    startActivity(new Intent(question.this, ListAda.class));
                }
                qwest.setText(var[i]);
            }
        });

        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Закомментил ибо на есс должен звук быть??Сириосли??
//                String text = "А Васька слушает да ест";
//                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//                qwest.setText("Херняяяя");

                remember_result(var_num[i]);
                if (i != 36) {i++;} else {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("MASS",mass).apply();
                    startActivity(new Intent(question.this, ListAda.class));
                    }
                Log.i("asd", mass);
                qwest.setText(var[i]);

            }
        });

        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(question.this, MainActivity.class));
            }
        });

    }

    public String remember_result(String num) {
        Log.i("asd", mass);
        for (CharSequence s : num.split(" ")) {
            Log.i("asdb", String.valueOf(s));
            if (s != " " && !mass.contains(s)) {
                mass = mass + " " + s;
            }
        }
        return mass;
    }

//    public boolean check_next(String num) {
//        boolean flag = false;
//        for (CharSequence s : num.split(" ")) {
//            if (s!= " " && !mass.contains(" "+s+" ")) {
//                flag = true;
//            } }
//        return flag;
//    }
}
