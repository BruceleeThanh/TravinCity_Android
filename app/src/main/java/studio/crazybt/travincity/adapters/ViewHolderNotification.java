package studio.crazybt.travincity.adapters;

import android.widget.ImageView;
import android.widget.TextView;

import studio.crazybt.travincity.models.NotificationPage;

/**
 * Created by Brucelee Thanh on 07/05/2016.
 */
public class ViewHolderNotification {

    public TextView notiContent;

    public ImageView notiIcon;

    public void setData(NotificationPage notificationPage){
        notiContent.setText(notificationPage.getNotiContent());

        notiIcon.setImageResource(notificationPage.getNotiIcon());
    }
}
