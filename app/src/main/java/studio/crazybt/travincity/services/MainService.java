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
import retrofit.http.Path;
import rx.Observable;
import studio.crazybt.travincity.R;
import studio.crazybt.travincity.presenters.inter.MainPresenter;

/**
 * Created by Brucelee Thanh on 16/06/2016.
 */
public class MainService extends ContextWrapper{

    public static String urlServices = null;
    private MainApi mainApi;

    public MainService(Context base) {
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

        mainApi = restAdapter.create(MainApi.class);
    }

    public MainApi getApi() {
        return mainApi;
    }


    public interface MainApi {

        @FormUrlEncoded
        @GET("/member/{idUser}")
        public Observable<JsonObject> getNavHeader(@Path("idUser") String idUser);
    }
}
