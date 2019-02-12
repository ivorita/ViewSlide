package com.android.ivorita.viewslide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取手指处的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){

            //手指按下
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;

            //手指滑动
            case MotionEvent.ACTION_MOVE:
                //计算滑动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                //调用layout()方法重新放置它的位置
                //layout(getLeft() + offsetX,getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

                //对left和right进行偏移
                //offsetLeftAndRight(offsetX);
                //对top和bottom进行偏移
                //offsetTopAndBottom(offsetY);

                //LayoutParams主要保存了一个View的布局参数，因此可以通过改变LayoutParams来改变View的布局参数从而达到改变View位置的效果
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);

                break;

        }

        return true;
    }
}
