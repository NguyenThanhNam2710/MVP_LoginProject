package com.example.mvpproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpproject.presenter.LoginPresenter;
import com.example.mvpproject.R;
import com.example.mvpproject.inteface.LoginView;
import com.example.mvpproject.model.User;

public class MainActivity extends AppCompatActivity implements LoginView {

    private TextView textView;
    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUser(edtUser.getText().toString().trim());
                user.setPass(edtPass.getText().toString().trim());
                loginPresenter.login(user.getUser(), user.getPass());
            }
        });
    }

    void init() {

        textView = (TextView) findViewById(R.id.textView);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btn_login);

    }


    @Override
    public void loginFail() {
        Toast.makeText(this, "Login fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateHome() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void setErrorUsername() {
        edtUser.setError("You need to enter username");
        edtUser.requestFocus();
    }

    @Override
    public void setErrorPassword() {
        edtPass.setError("You need to enter password");
        edtPass.requestFocus();
    }
}
