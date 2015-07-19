package me.dev.bkk.ncd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cengalabs.flatui.views.FlatButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.dev.bkk.ncd.hypertension.QuestionOne;
import me.dev.bkk.ncd.hypertension.ScreenHypertension;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuButtonActivityFragment extends Fragment {

    FlatButton btn_personal_information, btn_screen_hypertension, btn_screen_diabetes, btn_result;
    @Bind(R.id.btn_behavior)
    FlatButton btnBehavior;

    public MenuButtonActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu_button, container, false);

        //matching
        btn_personal_information = (FlatButton) rootView.findViewById(R.id.btn_personal_information);
        btn_screen_diabetes = (FlatButton) rootView.findViewById(R.id.btn_screen_age_14_to_34_years);
        btn_screen_hypertension = (FlatButton) rootView.findViewById(R.id.btn_screen_age_35_years_up);
        btn_result = (FlatButton) rootView.findViewById(R.id.btn_result);

        btn_personal_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personal_information = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(personal_information);
            }
        });


        btn_screen_diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen_diabetes = new Intent(getActivity(), Select14to34Or35up.class);
                getActivity().startActivity(screen_diabetes);
            }
        });

        btn_screen_hypertension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screen_hypertension = new Intent(getActivity(), ScreenHypertension.class);
                getActivity().startActivity(screen_hypertension);
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(getActivity(), ResultActivity.class);
                getActivity().startActivity(result);
            }
        });


        ButterKnife.bind(this, rootView);
        return rootView;

    }

    @OnClick(R.id.btn_behavior) void startBehaviorQuestion(){
        Intent behaviorQuestion = new Intent(getActivity(), QuestionOne.class);
        getActivity().startActivity(behaviorQuestion);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
