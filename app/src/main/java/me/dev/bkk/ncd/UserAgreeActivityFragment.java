package me.dev.bkk.ncd;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserAgreeActivityFragment extends Fragment {

    RadioButton rbn_agree, rbn_no_agree;
    Button btn_go;

    public UserAgreeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_user_agree, container, false);

        rbn_agree = (RadioButton) rootView.findViewById(R.id.rbn_agree);
        rbn_no_agree = (RadioButton) rootView.findViewById(R.id.rbn_no_agree);

        btn_go = (Button) rootView.findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbn_agree.isChecked()) {
                    Intent menuButton = new Intent(getActivity(), MenuButtonActivity.class);
                    getActivity().startActivity(menuButton);
                    getActivity().finish();
                }else if(rbn_no_agree.isChecked()){
                    getActivity().finish();
                }
            }
        });


        return rootView;
    }


}
