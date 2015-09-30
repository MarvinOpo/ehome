package com.uc.ehome;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import helpers.InputHelper;

public class SignUpActivity extends AppCompatActivity {

    protected EditText mEmail;
    protected EditText mFirstName;
    protected EditText mLastName;
    protected EditText mMobileNo;
    protected Spinner mGender;
    protected Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEmail = (EditText) findViewById(R.id.emailField);
        mFirstName = (EditText) findViewById(R.id.firstnameField);
        mLastName = (EditText) findViewById(R.id.lastnameField);
        mMobileNo = (EditText) findViewById(R.id.mobileNoField);
        mGender = (Spinner) findViewById(R.id.genderSpinner);
        mSignUpButton = (Button) findViewById(R.id.signUpButton);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /* Get Input and Parse */
                String email = mEmail.getText().toString(),
                       firstName = mFirstName.getText().toString(),
                       lastName = mLastName.getText().toString(),
                       mobileNo = mMobileNo.getText().toString(),
                       gender = mGender.getSelectedItem().toString();

                /* Sanitize Input */
                email = InputHelper.cleanInput(email);
                firstName = InputHelper.cleanInput(firstName);
                lastName = InputHelper.cleanInput(lastName);
                mobileNo = InputHelper.cleanInput(mobileNo);

                /* Validate Inputs */
                if(email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setTitle(R.string.sign_up_error_title)
                           .setMessage(R.string.sign_up_error)
                           .setPositiveButton(android.R.string.ok, null);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                Toast.makeText(getApplicationContext(), "wlay problema", Toast.LENGTH_SHORT).show();
                /* Connect to server com.uc.ehome.api to check credentials */
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
