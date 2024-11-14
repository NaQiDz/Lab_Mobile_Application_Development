package edu.my.utem.ftmk.mythirtdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityRegisterBinding;

public class ActivityRegister extends AppCompatActivity {

    ActivityRegisterBinding binding;



    @Override
    protected void onStart() {
        Intent intent = getIntent();
        binding.editRegisterName.setText(intent.getStringExtra("Username"));
        binding.editRegisterPassword.setText(intent.getStringExtra("Password"));
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRegister.setOnClickListener(this::fnCalDate);
    }

    public void fnCalDate(View view){
        String date = binding.editDate.getText().toString();
        String[] dateCal = date.split("/");
        int day = Integer.parseInt(dateCal[0]);
        int month = Integer.parseInt(dateCal[1]);
        int year = Integer.parseInt(dateCal[2]);
        Calendar currentDate = Calendar.getInstance();
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
        int currentMonth = currentDate.get(Calendar.MONTH);
        int currentYear = currentDate.get(Calendar.YEAR);
        int age = currentYear - year;
        if (currentMonth < month || (currentMonth == month && currentDay < day)) {
            age--;
        }
        binding.editDate.setText(String.valueOf("You are " + age +" years old"));
    }
}

