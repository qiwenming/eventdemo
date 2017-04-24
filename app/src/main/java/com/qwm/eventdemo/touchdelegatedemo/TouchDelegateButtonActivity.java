package com.qwm.eventdemo.touchdelegatedemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;

/**
 * <b>Project:</b> eventdemo<br>
 * <b>Create Date:</b> 2017/4/24<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b>
 * 两个按钮测试
 * <br>
 */
public class TouchDelegateButtonActivity extends BaseActivity {

    private View mForginView;
    private View mBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_delegate_button);
        initView();
        initDelegate();
    }

    private static final String TAG = "TouchDelegateButt";
    private void initView() {
        mForginView = findViewById(R.id.forgin_tv);
        mBackView = findViewById(R.id.back_tv);
        mForginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TouchDelegateButtonActivity.this, "forgin------>", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: ----forgin");
            }
        });
        mBackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ---back");
                Toast.makeText(TouchDelegateButtonActivity.this, "back------>", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initDelegate() {
        mForginView.post(new Runnable() {
            @Override
            public void run() {
                Rect rect = getIntersectDotRect();
                mForginView.setTouchDelegate(new TouchDelegate(rect,mBackView));
//                mForginView.setTouchDelegate(new ButtonTouchDelegate(rect,mBackView));
            }
        });
    }

    /**
     * 获取相交的部分，相对于前面控件的坐标
     * @return
     */
    public Rect getIntersectDotRect(){
        Rect rect = new Rect();
        //这里面最主要的一步就是计算相交部分的局域，并且转换为mForginView中的点。

        //距离左边 哪个大要哪个
        int left = mBackView.getLeft()-mForginView.getLeft();
        left = left < 0 ? 0 : left;

        //两个控件相对于 显示在前面控件（mForginView）右边到左边的距离， 哪个小用哪个
        int r1 = mForginView.getRight()-mForginView.getLeft();//就是宽度
        int r2 = mBackView.getRight()-mForginView.getLeft();
        int right = r1 - r2 > 0 ?r2:r1;

        int top = mBackView.getTop() - mForginView.getTop();
        top = top < 0 ? 0 : top;

        int b1 = mForginView.getBottom()-mForginView.getTop();//就是高度
        int b2 = mBackView.getBottom()-mForginView.getTop();
        int buttom = b1 - b2 > 0 ? b2 : b1;

        rect.set(left,top,right,buttom);

        return rect;
    }
}
