package com.acadgild.s12_a3_fragment_items_list_events;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TitlesFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listView = new ListView(getActivity());
        listView.setAdapter(new FrgListAdapter(getActivity(), Data.TITLES));
        return listView;
    }

    public class FrgListAdapter extends BaseAdapter {

        Context context;
        LayoutInflater inflater;

        String[] titles;
        Button titlesBtn;

        public FrgListAdapter(Context context, String[] titles) {
            this.context = context;
            this.titles = titles;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.adapter_frg_list, null);

            titlesBtn = (Button) convertView.findViewById(R.id.titles_btn);
            titlesBtn.setText(titles[position]);
            titlesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.details_frgmnt, DetailsFragment.newInstance(position));
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                }
            });
            return convertView;
        }
    }
}
