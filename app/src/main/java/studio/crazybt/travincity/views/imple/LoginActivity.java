package studio.crazybt.travincity.views.imple;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.w3c.dom.Text;

import studio.crazybt.travincity.R;
import studio.crazybt.travincity.models.LoginData;
import studio.crazybt.travincity.presenters.imple.LoginPresenterImp;
import studio.crazybt.travincity.presenters.inter.LoginPresenter;
import studio.crazybt.travincity.services.LoginService;
import studio.crazybt.travincity.views.inter.LoginView;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private String username;
    private String password;

    private ProgressBar pbWaitingLogin;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvSignup;
    private LoginPresenter presenter;
    private LoginService service;
    private LoginButton loginFacebook;
    private CallbackManager callbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        pbWaitingLogin = (ProgressBar) findViewById(R.id.pbWaitingLogin_acLogin);
        etUsername = (EditText) findViewById(R.id.etUsername_acLogin);
        etPassword = (EditText) findViewById(R.id.etPassword_acLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin_acLogin);
        tvSignup = (TextView) findViewById(R.id.tvSignup_acLogin);
        service = new LoginService(this.getBaseContext());
        presenter = new LoginPresenterImp(this, service);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
            password = extras.getString("password");
            etUsername.setText(username);
            etPassword.setText(password);
        }

        callbackManager = CallbackManager.Factory.create();

        loginFacebook = (LoginButton)findViewById(R.id.btnLoginFacebook_acLogin);
        loginFacebook.setReadPermissions("email");
        // Other app specific specialization

        tvSignup.setPaintFlags(tvSignup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Callback registration
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        pbWaitingLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbWaitingLogin.setVisibility(View.GONE);

    }

    @Override
    public void setUsernameError() {
        etUsername.setError(getString(R.string.textview_error));
    }

    @Override
    public void setPasswordError() {
        etPassword.setError(getString(R.string.textview_error));
    }

    @Override
    public void setUsernameOrPasswordIncorrect() {
        etUsername.setError(getString(R.string.username_password_incorrect));
    }

    @Override
    public void setServicesError() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_services_error_title))
                .setMessage(getString(R.string.dialog_services_error_message))
                .setPositiveButton(getString(R.string.dialog_services_error_dismiss), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void navigateToHome(String idUser) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("idUser", idUser);
        startActivity(intent);
        this.finish();
    }

    public void btnLogin_onClick(View view) {
        presenter.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString());
    }

    public void tvForgetPassword_onClick(View view) {

    }

    public void tvSignup_onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
        this.finish();
    }
}
