package com.qwm.eventdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qwm.eventdemo.activitydispatch.ADisMainActivity;
import com.qwm.eventdemo.viewgropdispatch.ViewGropDispatchActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private GridView contentGv;
    private ArrayList<String> itemList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGridView();
        Log.i(TAG, "onCreate: "+getWindowManager().getDefaultDisplay().getWidth());
    }

    public void initGridView() {
        contentGv = (GridView) findViewById(R.id.content_gv);
        itemList = new ArrayList<>();
        itemList.add("Activity的dispatchTouchEvent");
        itemList.add("ViewGrop的dispatchTouchEvent");
        contentGv.setAdapter(new MyGridAdapter(this, itemList));
        contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = itemList.get(position);
                if ("Activity的dispatchTouchEvent".equals(itemStr)) {
                    startActivity(itemStr, ADisMainActivity.class);
                }else if ("ViewGrop的dispatchTouchEvent".equals(itemStr)) {
                    startActivity(itemStr, ViewGropDispatchActivity.class);
                }
            }
        });

    }
}
