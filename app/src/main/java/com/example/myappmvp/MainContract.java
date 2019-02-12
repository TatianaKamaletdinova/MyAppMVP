package com.example.myappmvp;

class MainContract {

    interface IView {
        void showText(String message);
        String changeText();
    }

    interface IPresenter {
        void onButtonWasClicked();
        void onDestroy();
    }

    interface IModel{
        String loadMessage();
        String setChangeData(String data);
    }
}
