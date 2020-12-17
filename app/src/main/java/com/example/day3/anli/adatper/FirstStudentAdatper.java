package com.example.day3.anli.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.R;
import com.example.day3.anli.bean.FirstStudentBean;

import java.util.ArrayList;

public class FirstStudentAdatper extends RecyclerView.Adapter<FirstStudentAdatper.ViewHolder> {

    private Context context;
    private ArrayList<FirstStudentBean.StudenlistBean> list;
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public FirstStudentAdatper(Context context, ArrayList<FirstStudentBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.first_student_rel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FirstStudentBean.StudenlistBean studenlistBean = list.get(position);
        holder.studentName.setText("姓名："+studenlistBean.getName());
        holder.studentSkill.setText("理论成绩："+studenlistBean.getSkill()+"分");
        holder.studentTheory.setText("机试成绩："+studenlistBean.getTheory()+"分");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentName;
        private TextView studentSkill;
        private TextView studentTheory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentSkill = itemView.findViewById(R.id.student_skill);
            studentTheory = itemView.findViewById(R.id.student_theory);
        }
    }

    public interface OnClick{
        void onClick(int position);
    }
}
