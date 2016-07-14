package studio.crazybt.travincity.adapters;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import studio.crazybt.travincity.models.NewsFeedPage;

/**
 * Created by Brucelee Thanh on 03/05/2016.
 */
public class ViewHolderNewsFeed {
    public TextView profileName;
    public TextView location;
    public TextView time;
    public TextView postContent;
    public TextView likeCounter;
    public TextView pinCounter;
    public TextView commentCounter;
    public EditText writeComment;

    public ImageView profileImage;
    public ImageView postImage;
    public ImageView likeIcon;
    public ImageView pinIcon;
    public ImageView commentIcon;
    public ImageView reportProblemIcon;
    public ImageView sendCommentIcon;

    public void setData(NewsFeedPage aNewsFeedPage){
        profileName.setText(aNewsFeedPage.getProfileName());
        location.setText(aNewsFeedPage.getLocation());
        time.setText(aNewsFeedPage.getTime());
        postContent.setText(aNewsFeedPage.getPostContent());
        likeCounter.setText(aNewsFeedPage.getLikeCounter());
        pinCounter.setText(aNewsFeedPage.getPinCounter());
        commentCounter.setText(aNewsFeedPage.getCommentCounter());

        profileImage.setImageResource(aNewsFeedPage.getProfileImage());
        postImage.setImageResource(aNewsFeedPage.getPostImage());
        new DownloadImageTask(postImage).execute(aNewsFeedPage.getImageURL());
        likeIcon.setImageResource(aNewsFeedPage.getLikeIcon());
        pinIcon.setImageResource(aNewsFeedPage.getPinIcon());
        commentIcon.setImageResource(aNewsFeedPage.getCommentIcon());
        reportProblemIcon.setImageResource(aNewsFeedPage.getReportProblemIcon());
        sendCommentIcon.setImageResource(aNewsFeedPage.getSendCommentIcon());
    }
}
