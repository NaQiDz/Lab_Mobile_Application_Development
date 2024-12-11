package edu.my.utem.ftmk.mythirtdapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Calendar;
import java.util.Vector;

import edu.my.utem.ftmk.mythirtdapplication.adapter.StudentAdapter;
import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityStudentMainBinding;
import edu.my.utem.ftmk.mythirtdapplication.model.Student;

public class StudentMainActivity extends AppCompatActivity {

    private ActivityStudentMainBinding binding;
    private Student student;
    private Vector<Student> students;
    private StudentAdapter adapter;
    private DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.fabAdd.setOnClickListener(this::fnAdd);
        binding.edtBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                int mHour = cldr.get(Calendar.HOUR_OF_DAY);
                int mMinute = cldr.get(Calendar.MINUTE);
                String strDay = "";
                datePicker = new DatePickerDialog(StudentMainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                binding.edtBirthdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });
        students = new Vector<>();
        adapter = new StudentAdapter(getLayoutInflater(), students);
        binding.rcvStud.setAdapter(adapter);
        binding.rcvStud.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fnAdd(View view) {
         String fullname = binding.edtFullName.getText().toString();
         String studNo = binding.edtStudNum.getText().toString();
         String email = binding.edtEmail.getText().toString();
         String gender = "";
         String birthdate = binding.edtBirthdate.getText().toString();
         String state = binding.spnState.getSelectedItem().toString();
         if(binding.rbMale.isChecked())
             gender = binding.rbMale.getText().toString();
         else if(binding.rbFemale.isChecked())
             gender = binding.rbFemale.getText().toString();
         student = new Student(fullname, studNo, email, gender, birthdate, state);
         students.add(student);
         adapter.notifyItemInserted(students.size() - 1);

    }
}