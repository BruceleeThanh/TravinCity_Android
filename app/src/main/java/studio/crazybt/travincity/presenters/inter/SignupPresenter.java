package studio.crazybt.travincity.presenters.inter;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public interface SignupPresenter {

    void validateCredentials(String username, String password, String email);

    void onDestroy();
}
