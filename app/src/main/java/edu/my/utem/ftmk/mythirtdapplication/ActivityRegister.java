package edu.my.utem.ftmk.mythirtdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityRegisterBinding;

public class ActivityRegister extends AppCompatActivity {

    ActivityRegisterBinding binding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;


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

        drawerLayout = binding.navRegister;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name, R.string.date);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = binding.navigation;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Intent intent;
                int itemId = item.getItemId();

                if (itemId == R.id.nav_login_activity){
                    intent = new Intent(getApplicationContext(),ActivityLogin.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.nav_register) {
                    intent = new Intent(getApplicationContext(),ActivityRegister.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.nav_expenses) {
                    intent = new Intent(getApplicationContext(),ActivityExpense.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        Intent intent = new Intent(this, ActivityExpense.class);
        startActivity(intent);
    }
}

