package com.example.nine.box;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;                            //声明变量
    private MyBroadcastReceiver myBroadcastReceiver;
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*-----------------------------------------------------------------------*/
        intentFilter = new IntentFilter(); //首先创建一个IntentFilter的实例
        intentFilter.addAction("com.example.broadcasttest1.MY_BROADCAST");//添加一条Action
        myBroadcastReceiver = new MyBroadcastReceiver();//首先创建一个NetworkChangeReceiver的实例
        /*----------------------------------------------------------------------------------*/
        Button button = (Button)findViewById(R.id.button);          //获取按钮对象
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){                          //按钮监听
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                num = 1;
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);          //获取按钮对象
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                num =2;
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);          //获取按钮对象
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                num = 3;
            }
        });
        Button button4 = (Button)findViewById(R.id.button4);          //获取按钮对象
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                num = 4;
            }
        });
        Button button5 = (Button)findViewById(R.id.button5);          //获取按钮对象
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("com.example.broadcasttest1.MY_BROADCAST");
                sendBroadcast(intent);
                num = 5;
            }
        });

        /*--------------------------------------------------------------------------------*/
        registerReceiver(myBroadcastReceiver,intentFilter);//注册，传入2个实例
    }


    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);//取消注册
    }

    //继承和重写onReceive()方法
    class  MyBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent){

            if(num==1) {
                Toast.makeText(context, "郁麟枫 VS 蒙奇.D.路飞", Toast.LENGTH_SHORT).show();
            }
            else if(num==2) {
                Toast.makeText(context, "郁麟枫 VS 罗罗诺亚.索隆", Toast.LENGTH_SHORT).show();
            }
            else if (num==3){
                Toast.makeText(context, "郁麟枫 VS 文斯莫克.山治", Toast.LENGTH_SHORT).show();
            }
            else if (num==4){
                Toast.makeText(context, "郁麟枫 VS 妮可.罗宾", Toast.LENGTH_SHORT).show();
            }
            else if (num==5){
                Toast.makeText(context, "郁麟枫 VS 娜美", Toast.LENGTH_SHORT).show();
            }

        }
    }



}
