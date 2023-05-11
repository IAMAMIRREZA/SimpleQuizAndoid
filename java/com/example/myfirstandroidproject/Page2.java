package com.example.myfirstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        RadioButton rbutton=findViewById(R.id.radioButton3);


        Button btnsub=findViewById(R.id.button2);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int TrueAnswer=0;
                int FalseAnswer=0;
                int NumberOfTests=0;
                NumberOfTests++;
                Toast.makeText(Page2.this, "جواب شما ثبت شد", Toast.LENGTH_SHORT).show();
                if (rbutton.isChecked()) {
                    ++TrueAnswer;
                    Intent intentok=new Intent (Page2.this,Page3.class);
                    intentok.putExtra("true answer",TrueAnswer);
                    intentok.putExtra("false answer",FalseAnswer);
                    intentok.putExtra("tests number",NumberOfTests);
                    startActivity(intentok);

                }   else {
                    ++FalseAnswer;
                    Intent intentfalse=new Intent (Page2.this,Page3.class);
                    intentfalse.putExtra("false answer",FalseAnswer);
                    intentfalse.putExtra("true answer",TrueAnswer);
                    intentfalse.putExtra("tests number",NumberOfTests);
                    startActivity(intentfalse);
                }
            }
        });
    }
}