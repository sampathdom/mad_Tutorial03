package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleClick(View v){
        if(v.getId()==R.id.fa_ok_btn){
            Context context = getApplicationContext();
            /*
            //Exercise 1: Toast
            CharSequence message = "You just clicked the OK button";
            int duration = Toast.LENGTH_SHORT; //How long the toast
            Toast toast = Toast.makeText(context, message, duration);
            toast.setGravity(Gravity.BOTTOM| Gravity.START, 0, 0);
            toast.show();
             */
            //Exercise 2: Toast
            useCustomToast(Gravity.CENTER,0,0);
            Log.d("EXEC","Executing SecondActivity");
        }
    }

    //MainActivity caller
    public void useCustomToast(int g,int x, int y){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivityForResult(i,1);
    }

    //after MainActivity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Bundle b = new Bundle();
        int num1 = 0, num2 = 0;
        try {
            //when user types in a number
            num1 = Integer.parseInt(((EditText) findViewById(R.id.fa_num_1)).getText().toString());
            num2 = Integer.parseInt(((EditText) findViewById(R.id.fa_num_2)).getText().toString());
            Log.d("NUM INPUTS","num1 = " + num1 + " num2 = " + num2);
        }catch(NumberFormatException e){
            Log.d("NUM INPUTS","" + e.getMessage());
        }

        b.putInt("num1",num1);
        b.putInt("num2",num2);
        Intent i = new Intent(getApplicationContext(),SecondActivity.class);
        i.putExtras(b);
        startActivity(i);
    }
}