package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private int num_1 = 0, num_2 = 0;
    private TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        display = (TextView)findViewById(R.id.sa_result);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            num_1 = b.getInt("num1");
            num_2 = b.getInt("num2");
        }
        String out_num1 = "" + num_1, out_num2 = "" + num_2;
        ((EditText)findViewById(R.id.sa_num_1)).setText(out_num1);
        ((EditText)findViewById(R.id.sa_num_2)).setText(out_num2);
        display.setText(" "); //show empty
    }
    public void handleFunctions(View v){

        try{
            num_1 = Integer.parseInt(((EditText)findViewById(R.id.sa_num_1)).getText().toString());
            num_2 = Integer.parseInt(((EditText)findViewById(R.id.sa_num_2)).getText().toString());
            Log.d("NUM INPUTS","num1 = " + num_1 + " num2 = " + num_2);
        }catch (NumberFormatException e){
            Log.d("NUM INPUTS","" + e.getMessage());
        }
        String output = "";
        double ans = 0.00;
        switch (v.getId()){
            case R.id.btn_plus:
                output = num_1 + " + " +num_2+" = " + (num_1+num_2);
                break;
            case R.id.btn_minus:
                output = num_1 + " - " +num_2+" = " + (num_1-num_2);
                break;
            case R.id.btn_multi:
                output = num_1 + " * " +num_2+" = " + (num_1*num_2);
                break;
            case R.id.btn_div:
                ans =  (Double.valueOf(num_1)/Double.valueOf(num_2));
                output = num_1 + " / " +num_2+" = " + String.format("%.2f",ans);
                break;
            default:
                output = " ";
                break;
        }
        Log.d("RESULT: ","" + output);
        display.setText(output);
    }
}