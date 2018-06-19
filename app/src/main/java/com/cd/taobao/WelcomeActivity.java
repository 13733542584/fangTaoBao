package com.cd.taobao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {
    private boolean isFirstIn=false;
    private static final int TIME=2000;
    private static final int GO_HOME=1000;
    private static final int GO_GUIDE=1001;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };
    public void init()
    {
        SharedPreferences preferences=getSharedPreferences("cdicon",MODE_PRIVATE);
        isFirstIn=preferences.getBoolean("isFirstIn",true);
        if (!isFirstIn)
        {
            handler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }else {
            handler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }
    public void goHome()
    {
        Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    //调到引导页,暂未处理
    public void goGuide()
    {
        Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
