package me.dev.bkk.ncd;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class ResultActivityFragment extends Fragment {

    Button btn_not_risk, btn_risk;

    public ResultActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        btn_not_risk = (Button) rootView.findViewById(R.id.btn_not_risk);
        btn_risk = (Button) rootView.findViewById(R.id.btn_risk);

        btn_not_risk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result_not_risk = new Intent(getActivity(), ResultNotRiskActivity.class);
                getActivity().startActivity(result_not_risk);
            }
        });

        btn_risk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result_risk = new Intent(getActivity(), ResultRiskActivity.class);
                getActivity().startActivity(result_risk);
            }
        });


        return rootView;
    }
}
