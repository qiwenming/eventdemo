package com.qwm.eventdemo.touchdelegatedemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Toast;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;
/**
 * <b>Project:</b> eventdemo<br>
 * <b>Create Date:</b> 2017/4/21<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b>
 * TouchDelegate测试
 * <br>
 */
public class TouchDelegateDemoActivity extends BaseActivity {
    private AppCompatButton testBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_delegate_demo);
        testBtn = (AppCompatButton)findViewById(R.id.test_btn);
        testBtn.setOnClickListener(mOnClickListener);
        View parent = (View) testBtn.getParent();
        parent.post(new Runnable() {
            @Override
            public void run() {
                int offset = 200;
                Rect rect = new Rect();
                testBtn.getHitRect(rect);
                rect.set(rect.left-offset, rect.top-offset, rect.right+offset, rect.bottom+offset);
                TouchDelegate delegate = new TouchDelegate(rect,testBtn);
                ((View)testBtn.getParent()).setTouchDelegate(delegate);
            }
        });
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TouchDelegateDemoActivity.this, "测试而已", Toast.LENGTH_SHORT).show();
        }
    };
}
