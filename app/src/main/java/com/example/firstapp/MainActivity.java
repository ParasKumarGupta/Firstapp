package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtname;
    EditText edtname, edtpassword;
    Button btnsubmit,btnsubmit1;
    CheckBox check_box;
    RadioGroup radioGroup;
    RadioButton genderradioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = (EditText) findViewById(R.id.edt_name);
        edtpassword = (EditText) findViewById(R.id.edt_password);
        btnsubmit = findViewById(R.id.btn_Submit);
        txtname = findViewById(R.id.txt_output);
        check_box = findViewById(R.id.check);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        btnsubmit1=(Button)findViewById(R.id.btn_Submit1);

        btnsubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    String name = edtname.getText().toString();
                    String password = edtpassword.getText().toString();
                    Toast.makeText(getApplicationContext(), "Name: " + name + "\n" + "Password: " + password, Toast.LENGTH_LONG).show();
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    genderradioButton = (RadioButton) findViewById(selectedId);
                    if(selectedId==-1){
                        Toast.makeText(MainActivity.this,"No Gender selected", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(MainActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
                    }

                    txtname.setText("Name: " + name + "\n" + "Password: " + password);
                    Intent intent = new Intent(getApplicationContext(), login.class);
                    intent.putExtra("name1", name);
                    intent.putExtra("pass2", password);
                    startActivity(intent);
                }
            });
        }
    }
