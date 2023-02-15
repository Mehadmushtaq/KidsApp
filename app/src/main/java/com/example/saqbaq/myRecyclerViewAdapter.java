package com.example.saqbaq;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.myVH> {

    List<Student> studentList;
    public myRecyclerViewAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new myVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.myVH holder, int position) {
        holder.std = studentList.get(position);
        holder.textViewName.setText(holder.std.getName().toString());
        holder.textViewRollNo.setText(holder.std.getRollNo().toString());
        holder.textViewSabaq.setText(String.valueOf(holder.std.getSabaq()));
        holder.textViewSabqi.setText(String.valueOf(holder.std.getSabqi()));
        holder.textViewManzil.setText(String.valueOf(holder.std.getManzil()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class myVH extends RecyclerView.ViewHolder{

        TextView textViewName,textViewRollNo,textViewSabaq,textViewSabqi,textViewManzil;
        Student std;

        public myVH(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewRollNo = itemView.findViewById(R.id.textViewRollNo);
            textViewSabaq = itemView.findViewById(R.id.textViewSabaq);
            textViewSabqi = itemView.findViewById(R.id.textViewSabqi);
            textViewManzil = itemView.findViewById(R.id.textViewManzil);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MainActivity3.class);

                    intent.putExtra("id",std.getId());
                    intent.putExtra("Name",textViewName.getText().toString());
                    intent.putExtra("RollNo",textViewRollNo.getText().toString());
                    intent.putExtra("Sabaq",Integer.parseInt(textViewSabaq.getText().toString()));
                    intent.putExtra("Sabqi",Integer.parseInt(textViewSabqi.getText().toString()));
                    intent.putExtra("Manzil",Integer.parseInt(textViewManzil.getText().toString()));

                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
