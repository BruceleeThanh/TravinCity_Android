package studio.crazybt.travincity.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class PostData {
    @SerializedName("value")
    private List<NewsFeedPage> newsFeedPages;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private int status;

    public List<NewsFeedPage> getNewsFeedPages() {
        return newsFeedPages;
    }

    public void setNewsFeedPages(List<NewsFeedPage> newsFeedPages) {
        this.newsFeedPages = newsFeedPages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
