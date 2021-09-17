package umn.ac.id;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSatu, btnDua;
    private EditText etIsian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSatu = findViewById(R.id.main_button_change_1);
        btnDua = findViewById(R.id.main_button_change_2);
        etIsian = findViewById(R.id.editText);

        btnSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                String name = etIsian.getText().toString();
                secondIntent.putExtra("Name", name);
                startActivity(secondIntent);
            }
        });

        btnDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdIntent = new Intent(MainActivity.this, ThirdActivity.class);
                String name = etIsian.getText().toString();
                thirdIntent.putExtra("Name", name);
                startActivity(thirdIntent);
            }
        });
    }
}