package com.acadgild.s12_a3_fragment_items_list_events;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 */
public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView text = new TextView(getActivity());
        text.setText(Data.DETAILS[getArguments().getInt("position", 0)]);
        return text;
    }


    public static DetailsFragment newInstance(int index) {
        DetailsFragment df = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("position", index);
        df.setArguments(bundle);

        return df;
    }

}