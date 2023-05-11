package com.example.myfirstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        Button btnsub=findViewById(R.id.button3);

        RadioButton rbutton=findViewById(R.id.radioButton4);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent recieve=getIntent();
                int TrueAnswer=recieve.getIntExtra("true answer",0);
                int FalseAnswer=recieve.getIntExtra("false answer",0);
                int NumberOfTests=recieve.getIntExtra("tests number",0);
                NumberOfTests++;
                if (rbutton.isChecked()) {
                    ++TrueAnswer;
                    //Toast.makeText(Page3.this, "درسته", Toast.LENGTH_SHORT).show();
                    Intent intentok=new Intent (Page3.this,Page4.class);
                    intentok.putExtra("true answer",TrueAnswer);
                    intentok.putExtra("false answer",FalseAnswer);
                    intentok.putExtra("tests number",NumberOfTests);
                    startActivity(intentok);

                    /*
                    String truescore=String.valueOf(TrueAnswer);
                    Toast.makeText(MainActivity3.this, truescore, Toast.LENGTH_LONG).show();*/


                } else {
                    ++FalseAnswer;
                //    Toast.makeText(Page3.this, "سوال به این راحتی اشتباه نوشتی!!!", Toast.LENGTH_LONG).show();
                    Intent intentfalse=new Intent (Page3.this,Page4.class);
                    intentfalse.putExtra("false answer",FalseAnswer);
                    intentfalse.putExtra("true answer",TrueAnswer);
                    intentfalse.putExtra("tests number",NumberOfTests);
                    startActivity(intentfalse);
                }

            }
        });
    }
}