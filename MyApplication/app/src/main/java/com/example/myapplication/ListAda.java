package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
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
        SharedPreferences prefs =getSharedPreferences("settings", Context.MODE_PRIVATE);
        String was=prefs.getString("MASS"," ");
// код пишется в методе onCreate()
        final String[] allExemption;
        final String[] bodys;
// получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);

//        ---Не трогать под страхом небесных кар---

        String[] name = getResources().getStringArray(R.array.name);//name+n
        String[] n = getResources().getStringArray(R.array.n);
        if(was!=" ") {
            String[] sa = was.split(" ");
            String my_name = "";
            String my_n = "";
            for (String s : was.split(" ")) {
                if (s != " " && s != "") {
                    Log.i("asd", s);
                }
                for (int i = 0; i < 22; i++) {
                    Log.i("asdd", i + " " + s);
                    if (String.valueOf(i).equals(s)) {
                        Log.i("asddd", String.valueOf(i));
                        my_name = my_name + name[i - 1] + "!";
                        my_n = my_n + n[i - 1] + "!";
                    }
                }
            }
// определяем строковый массив

            allExemption = my_name.split("!");
            bodys = my_n.split("!");
        }else{
            allExemption = name;
            bodys = n;}

//        ---Теперь можно трогать---

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
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences prefs =getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if(prefs.getString("MASS"," ")!=" ")editor.putString("MASs",prefs.getString("MASS"," ")).apply();
        editor.putString("MASS"," ").apply();
    }
}
