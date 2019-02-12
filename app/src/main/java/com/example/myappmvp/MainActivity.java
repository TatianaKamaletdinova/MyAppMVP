package com.example.myappmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.IView, Observer {

    private static final String TAG = "MainActivity";

    private MainContract.IPresenter mIPresenter;

    private Button mButton;
    private Button mButton2;
    private TextView myTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIPresenter = new MainPresenter(this);

        myTv = findViewById(R.id.text_view);
        mButton = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPresenter.onButtonWasClicked();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPresenter.onButtonWasClicked();
            }
        });

        Log.d(TAG, "onCreate()");
    }

    @Override
    public void showText(String message) {
        myTv.setText(message);
        Log.d(TAG, "showMessage()");
    }

    @Override
    public String changeText() {
        return "Тата";
    }


    //Вызываем у Presenter метод onDestroy, чтобы избежать утечек контекста и прочих неприятностей.
    @Override
    public void onDestroy() {
        super.onDestroy();
        mIPresenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void handleEvent(String data) {
        myTv.setText(data);
    }
}
