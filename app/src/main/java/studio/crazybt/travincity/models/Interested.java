package studio.crazybt.travincity.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class Interested {
    @SerializedName("NumberInterest")
    private int number;


    public Interested(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
