package studio.crazybt.travincity.models;

import studio.crazybt.travincity.R;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class Post {

    private String profileName;
    private String location;
    private String time;
    private String postContent;
    private String likeCounter;
    private String pinCounter;
    private String commentCounter;
    private String writeComment;

    private int profileImage;
    private int postImage;
    private int likeIcon;
    private int pinIcon;
    private int commentIcon;
    private int reportProblemIcon;
    private int sendCommentIcon;

    public Post() {

    }

    public Post(String profileName, String location, String time, String postContent, String likeCounter, String pinCounter,
                        String commentCounter, String writeComment, int profileImage, int postImage, int likeIcon, int pinIcon,
                        int commentIcon, int reportProblemIcon, int sendCommentIcon) {
        this.profileName = profileName;
        this.location = location;
        this.time = time;
        this.postContent = postContent;
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

    public Post(String profileName, String location, String time, String postContent, String likeCounter, String pinCounter,
                        String commentCounter, String writeComment, int profileImage, int postImage) {
        this.profileName = profileName;
        this.location = location;
        this.time = time;
        this.postContent = postContent;
        this.likeCounter = likeCounter;
        this.pinCounter = pinCounter;
        this.commentCounter = commentCounter;
        this.writeComment = writeComment;
        this.profileImage = profileImage;
        this.postImage = postImage;
/*        this.likeIcon = R.drawable.ic_favorite;
        this.pinIcon = R.drawable.ic_loyalty;
        this.commentIcon = R.drawable.ic_comment;
        this.reportProblemIcon = R.drawable.ic_report_problem;
        this.sendCommentIcon = R.drawable.ic_send;*/
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
        return likeCounter;
    }

    public void setLikeCounter(String likeCounter) {
        this.likeCounter = likeCounter;
    }

    public String getPinCounter() {
        return pinCounter;
    }

    public void setPinCounter(String pinCounter) {
        this.pinCounter = pinCounter;
    }

    public String getCommentCounter() {
        return commentCounter;
    }

    public void setCommentCounter(String commentCounter) {
        this.commentCounter = commentCounter;
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
}
