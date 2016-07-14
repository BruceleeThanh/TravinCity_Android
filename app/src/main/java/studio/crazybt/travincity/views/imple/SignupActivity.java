package studio.crazybt.travincity.views.imple;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import studio.crazybt.travincity.R;
import studio.crazybt.travincity.presenters.imple.SignupPresenterImp;
import studio.crazybt.travincity.presenters.inter.SignupPresenter;
import studio.crazybt.travincity.services.SignupService;
import studio.crazybt.travincity.views.inter.SignupView;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public class SignupActivity extends AppCompatActivity implements SignupView{

    private ProgressBar pbWaitingRegister;
    private TextView etUsername;
    private TextView etPassword;
    private TextView etEmail;
    private LoginButton loginFacebook;
    private CallbackManager callbackManager;

    private SignupPresenter presenter;
    private SignupService services;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        pbWaitingRegister = (ProgressBar) findViewById(R.id.pbWaitingRegister_acSignup);
        etUsername = (TextView) findViewById(R.id.etUsername_acSignup);
        etPassword = (TextView) findViewById(R.id.etPassword_acSignup);
        etEmail = (TextView) findViewById(R.id.etEmail_acSignup);

        services = new SignupService(this.getBaseContext());
        presenter = new SignupPresenterImp(this, services);

        callbackManager = CallbackManager.Factory.create();
        loginFacebook = (LoginButton)findViewById(R.id.btnLoginFacebook_acSignup);
        loginFacebook.setReadPermissions("email");
        // Other app specific specialization

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
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        pbWaitingRegister.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbWaitingRegister.setVisibility(View.GONE);
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
    public void setEmailError() {
        etEmail.setError(getString(R.string.textview_error));
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
    public void successSignup(String username, String password) {
        Toast.makeText(this, getString(R.string.mesSuccess) + username, Toast.LENGTH_LONG);
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("username",username);
        intent.putExtra("password", password);
        startActivity(intent);
    }

    public void btnSignup_onClick(View view) {
        presenter.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString());
    }
}
