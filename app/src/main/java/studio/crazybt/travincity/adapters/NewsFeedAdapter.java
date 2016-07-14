package studio.crazybt.travincity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import studio.crazybt.travincity.R;
import studio.crazybt.travincity.models.NewsFeedPage;


/**
 * Created by Brucelee Thanh on 26/04/2016.
 */
public class NewsFeedAdapter extends ArrayAdapter<NewsFeedPage> {

    List<NewsFeedPage> listNewsFeedPages;
    LayoutInflater inflater;

    public NewsFeedAdapter(Context context, int layoutId, List<NewsFeedPage> object) {
        super(context, layoutId, object);
        listNewsFeedPages = object;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolderNewsFeed viewHolderNewsFeed;
        if(view==null){
            view = inflater.inflate(R.layout.newsfeed_page, parent, false);
            viewHolderNewsFeed = new ViewHolderNewsFeed();
            viewHolderNewsFeed.profileName = (TextView) view.findViewById(R.id.tvProfileName);
            viewHolderNewsFeed.location = (TextView) view.findViewById(R.id.tvLocation);
            viewHolderNewsFeed.time = (TextView) view.findViewById(R.id.tvTime);
            viewHolderNewsFeed.postContent = (TextView) view.findViewById(R.id.tvPostContent);
            viewHolderNewsFeed.likeCounter = (TextView) view.findViewById(R.id.tvLikeCounter);
            viewHolderNewsFeed.pinCounter = (TextView) view.findViewById(R.id.tvPinCounter);
            viewHolderNewsFeed.commentCounter = (TextView) view.findViewById(R.id.tvCommentCounter);

            viewHolderNewsFeed.profileImage = (ImageView) view.findViewById(R.id.ivProfileImage);
            viewHolderNewsFeed.postImage = (ImageView) view.findViewById(R.id.ivPostImage);
            viewHolderNewsFeed.likeIcon = (ImageView) view.findViewById(R.id.ibLikeIcon);
            viewHolderNewsFeed.pinIcon = (ImageView) view.findViewById(R.id.ibPinIcon);
            viewHolderNewsFeed.commentIcon = (ImageView) view.findViewById(R.id.ibCommentIcon);
            viewHolderNewsFeed.reportProblemIcon = (ImageView) view.findViewById(R.id.ibReportProblemIcon);
            viewHolderNewsFeed.sendCommentIcon = (ImageView) view.findViewById(R.id.ibSendCommentIcon);

            view.setTag(viewHolderNewsFeed);
        }else {
            viewHolderNewsFeed = (ViewHolderNewsFeed) view.getTag();
        }

        NewsFeedPage newsFeedPage = listNewsFeedPages.get(position);
        viewHolderNewsFeed.setData(newsFeedPage);

        return view;
    }
}

