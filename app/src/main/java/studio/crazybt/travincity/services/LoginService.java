package studio.crazybt.travincity.services;

import android.content.Context;
import android.content.ContextWrapper;

import com.google.gson.JsonObject;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import studio.crazybt.travincity.R;
import studio.crazybt.travincity.models.LoginData;
import rx.Observable;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public class LoginService extends ContextWrapper {

    public static String urlServices = null;
    private LoginApi loginApi;

    public LoginService(Context base) {
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

        loginApi = restAdapter.create(LoginApi.class);
    }

    public LoginApi getApi() {
        return loginApi;
    }


    public interface LoginApi {
        @FormUrlEncoded
        @POST("/api/signin")
        public Observable<JsonObject> getLogin(@Field("username") String username, @Field("password") String password);

    }
}
