package com.qwm.eventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private GridView contentGv;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGridView();
    }

    public void initGridView() {
        contentGv = (GridView) findViewById(R.id.content_gv);
        itemList = new ArrayList<>();
        itemList.add("Activity的dispatchTouchEvent");
        contentGv.setAdapter(new MyGridAdapter(this, itemList));
        contentGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = itemList.get(position);
                if ("Activity的dispatchTouchEvent".equals(itemStr)) {
                    startActivity(itemStr, ActivityDispatchActivity.class);
                }
            }
        });

    }
}
