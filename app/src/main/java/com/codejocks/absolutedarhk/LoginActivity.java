package com.codejocks.absolutedarhk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout loginPanel;
    private boolean isPanelShown = false;
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPanel = (LinearLayout) findViewById(R.id.hidden_panel);
        TextView login = (TextView) findViewById(R.id.login_textView);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideUpDown();
            }
        });

        emailEditText = (EditText) findViewById(R.id.email_editText);
        passwordEditText = (EditText) findViewById(R.id.password_editText);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        TextView signUp = (TextView) findViewById(R.id.signup_textView);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

    }

    public void slideUpDown() {
        if(!isPanelShown) {
            // Show the panel
            Animation bottomUp = AnimationUtils.loadAnimation(this,
                    R.anim.bottom_up);

            loginPanel.startAnimation(bottomUp);
            loginPanel.setVisibility(View.VISIBLE);
            isPanelShown = true;
            emailEditText.clearFocus();
        }
        else {
            // Hide the Panel
            Animation bottomDown = AnimationUtils.loadAnimation(this,
                    R.anim.bottom_down);

            loginPanel.startAnimation(bottomDown);
            loginPanel.setVisibility(View.INVISIBLE);
            isPanelShown = false;
        }
    }

    @Override
    public void onBackPressed(){
        if(isPanelShown){
            slideUpDown();
        } else {
            super.onBackPressed();
        }
    }

}
