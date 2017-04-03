package com.qwm.eventdemo.activitydispatch;

import android.os.Bundle;
import android.view.View;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;

public class ADisMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adis_main);
    }

    public void testTou(View view){
        startActivity("isOutOfBounds查看",ADisDialogActivity.class);
    }

    public void testDis(View view){
        startActivity("dispatchTouchEvent测试",ActivityDispatchActivity.class);
    }
}
