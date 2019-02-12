package com.android.ivorita.viewslide;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

public class ViewSlideActivity extends AppCompatActivity {

    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_slide);

        customView = findViewById(R.id.custom_view);

        //使用View动画使View滑动
        //attention: View动画并不能改变View的位置参数
        //customView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));

        //使用属性动画使View滑动
        //不仅可以执行动画，还可以改变View的位置参数
        //ObjectAnimator.ofFloat(customView,"translationX",0,300).setDuration(1000).start();

        //使用Scroll来进行平滑移动
        customView.smoothScrollTo(-400,0);

    }
}
