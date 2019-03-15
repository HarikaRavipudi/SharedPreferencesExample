package com.example.acer.sharedcount;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button bblack,bred,bgreen,bblue;
    int cnt=0,colorcode;
    SharedPreferences sp;
    private String spFileName="com.example.acer.sharedcount";
    private String countkey="countkey";
    private String colorkey="colorkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        bblack=findViewById(R.id.black);
        bblue=findViewById(R.id.blue);
        bgreen=findViewById(R.id.green);
        bred=findViewById(R.id.red);
        sp=getSharedPreferences(spFileName,MODE_PRIVATE);
            cnt=sp.getInt(countkey,cnt);
                textView.setText(String.valueOf(cnt));
            colorcode=sp.getInt(colorkey,colorcode);
            if(colorcode!=0)
            textView.setBackgroundColor(colorcode);
        }


    public void btnblack(View view) {
    int code=getResources().getColor(R.color.black);
        textView.setBackgroundColor(code);
        colorcode=code;
    }

    public void btnred(View view) {
        int code=getResources().getColor(R.color.red);
        textView.setBackgroundColor(code);
        colorcode=code;
    }

    public void btnblue(View view) {
        int code=getResources().getColor(R.color.blue);
        textView.setBackgroundColor(code);
        colorcode=code;
    }

    public void btngreen(View view) {
        int code=getResources().getColor(R.color.green);
        textView.setBackgroundColor(code);
        colorcode=code;
    }

    public void count(View view) {
        cnt++;
        textView.setText(String.valueOf(cnt));
    }

    public void reset(View view) {
        cnt=0;
        textView.setText(String.valueOf(cnt));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countkey,cnt);
        editor.putInt(colorkey,colorcode);
        editor.apply();
        //Toast.makeText(this, "count:"+cnt+"\n"+colorcode+"\n:Successfully set", Toast.LENGTH_SHORT).show();
    }
}
