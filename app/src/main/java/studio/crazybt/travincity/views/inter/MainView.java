package studio.crazybt.travincity.views.inter;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Brucelee Thanh on 15/06/2016.
 */
public interface MainView {

    void setNavHeader(String name, String email, String avatarURL, String coverURL) throws IOException;

    void showProgress_NavHeader();

    void hideProgress_NavHeader();

}
