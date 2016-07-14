package studio.crazybt.travincity.presenters.inter;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(String username, String password);
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
