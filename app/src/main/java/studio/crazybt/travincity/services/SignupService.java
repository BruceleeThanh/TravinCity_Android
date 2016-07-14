package studio.crazybt.travincity.services;

import android.content.Context;
import android.content.ContextWrapper;

import com.google.gson.JsonObject;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;
import studio.crazybt.travincity.R;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public class SignupService extends ContextWrapper {

    public static String urlServices = null;
    private SignupApi signupApi;

    public SignupService(Context base) {
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

        signupApi = restAdapter.create(SignupApi.class);
    }

    public SignupApi getApi() {
        return signupApi;
    }


    public interface SignupApi {

        @FormUrlEncoded
        @POST("/api/signup")
        public Observable<JsonObject> setSignup(@Field("username") String username, @Field("password") String password,
                                                @Field("email") String email);
    }
}
