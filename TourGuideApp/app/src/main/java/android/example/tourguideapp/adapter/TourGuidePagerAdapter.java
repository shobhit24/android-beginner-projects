package android.example.tourguideapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.example.tourguideapp.ui.HotelFragment;
import android.example.tourguideapp.ui.MallFragment;
import android.example.tourguideapp.ui.RestaurantFragment;
import android.example.tourguideapp.ui.SchoolFragment;


public class TourGuidePagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;

    private String tabTitles[] = new String[]{
            HotelFragment.NAME,
            SchoolFragment.NAME,
            MallFragment.NAME,
            RestaurantFragment.NAME};

    private Context mContext;

    public TourGuidePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment.instantiate(mContext, HotelFragment.class.getName());
                break;
            case 1:
                fragment = Fragment.instantiate(mContext, SchoolFragment.class.getName());
                break;
            case 2:
                fragment = Fragment.instantiate(mContext, MallFragment.class.getName());
                break;
            case 3:
                fragment = Fragment.instantiate(mContext, RestaurantFragment.class.getName());
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
