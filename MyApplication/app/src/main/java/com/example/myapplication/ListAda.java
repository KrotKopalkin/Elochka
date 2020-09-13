package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.myapplication.MainActivity.mTTS;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class ListAda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

// код пишется в методе onCreate()

// получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);

// определяем строковый массив

        final String[] allExemption = getResources().getStringArray(R.array.name);
        final String[] bodys=getResources().getStringArray(R.array.n);

// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, allExemption);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                int num = Arrays.asList(allExemption).indexOf(strText);
                mTTS.speak(strText, TextToSpeech.QUEUE_FLUSH, null);
                Intent goAns=new Intent(ListAda.this, fullAnswer.class);
                goAns.putExtra("ansName", strText);
                goAns.putExtra("bodyName",bodys[num]);
                startActivity(goAns);

            }
        });
    }

}
