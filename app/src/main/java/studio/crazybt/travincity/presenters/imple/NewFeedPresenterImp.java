package studio.crazybt.travincity.presenters.imple;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import studio.crazybt.travincity.models.Post;
import studio.crazybt.travincity.models.PostData;
import studio.crazybt.travincity.models.User;
import studio.crazybt.travincity.presenters.inter.NewFeedPresenter;
import studio.crazybt.travincity.services.MainService;
import studio.crazybt.travincity.services.PostService;
import studio.crazybt.travincity.views.inter.MainView;
import studio.crazybt.travincity.views.inter.Tab1View;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class NewFeedPresenterImp implements NewFeedPresenter {

    private Tab1View tab1View;
    private PostService postService;

    public NewFeedPresenterImp(Tab1View tab1View, PostService postService) {
        this.tab1View = tab1View;
        this.postService = postService;
    }

    @Override
    public void requestData_NewFeed() {
        if(tab1View != null){
            tab1View.showProgress();
        }
        final PostData[] postDatas = {null};
        if (tab1View != null) {
            postService.getApi()
                    .getPost()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JsonObject>() {
                        @Override
                        public void onCompleted() {
                            tab1View.hideProgress();
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(JsonObject jsonObject) {
                            if (jsonObject != null) {
                                Gson gson = new Gson();
                                PostData temp = gson.fromJson(jsonObject, PostData.class);
                                if(temp != null){
                                    postDatas[0] = temp;
                                    tab1View.setPost(postDatas[0].getNewsFeedPages());
                                }
                            }
                        }
                    });
        }
    }

    @Override
    public void onDestroy() {

    }
}
