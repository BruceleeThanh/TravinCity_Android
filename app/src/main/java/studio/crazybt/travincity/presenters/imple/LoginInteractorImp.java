package studio.crazybt.travincity.presenters.imple;

import android.os.Handler;
import android.text.TextUtils;

import studio.crazybt.travincity.presenters.inter.LoginInteractor;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class LoginInteractorImp implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            error = true;
        }
//        if (TextUtils.isEmpty(password)) {
//            listener.onPasswordError();
//            error = true;
//        }
        if (!error) {
            listener.onSuccess(username, password);
        }
    }
}

