package studio.crazybt.travincity.presenters.inter;

/**
 * Created by Brucelee Thanh on 23/05/2016.
 */
public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
