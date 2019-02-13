package com.example.myappmvp;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainPresenter implements MainContract.IPresenter, Observer {


    //Компоненты MVP приложения
    private MainContract.IModel mModel;
    private MainContract.IView mView;


    MainPresenter(MainContract.IView mView) {
        this.mView = mView;
        this.mModel = new MainModel();

        Log.d(TAG, "Constructor");
    }

    @Override
    public void onButtonWasClicked() {
        //Сообщение
        String message = mModel.setChangeData(mView.changeText());
        mView.showText(message);
        Log.d(TAG, "onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
/**
 * Если бы мы работали например с RxJava, в этом классе стоило бы отписываться от подписок
 * Кроме того, при работе с другими методами асинхронного андроида,здесь мы боремся с утечкой контекста
 */

        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void handleEvent(String data) {
        mView.showText(data);
    }
}
