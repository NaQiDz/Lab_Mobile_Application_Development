package edu.my.utem.ftmk.mythirtdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityLoginBinding;

public class ActivityLogin extends AppCompatActivity {

    ActivityLoginBinding binding;

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