package com.itheima.zhbj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class GuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 必须在setContentView之前调用
//        requestWindowFeature(Window.FEATURE_NO_TITLE); // 去掉标题,

        setContentView(R.layout.activity_guide);
    }
}