package me.dev.bkk.ncd;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cengalabs.flatui.views.FlatButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuButtonActivityFragment extends Fragment {

    FlatButton btn_personal_information, btn_screen_age_35_years_up, btn_screen_age_14_to_34_years, btn_result;

    public MenuButtonActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu_button, container, false);

        //matching
        btn_personal_information = (FlatButton) rootView.findViewById(R.id.btn_personal_information);
        btn_screen_age_14_to_34_years = (FlatButton) rootView.findViewById(R.id.btn_screen_age_14_to_34_years);
        btn_screen_age_35_years_up = (FlatButton) rootView.findViewById(R.id.btn_screen_age_35_years_up);
        btn_result = (FlatButton) rootView.findViewById(R.id.btn_result);

       btn_personal_information.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent personal_information = new Intent(getActivity(), MainActivity.class);
               getActivity().startActivity(personal_information);
           }
       });


        return rootView;

    }
}
