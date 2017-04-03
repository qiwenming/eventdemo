package com.qwm.eventdemo.activitydispatch;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;
/**
 * @author: qiwenming
 * @date: 17/4/2 下午10:55
 * @className: ActivityDispatchActivity
 * @description: activity的dispatchTouchEvent测试
 */
public class ActivityDispatchActivity extends BaseActivity {

    private static final String TAG = "ActivityDispatch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: "+MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent:"+MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }
}
