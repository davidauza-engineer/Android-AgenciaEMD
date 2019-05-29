package engineer.davidauza.agenciaemd.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.fragments.LocationsFragment;

/**
 * {@link LocationPagerAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of
 * {@link engineer.davidauza.agenciaemd.models.Location} objects.
 */
public class LocationPagerAdapter extends FragmentPagerAdapter {

    /**
     * Context of the TourGuideMainActivity
     */
    private Context mContext;

    /**
     * Create a new {@link LocationPagerAdapter} object.
     *
     * @param pFragmentManager is the FragmentManager that will keep each fragment's state in the
     *                         adapter across swipes.
     * @param pContext         is the Context of the TourGuideMainActivity.
     */
    public LocationPagerAdapter(FragmentManager pFragmentManager,
                                Context pContext) {
        super(pFragmentManager);
        mContext = pContext;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int i) {
        LocationsFragment fragment = new LocationsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LocationsFragment.BUNDLE_KEY, i);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        // There are a total of 5 categories which will be displayed in the ViewPager.
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.tour_guide_main_category_one);
            case 1:
                return mContext.getString(R.string.tour_guide_main_category_two);
            case 2:
                return mContext.getString(R.string.tour_guide_main_category_three);
            case 3:
                return mContext.getString(R.string.tour_guide_main_category_four);
            default:
                return mContext.getString(R.string.tour_guide_main_category_five);
        }
    }
}
