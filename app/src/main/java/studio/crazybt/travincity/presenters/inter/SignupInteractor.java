package studio.crazybt.travincity.presenters.inter;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public interface SignupInteractor {

    interface OnSignupFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onEmailError();

        void onSuccess(String username, String password, String email);
    }

    void signup(String username, String password, String email, OnSignupFinishedListener listener);
}
