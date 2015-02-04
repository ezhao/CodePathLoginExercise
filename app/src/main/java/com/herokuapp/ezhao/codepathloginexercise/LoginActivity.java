package com.herokuapp.ezhao.codepathloginexercise;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        Drawable[] myDrawables = etEmail.getCompoundDrawables();
        Toast.makeText(getApplicationContext(),"Testing toasts",Toast.LENGTH_SHORT);
    }

    public void onLoginFieldClicked(View v) {
        Log.i("emily_debug_logs", "EditText email field clicked");
    }

    public void onForgotPasswordClicked(View v) {
        // Change what some of the UI says
        TextView tvBottomLeft = (TextView) findViewById(R.id.tvBottomLeft);
        tvBottomLeft.setText(getResources().getText(R.string.log_in));

        TextView tvTopRight = (TextView) findViewById(R.id.tvTopRight);
        tvTopRight.setText(getResources().getText(R.string.send_caps));

        // Remove the "Password" field
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        animate(etPassword).alpha(0).translationYBy(100);

        // Also remove the "Forgot password" button
        animate(v).alpha(0);
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
