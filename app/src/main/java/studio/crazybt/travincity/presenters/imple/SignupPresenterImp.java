package studio.crazybt.travincity.presenters.imple;

import com.google.gson.JsonObject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import studio.crazybt.travincity.presenters.inter.SignupInteractor;
import studio.crazybt.travincity.presenters.inter.SignupPresenter;
import studio.crazybt.travincity.services.SignupService;
import studio.crazybt.travincity.views.inter.SignupView;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public class SignupPresenterImp implements SignupPresenter, SignupInteractor.OnSignupFinishedListener {

    private SignupView signupView;
    private SignupInteractor signupInteractor;
    private SignupService signupService;

    public SignupPresenterImp(SignupView signupView, SignupService signupService) {
        this.signupView = signupView;
        this.signupInteractor = new SignupInteractorImp();
        this.signupService = signupService;
    }

    @Override
    public void validateCredentials(String username, String password, String email) {
        if (signupView != null) {
            signupView.showProgress();
        }
        signupInteractor.signup(username, password, email, this);
    }

    @Override
    public void onDestroy() {
        signupView = null;
    }

    @Override
    public void onUsernameError() {
        if(signupView!=null){
            signupView.setUsernameError();
            signupView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(signupView!=null){
            signupView.setPasswordError();
            signupView.hideProgress();
        }
    }

    @Override
    public void onEmailError() {
        if(signupView!=null){
            signupView.setEmailError();
            signupView.hideProgress();
        }
    }

    @Override
    public void onSuccess(final String username, final String password, String email) {
        if (signupView != null) {
            signupService.getApi()
                    .setSignup(username, password, email)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JsonObject>() {
                        @Override
                        public void onCompleted() {
                            signupView.hideProgress();
                            signupView.successSignup(username, password);
                        }

                        @Override
                        public void onError(Throwable e) {
                            signupView.setServicesError();
                            signupView.hideProgress();
                        }

                        @Override
                        public void onNext(JsonObject jsonObject) {
                            if(!jsonObject.isJsonNull()){
                                if(jsonObject.get("type").getAsBoolean()){
                                    this.onCompleted();
                                }
                            }
                        }
                    });
        }
    }



}
