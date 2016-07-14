package studio.crazybt.travincity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import studio.crazybt.travincity.models.NotificationPage;
import studio.crazybt.travincity.R;

/**
 * Created by Brucelee Thanh on 07/05/2016.
 */
public class NotificationAdapter extends ArrayAdapter<NotificationPage> {

    List<NotificationPage> listNotificationPages;
    LayoutInflater inflater;

    public NotificationAdapter(Context context, int layoutId, List<NotificationPage> object) {
        super(context, layoutId, object);
        listNotificationPages = object;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolderNotification viewHolderNotification;
        if(view==null){
            view = inflater.inflate(R.layout.notification_page, parent, false);
            viewHolderNotification = new ViewHolderNotification();

            viewHolderNotification.notiContent = (TextView) view.findViewById(R.id.tvNotiContent);

            viewHolderNotification.notiIcon = (ImageView) view.findViewById(R.id.ivNotiIcon);


            view.setTag(viewHolderNotification);
        }else {
            viewHolderNotification = (ViewHolderNotification) view.getTag();
        }

        NotificationPage notificationPage = listNotificationPages.get(position);
        viewHolderNotification.setData(notificationPage);

        return view;
    }
}

