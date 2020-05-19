package android.example.tourguideapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import android.example.tourguideapp.R;
import android.example.tourguideapp.adapter.TourAdapter;
import android.example.tourguideapp.model.TourItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {

    public static final String NAME = "Restaurants";

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_restaurant, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.rest_dilli_name), "", getString(R.string.rest_dilli_addr)));
        tourItems.add(new TourItem(getString(R.string.rest_raaj_name), "", getString(R.string.rest_raaj_addr)));

        ListView listView = (ListView) rootView.findViewById(R.id.rest_lv);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }

}
