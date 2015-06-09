package me.dev.bkk.ncd;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import java.util.Arrays;

import me.dev.bkk.ncd.adapter.QuestionP6H1YesAdapter;


/**
 * A placeholder fragment containing a simple view.
 */
public class SelectYesActivityFragment extends Fragment {


    ListView lv_QuestionP6H1Yes;

    public SelectYesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_yes, container, false);

        lv_QuestionP6H1Yes = (ListView) rootView.findViewById(R.id.lv_QuestionP6H1Yes);

        String data[] = {"zzz","xxx","ccc"};

        QuestionP6H1YesAdapter questionP6H1YesAdapter = new QuestionP6H1YesAdapter(getActivity(), data);

        return rootView;
    }
}
