package com.example.ly.ly;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.edt)
    EditText edt;
    @BindView(R.id.toobar_btn)
    Button toobarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FirstActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn2:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                break;
        }
    }

    @OnClick(R.id.toobar_btn)
    public void onClick() {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ToolbarActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());



    }
}
