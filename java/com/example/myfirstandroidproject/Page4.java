package com.example.myfirstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Page4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);


        RadioButton rbutton=findViewById(R.id.radioButton);
        Button btnsub=findViewById(R.id.button5);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent recieve=getIntent();
                int TrueAnswer=recieve.getIntExtra("true answer",0);
                int FalseAnswer=recieve.getIntExtra("false answer",0);
                int NumberOfTests=recieve.getIntExtra("tests number",0);
                Toast.makeText(Page4.this, "جواب شما با موفقیت ثبت شد", Toast.LENGTH_SHORT).show();
                NumberOfTests++;
                if (rbutton.isChecked()) {
                    ++TrueAnswer;
                    Intent intentok=new Intent (Page4.this,ResaultPage.class);
                    intentok.putExtra("true answer",TrueAnswer);
                    intentok.putExtra("false answer",FalseAnswer);
                    intentok.putExtra("tests number",NumberOfTests);
                    startActivity(intentok);


                } else {
                    ++FalseAnswer;
                    Intent intentfalse=new Intent (Page4.this,ResaultPage.class);
                    intentfalse.putExtra("false answer",FalseAnswer);
                    intentfalse.putExtra("true answer",TrueAnswer);
                    intentfalse.putExtra("tests number",NumberOfTests);
                    startActivity(intentfalse);
                }

            }
        });
    }
}