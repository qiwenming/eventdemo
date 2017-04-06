package com.qwm.eventdemo.viewgropdispatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.qwm.eventdemo.BaseActivity;
import com.qwm.eventdemo.R;

public class ViewGropDispatchActivity extends BaseActivity {
    private static final String TAG = "ViewGropDispatch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grop_dispatch);
//        printVG((ViewGroup) getWindow().getDecorView(),0);
    }



    public void printVG(ViewGroup viewGroup,int level){
        int count = viewGroup.getChildCount();
        Log.i(TAG,getSpanceStr(level) + viewGroup);
        for (int i = 0; i < count; i++) {
            if( viewGroup.getChildAt(i) instanceof ViewGroup){
                printVG((ViewGroup) viewGroup.getChildAt(i),level+1);
            }else{
                Log.i(TAG, getSpanceStr(level+1)+ viewGroup.getChildAt(i));
            }
        }
    }

    public String getSpanceStr(int level){
        String str = "";
        for (int i = 0; i < level; i++) {
            str+="|--";
        }
        return str;
    }
}
