package edu.my.utem.ftmk.mythirtdapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Vector;
import edu.my.utem.ftmk.mythirtdapplication.R;
import edu.my.utem.ftmk.mythirtdapplication.model.Student;
import edu.my.utem.ftmk.mythirtdapplication.viewholder.StudentViewHolder;


public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder>{
    private final LayoutInflater layoutInflater;
    private final Vector<Student> student;

    public StudentAdapter(LayoutInflater layoutInflater, Vector<Student> students) {
        this.layoutInflater = layoutInflater;
        this.student = students;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new StudentViewHolder(layoutInflater.inflate(R.layout.student_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.setStudent(student.get(position));
    }

    @Override
    public int getItemCount() {
        return student.size();
    }
}
