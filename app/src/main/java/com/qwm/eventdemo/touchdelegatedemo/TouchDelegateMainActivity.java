package com.qwm.eventdemo.touchdelegatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;

public class TouchDelegateMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_delegate_main);
    }

    public void test1(View view) {
        startActivity("基本使用测试",TouchDelegateDemoActivity.class);
    }

    public void test2(View view){
        startActivity("两个前后按钮测试",TouchDelegateButtonActivity.class);
    }
}
