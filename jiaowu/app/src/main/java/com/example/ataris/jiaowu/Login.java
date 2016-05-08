package com.example.ataris.jiaowu;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {


    public static String uid = null;
    public static boolean is_login = false;
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        uid = username.getText().toString();
        String pass = password.getText().toString();

        switch (uid) {
            case "2012012136":
                if (pass.equals("password"))
                    is_login = true;
                break;
            case "admin":
                if (pass.equals("test"))
                    is_login = true;
                break;
            default:
                is_login = true;
                //is_login = false;
                break;
        }
        if (is_login)
            startActivity(new Intent(this, MainActivity.class));
        else
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }
}