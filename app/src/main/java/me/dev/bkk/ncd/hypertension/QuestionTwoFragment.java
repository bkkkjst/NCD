package me.dev.bkk.ncd.hypertension;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.dev.bkk.ncd.R;
import me.dev.bkk.ncd.model.Result;

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

    Bundle bundle;

    int[] rbnId = { R.id.rbn_ch1, R.id.rbn_ch2, R.id.rbn_ch3, R.id.rbn_ch4,
            R.id.rbn_ch5, R.id.rbn_ch6, R.id.rbn_ch7, R.id.rbn_ch8};

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

    @OnClick(R.id.btn_ok)
    void saveAndNextQuestion() {

        if (checkSelectRadioButton(rbnId)) {
            getActivity().finish();
        } else {

        }

    }

    private boolean checkSelectRadioButton(int[] rbnId){
        boolean check = false;
        StringBuilder answer2 = new StringBuilder();
        for(int i = 0; i < rbnId.length; i++){
            RadioButton radioButton = (RadioButton) getActivity().findViewById(rbnId[i]);
            if(radioButton.isChecked()){
                String selected = radioButton.getText().toString();
                String[] strings = new String[rbnId.length];
                strings[i] = selected;
                answer2.append(strings[i] + "\n");


                check = true;
            }else{

            }
        }
        Result.getInstance().setAnswer2(answer2.toString());

        String data = Result.getInstance().getInformation()+"\n\n"
                +Result.getInstance().getAnswer1()+"\n"
                +Result.getInstance().getAnswer2();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{});
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        intent.putExtra(Intent.EXTRA_TEXT, data);
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }



        return check;
    }
}
