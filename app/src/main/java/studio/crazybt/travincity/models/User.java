package studio.crazybt.travincity.models;

import android.text.method.DateTimeKeyListener;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public class User {
    @SerializedName("_id")
    private String id;
    @SerializedName("LoginName")
    private String loginName;
    @SerializedName("Password")
    private String password;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Birthday")
    private Date birthday;
    @SerializedName("Gender")
    private int gender;
    @SerializedName("Address")
    private String address;
    @SerializedName("ProfileID")
    private String profileID;
    @SerializedName("ProfileURL")
    private String profileURL;
    @SerializedName("AvatarImageURL")
    private String avatarImageURL;
    @SerializedName("CoverImageURL")
    private String coverImageURL;
    @SerializedName("ActiveTime")
    private Date activeTime;
    @SerializedName("Email")
    private String email;
    @SerializedName("Provider")
    private String provider;
    @SerializedName("ProviderId")
    private String providerID;
    @SerializedName("Role")
    private int role;
    @SerializedName("accessToken")
    private String accessToken;

    public User() {
    }

    public User(String id, String loginName, String password, String firstName, String lastName, Date birthday,
                int gender, String address, String profileID, String profileURL, String avatarImageURL, String coverImageURL,
                Date activeTime, String email, String provider, String providerID, int role, String accessToken) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.profileID = profileID;
        this.profileURL = profileURL;
        this.avatarImageURL = avatarImageURL;
        this.coverImageURL = coverImageURL;
        this.activeTime = activeTime;
        this.email = email;
        this.provider = provider;
        this.providerID = providerID;
        this.role = role;
        this.accessToken = accessToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public String getAvatarImageURL() {
        return avatarImageURL;
    }

    public void setAvatarImageURL(String avatarImageURL) {
        this.avatarImageURL = avatarImageURL;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
