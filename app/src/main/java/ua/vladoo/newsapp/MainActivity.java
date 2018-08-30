package ua.vladoo.newsapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toolbar
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        final ActionBar mActionBar = getSupportActionBar();

        // Create and setup viewPager
        mViewPager = findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        // Create and setup TabLayout with viewPager
        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);


    }




    public void setupViewPager(ViewPager viewPager) {
        // Setup the ViewPager with multiple fragment
        ViewPagerAdapter mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new MostEmailedFragment(), "MOST POPULAR");
        mPagerAdapter.addFragment(new MostSharedFragment(), "MOST SHARED");
        mPagerAdapter.addFragment(new MostViewedFragment(), "MOST VIEWED");
        viewPager.setAdapter(mPagerAdapter);
    }
}
