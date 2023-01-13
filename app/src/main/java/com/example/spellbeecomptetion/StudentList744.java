package com.example.spellbeecomptetion;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentList744 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list744);
        TextView textView = findViewById(R.id.tv_menu_top2);
        RecyclerView rv = findViewById(R.id.rv_students);

        DiffUtil.ItemCallback<Student> itemCallback = new DiffUtil.ItemCallback<Student>() {

            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem == newItem;
            }
        };

        int show = getIntent().getIntExtra("show", 0);
        StudentListAdapter744 studentListAdapter744 = new StudentListAdapter744(itemCallback);
        MyAppDB myAppDB = new MyAppDB(this);
        List<Student> student = null;
        String msg = "All Student";

        if (show == 30) {
            student = myAppDB.get30Perc();
            msg = "Students with less than 30% in english";
        } else if (show == 80) {
            msg = "Students with more than 80% in english";
            student = myAppDB.get80Student();
        } else if (show == 9) {
            msg = "Students from class IX";
            student = myAppDB.getClass("IX");
        } else if (show == 10) {
            msg = "Students from class X";
            student = myAppDB.getClass("X");
        } else {
            student = myAppDB.getAllStudent();
            msg = "All Students count " + (student.size());
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textView.setText(msg);
        studentListAdapter744.submitList(student);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(studentListAdapter744);

    }
}