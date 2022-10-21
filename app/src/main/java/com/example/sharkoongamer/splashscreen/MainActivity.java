package com.example.sharkoongamer.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pageadapter;
    private Animation animeehome ;
    private LinearLayout screenlayout ;
    private DrawerLayout drawer_layout ;
    private NavigationView navigation_view ;
    private ActionBarDrawerToggle toggle ;
    private TextView nameuser ;
    private SharedPreferences result;
    private View myview ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);


        /////////////     7atina el viewpager chya3mel 7atit 4 frags bech ki nemchi maydestrowich eli kablou    ////////////
        pageadapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageadapter);
        viewPager.setOffscreenPageLimit(4);
        /////////////     ENDS HERE     ////////////


        /////////////    Initialisation mta3 el toolbar wel couleur toolbar,tablayout w status bar by default     ////////////
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.dashboard));
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                R.color.slider3));
        tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                R.color.slider3));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                    R.color.slider33));
        }
        /////////////     ENDS HERE     ////////////


        /////////////     3maltna toggle n7elou bih el drawer menu     ////////////
        toggle = new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.openmenu,R.string.closemenu);
        drawer_layout.setDrawerListener(toggle);
        toggle.syncState();
        /////////////     ENDS HERE     ////////////


        /////////////     5demna kol bouton fel menu drawer chtaamel     ////////////
        navigation_view=(NavigationView)findViewById(R.id.navigation_view);
        navigation_view.setNavigationItemSelectedListener(this);
        /////////////     ENDS HERE     ////////////


        /////////////     7atina esm l'utilisateur fi blastou     ////////////
        result = getSharedPreferences("SaveData",MODE_PRIVATE);
        myview=navigation_view.getHeaderView(0);
        nameuser=(TextView)myview.findViewById(R.id.usernameplace);
        nameuser.setText(result.getString("key",null));
        /////////////     ENDS HERE     ////////////


        /////////////    3malna animation lel app kolha awel matet7al     ////////////
        animeehome =AnimationUtils.loadAnimation(this,R.anim.animehome);
        screenlayout=(LinearLayout)findViewById(R.id.screenlayout);
//3malt fade b overridependingtransition
        /////////////    ENDS HERE     ////////////


        /////////////     syncronisation el viewpager maa tablayout    ////////////
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        /////////////     ENDS HERE     ////////////


        /////////////     kol bouton mel tablayout chneya taamel     ////////////
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    /////////////     syncronisation el tablayout maa viewpager     ////////////
                    viewPager.setCurrentItem(tab.getPosition());
                    /////////////     ENDS HERE     ////////////


                    if (tab.getPosition() == 0) {
                        toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider3));
                        tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider3));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                    R.color.slider33));
                        }
                    } else if (tab.getPosition() == 1) {
                        toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider2));
                        tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider2));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                    R.color.slider22));
                        }
                    } else if (tab.getPosition() == 2) {
                        toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider1));
                        tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider1));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                    R.color.slider11));
                        }
                    } else {
                        toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider4));
                        tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                                R.color.slider4));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                    R.color.slider44));
                        }
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        /////////////     ENDS HERE     ////////////





        }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

         int id;
         id=menuItem.getItemId();

         switch (id)
         {
             case R.id.achievements :
                     Toast.makeText(this, "Clicked on notifications for achievements", Toast.LENGTH_SHORT).show();
                     break;
             case R.id.draft :
                 Toast.makeText(this, "Clicked on notifications for draft", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.agenda :
                 Toast.makeText(this, "Clicked on notifications for agenda", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.basket :
                 Toast.makeText(this, "Clicked on notifications for basket", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.guide :
                 Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                 startActivity(intent);
                 overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                 break;
             case R.id.faq :
                 Toast.makeText(this, "Clicked on notifications for faq", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.contacus :
                 Toast.makeText(this, "Clicked on notifications for contact us", Toast.LENGTH_SHORT).show();
                 break;

         }

         drawer_layout.closeDrawer(GravityCompat.START);

        return false;
    }

    @Override
    public void onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START))
            drawer_layout.closeDrawer(GravityCompat.START);
        else
        super.onBackPressed();
    }





}

