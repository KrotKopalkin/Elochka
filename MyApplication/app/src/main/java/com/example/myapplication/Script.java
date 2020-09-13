package com.example.myapplication;

import android.app.Application;
import android.content.Context;

public class Script extends Application {
    private static Script instance;
    public String mass;//набор айди, которые нам подходят
    public String[] name;//названия
    public String[] n;//описание
    public String[] var_start;//Начальные вопросы
    public String[] var;//Вопросы для анкеты
    public String[] var_num;//Айди вопросов анкет

    //не трогать--------
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }
    //------------------

    //функция для инициализации всех массивов
    public void start_all(){
        name=Script.getContext().getResources().getStringArray(R.array.name);//name+n
        n=Script.getContext().getResources().getStringArray(R.array.n);
        var_start=Script.getContext().getResources().getStringArray(R.array.var_start);
        var=Script.getContext().getResources().getStringArray(R.array.var);//var+var_num
        var_num=Script.getContext().getResources().getStringArray(R.array.var_num);

    }

    //функция для инициализации массива только с начальными вопросами
    public void var_start(){var_start=Script.getContext().getResources().getStringArray(R.array.var_start); }

    //инициализация массивов для анкеты
    public void init_que(){
        var=Script.getContext().getResources().getStringArray(R.array.var);
        var_num=Script.getContext().getResources().getStringArray(R.array.var_num);
    }

    //функция запоминания результата
    //(передавать сюда массив айдишек этого вопроса при "положительном" ответе,
    // например "Вы инвалид?"-да, "У вас есть дом?" - нет. Оба ответа "положительные")
    public void remember_result(String[] num){
        for(String s:num){
            if(!mass.contains(s) && s != " "){
                mass=mass+s; }
        }
    }

    //функция проверки след. вопроса в списке для анкеты.
    // Например, если айди 1 (Бесплатное предоставление для временного пребывания..) уже есть в mass,
    // то вопрос, единственный положительных вариант которого даст айди "1" показан в анкете не будет.
    //Сюда передавать массив айдишек следующего (i+1) вопроса
    public boolean check_next(String[] num){
        boolean flag=false;
        for(String s:num){
            if(s!=" " && !mass.contains(s)){flag=true;}
            }
        return flag;
        }


    }


