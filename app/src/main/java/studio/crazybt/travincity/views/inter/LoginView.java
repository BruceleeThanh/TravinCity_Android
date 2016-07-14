package studio.crazybt.travincity.views.inter;

import studio.crazybt.travincity.models.LoginData;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void setUsernameOrPasswordIncorrect();

    void setServicesError();

    void navigateToHome(String idUser);
}
