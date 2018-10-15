package com.thkrue.cert;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thkrue.cert.util.InputValidator;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private EditText etEmail, etPwd;
    private TextView tvInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        initInputFields();
        initLoginButton();
        initFab();
    }

    private void initInputFields() {
        etEmail = findViewById(R.id.et_email);
        etPwd = findViewById(R.id.et_password);
    }

    public void toasty(View v) {
        Toast.makeText(this, "X", Toast.LENGTH_SHORT).show();
    }

    private void initLoginButton() {
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputValidator validator = new InputValidator();
                if (validator.isValidEmail(etEmail.getText().toString())) {
                    if (validator.isValidPassword(etPwd.getText().toString())) {
                        doLogin();
                    } else {
                        Log.i(TAG, "Wrong password");
                        etPwd.setError("Error");
                    }
                } else {
                    Log.i(TAG, "Wrong email");
                    etEmail.setError("Error");
                }
            }
        });
    }

    private String getCurrentUserNameFromPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.key_username), getString(R.string.default_username));
    }

    private void doLogin() {
        setImageFromAssets();
        tvInfo = findViewById(R.id.tv_info);
        tvInfo.setText("Logged in as " + getCurrentUserNameFromPrefs() + "!");
        tvInfo.setVisibility(View.VISIBLE);
    }

    private void setImageFromAssets() {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getAssets().open("android.png"));
//        Bitmap bitmap = BitmapFactory.decodeStream(getResources().openRawResource(R.raw.android_raw));//Raw alternative
            ((ImageView) findViewById(R.id.iv_header)).setImageBitmap(bitmap);
            //Drawable drawable = Drawable.createFromStream(getAssets().open("android.png"), null);
            //((ImageView) findViewById(R.id.iv_header)).setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initFab() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, DataListActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_start_service:
                MyJobService.scheduleJob(getApplicationContext());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
