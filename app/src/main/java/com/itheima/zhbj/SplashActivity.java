package com.itheima.zhbj;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.itheima.zhbj.utils.PrefUtils;

public class SplashActivity extends Activity {

    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_root = findViewById(R.id.rl_root);

        // 旋转动画
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000); // 动画时间
        rotate.setFillAfter(true); // 保持动画结束状态

        // 缩放动画
        ScaleAnimation scale = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scale.setDuration(1000);
        scale.setFillAfter(true); // 保持动画结束状态

        // 渐变动画
        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setFillAfter(true); // 保持动画结束状态
        alpha.setDuration(2000); // 动画时间

        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);

        rl_root.startAnimation(set);

        set.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                // 动画结束,跳转页面
                // 如果是第一次进入, 跳新手引导
                // 否则跳主页面
                boolean isFirstEnter = PrefUtils.getBoolean(
                        SplashActivity.this, "is_first_enter", true);

                Intent intent;
                if (isFirstEnter) {
                    // 新手引导
                    intent = new Intent(getApplicationContext(),
                            GuideActivity.class);
                } else {
                    // 主页面
                    intent = new Intent(getApplicationContext(),
                            MainActivity.class);
                }

                startActivity(intent);

                finish(); // 结束当前页面
            }
        });

    }
}