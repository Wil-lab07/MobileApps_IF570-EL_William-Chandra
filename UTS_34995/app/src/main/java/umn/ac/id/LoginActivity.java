package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText loginText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginText = findViewById(R.id.loginText);
        loginBtn = findViewById(R.id.loginBtn);
        setTitle("Login");

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLibrary = new Intent(LoginActivity.this, LibraryActivity.class);
                String username = loginText.getText().toString();
                if(username.isEmpty()){
                    loginText.setError("Harap Diisi");
                }
                else{
                    intentLibrary.putExtra("Message", username);
                    startActivity(intentLibrary);
                }
            }
        });
    }
}