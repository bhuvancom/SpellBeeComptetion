package com.example.spellbeecomptetion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MyAppDB myAppDB;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_marks, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int show = 0;
        if (item.getItemId() == R.id.menu_all) {
            show = 1;
        } else if (item.getItemId() == R.id.menu_80) {
            show = 80;
        } else if (item.getItemId() == R.id.menu_less30) {
            show = 30;
        } else if (item.getItemId() == R.id.menu_class9) {
            show = 9;
        } else if (item.getItemId() == R.id.menu_class10) {
            show = 10;
        }
        if (show > 0) {
            Intent intent = new Intent(MainActivity.this, StudentList744.class);
            intent.putExtra("show", show);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    String getValue744(@IdRes int id) {
        TextInputLayout layout = findViewById(id);
        return layout.getEditText().getText().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDB = new MyAppDB(this);
        Button btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitStudent();
            }
        });
    }

    private int attn(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void submitStudent() {
        String regNo = getValue744(R.id.reg_no);
        String name = getValue744(R.id.name);
        int att = attn(getValue744(R.id.attn_perc));
        RadioGroup classIn = findViewById(R.id.rg_atn);
        int rb = classIn.getCheckedRadioButtonId();
        RadioButton rbt = findViewById(rb);
        String gen = rbt.getText().toString();
        Student s = new Student(name, regNo, att, gen);
        myAppDB.addStudent(s);

        Toast.makeText(this, "Added success", Toast.LENGTH_SHORT).show();
    }

}