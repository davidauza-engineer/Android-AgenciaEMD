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
                        R.string.tour_guide_main_location_tunja_name,
                        R.string.tour_guide_main_location_tunja_short_description,
                        R.string.tour_guide_main_location_tunja_long_description));
                locations.add(new Location(R.drawable.img_location_chiquinquira,
                        R.string.tour_guide_main_location_chiquinquira_name,
                        R.string.tour_guide_main_location_chiquinquira_short_description,
                        R.string.tour_guide_main_location_chiquinquira_long_description));
                locations.add(new Location(R.drawable.img_location_paipa,
                        R.string.tour_guide_main_location_paipa_name,
                        R.string.tour_guide_main_location_paipa_short_description,
                        R.string.tour_guide_main_location_paipa_long_description));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        R.string.tour_guide_main_location_villa_de_leyva_name,
                        R.string.tour_guide_main_location_villa_de_leyva_short_description,
                        R.string.tour_guide_main_location_villa_de_leyva_long_description));
                locations.add(new Location(R.drawable.img_location_soata,
                        R.string.tour_guide_main_location_soata_name,
                        R.string.tour_guide_main_location_soata_short_description,
                        R.string.tour_guide_main_location_soata_long_description));
                locations.add(new Location(R.drawable.img_location_ramiriqui,
                        R.string.tour_guide_main_location_ramiriqui_name,
                        R.string.tour_guide_main_location_ramiriqui_short_description,
                        R.string.tour_guide_main_location_ramiriqui_long_description));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        R.string.tour_guide_main_location_busbanza_name,
                        R.string.tour_guide_main_location_busbanza_short_description,
                        R.string.tour_guide_main_location_busbanza_long_description));
                locations.add(new Location(R.drawable.img_location_jenesano,
                        R.string.tour_guide_main_location_jenesano_name,
                        R.string.tour_guide_main_location_jenesano_short_description,
                        R.string.tour_guide_main_location_jenesano_long_description));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        R.string.tour_guide_main_location_zetaquira_name,
                        R.string.tour_guide_main_location_zetaquira_short_description,
                        R.string.tour_guide_main_location_zetaquira_long_description));
                locations.add(new Location(R.drawable.img_location_firavitoba,
                        R.string.tour_guide_main_location_firavitoba_name,
                        R.string.tour_guide_main_location_firavitoba_short_description,
                        R.string.tour_guide_main_location_firavitoba_long_description));
                locations.add(new Location(R.drawable.img_location_tasco,
                        R.string.tour_guide_main_location_tasco_name,
                        R.string.tour_guide_main_location_tasco_short_description,
                        R.string.tour_guide_main_location_tasco_long_description));
                locations.add(new Location(R.drawable.img_location_cerinza,
                        R.string.tour_guide_main_location_cerinza_name,
                        R.string.tour_guide_main_location_cerinza_short_description,
                        R.string.tour_guide_main_location_cerinza_long_description));
                locations.add(new Location(R.drawable.img_location_santa_sofia,
                        R.string.tour_guide_main_location_santa_sofia_name,
                        R.string.tour_guide_main_location_santa_sofia_short_description,
                        R.string.tour_guide_main_location_santa_sofia_long_description));
                locations.add(new Location(R.drawable.img_location_morca,
                        R.string.tour_guide_main_location_morca_name,
                        R.string.tour_guide_main_location_morca_short_description,
                        R.string.tour_guide_main_location_morca_long_description));
                locations.add(new Location(R.drawable.img_location_belen,
                        R.string.tour_guide_main_location_belen_name,
                        R.string.tour_guide_main_location_belen_short_description,
                        R.string.tour_guide_main_location_belen_long_description));
                locations.add(new Location(R.drawable.img_location_paz_de_rio,
                        R.string.tour_guide_main_location_paz_de_rio_name,
                        R.string.tour_guide_main_location_paz_de_rio_short_description,
                        R.string.tour_guide_main_location_paz_de_rio_long_description));
                locations.add(new Location(R.drawable.img_location_santa_rosa_de_viterbo,
                        R.string.tour_guide_main_location_santa_rosa_de_viterbo_name,
                        R.string.tour_guide_main_location_santa_rosa_de_viterbo_short_description,
                        R.string.tour_guide_main_location_santa_rosa_de_viterbo_long_description));
                locations.add(new Location(R.drawable.img_location_rondon,
                        R.string.tour_guide_main_location_rondon_name,
                        R.string.tour_guide_main_location_rondon_short_description,
                        R.string.tour_guide_main_location_rondon_long_description));
                locations.add(new Location(R.drawable.img_location_paya,
                        R.string.tour_guide_main_location_paya_name,
                        R.string.tour_guide_main_location_paya_short_description,
                        R.string.tour_guide_main_location_paya_long_description));
                break;
            case 1:
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        R.string.tour_guide_main_location_paramo_iguaque_name,
                        R.string.tour_guide_main_location_paramo_iguaque_short_description,
                        R.string.tour_guide_main_location_paramo_iguaque_long_description));
                locations.add(new Location(R.drawable.img_location_arcabuco,
                        R.string.tour_guide_main_location_arcabuco_name,
                        R.string.tour_guide_main_location_arcabuco_short_description,
                        R.string.tour_guide_main_location_arcabuco_long_description));
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        R.string.tour_guide_main_location_el_cocuy_name,
                        R.string.tour_guide_main_location_el_cocuy_short_description,
                        R.string.tour_guide_main_location_el_cocuy_long_description));
                locations.add(new Location(R.drawable.img_location_tenza,
                        R.string.tour_guide_main_location_tenza_name,
                        R.string.tour_guide_main_location_tenza_short_description,
                        R.string.tour_guide_main_location_tenza_long_description));
                locations.add(new Location(R.drawable.img_location_raquira,
                        R.string.tour_guide_main_location_raquira_name,
                        R.string.tour_guide_main_location_raquira_short_description,
                        R.string.tour_guide_main_location_raquira_long_description));
                locations.add(new Location(R.drawable.img_location_moniquira,
                        R.string.tour_guide_main_location_moniquira_name,
                        R.string.tour_guide_main_location_moniquira_short_description,
                        R.string.tour_guide_main_location_moniquira_long_description));
                locations.add(new Location(R.drawable.img_location_garagoa,
                        R.string.tour_guide_main_location_garagoa_name,
                        R.string.tour_guide_main_location_garagoa_short_description,
                        R.string.tour_guide_main_location_garagoa_long_description));
                locations.add(new Location(R.drawable.img_location_san_pablo_de_borbur,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_name,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_short_description,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_long_description));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        R.string.tour_guide_main_location_busbanza_name,
                        R.string.tour_guide_main_location_busbanza_short_description,
                        R.string.tour_guide_main_location_busbanza_long_description));
                break;
            case 2:
                locations.add(new Location(R.drawable.img_location_paipa,
                        R.string.tour_guide_main_location_paipa_name,
                        R.string.tour_guide_main_location_paipa_short_description,
                        R.string.tour_guide_main_location_paipa_long_description));
                locations.add(new Location(R.drawable.img_location_iza,
                        R.string.tour_guide_main_location_iza_name,
                        R.string.tour_guide_main_location_iza_short_description,
                        R.string.tour_guide_main_location_iza_long_description));
                locations.add(new Location(R.drawable.img_location_guican,
                        R.string.tour_guide_main_location_guican_name,
                        R.string.tour_guide_main_location_guican_short_description,
                        R.string.tour_guide_main_location_guican_long_description));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        R.string.tour_guide_main_location_zetaquira_name,
                        R.string.tour_guide_main_location_zetaquira_short_description,
                        R.string.tour_guide_main_location_zetaquira_long_description));
                locations.add(new Location(R.drawable.img_location_cuitiva,
                        R.string.tour_guide_main_location_cuitiva_name,
                        R.string.tour_guide_main_location_cuitiva_short_description,
                        R.string.tour_guide_main_location_cuitiva_long_description));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        R.string.tour_guide_main_location_chinavita_name,
                        R.string.tour_guide_main_location_chinavita_short_description,
                        R.string.tour_guide_main_location_chinavita_long_description));
                break;
            case 3:
                locations.add(new Location(R.drawable.img_location_lago_tota,
                        R.string.tour_guide_main_location_lago_de_tota_name,
                        R.string.tour_guide_main_location_lago_de_tota_short_description,
                        R.string.tour_guide_main_location_lago_de_tota_long_description));
                locations.add(new Location(R.drawable.img_location_paipa,
                        R.string.tour_guide_main_location_paipa_name,
                        R.string.tour_guide_main_location_paipa_short_description,
                        R.string.tour_guide_main_location_paipa_long_description));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        R.string.tour_guide_main_location_villa_de_leyva_name,
                        R.string.tour_guide_main_location_villa_de_leyva_short_description,
                        R.string.tour_guide_main_location_villa_de_leyva_long_description));
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        R.string.tour_guide_main_location_paramo_iguaque_name,
                        R.string.tour_guide_main_location_paramo_iguaque_short_description,
                        R.string.tour_guide_main_location_paramo_iguaque_long_description));
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        R.string.tour_guide_main_location_el_cocuy_name,
                        R.string.tour_guide_main_location_el_cocuy_short_description,
                        R.string.tour_guide_main_location_el_cocuy_long_description));
                locations.add(new Location(R.drawable.img_location_tota,
                        R.string.tour_guide_main_location_tota_name,
                        R.string.tour_guide_main_location_tota_short_description,
                        R.string.tour_guide_main_location_tota_long_description));
                locations.add(new Location(R.drawable.img_location_aquitania,
                        R.string.tour_guide_main_location_aquitania_name,
                        R.string.tour_guide_main_location_aquitania_short_description,
                        R.string.tour_guide_main_location_aquitania_long_description));
                locations.add(new Location(R.drawable.img_location_iza,
                        R.string.tour_guide_main_location_iza_name,
                        R.string.tour_guide_main_location_iza_short_description,
                        R.string.tour_guide_main_location_iza_long_description));
                locations.add(new Location(R.drawable.img_location_moniquira,
                        R.string.tour_guide_main_location_moniquira_name,
                        R.string.tour_guide_main_location_moniquira_short_description,
                        R.string.tour_guide_main_location_moniquira_long_description));
                locations.add(new Location(R.drawable.img_location_guican,
                        R.string.tour_guide_main_location_guican_name,
                        R.string.tour_guide_main_location_guican_short_description,
                        R.string.tour_guide_main_location_guican_long_description));
                locations.add(new Location(R.drawable.img_location_arcabuco,
                        R.string.tour_guide_main_location_arcabuco_name,
                        R.string.tour_guide_main_location_arcabuco_short_description,
                        R.string.tour_guide_main_location_arcabuco_long_description));
                locations.add(new Location(R.drawable.img_location_raquira,
                        R.string.tour_guide_main_location_raquira_name,
                        R.string.tour_guide_main_location_raquira_short_description,
                        R.string.tour_guide_main_location_raquira_long_description));
                locations.add(new Location(R.drawable.img_location_zetaquira,
                        R.string.tour_guide_main_location_zetaquira_name,
                        R.string.tour_guide_main_location_zetaquira_short_description,
                        R.string.tour_guide_main_location_zetaquira_long_description));
                locations.add(new Location(R.drawable.img_location_gachantiva,
                        R.string.tour_guide_main_location_gachantiva_name,
                        R.string.tour_guide_main_location_gachantiva_short_description,
                        R.string.tour_guide_main_location_gachantiva_long_description));
                locations.add(new Location(R.drawable.img_location_santa_sofia,
                        R.string.tour_guide_main_location_santa_sofia_name,
                        R.string.tour_guide_main_location_santa_sofia_short_description,
                        R.string.tour_guide_main_location_santa_sofia_long_description));
                locations.add(new Location(R.drawable.img_location_tenza,
                        R.string.tour_guide_main_location_tenza_name,
                        R.string.tour_guide_main_location_tenza_short_description,
                        R.string.tour_guide_main_location_tenza_long_description));
                locations.add(new Location(R.drawable.img_location_sogamoso,
                        R.string.tour_guide_main_location_sogamoso_name,
                        R.string.tour_guide_main_location_sogamoso_short_description,
                        R.string.tour_guide_main_location_sogamoso_long_description));
                locations.add(new Location(R.drawable.img_location_cuitiva,
                        R.string.tour_guide_main_location_cuitiva_name,
                        R.string.tour_guide_main_location_cuitiva_short_description,
                        R.string.tour_guide_main_location_cuitiva_long_description));
                locations.add(new Location(R.drawable.img_location_garagoa,
                        R.string.tour_guide_main_location_garagoa_name,
                        R.string.tour_guide_main_location_garagoa_short_description,
                        R.string.tour_guide_main_location_garagoa_long_description));
                locations.add(new Location(R.drawable.img_location_jenesano,
                        R.string.tour_guide_main_location_jenesano_name,
                        R.string.tour_guide_main_location_jenesano_short_description,
                        R.string.tour_guide_main_location_jenesano_long_description));
                locations.add(new Location(R.drawable.img_location_mongui,
                        R.string.tour_guide_main_location_mongui_name,
                        R.string.tour_guide_main_location_mongui_short_description,
                        R.string.tour_guide_main_location_mongui_long_description));
                locations.add(new Location(R.drawable.img_location_duitama,
                        R.string.tour_guide_main_location_duitama_name,
                        R.string.tour_guide_main_location_duitama_short_description,
                        R.string.tour_guide_main_location_duitama_long_description));
                locations.add(new Location(R.drawable.img_location_sachica,
                        R.string.tour_guide_main_location_sachica_name,
                        R.string.tour_guide_main_location_sachica_short_description,
                        R.string.tour_guide_main_location_sachica_long_description));
                locations.add(new Location(R.drawable.img_location_puerto_boyaca,
                        R.string.tour_guide_main_location_puerto_boyaca_name,
                        R.string.tour_guide_main_location_puerto_boyaca_short_description,
                        R.string.tour_guide_main_location_puerto_boyaca_long_description));
                locations.add(new Location(R.drawable.img_location_cienaga,
                        R.string.tour_guide_main_location_cienega_name,
                        R.string.tour_guide_main_location_cienega_short_description,
                        R.string.tour_guide_main_location_cienega_long_description));
                locations.add(new Location(R.drawable.img_location_socha,
                        R.string.tour_guide_main_location_socha_name,
                        R.string.tour_guide_main_location_socha_short_description,
                        R.string.tour_guide_main_location_socha_long_description));
                locations.add(new Location(R.drawable.img_location_pajarito,
                        R.string.tour_guide_main_location_pajarito_name,
                        R.string.tour_guide_main_location_pajarito_short_description,
                        R.string.tour_guide_main_location_pajarito_long_description));
                locations.add(new Location(R.drawable.img_location_pisba,
                        R.string.tour_guide_main_location_pisba_name,
                        R.string.tour_guide_main_location_pisba_short_description,
                        R.string.tour_guide_main_location_pisba_long_description));
                locations.add(new Location(R.drawable.img_location_pesca,
                        R.string.tour_guide_main_location_pesca_name,
                        R.string.tour_guide_main_location_pesca_short_description,
                        R.string.tour_guide_main_location_pesca_long_description));
                locations.add(new Location(R.drawable.img_location_tinjaca,
                        R.string.tour_guide_main_location_tinjaca_name,
                        R.string.tour_guide_main_location_tinjaca_short_description,
                        R.string.tour_guide_main_location_tinjaca_long_description));
                locations.add(new Location(R.drawable.img_location_guateque,
                        R.string.tour_guide_main_location_guateque_name,
                        R.string.tour_guide_main_location_guateque_short_description,
                        R.string.tour_guide_main_location_guateque_long_description));
                locations.add(new Location(R.drawable.img_location_saboya,
                        R.string.tour_guide_main_location_saboya_name,
                        R.string.tour_guide_main_location_saboya_short_description,
                        R.string.tour_guide_main_location_saboya_long_description));
                locations.add(new Location(R.drawable.img_location_combita,
                        R.string.tour_guide_main_location_combita_name,
                        R.string.tour_guide_main_location_combita_short_description,
                        R.string.tour_guide_main_location_combita_long_description));
                locations.add(new Location(R.drawable.img_location_cerinza,
                        R.string.tour_guide_main_location_cerinza_name,
                        R.string.tour_guide_main_location_cerinza_short_description,
                        R.string.tour_guide_main_location_cerinza_long_description));
                locations.add(new Location(R.drawable.img_location_firavitoba,
                        R.string.tour_guide_main_location_firavitoba_name,
                        R.string.tour_guide_main_location_firavitoba_short_description,
                        R.string.tour_guide_main_location_firavitoba_long_description));
                locations.add(new Location(R.drawable.img_location_toca,
                        R.string.tour_guide_main_location_toca_name,
                        R.string.tour_guide_main_location_toca_short_description,
                        R.string.tour_guide_main_location_toca_long_description));
                locations.add(new Location(R.drawable.img_location_cucaita,
                        R.string.tour_guide_main_location_cucaita_name,
                        R.string.tour_guide_main_location_cucaita_short_description,
                        R.string.tour_guide_main_location_cucaita_long_description));
                locations.add(new Location(R.drawable.img_location_somondoco,
                        R.string.tour_guide_main_location_somondoco_name,
                        R.string.tour_guide_main_location_somondoco_short_description,
                        R.string.tour_guide_main_location_somondoco_long_description));
                locations.add(new Location(R.drawable.img_location_chitaraque,
                        R.string.tour_guide_main_location_chitaraque_name,
                        R.string.tour_guide_main_location_chitaraque_short_description,
                        R.string.tour_guide_main_location_chitaraque_long_description));
                locations.add(new Location(R.drawable.img_location_umbita,
                        R.string.tour_guide_main_location_umbita_name,
                        R.string.tour_guide_main_location_umbita_short_description,
                        R.string.tour_guide_main_location_umbita_long_description));
                locations.add(new Location(R.drawable.img_location_tasco,
                        R.string.tour_guide_main_location_tasco_name,
                        R.string.tour_guide_main_location_tasco_short_description,
                        R.string.tour_guide_main_location_tasco_long_description));
                locations.add(new Location(R.drawable.img_location_togui,
                        R.string.tour_guide_main_location_togui_name,
                        R.string.tour_guide_main_location_togui_short_description,
                        R.string.tour_guide_main_location_togui_long_description));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        R.string.tour_guide_main_location_chinavita_name,
                        R.string.tour_guide_main_location_chinavita_short_description,
                        R.string.tour_guide_main_location_chinavita_long_description));
                locations.add(new Location(R.drawable.img_location_san_pablo_de_borbur,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_name,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_short_description,
                        R.string.tour_guide_main_location_san_pablo_de_borbur_long_description));
                locations.add(new Location(R.drawable.img_location_busbanza,
                        R.string.tour_guide_main_location_busbanza_name,
                        R.string.tour_guide_main_location_busbanza_short_description,
                        R.string.tour_guide_main_location_busbanza_long_description));
                break;
            case 4:
                locations.add(new Location(R.drawable.img_location_el_cocuy,
                        R.string.tour_guide_main_location_el_cocuy_name,
                        R.string.tour_guide_main_location_el_cocuy_short_description,
                        R.string.tour_guide_main_location_el_cocuy_long_description));
                locations.add(new Location(R.drawable.img_location_villa_de_leyva,
                        R.string.tour_guide_main_location_villa_de_leyva_name,
                        R.string.tour_guide_main_location_villa_de_leyva_short_description,
                        R.string.tour_guide_main_location_villa_de_leyva_long_description));
                locations.add(new Location(R.drawable.img_location_lago_tota,
                        R.string.tour_guide_main_location_lago_de_tota_name,
                        R.string.tour_guide_main_location_lago_de_tota_short_description,
                        R.string.tour_guide_main_location_lago_de_tota_long_description));
                locations.add(new Location(R.drawable.img_location_duitama,
                        R.string.tour_guide_main_location_duitama_name,
                        R.string.tour_guide_main_location_duitama_short_description,
                        R.string.tour_guide_main_location_duitama_long_description));
                locations.add(new Location(R.drawable.img_location_ramiriqui,
                        R.string.tour_guide_main_location_ramiriqui_name,
                        R.string.tour_guide_main_location_ramiriqui_short_description,
                        R.string.tour_guide_main_location_ramiriqui_long_description));
                locations.add(new Location(R.drawable.img_location_chivor,
                        R.string.tour_guide_main_location_chivor_name,
                        R.string.tour_guide_main_location_chivor_short_description,
                        R.string.tour_guide_main_location_chivor_long_description));
                locations.add(new Location(R.drawable.img_location_paramo_iguaque,
                        R.string.tour_guide_main_location_paramo_iguaque_name,
                        R.string.tour_guide_main_location_paramo_iguaque_short_description,
                        R.string.tour_guide_main_location_paramo_iguaque_long_description));
                locations.add(new Location(R.drawable.img_location_soata,
                        R.string.tour_guide_main_location_soata_name,
                        R.string.tour_guide_main_location_soata_short_description,
                        R.string.tour_guide_main_location_soata_long_description));
                locations.add(new Location(R.drawable.img_location_mongui,
                        R.string.tour_guide_main_location_mongui_name,
                        R.string.tour_guide_main_location_mongui_short_description,
                        R.string.tour_guide_main_location_mongui_long_description));
                locations.add(new Location(R.drawable.img_location_guican,
                        R.string.tour_guide_main_location_guican_name,
                        R.string.tour_guide_main_location_guican_short_description,
                        R.string.tour_guide_main_location_guican_long_description));
                locations.add(new Location(R.drawable.img_location_mongua,
                        R.string.tour_guide_main_location_mongua_name,
                        R.string.tour_guide_main_location_mongua_short_description,
                        R.string.tour_guide_main_location_mongua_long_description));
                locations.add(new Location(R.drawable.img_location_gameza,
                        R.string.tour_guide_main_location_gameza_name,
                        R.string.tour_guide_main_location_gameza_short_description,
                        R.string.tour_guide_main_location_gameza_long_description));
                locations.add(new Location(R.drawable.img_location_belen,
                        R.string.tour_guide_main_location_belen_name,
                        R.string.tour_guide_main_location_belen_short_description,
                        R.string.tour_guide_main_location_belen_long_description));
                locations.add(new Location(R.drawable.img_location_samaca,
                        R.string.tour_guide_main_location_samaca_name,
                        R.string.tour_guide_main_location_samaca_short_description,
                        R.string.tour_guide_main_location_samaca_long_description));
                locations.add(new Location(R.drawable.img_location_chinavita,
                        R.string.tour_guide_main_location_chinavita_name,
                        R.string.tour_guide_main_location_chinavita_short_description,
                        R.string.tour_guide_main_location_chinavita_long_description));
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
