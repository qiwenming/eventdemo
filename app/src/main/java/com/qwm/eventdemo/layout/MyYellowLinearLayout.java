package com.qwm.eventdemo.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * <b>Project:</b> AndroidReview01<br>
 * <b>Create Date:</b> 2017/3/28<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class MyYellowLinearLayout extends BaseRelativeLayout{
    public MyYellowLinearLayout(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    private static final String TAG = "MyYellowLinearLayout";

    public MyYellowLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);
    }

    public MyYellowLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: "+ ev.getPointerCount());
        return super.dispatchTouchEvent(ev);
    }
}
