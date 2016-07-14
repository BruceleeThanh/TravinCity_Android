package studio.crazybt.travincity.models;

/**
 * Created by Brucelee Thanh on 07/05/2016.
 */
public class NotificationPage {

    private String notiContent;

    private int notiIcon;

    public NotificationPage(String notiContent, int notiIcon) {
        this.notiContent = notiContent;
        this.notiIcon = notiIcon;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public int getNotiIcon() {
        return notiIcon;
    }

    public void setNotiIcon(int notiIcon) {
        this.notiIcon = notiIcon;
    }
}
