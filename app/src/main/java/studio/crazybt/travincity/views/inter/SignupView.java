package studio.crazybt.travincity.views.inter;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public interface SignupView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void setEmailError();

    void setServicesError();

    void successSignup(String username, String password);
}
