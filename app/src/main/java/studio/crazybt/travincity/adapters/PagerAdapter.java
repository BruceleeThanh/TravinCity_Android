package studio.crazybt.travincity.adapters;

/**
 * Created by Brucelee Thanh on 11/04/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import studio.crazybt.travincity.views.imple.Tab1Fragment;
import studio.crazybt.travincity.views.imple.Tab2Fragment;
import studio.crazybt.travincity.views.imple.Tab3Fragment;
import studio.crazybt.travincity.views.imple.Tab4Fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab1Fragment tab1 = new Tab1Fragment();
                return tab1;
            case 1:
                Tab2Fragment tab2 = new Tab2Fragment();
                return tab2;
            case 2:
                Tab3Fragment tab3 = new Tab3Fragment();
                return tab3;
            case 3:
                Tab4Fragment tab4 = new Tab4Fragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
