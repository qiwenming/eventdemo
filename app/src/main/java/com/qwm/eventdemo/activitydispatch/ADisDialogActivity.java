package com.qwm.eventdemo.activitydispatch;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;
/**
 * @author: qiwenming
 * @date: 17/4/4 上午12:33
 * @className: ADisDialogActivity
 * @description: 测试 onTouchEvent方法，其实我们主要来看 window的 isOutOfBounds()方法
 */
public class ADisDialogActivity extends BaseActivity {

    private static final String TAG = "ADisDialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adis_dialog);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_DOWN){
            isOutOfBounds(this,ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    private boolean isOutOfBounds(Context context, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        //下面这句代码；原来是 final View decorView = getDecorView(); 其他地方都不变
        final View decorView = getWindow().getDecorView();
        print(x,y,slop,decorView);
        return (x < -slop) || (y < -slop)
                || (x > (decorView.getWidth()+slop))
                || (y > (decorView.getHeight()+slop));
    }

    private void print(int x,int y,int slop,View decorView){
        Log.i(TAG, "=================================");
        Log.i(TAG, "x: "+x);
        Log.i(TAG, "y: "+y);
        Log.i(TAG, "slop: "+slop);
        Log.i(TAG, "decorView.getWidth(): "+decorView.getWidth());
        Log.i(TAG, "decorView.getHeight(): "+decorView.getHeight());
        Log.i(TAG, "decorView.getWidth()+slop: "+(decorView.getWidth()+slop));
        Log.i(TAG, "decorView.getHeight()+slop: "+(decorView.getHeight()+slop));
        Log.i(TAG, "x < -slop: "+ (x < -slop) );
        Log.i(TAG, "y < -slop: "+(y < -slop));
        Log.i(TAG, "x > (decorView.getWidth()+slop): "+(x > (decorView.getWidth()+slop)));
        Log.i(TAG, "y > (decorView.getHeight()+slop): "+(y > (decorView.getHeight()+slop)));
        boolean isOut =  (x < -slop) || (y < -slop)
                || (x > (decorView.getWidth()+slop))
                || (y > (decorView.getHeight()+slop));
        Log.i(TAG, "isOut: "+isOut);
    }
}
