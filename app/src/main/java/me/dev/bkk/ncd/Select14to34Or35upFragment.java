package me.dev.bkk.ncd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class Select14to34Or35upFragment extends Fragment {

    @Bind(R.id.btn_14to34years)
    Button btn14to34years;
    @Bind(R.id.btn_35up)
    Button btn35up;

    public Select14to34Or35upFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select14to34_or35up, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @OnClick(R.id.btn_14to34years)
        void showQuestion14to34years(){
        Intent showQuestion14to34years = new Intent(getActivity(), ScreenAge14to34YearsActivity.class);
        getActivity().startActivity(showQuestion14to34years);
    }

    @OnClick(R.id.btn_35up)
    void showQuestion35yearsUp(){
        Intent showQuestion35yearsUp = new Intent(getActivity(), ScreenAge35YearsUpActivity.class);
        getActivity().startActivity(showQuestion35yearsUp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
