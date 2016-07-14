package studio.crazybt.travincity.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.crazybt.travincity.R;

/**
 * Created by Brucelee Thanh on 26/04/2016.
 */
public class NewsFeedPage {

    @SerializedName("IDMemberProfile")
    private String profileName;
    @SerializedName("Title")
    private String location;
    @SerializedName("PostTime")
    private String time;
    @SerializedName("Content")
    private String postContent;
    @SerializedName("ImageURL")
    private String imageURL;
    @SerializedName("Status")
    private int status;

    @SerializedName("Interested")
    private Interested interested;
    @SerializedName("Like")
    private Like like;

    private int likeCounter;
    private int pinCounter;
    private int commentCounter;
    private String writeComment;

    private int profileImage;
    private int postImage;
    private int likeIcon;
    private int pinIcon;
    private int commentIcon;
    private int reportProblemIcon;
    private int sendCommentIcon;



    public NewsFeedPage() {
        this.likeIcon = R.drawable.ic_favorite;
        this.pinIcon = R.drawable.ic_loyalty;
        this.commentIcon = R.drawable.ic_comment;
        this.reportProblemIcon = R.drawable.ic_report_problem;
        this.sendCommentIcon = R.drawable.ic_send;
    }

    public NewsFeedPage(String profileName, String location, String time, String postContent, String likeCounter, String pinCounter,
                        String commentCounter, String writeComment, int profileImage, int postImage, int likeIcon, int pinIcon,
                        int commentIcon, int reportProblemIcon, int sendCommentIcon) {
        this.profileName = profileName;
        this.location = location;
        this.time = time;
        this.postContent = postContent;
        this.likeCounter = Integer.parseInt(likeCounter);
        this.pinCounter = Integer.parseInt(pinCounter);
        this.commentCounter = Integer.parseInt(commentCounter);
        this.writeComment = writeComment;
        this.profileImage = profileImage;
        this.postImage = postImage;
        this.likeIcon = likeIcon;
        this.pinIcon = pinIcon;
        this.commentIcon = commentIcon;
        this.reportProblemIcon = reportProblemIcon;
        this.sendCommentIcon = sendCommentIcon;
    }

    public NewsFeedPage(String profileName, String location, String time, String postContent, String likeCounter, String pinCounter,
                        String commentCounter, String writeComment, int profileImage, int postImage) {
        this.profileName = profileName;
        this.location = location;
        this.time = time;
        this.postContent = postContent;
        this.likeCounter = Integer.parseInt(likeCounter);
        this.pinCounter = Integer.parseInt(pinCounter);
        this.commentCounter = Integer.parseInt(commentCounter);
        this.writeComment = writeComment;
        this.profileImage = profileImage;
        this.postImage = postImage;
        this.likeIcon = R.drawable.ic_favorite;
        this.pinIcon = R.drawable.ic_loyalty;
        this.commentIcon = R.drawable.ic_comment;
        this.reportProblemIcon = R.drawable.ic_report_problem;
        this.sendCommentIcon = R.drawable.ic_send;
    }

    public NewsFeedPage(String profileName, String location, String time, String postContent, Interested interested, Like like, int likeCounter, int pinCounter, int commentCounter, String writeComment, int profileImage, int postImage, int likeIcon, int pinIcon, int commentIcon, int reportProblemIcon, int sendCommentIcon) {
        this.profileName = profileName;
        this.location = location;
        this.time = time;
        this.postContent = postContent;
        this.interested = interested;
        this.like = like;
        this.likeCounter = likeCounter;
        this.pinCounter = pinCounter;
        this.commentCounter = commentCounter;
        this.writeComment = writeComment;
        this.profileImage = profileImage;
        this.postImage = postImage;
        this.likeIcon = likeIcon;
        this.pinIcon = pinIcon;
        this.commentIcon = commentIcon;
        this.reportProblemIcon = reportProblemIcon;
        this.sendCommentIcon = sendCommentIcon;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getLikeCounter() {
        return String.valueOf(like.getNumber());
    }

    public void setLikeCounter(String likeCounter) {
        this.likeCounter = Integer.parseInt(likeCounter);
    }

    public String getPinCounter() {
        return String.valueOf(interested.getNumber());
    }

    public void setPinCounter(String pinCounter) {
        this.pinCounter = Integer.parseInt(pinCounter);
    }

    public String getCommentCounter() {
        return String.valueOf(commentCounter);
    }

    public void setCommentCounter(String commentCounter) {
        this.commentCounter = Integer.parseInt(commentCounter);
    }

    public String getWriteComment() {
        return writeComment;
    }

    public void setWriteComment(String writeComment) {
        this.writeComment = writeComment;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public int getLikeIcon() {
        return likeIcon;
    }

    public void setLikeIcon(int likeIcon) {
        this.likeIcon = likeIcon;
    }

    public int getPinIcon() {
        return pinIcon;
    }

    public void setPinIcon(int pinIcon) {
        this.pinIcon = pinIcon;
    }

    public int getCommentIcon() {
        return commentIcon;
    }

    public void setCommentIcon(int commentIcon) {
        this.commentIcon = commentIcon;
    }

    public int getReportProblemIcon() {
        return reportProblemIcon;
    }

    public void setReportProblemIcon(int reportProblemIcon) {
        this.reportProblemIcon = reportProblemIcon;
    }

    public int getSendCommentIcon() {
        return sendCommentIcon;
    }

    public void setSendCommentIcon(int sendCommentIcon) {
        this.sendCommentIcon = sendCommentIcon;
    }

    public Interested getInterested() {
        return interested;
    }

    public void setInterested(Interested interested) {
        this.interested = interested;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
