package edu.my.utem.ftmk.mythirtdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityExpenseBinding;
import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityLoginBinding;


public class ActivityLogin extends AppCompatActivity {

    ActivityLoginBinding binding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

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
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonLogin.setOnClickListener(this::fnLogin);

        String[] state = {"Johor","Kedah","Kelantan","Melaka","Negeri Sembilan","Pahang","Pulau Pinang","Perak","Perlis","Sabah","Sarawak","Selangor","Terengganu"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, state);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnState.setAdapter(adapter);

        drawerLayout = binding.myDrawerLayout;
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

    public void fnLogin(View view) {
        String username = binding.editLoginName.getText().toString();
        String password = binding.editLoginPassword.getText().toString();
        Intent intent = new Intent(this, ActivityRegister.class);
        intent.putExtra("Username", username);
        intent.putExtra("Password", password);
        startActivity(intent);
    }

}