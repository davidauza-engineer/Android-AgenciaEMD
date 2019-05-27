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
                locations.add(new Location(R.drawable.img_location_arcabuco,
                        getString(R.string.tour_guide_main_location_arcabuco_name),
                        getString(R.string.tour_guide_main_location_arcabuco_description)));
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        getString(R.string.tour_guide_main_location_el_cocuy_name),
                        getString(R.string.tour_guide_main_location_el_cocuy_description)));
                locations.add(new Location(R.drawable.img_location_tenza,
                        getString(R.string.tour_guide_main_location_tenza_name),
                        getString(R.string.tour_guide_main_location_tenza_description)));
                locations.add(new Location(R.drawable.img_location_raquira,
                        getString(R.string.tour_guide_main_location_raquira_name),
                        getString(R.string.tour_guide_main_location_raquira_description)));
                locations.add(new Location(R.drawable.img_location_moniquira,
                        getString(R.string.tour_guide_main_location_moniquira_name),
                        getString(R.string.tour_guide_main_location_moniquira_description)));
                locations.add(new Location(R.drawable.img_location_garagoa,
                        getString(R.string.tour_guide_main_location_garagoa_name),
                        getString(R.string.tour_guide_main_location_garagoa_description)));
                locations.add(new Location(R.drawable.img_location_san_pablo_de_borbur,
                        getString(R.string.tour_guide_main_location_san_pablo_de_borbur_name),
                        getString(R.string.
                                tour_guide_main_location_san_pablo_de_borbur_description)));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        getString(R.string.tour_guide_main_location_busbanza_name),
                        getString(R.string.tour_guide_main_location_busbanza_description)));
                locations.add(new Location(R.drawable.img_location_el_marfil,
                        getString(R.string.tour_guide_main_location_el_marfil_name),
                        getString(R.string.tour_guide_main_location_el_marfil_description)));
                locations.add(new Location(R.drawable.img_location_puerto_pinzon,
                        getString(R.string.tour_guide_main_location_puerto_pinzon_name),
                        getString(R.string.tour_guide_main_location_puerto_pinzon_description)));
                break;
            case 2:
                locations.add(new Location(R.drawable.img_location_paipa,
                        getString(R.string.tour_guide_main_location_paipa_name),
                        getString(R.string.tour_guide_main_location_paipa_description)));
                locations.add(new Location(R.drawable.img_location_iza,
                        getString(R.string.tour_guide_main_location_iza_name),
                        getString(R.string.tour_guide_main_location_iza_description)));
                locations.add(new Location(R.drawable.img_location_guican,
                        getString(R.string.tour_guide_main_location_guican_name),
                        getString(R.string.tour_guide_main_location_guican_description)));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        getString(R.string.tour_guide_main_location_zetaquira_name),
                        getString(R.string.tour_guide_main_location_zetaquira_description)));
                locations.add(new Location(R.drawable.img_location_cuitiva,
                        getString(R.string.tour_guide_main_location_cuitiva_name),
                        getString(R.string.tour_guide_main_location_cuitiva_description)));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        getString(R.string.tour_guide_main_location_chinavita_name),
                        getString(R.string.tour_guide_main_location_chinavita_description)));
                break;
            case 3:
                locations.add(new Location(R.drawable.img_location_lago_tota,
                        getString(R.string.tour_guide_main_location_lago_tota_name),
                        getString(R.string.tour_guide_main_location_lago_tota_description)));
                locations.add(new Location(R.drawable.img_location_paipa,
                        getString(R.string.tour_guide_main_location_paipa_name),
                        getString(R.string.tour_guide_main_location_paipa_description)));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        getString(R.string.tour_guide_main_location_villa_de_leyva_name),
                        getString(R.string.tour_guide_main_location_villa_de_leyva_description)));
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        getString(R.string.tour_guide_main_location_paramo_iguaque_name),
                        getString(R.string.tour_guide_main_location_paramo_iguaque_description)));
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        getString(R.string.tour_guide_main_location_el_cocuy_name),
                        getString(R.string.tour_guide_main_location_el_cocuy_description)));
                locations.add(new Location(R.drawable.img_location_tota,
                        getString(R.string.tour_guide_main_location_tota_name),
                        getString(R.string.tour_guide_main_location_tota_description)));
                locations.add(new Location(R.drawable.img_location_aquitania,
                        getString(R.string.tour_guide_main_location_aquitania_name),
                        getString(R.string.tour_guide_main_location_aquitania_description)));
                locations.add(new Location(R.drawable.img_location_iza,
                        getString(R.string.tour_guide_main_location_iza_name),
                        getString(R.string.tour_guide_main_location_iza_description)));
                locations.add(new Location(R.drawable.img_location_moniquira,
                        getString(R.string.tour_guide_main_location_moniquira_name),
                        getString(R.string.tour_guide_main_location_moniquira_description)));
                locations.add(new Location(R.drawable.img_location_guican,
                        getString(R.string.tour_guide_main_location_guican_name),
                        getString(R.string.tour_guide_main_location_guican_description)));
                locations.add(new Location(R.drawable.img_location_arcabuco,
                        getString(R.string.tour_guide_main_location_arcabuco_name),
                        getString(R.string.tour_guide_main_location_arcabuco_description)));
                locations.add(new Location(R.drawable.img_location_raquira,
                        getString(R.string.tour_guide_main_location_raquira_name),
                        getString(R.string.tour_guide_main_location_raquira_description)));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        getString(R.string.tour_guide_main_location_zetaquira_name),
                        getString(R.string.tour_guide_main_location_zetaquira_description)));
                locations.add(new Location(R.drawable.img_location_gachantiva,
                        getString(R.string.tour_guide_main_location_gachantiva_name),
                        getString(R.string.tour_guide_main_location_gachantiva_description)));
                locations.add(new Location(R.drawable.img_location_santa_sofia,
                        getString(R.string.tour_guide_main_location_santa_sofia_name),
                        getString(R.string.tour_guide_main_location_santa_sofia_description)));
                locations.add(new Location(R.drawable.img_location_tenza,
                        getString(R.string.tour_guide_main_location_tenza_name),
                        getString(R.string.tour_guide_main_location_tenza_description)));
                locations.add(new Location(R.drawable.img_location_sogamoso,
                        getString(R.string.tour_guide_main_location_sogamoso_name),
                        getString(R.string.tour_guide_main_location_sogamoso_description)));
                locations.add(new Location(R.drawable.img_location_cuitiva,
                        getString(R.string.tour_guide_main_location_cuitiva_name),
                        getString(R.string.tour_guide_main_location_cuitiva_description)));
                locations.add(new Location(R.drawable.img_location_garagoa,
                        getString(R.string.tour_guide_main_location_garagoa_name),
                        getString(R.string.tour_guide_main_location_garagoa_description)));
                locations.add(new Location(R.drawable.img_location_jenesano,
                        getString(R.string.tour_guide_main_location_jenesano_name),
                        getString(R.string.tour_guide_main_location_jenesano_description)));
                locations.add(new Location(R.drawable.img_location_mongui,
                        getString(R.string.tour_guide_main_location_mongui_name),
                        getString(R.string.tour_guide_main_location_mongui_description)));
                locations.add(new Location(R.drawable.img_location_duitama,
                        getString(R.string.tour_guide_main_location_duitama_name),
                        getString(R.string.tour_guide_main_location_duitama_description)));
                locations.add(new Location(R.drawable.img_location_sachica,
                        getString(R.string.tour_guide_main_location_sachica_name),
                        getString(R.string.tour_guide_main_location_sachica_description)));
                locations.add(new Location(R.drawable.img_location_puerto_boyaca,
                        getString(R.string.tour_guide_main_location_puerto_boyaca_name),
                        getString(R.string.tour_guide_main_location_puerto_boyaca_description)));
                locations.add(new Location(R.drawable.img_location_cienaga,
                        getString(R.string.tour_guide_main_location_cienaga_name),
                        getString(R.string.tour_guide_main_location_cienaga_description)));
                locations.add(new Location(R.drawable.img_location_socha,
                        getString(R.string.tour_guide_main_location_socha_name),
                        getString(R.string.tour_guide_main_location_socha_description)));
                locations.add(new Location(R.drawable.img_location_pajarito,
                        getString(R.string.tour_guide_main_location_pajarito_name),
                        getString(R.string.tour_guide_main_location_pajarito_description)));
                locations.add(new Location(R.drawable.img_location_pisba,
                        getString(R.string.tour_guide_main_location_pisba_name),
                        getString(R.string.tour_guide_main_location_pisba_description)));
                locations.add(new Location(R.drawable.img_location_pesca,
                        getString(R.string.tour_guide_main_location_pesca_name),
                        getString(R.string.tour_guide_main_location_pesca_description)));
                locations.add(new Location(R.drawable.img_location_tinjaca,
                        getString(R.string.tour_guide_main_location_tinjaca_name),
                        getString(R.string.tour_guide_main_location_tinjaca_description)));
                locations.add(new Location(R.drawable.img_location_guateque,
                        getString(R.string.tour_guide_main_location_guateque_name),
                        getString(R.string.tour_guide_main_location_guateque_description)));
                locations.add(new Location(R.drawable.img_location_saboya,
                        getString(R.string.tour_guide_main_location_saboya_name),
                        getString(R.string.tour_guide_main_location_saboya_description)));
                locations.add(new Location(R.drawable.img_location_combita,
                        getString(R.string.tour_guide_main_location_combita_name),
                        getString(R.string.tour_guide_main_location_combita_description)));
                locations.add(new Location(R.drawable.img_location_cerinza,
                        getString(R.string.tour_guide_main_location_cerinza_name),
                        getString(R.string.tour_guide_main_location_cerinza_description)));
                locations.add(new Location(R.drawable.img_location_firavitoba,
                        getString(R.string.tour_guide_main_location_firavitoba_name),
                        getString(R.string.tour_guide_main_location_firavitoba_description)));
                locations.add(new Location(R.drawable.img_location_toca,
                        getString(R.string.tour_guide_main_location_toca_name),
                        getString(R.string.tour_guide_main_location_toca_description)));
                locations.add(new Location(R.drawable.img_location_cucaita,
                        getString(R.string.tour_guide_main_location_cucaita_name),
                        getString(R.string.tour_guide_main_location_cucaita_description)));
                locations.add(new Location(R.drawable.img_location_somondoco,
                        getString(R.string.tour_guide_main_location_somondoco_name),
                        getString(R.string.tour_guide_main_location_somondoco_description)));
                locations.add(new Location(R.drawable.img_location_chitaraque,
                        getString(R.string.tour_guide_main_location_chitaraque_name),
                        getString(R.string.tour_guide_main_location_chitaraque_description)));
                locations.add(new Location(R.drawable.img_location_umbita,
                        getString(R.string.tour_guide_main_location_umbita_name),
                        getString(R.string.tour_guide_main_location_umbita_description)));
                locations.add(new Location(R.drawable.img_location_tasco,
                        getString(R.string.tour_guide_main_location_tasco_name),
                        getString(R.string.tour_guide_main_location_tasco_description)));
                locations.add(new Location(R.drawable.img_location_togui,
                        getString(R.string.tour_guide_main_location_togui_name),
                        getString(R.string.tour_guide_main_location_togui_description)));
                locations.add(new Location(R.drawable.img_location_el_marfil,
                        getString(R.string.tour_guide_main_location_el_marfil_name),
                        getString(R.string.tour_guide_main_location_el_marfil_description)));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        getString(R.string.tour_guide_main_location_chinavita_name),
                        getString(R.string.tour_guide_main_location_chinavita_description)));
                locations.add(new Location(R.drawable.img_location_san_pablo_de_borbur,
                        getString(R.string.tour_guide_main_location_san_pablo_de_borbur_name),
                        getString(R.string.
                                tour_guide_main_location_san_pablo_de_borbur_description)));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        getString(R.string.tour_guide_main_location_busbanza_name),
                        getString(R.string.tour_guide_main_location_busbanza_description)));
                locations.add(new Location(R.drawable.img_location_puerto_pinzon,
                        getString(R.string.tour_guide_main_location_puerto_pinzon_name),
                        getString(R.string.tour_guide_main_location_puerto_pinzon_description)));
                break;
            case 4:
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        getString(R.string.tour_guide_main_location_el_cocuy_name),
                        getString(R.string.tour_guide_main_location_el_cocuy_description)));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        getString(R.string.tour_guide_main_location_villa_de_leyva_name),
                        getString(R.string.tour_guide_main_location_villa_de_leyva_description)));
                locations.add(new Location(R.drawable.img_location_lago_tota,
                        getString(R.string.tour_guide_main_location_lago_tota_name),
                        getString(R.string.tour_guide_main_location_lago_tota_description)));
                locations.add(new Location(R.drawable.img_location_duitama,
                        getString(R.string.tour_guide_main_location_duitama_name),
                        getString(R.string.tour_guide_main_location_duitama_description)));
                locations.add(new Location(R.drawable.img_location_ramiriqui,
                        getString(R.string.tour_guide_main_location_ramiriqui_name),
                        getString(R.string.tour_guide_main_location_ramiriqui_description)));
                locations.add(new Location(R.drawable.img_location_chivor,
                        getString(R.string.tour_guide_main_location_chivor_name),
                        getString(R.string.tour_guide_main_location_chivor_description)));
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        getString(R.string.tour_guide_main_location_paramo_iguaque_name),
                        getString(R.string.tour_guide_main_location_paramo_iguaque_description)));
                locations.add(new Location(R.drawable.img_location_soata,
                        getString(R.string.tour_guide_main_location_soata_name),
                        getString(R.string.tour_guide_main_location_soata_description)));
                locations.add(new Location(R.drawable.img_location_mongui,
                        getString(R.string.tour_guide_main_location_mongui_name),
                        getString(R.string.tour_guide_main_location_mongui_description)));
                locations.add(new Location(R.drawable.img_location_guican,
                        getString(R.string.tour_guide_main_location_guican_name),
                        getString(R.string.tour_guide_main_location_guican_description)));
                locations.add(new Location(R.drawable.img_location_mongua,
                        getString(R.string.tour_guide_main_location_mongua_name),
                        getString(R.string.tour_guide_main_location_mongua_description)));
                locations.add(new Location(R.drawable.img_location_gameza,
                        getString(R.string.tour_guide_main_location_gameza_name),
                        getString(R.string.tour_guide_main_location_gameza_description)));
                locations.add(new Location(R.drawable.img_location_belen,
                        getString(R.string.tour_guide_main_location_belen_name),
                        getString(R.string.tour_guide_main_location_belen_description)));
                locations.add(new Location(R.drawable.img_location_samaca,
                        getString(R.string.tour_guide_main_location_samaca_name),
                        getString(R.string.tour_guide_main_location_samaca_description)));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        getString(R.string.tour_guide_main_location_chinavita_name),
                        getString(R.string.tour_guide_main_location_chinavita_description)));
                locations.add(new Location(R.drawable.img_location_coscuez,
                        getString(R.string.tour_guide_main_location_coscuez_name),
                        getString(R.string.tour_guide_main_location_coscuez_description)));
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
