package com.example.myappmvp;

public class MainContract {

    interface IView {
        void showText(String message);
    }

    interface IPresenter {
        void onButtonWasClicked(String data);
        void onDestroy();
    }

    interface IModel{
        String loadMessage();
        String setChangeData(String data);
    }
}
