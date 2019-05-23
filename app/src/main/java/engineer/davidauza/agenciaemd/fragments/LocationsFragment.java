package engineer.davidauza.agenciaemd.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import engineer.davidauza.agenciaemd.R;
import engineer.davidauza.agenciaemd.adapters.LocationAdapter;
import engineer.davidauza.agenciaemd.models.Location;

/**
 * A simple {@link Fragment} subclass which contains a list of locations. The list is set up
 * according to a category of locations.
 */
public class LocationsFragment extends Fragment {

    /**
     * The RecyclerView to display the list of locations.
     */
    private RecyclerView mRecyclerView;

    /**
     * The Adapter to populate data in the RecyclerView.
     */
    private RecyclerView.Adapter mAdapter;

    /**
     * The LinearLayoutManager used by the RecyclerView.
     */
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * Create a new {@link LocationsFragment} object.
     */
    public LocationsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setUpRecyclerView(inflater, container);
        ArrayList<Location> locations = createList();
        setUpRecyclerViewAdapter(locations);
        return mRecyclerView;
    }

    /**
     * This method sets up the RecyclerView which displays the list of locations.
     *
     * @param pInflater  is the LayoutInflater object passed by the onCreateView method.
     * @param pContainer is the ViewGroup object passed by the onCreateView method.
     */
    private void setUpRecyclerView(LayoutInflater pInflater, ViewGroup pContainer) {
        mRecyclerView = (RecyclerView) pInflater.inflate(R.layout.fragment_tour_guide_locations,
                pContainer, false);

        //TODO check when the lists are ready
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * This method creates an appropriate list according to the page in the ViewPager in which the
     * fragment is going to be displayed.
     */
    private ArrayList<Location> createList() {
        ArrayList<Location> locations = new ArrayList<>();
        String bundleKey = getString(R.string.tour_guide_bundle_key);
        // Get the page passed using the method setArguments in the {@link LocationCategoryAdapter}
        int page = getArguments().getInt(bundleKey);
        switch (page) {
            case 0:
                locations.add(new Location(R.drawable.img_question_one,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                locations.add(new Location(R.drawable.img_question_two,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                break;
            case 1:
                locations.add(new Location(R.drawable.img_question_three,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                locations.add(new Location(R.drawable.img_question_four,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                break;
            case 2:
                locations.add(new Location(R.drawable.img_question_five,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                locations.add(new Location(R.drawable.img_question_six,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                break;
            case 3:
                locations.add(new Location(R.drawable.img_question_seven,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                locations.add(new Location(R.drawable.img_question_eight,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                break;
            case 4:
                locations.add(new Location(R.drawable.img_question_nine,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                locations.add(new Location(R.drawable.img_question_ten,
                        getString(R.string.main_app_name), getString(R.string.main_description)));
                break;
        }
        return locations;
    }

    /**
     * This method creates a {@link LocationAdapter} and sets it to the RecyclerView.
     *
     * @param pLocation is the ArrayList containing the locations to be displayed.
     */
    private void setUpRecyclerViewAdapter(ArrayList<Location> pLocation) {
        mAdapter = new LocationAdapter(pLocation);
        mRecyclerView.setAdapter(mAdapter);
    }
}
