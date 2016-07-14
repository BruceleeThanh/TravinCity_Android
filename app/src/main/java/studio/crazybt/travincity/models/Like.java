package studio.crazybt.travincity.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class Like {
    @SerializedName("NumberLike")
    private int number;

    public Like(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
