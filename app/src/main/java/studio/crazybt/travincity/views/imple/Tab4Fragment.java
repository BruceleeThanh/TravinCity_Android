package studio.crazybt.travincity.views.imple;

/**
 * Created by Brucelee Thanh on 11/04/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import studio.crazybt.travincity.models.NotificationPage;
import studio.crazybt.travincity.R;
import studio.crazybt.travincity.adapters.NotificationAdapter;

public class Tab4Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private View rootView;
    private List<NotificationPage> listNotificationPages = new ArrayList<NotificationPage>();
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.tab_fragment_4, container, false);

            swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.srlNotification);
            this.listNotificationPages_Load();
            this.lvNotification_Load(rootView, this.getContext(), R.layout.notification_page, listNotificationPages);
            swipeRefreshLayout.setOnRefreshListener(this);

            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                    refreshNotificationPageList();
                }
            });

        } else {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        return rootView;
    }

    public void listNotificationPages_Load(){
        listNotificationPages.add(new NotificationPage("Đã có 11 người thích bài viết của bạn:\nHồ Hoàn Kiếm còn được gọi là...", R.drawable.ic_favorite));
        listNotificationPages.add(new NotificationPage("Đã có 15 người quan tâm bài viết của bạn:\nHồ Hoàn Kiếm còn được gọi là...", R.drawable.ic_loyalty));
    }

    public void lvNotification_Load(View view, Context context, int layoutId, List<NotificationPage> arr){
        NotificationAdapter adapter = new NotificationAdapter(context, layoutId, arr);
        ListView lvNotification = (ListView) view.findViewById(R.id.lvNotification);
        lvNotification.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onRefresh() {
        this.refreshNotificationPageList();
    }

    private void refreshNotificationPageList(){
        swipeRefreshLayout.setRefreshing(true);

        // refresh: re-request to server task

        swipeRefreshLayout.setRefreshing(false);
    }
}
