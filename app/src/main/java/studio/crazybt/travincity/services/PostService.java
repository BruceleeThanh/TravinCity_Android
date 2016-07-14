package studio.crazybt.travincity.services;

import android.content.Context;
import android.content.ContextWrapper;

import com.google.gson.JsonObject;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;
import studio.crazybt.travincity.R;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class PostService extends ContextWrapper {
    public static String urlServices = null;
    private PostApi postApi;

    public PostService(Context base) {
        super(base);
        urlServices = getResources().getString(R.string.services_url);
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(urlServices)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        postApi = restAdapter.create(PostApi.class);
    }

    public PostApi getApi() {
        return postApi;
    }


    public interface PostApi {
        @GET("/post")
        public Observable<JsonObject> getPost();
    }
}
