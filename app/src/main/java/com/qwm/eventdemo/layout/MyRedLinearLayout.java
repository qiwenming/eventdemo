package com.qwm.eventdemo.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

/**
 * <b>Project:</b> AndroidReview01<br>
 * <b>Create Date:</b> 2017/3/28<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class MyRedLinearLayout extends BaseLinearLayout{

    public MyRedLinearLayout(Context context) {
        super(context);
        setBackgroundColor(Color.GRAY);
    }

    public MyRedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.GRAY);
    }

    public MyRedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.GRAY);
    }
}
