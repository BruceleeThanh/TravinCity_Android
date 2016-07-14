package studio.crazybt.travincity.presenters.imple;

import android.text.TextUtils;

import studio.crazybt.travincity.presenters.inter.SignupInteractor;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public class SignupInteractorImp implements SignupInteractor {
    @Override
    public void signup(String username, String password, String email, OnSignupFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;
        }
        if (TextUtils.isEmpty(email)) {
            listener.onEmailError();
            error = true;
        }
        if (!error) {
            listener.onSuccess(username, password, email);
        }
    }
}
