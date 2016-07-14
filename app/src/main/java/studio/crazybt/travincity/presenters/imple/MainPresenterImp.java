package studio.crazybt.travincity.presenters.imple;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import studio.crazybt.travincity.models.LoginData;
import studio.crazybt.travincity.models.User;
import studio.crazybt.travincity.presenters.inter.MainPresenter;
import studio.crazybt.travincity.services.MainService;
import studio.crazybt.travincity.views.inter.MainView;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class MainPresenterImp implements MainPresenter {

    private MainView mainView;
    private MainService mainService;

    public MainPresenterImp(MainView mainView, MainService mainService) {
        this.mainView = mainView;
        this.mainService = mainService;
    }

    @Override
    public void requestData_NavHeader(String idUser) {
        if(mainView != null){
            //mainView.showProgress_NavHeader();
        }
        final User[] users = {null};
        if (mainView != null) {
            mainService.getApi()
                    .getNavHeader(idUser)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JsonObject>() {
                        @Override
                        public void onCompleted() {
                            mainView.hideProgress_NavHeader();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(JsonObject jsonObject) {
                            if (jsonObject != null) {
                                Gson gson = new Gson();
                                User temp = gson.fromJson(jsonObject, User.class);
                                if(temp != null){
                                    users[0] = temp;
                                    try {
                                        mainView.setNavHeader(users[0].getCoverImageURL(), users[0].getAvatarImageURL(),
                                                users[0].getFirstName() + users[0].getLastName(), users[0].getEmail());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
        }
    }

    @Override
    public void onDestroy() {
        mainView=null;
    }
}
