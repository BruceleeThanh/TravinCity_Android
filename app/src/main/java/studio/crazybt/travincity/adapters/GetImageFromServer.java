package studio.crazybt.travincity.adapters;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class GetImageFromServer {
    private URL url;
    private BitmapDrawable bitmapDrawable;

    public GetImageFromServer(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public BitmapDrawable getBitmapDrawable() throws IOException {
        return new BitmapDrawable(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
    }

    public void setBitmapDrawable(BitmapDrawable bitmapDrawable) {
        this.bitmapDrawable = bitmapDrawable;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
}
