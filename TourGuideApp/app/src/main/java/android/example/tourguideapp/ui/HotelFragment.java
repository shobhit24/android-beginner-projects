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

public class HotelFragment extends Fragment {

    public static final String NAME = "Hotels";

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_hotel, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.hotel_bill_name), "", getString(R.string.hotel_bill_addr)));
        tourItems.add(new TourItem(getString(R.string.hotel_heights_name), "", getString(R.string.hotel_heights_addr)));

        ListView listView = (ListView) rootView.findViewById(R.id.hotel_lv);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }

}
