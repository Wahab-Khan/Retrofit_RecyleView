package com.example.khan.retrorecyleviewtest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KHAN on 11/15/2017.
 */

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.StudentViewHolder> {

    private List<Student> students;

    public RV_Adapter(List<Student> students) {
        this.students = students;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView sName , sId , sMarks;
        CardView cardView;
        private StudentViewHolder(View itemView) {
            super(itemView);
            Log.i("hodler","in View  Holder");
            sName = (TextView) itemView.findViewById(R.id.name);
            sId = (TextView) itemView.findViewById(R.id.ID);
            sMarks = (TextView) itemView.findViewById(R.id.marks);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("create" , "creating view holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Log.i("bind" ,"onBind View ");
        Student student=students.get(position);
        holder.sName.setText(student.name);
        holder.sId.setText(student.ID);
        holder.sMarks.setText(student.marks);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

}
