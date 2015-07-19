package me.dev.bkk.ncd.hypertension;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.bkk.ncd.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionTwoFragment extends Fragment {

    @Bind(R.id.tv_headerQ2)
    TextView tvHeaderQ2;
    @Bind(R.id.tv_q2)
    TextView tvQ2;
    @Bind(R.id.rbn_ch1)
    RadioButton rbnCh1;
    @Bind(R.id.rbn_ch2)
    RadioButton rbnCh2;
    @Bind(R.id.rbn_ch3)
    RadioButton rbnCh3;
    @Bind(R.id.rbn_ch4)
    RadioButton rbnCh4;
    @Bind(R.id.rbn_ch5)
    RadioButton rbnCh5;
    @Bind(R.id.rbn_ch6)
    RadioButton rbnCh6;
    @Bind(R.id.rbn_ch7)
    RadioButton rbnCh7;
    @Bind(R.id.rbn_ch8)
    RadioButton rbnCh8;
    @Bind(R.id.rgp_ch2)
    RadioGroup rgpCh2;

    public QuestionTwoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_question_two, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
