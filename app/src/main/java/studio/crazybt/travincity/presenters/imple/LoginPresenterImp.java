package studio.crazybt.travincity.presenters.imple;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import studio.crazybt.travincity.models.LoginData;
import studio.crazybt.travincity.presenters.inter.LoginInteractor;
import studio.crazybt.travincity.presenters.inter.LoginPresenter;
import studio.crazybt.travincity.services.LoginService;
import studio.crazybt.travincity.views.inter.LoginView;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class LoginPresenterImp implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private LoginService loginService;

    public LoginPresenterImp(LoginView loginView, LoginService loginService) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImp();
        this.loginService = loginService;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(String username, String password) {
        final String[] idUser = {null};
        if (loginView != null) {
            loginService.getApi()
                    .getLogin(username, password)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JsonObject>() {
                        @Override
                        public void onCompleted() {
                            loginView.hideProgress();
                        }

                        @Override
                        public void onError(Throwable e) {
                            loginView.setServicesError();
                            loginView.hideProgress();
                        }

                        @Override
                        public void onNext(JsonObject jsonObject) {
                            if (jsonObject != null) {
                                Gson gson = new Gson();
                                LoginData temp = gson.fromJson(jsonObject, LoginData.class);
                                if(temp.isSuccess()){
                                    idUser[0] = temp.getUser().getId();
                                    loginView.navigateToHome(idUser[0]);
                                }else{
                                    loginView.hideProgress();
                                    loginView.setUsernameOrPasswordIncorrect();
                                }
                            }
                        }
                    });
        }
    }
}
