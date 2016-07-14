package studio.crazybt.travincity.views.inter;

import java.util.List;

import studio.crazybt.travincity.models.NewsFeedPage;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public interface Tab1View {

    void setPost(List<NewsFeedPage> newsFeedPageList);

    void showProgress();

    void hideProgress();
}
