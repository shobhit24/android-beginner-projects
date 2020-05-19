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
public class SchoolFragment extends Fragment {

    public static final String NAME = "Schools";

    public SchoolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_school, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();

        tourItems.add(new TourItem(getString(R.string.sch_greenway_name), "", getString(R.string.sch_greenway_addr)));
        tourItems.add(new TourItem(getString(R.string.sch_john_name), "", getString(R.string.sch_john_addr)));

        ListView listView = (ListView) rootView.findViewById(R.id.school_lv);
        TourAdapter tourAdapter = new TourAdapter(rootView.getContext(), tourItems);
        listView.setAdapter(tourAdapter);

        return rootView;
    }

}
