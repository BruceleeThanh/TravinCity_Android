package studio.crazybt.travincity.views.imple;

/**
 * Created by Brucelee Thanh on 11/04/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import studio.crazybt.travincity.models.NewsFeedPage;
import studio.crazybt.travincity.R;
import studio.crazybt.travincity.adapters.NewsFeedAdapter;
import studio.crazybt.travincity.presenters.imple.NewFeedPresenterImp;
import studio.crazybt.travincity.presenters.inter.NewFeedPresenter;
import studio.crazybt.travincity.services.PostService;
import studio.crazybt.travincity.views.inter.Tab1View;

public class Tab1Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Tab1View{

    private List<NewsFeedPage> listNewsFeedPage = new ArrayList<NewsFeedPage>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private View rootView;
    private boolean fabStatus;

    ListView lvNewsFeed;
    FloatingActionButton floatingActionButton;
    FloatingActionButton sub_fab_1;
    FloatingActionButton sub_fab_2;
    FloatingActionButton sub_fab_3;
    Animation show_sub_fab_1;
    Animation hide_sub_fab_1;
    Animation show_sub_fab_2;
    Animation hide_sub_fab_2;
    Animation show_sub_fab_3;
    Animation hide_sub_fab_3;
    ProgressBar pbWaitingNewFeead;

    private NewFeedPresenter presenter;
    private PostService services;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);

            pbWaitingNewFeead = (ProgressBar) rootView.findViewById(R.id.pbWaitingNewFeed_fraTab1);

            swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.srlNewsFeed);

            services = new PostService(this.getActivity().getBaseContext());
            presenter = new NewFeedPresenterImp(this, services);

            presenter.requestData_NewFeed();
            //newsFeedPageList_Load();

            this.lvNewsFeed_Load(rootView, this.getContext(), R.layout.newsfeed_page, listNewsFeedPage);

            swipeRefreshLayout.setOnRefreshListener(this);

            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                    refreshNewsFeedPageList();
                }
            });

            this.fab_Load(rootView, this.getContext());
            this.subFAB_Load(rootView, this.getContext());

        } else {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }


        return rootView;

    }

    private void fab_Load(View view, final Context context){
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabTab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabStatus == false) {
                    //Display FAB menu
                    expandFAB();
                    fabStatus = true;
                } else {
                    //Close FAB menu
                    hideFAB();
                    fabStatus = false;
                }
            }
        });
        final int[] location = new int[2];
        floatingActionButton.getLocationOnScreen(location);
        lvNewsFeed.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == SCROLL_STATE_TOUCH_SCROLL){
                    floatingActionButton.animate().cancel();
                    floatingActionButton.animate().translationYBy(200);
                }else{
                    floatingActionButton.animate().cancel();
                    floatingActionButton.animate().translationY(location[1]);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    private void subFAB_Load(View view, Context context){
        sub_fab_1 = (FloatingActionButton) view.findViewById(R.id.sub_fab_1_tab1);
        sub_fab_2 = (FloatingActionButton) view.findViewById(R.id.sub_fab_2_tab1);
        sub_fab_3 = (FloatingActionButton) view.findViewById(R.id.sub_fab_3_tab1);
        show_sub_fab_1 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_1_tab_1_show);
        hide_sub_fab_1 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_1_tab_1_hide);
        show_sub_fab_2 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_2_tab_1_show);
        hide_sub_fab_2 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_2_tab_1_hide);
        show_sub_fab_3 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_3_tab_1_show);
        hide_sub_fab_3 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_3_tab_1_hide);

    }

    public void newsFeedPageList_Load(){
        listNewsFeedPage.add(new NewsFeedPage("Brucelee Thanh", "Hồ Hoàn Kiếm, Quận Hoàn Kiếm, Hà Nội", "2 giờ trước",
                "Hồ Hoàn Kiếm còn được gọi là Hồ Gươm (trong bản đồ Hà Nội năm 1886, hồ này được gọi là Hồ Hoàn Gươm - Lac de Hoan Guom), là một hồ nước ngọt tự nhiên của thành phố Hà Nội.",
                "10", "15", "20", "Wow, amazing!", R.drawable.img_profile, R.drawable.hohoankiem));
        listNewsFeedPage.add(new NewsFeedPage("Trang Thư", "Hồ Hoàn Kiếm, Quận Hoàn Kiếm, Hà Nội", "2 giờ trước",
                "Hồ Hoàn Kiếm còn được gọi là Hồ Gươm (trong bản đồ Hà Nội năm 1886, hồ này được gọi là Hồ Hoàn Gươm - Lac de Hoan Guom), là một hồ nước ngọt tự nhiên của thành phố Hà Nội.",
                "10", "15", "20", "Wow, amazing!", R.drawable.img_profile, R.drawable.hohoankiem));
    }

    public void lvNewsFeed_Load(View view, Context context, int layoutId, List<NewsFeedPage> arr){
        NewsFeedAdapter adapter = new NewsFeedAdapter(context, layoutId, arr);
        lvNewsFeed = (ListView) view.findViewById(R.id.lvNewsFeed);
        lvNewsFeed.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onRefresh() {
        this.refreshNewsFeedPageList();
    }

    private void refreshNewsFeedPageList(){
        swipeRefreshLayout.setRefreshing(true);

        // refresh: re-request to server task

        swipeRefreshLayout.setRefreshing(false);
    }

    private void expandFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sub_fab_1.getLayoutParams();
        layoutParams.rightMargin += (int) (sub_fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin += (int) (sub_fab_1.getHeight() * 0.25);
        sub_fab_1.setLayoutParams(layoutParams);
        sub_fab_1.startAnimation(show_sub_fab_1);
        sub_fab_1.setClickable(true);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) sub_fab_2.getLayoutParams();
        layoutParams2.rightMargin += (int) (sub_fab_2.getWidth() * 1.5);
        layoutParams2.bottomMargin += (int) (sub_fab_2.getHeight() * 1.5);
        sub_fab_2.setLayoutParams(layoutParams2);
        sub_fab_2.startAnimation(show_sub_fab_2);
        sub_fab_2.setClickable(true);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) sub_fab_3.getLayoutParams();
        layoutParams3.rightMargin += (int) (sub_fab_3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (sub_fab_3.getHeight() * 1.7);
        sub_fab_3.setLayoutParams(layoutParams3);
        sub_fab_3.startAnimation(show_sub_fab_3);
        sub_fab_3.setClickable(true);
    }


    private void hideFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sub_fab_1.getLayoutParams();
        layoutParams.rightMargin -= (int) (sub_fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (sub_fab_1.getHeight() * 0.25);
        sub_fab_1.setLayoutParams(layoutParams);
        sub_fab_1.startAnimation(hide_sub_fab_1);
        sub_fab_1.setClickable(false);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) sub_fab_2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (sub_fab_2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (sub_fab_2.getHeight() * 1.5);
        sub_fab_2.setLayoutParams(layoutParams2);
        sub_fab_2.startAnimation(hide_sub_fab_2);
        sub_fab_2.setClickable(false);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) sub_fab_3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (sub_fab_3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (sub_fab_3.getHeight() * 1.7);
        sub_fab_3.setLayoutParams(layoutParams3);
        sub_fab_3.startAnimation(hide_sub_fab_3);
        sub_fab_3.setClickable(false);
    }

    @Override
    public void setPost(List<NewsFeedPage> newsFeedPageList) {
        listNewsFeedPage.addAll(newsFeedPageList);

    }

    @Override
    public void showProgress() {
        pbWaitingNewFeead.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbWaitingNewFeead.setVisibility(View.GONE);
    }
}
