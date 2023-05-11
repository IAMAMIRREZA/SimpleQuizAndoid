package com.example.myfirstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResaultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resault_page);

        TextView exampercent=findViewById(R.id.textView11);
        Button btnrestart=findViewById(R.id.button4);

        TextView trueanswer=findViewById(R.id.textView12);
        TextView falseanswer=findViewById(R.id.textView7);
        TextView numberoftest=findViewById(R.id.textView10);

        Intent recieve=getIntent();
        int TrueAnswer=recieve.getIntExtra("true answer",0);
        int FalseAnswer=recieve.getIntExtra("false answer",0);
        int NumberOfTests=recieve.getIntExtra("tests number",0);
        //  int percent=((3*TrueAnswer)-(FalseAnswer)/(NumberOfTests*3));
        double percent=((3*TrueAnswer)-FalseAnswer)/(NumberOfTests*3);


        trueanswer.setText("تست های درست : "+String.valueOf(TrueAnswer));
        trueanswer.setTextSize(25);
        trueanswer.setTextColor(Color.GREEN);

        falseanswer.setText("تست های غلط : "+String.valueOf(FalseAnswer));
        falseanswer.setTextSize(25);
        falseanswer.setTextColor(Color.RED);

        numberoftest.setText("تعداد سوالات : "+String.valueOf(NumberOfTests));
        numberoftest.setTextSize(25);
        numberoftest.setTextColor(Color.BLUE);



        exampercent.setText("درصد شما: "+String.valueOf(percent)+"%");
        exampercent.setTextSize(25);
        exampercent.setTextColor(Color.GREEN);

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResaultPage.this,"آزمون مجدد",Toast.LENGTH_LONG).show();
                Intent backpage1=new Intent(ResaultPage.this,MainActivity.class);
                startActivity(backpage1);

            }

        });

    }
}