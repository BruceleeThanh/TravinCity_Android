package studio.crazybt.travincity.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class LoginData {
    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("token")
    private String token;
    @SerializedName("user")
    private User user;

    public LoginData() {
    }

    public LoginData(boolean success, String message, String token, User user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
