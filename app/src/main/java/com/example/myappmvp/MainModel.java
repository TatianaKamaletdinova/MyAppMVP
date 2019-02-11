package com.example.myappmvp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements MainContract.IModel, Observable {

    private static final String TAG = "MainRepository";

    List<Observer> observers = new ArrayList<>();
    String data;

    @Override
    public String loadMessage() {
        Log.d(TAG, "loadMessage()");
        /** Здесь обращаемся к БД или сети.
         * Я специально ничего не пишу, чтобы не загромождать пример
         * DBHelper'ами и прочими не относяшимеся к теме объектами.
         * Поэтому я буду возвращать строку Сосисочная =)
         */
        return "Сосисочная у Лёхи";
    }

    @Override
    public String setChangeData(String data) {
        this.data = data;
        notifyObserver();
        return data;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer o: observers){
            o.handleEvent(data);
        }
    }
}
