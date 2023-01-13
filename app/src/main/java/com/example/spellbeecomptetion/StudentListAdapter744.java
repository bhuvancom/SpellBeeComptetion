package com.example.spellbeecomptetion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author  : Indra
 **/

public class StudentListAdapter744 extends ListAdapter<Student, StudentListAdapter744.StViewHolder> {

    protected StudentListAdapter744(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public StViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class StViewHolder extends RecyclerView.ViewHolder {
        TextView name, regNo, attn, gender;

        private TextView getView(View v, @IdRes int id) {
            return v.findViewById(id);
        }

        public StViewHolder(@NonNull View itemView) {
            super(itemView);
            name = getView(itemView, R.id.name);
            regNo = getView(itemView, R.id.reg_no);
            attn = getView(itemView, R.id.attn);
            gender = getView(itemView, R.id.gender);
        }

        public void bind(Student student) {
            name.setText("Name - " + student.name);
            regNo.setText("Roll no - " + student.rollNumber);
            attn.setText("Marks in english - " + student.engMarkPerc + "%");
            gender.setText("Class - " + student.classIn);
        }
    }
}
