package engineer.davidauza.agenciaemd.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
     * The BundleKey to receive the category page from
     * {@link engineer.davidauza.agenciaemd.adapters.LocationCategoryAdapter}
     */
    public static final String BUNDLE_KEY = "category_page";

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
        // Use this setting to improve performance if you know that changes in content do not change
        // the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Use a LinearLayoutManager for portrait orientation, or a GridLayoutManager with two
        // columns for landscape orientation
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        } else {
            mLayoutManager = new GridLayoutManager(mRecyclerView.getContext(), 2);
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * This method creates an appropriate list according to the page in the ViewPager in which the
     * fragment is going to be displayed.
     */
    private ArrayList<Location> createList() {
        ArrayList<Location> locations = new ArrayList<>();
        // Get the page passed using the method setArguments in the {@link LocationCategoryAdapter}
        int page = getArguments().getInt(BUNDLE_KEY);
        switch (page) {
            case 0:
                locations.add(new Location(R.drawable.img_location_tunja,
                        getString(R.string.tour_guide_main_location_tunja_name),
                        getString(R.string.tour_guide_main_location_tunja_description)));
                locations.add(new Location(R.drawable.img_location_chiquinquira,
                        getString(R.string.tour_guide_main_location_chiquinquira_name),
                        getString(R.string.tour_guide_main_location_chiquinquira_description)));
                locations.add(new Location(R.drawable.img_location_paipa,
                        getString(R.string.tour_guide_main_location_paipa_name),
                        getString(R.string.tour_guide_main_location_paipa_description)));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        getString(R.string.tour_guide_main_location_villa_de_leyva_name),
                        getString(R.string.tour_guide_main_location_villa_de_leyva_description)));
                locations.add(new Location(R.drawable.img_location_soata,
                        getString(R.string.tour_guide_main_location_soata_name),
                        getString(R.string.tour_guide_main_location_soata_description)));
                locations.add(new Location(R.drawable.img_location_ramiriqui,
                        getString(R.string.tour_guide_main_location_ramiriqui_name),
                        getString(R.string.tour_guide_main_location_ramiriqui_description)));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        getString(R.string.tour_guide_main_location_busbanza_name),
                        getString(R.string.tour_guide_main_location_busbanza_description)));
                locations.add(new Location(R.drawable.img_location_jenesano,
                        getString(R.string.tour_guide_main_location_jenesano_name),
                        getString(R.string.tour_guide_main_location_jenesano_description)));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        getString(R.string.tour_guide_main_location_zetaquira_name),
                        getString(R.string.tour_guide_main_location_zetaquira_description)));
                locations.add(new Location(R.drawable.img_location_firavitoba,
                        getString(R.string.tour_guide_main_location_firavitoba_name),
                        getString(R.string.tour_guide_main_location_firavitoba_description)));
                locations.add(new Location(R.drawable.img_location_tasco,
                        getString(R.string.tour_guide_main_location_tasco_name),
                        getString(R.string.tour_guide_main_location_tasco_description)));
                locations.add(new Location(R.drawable.img_location_tobasia,
                        getString(R.string.tour_guide_main_location_tobasia_name),
                        getString(R.string.tour_guide_main_location_tobasia_description)));
                locations.add(new Location(R.drawable.img_location_cerinza,
                        getString(R.string.tour_guide_main_location_cerinza_name),
                        getString(R.string.tour_guide_main_location_cerinza_description)));
                locations.add(new Location(R.drawable.img_location_santa_sofia,
                        getString(R.string.tour_guide_main_location_santa_sofia_name),
                        getString(R.string.tour_guide_main_location_santa_sofia_description)));
                locations.add(new Location(R.drawable.img_location_morca,
                        getString(R.string.tour_guide_main_location_morca_name),
                        getString(R.string.tour_guide_main_location_morca_description)));
                locations.add(new Location(R.drawable.img_location_belen,
                        getString(R.string.tour_guide_main_location_belen_name),
                        getString(R.string.tour_guide_main_location_belen_description)));
                locations.add(new Location(R.drawable.img_location_paz_de_rio,
                        getString(R.string.tour_guide_main_location_paz_de_rio_name),
                        getString(R.string.tour_guide_main_location_paz_de_rio_description)));
                locations.add(new Location(R.drawable.img_location_santa_rosa_de_viterbo,
                        getString(R.string.tour_guide_main_location_santa_rosa_de_viterbo_name),
                        getString(R.string.
                                tour_guide_main_location_santa_rosa_de_viterbo_description)));
                locations.add(new Location(R.drawable.img_location_rondon,
                        getString(R.string.tour_guide_main_location_rondon_name),
                        getString(R.string.tour_guide_main_location_rondon_description)));
                locations.add(new Location(R.drawable.img_location_paya,
                        getString(R.string.tour_guide_main_location_paya_name),
                        getString(R.string.tour_guide_main_location_paya_description)));
                locations.add(new Location(R.drawable.img_location_jerico,
                        getString(R.string.tour_guide_main_location_jerico_name),
                        getString(R.string.tour_guide_main_location_jerico_description)));
                break;
            case 1:
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        getString(R.string.tour_guide_main_location_paramo_iguaque_name),
                        getString(R.string.tour_guide_main_location_paramo_iguaque_description)));
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
        // Specify an adapter
        mAdapter = new LocationAdapter(pLocation);
        mRecyclerView.setAdapter(mAdapter);
    }
}
