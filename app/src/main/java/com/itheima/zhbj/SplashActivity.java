package com.itheima.zhbj;


import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_root = findViewById(R.id.rl_root);


    }
}