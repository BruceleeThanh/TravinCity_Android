package studio.crazybt.travincity.views.imple;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import studio.crazybt.travincity.R;
import studio.crazybt.travincity.adapters.DownloadImageTask;
import studio.crazybt.travincity.adapters.PagerAdapter;
import studio.crazybt.travincity.presenters.imple.MainPresenterImp;
import studio.crazybt.travincity.services.MainService;
import studio.crazybt.travincity.views.inter.MainView;

/**
 * Created by Brucelee Thanh on 04/06/2016.
 */
public class MainActivity extends AppCompatActivity implements MainView{
    //Defining Variables
    private String idUser;

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    // nav header
    private View vNavHeader;
    private ImageView ivCover;
    private CircleImageView civAvatar;
    private TextView tvName;
    private TextView tvEmail;
    private ProgressBar pbWaitingNavHeader;

    private MainPresenterImp presenter;
    private MainService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idUser = extras.getString("idUser");
        }

        service = new MainService(this.getBaseContext());
        presenter = new MainPresenterImp(this, service);

        presenter.requestData_NavHeader(idUser);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // nav header set item
        vNavHeader = navigationView.getHeaderView(0);
        ivCover = (ImageView) vNavHeader.findViewById(R.id.ivCover);
        civAvatar = (CircleImageView) vNavHeader.findViewById(R.id.civAvatar_navheader);
        tvName = (TextView)vNavHeader.findViewById(R.id.tvName_navheader);
        tvEmail=(TextView)vNavHeader.findViewById(R.id.tvEmail_nav_navheader);
        pbWaitingNavHeader = (ProgressBar) vNavHeader.findViewById(R.id.pbWaitingNavHeader_navheader);


        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                // Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                // Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    // Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_timeline:
                        Toast.makeText(getApplicationContext(),"Inbox Selected",Toast.LENGTH_SHORT).show();
//                        ContentFragment fragment = new ContentFragment();
//                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.frame,fragment);
//                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.nav_feedback_letterboxes:
                        Toast.makeText(getApplicationContext(),"Stared Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_album:
                        Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_activity_log:
                        Toast.makeText(getApplicationContext(),"Drafts Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_settings:
                        Toast.makeText(getApplicationContext(),"All Mail Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_info:
                        Toast.makeText(getApplicationContext(),"Trash Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_logout:
                        finish();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }

            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        // Create Tabs - Begin
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_view_list_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_grade_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_map_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_notifications_24dp));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        int tabIconColor = Color.parseColor("#558B2F");
        tabLayout.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int temp = tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
                int tabIconColor = Color.parseColor("#558B2F");
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = Color.parseColor("#E9EAED");
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // Create Tabs - End
    }

    @Override
    public void setNavHeader(String coverURL,  String avatarURL, String name, String email) throws IOException {
        if(coverURL!=null){
            new DownloadImageTask(ivCover).execute(coverURL);
        }
        if(avatarURL!=null){
            new DownloadImageTask(civAvatar).execute(avatarURL);
        }
        if(name != null){
            tvName.setText(name);
        }
        if(email!=null){
            tvEmail.setText(email);
        }
    }

    @Override
    public void hideProgress_NavHeader() {
        pbWaitingNavHeader.setVisibility(View.GONE);
    }

    @Override
    public void showProgress_NavHeader() {
        pbWaitingNavHeader.setVisibility(View.VISIBLE);
    }
}
