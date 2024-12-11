package edu.my.utem.ftmk.mythirtdapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

import edu.my.utem.ftmk.mythirtdapplication.databinding.ActivityExpenseBinding;

public class ActivityExpense extends AppCompatActivity {

    ActivityExpenseBinding binding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Integer[] numbers = new Integer[15];
        for (int i = 0; i < 15; i++){
            numbers[i] = i +1;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnQty.setAdapter(adapter);
        binding.btnSave.setOnClickListener(this::fnSaveExp);
        binding.imgExp.setOnClickListener(this::fnTakePic);

        drawerLayout = binding.navExpenses;
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

    public void fnSaveExp(View view){
        int qtyItem = (int) binding.spnQty.getSelectedItem();
        binding.txtVwTotalPrice.setText("" + qtyItem * Float.parseFloat(binding.edtExpValue.getText().toString()));
    }

    public void fnTakePic(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        binding.imgExp.setImageBitmap(bitmap);

        binding.edtExpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fnInvokeDatePicker();
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

    DatePickerDialog pickerDialog;
    private void fnInvokeDatePicker(){
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        pickerDialog = new DatePickerDialog(ActivityExpense.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                binding.edtExpDate.setText(dayOfMonth + "/" + month + "/" + year);
            }
        },year,month,day);
        pickerDialog.show();
    }
}