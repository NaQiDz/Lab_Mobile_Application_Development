package edu.my.utem.ftmk.mythirtdapplication.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.my.utem.ftmk.mythirtdapplication.R;
import edu.my.utem.ftmk.mythirtdapplication.model.Student;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private final TextView lblFullName, lblStudNo, lblEmail, lblGender, lblBirthdate, lblState;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.lblFullName = itemView.findViewById(R.id.lblFullName);
        this.lblStudNo = itemView.findViewById(R.id.lblStudNo);
        this.lblEmail = itemView.findViewById(R.id.lblEmail);
        this.lblGender = itemView.findViewById(R.id.lblGender);
        this.lblBirthdate = itemView.findViewById(R.id.lblBirthdate);
        this.lblState = itemView.findViewById(R.id.lblState);
    }

    public void setStudent(Student student){
        lblFullName.setText(student.getFullname());
        lblStudNo.setText(student.getStudNo());
        lblEmail.setText(student.getEmail());
        lblGender.setText(student.getGender());
        lblBirthdate.setText(student.getBirthdate());
        lblState.setText(student.getState());
    }
}
