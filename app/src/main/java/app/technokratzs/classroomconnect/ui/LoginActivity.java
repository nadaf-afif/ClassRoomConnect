package app.technokratzs.classroomconnect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.technokratzs.classroomconnect.R;

/**
 * Created by afif on 23/5/15.
 */
public class LoginActivity extends Activity {

    private EditText mUserNameEditText, mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {

        mUserNameEditText = (EditText) findViewById(R.id.usernameEditText);
        mPasswordEditText = (EditText)findViewById(R.id.passwordEditText);
        mLoginButton = (Button)findViewById(R.id.loginButton);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doLogin();
            }
        });

    }

    private void doLogin() {

        String username = mUserNameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin")){

            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
