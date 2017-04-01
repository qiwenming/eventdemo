package com.qwm.eventdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

/**
 * <b>Project:</b> eventdemo<br>
 * <b>Create Date:</b> 2017/4/1<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    public static String ACTIVITY_FROM_TITLE = "FROM_TITLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fromTitle = getIntent().getStringExtra(ACTIVITY_FROM_TITLE);
        if(!TextUtils.isEmpty(fromTitle)){
            setTitle(fromTitle);
        }
    }

    public void startActivity(String title,Class activityClass){
        Intent intent = new Intent(this,activityClass);
        intent.putExtra(ACTIVITY_FROM_TITLE,title);
        startActivity(intent);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.i(TAG, "onUserLeaveHint: ");
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        Log.i(TAG, "onUserInteraction: ");
    }
}
