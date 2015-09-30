package com.uc.ehome;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uc.ehome.api.JSONParser;
import com.uc.ehome.api.LoginService;
import com.uc.ehome.api.ServiceGenerator;
import com.uc.ehome.models.User;
import constants.URI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.Hashtable;

public class LoginActivity extends AppCompatActivity {

    protected EditText mEmail;
    protected EditText mPassword;
    
    protected Button mSignInButton;

    protected TextView mSignUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mEmail = (EditText) findViewById(R.id.emailField);
        mPassword = (EditText) findViewById(R.id.passwordField);
        mSignInButton = (Button) findViewById(R.id.signInButton);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();


                JSONParser parser = new JSONParser();
                JSONArray jArray = parser.getJSONFromUrl("http://ehomeuc.eu1.frbit.net/user/2/task");

                try {
                    Toast.makeText(LoginActivity.this, "JSON: "+jArray.getJSONObject(0), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
                //login(email, password);
            }
        });

        mSignUpTextView = (TextView) findViewById(R.id.signUpText);
        mSignUpTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(String email, String password) {
        Hashtable credentials = new Hashtable();
        credentials.put("email", email);
        credentials.put("password", password);

        LoginService loginService = ServiceGenerator.createService(LoginService.class, URI.BASE_URI, email, password);
        loginService.basicLogin(credentials, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                Toast.makeText(LoginActivity.this, "Success User: " + user.firstname, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(LoginActivity.this, "Request Failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
