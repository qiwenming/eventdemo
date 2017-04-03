package com.qwm.eventdemo.activitydispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author: qiwenming
 * @date: 17/4/2 下午10:31
 * @className: TestRelativeLayout
 * @description: Activity的dispatchTouchEvent测试
 */
public class TestRelativeLayout extends RelativeLayout {
    private static final String TAG = "TestRelativeLayout";
    public TestRelativeLayout(Context context) {
        super(context);
    }

    public TestRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: "+MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }
}
