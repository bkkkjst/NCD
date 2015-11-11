package me.dev.bkk.ncd.hypertension;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.dev.bkk.ncd.R;
import me.dev.bkk.ncd.model.Result;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionOneFragment extends Fragment{

    String[] choiceQ1 = {"เบาหวาน", "ความดันโลหิตสูง", "โรคเกาท์", "ไตวายเรื้อรัง",
            "กล้ามเนื้อหัวใจตาย", "เส้นเลือดสมอง", "ถุงลมโป่งพอง", "ไม่ทราบ", "อื่นๆ"};
    @Bind(R.id.tv_headerQ1)
    TextView tvHeaderQ1;
    @Bind(R.id.tv_q1)
    TextView tvQ1;
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
    @Bind(R.id.rbn_ch9)
    RadioButton rbnCh9;
    @Bind(R.id.ll_anwser_question_one)
    LinearLayout llAnwserQuestionOne;
    @Bind(R.id.btn_ok)
    Button btnOk;

    int[] rbnId = { R.id.rbn_ch1, R.id.rbn_ch2, R.id.rbn_ch3, R.id.rbn_ch4,
                    R.id.rbn_ch5, R.id.rbn_ch6, R.id.rbn_ch7, R.id.rbn_ch8,
                    R.id.rbn_ch9};

    public QuestionOneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_question_one, container, false);

        ButterKnife.bind(this, rootView);



        return rootView;
    }

    @OnClick(R.id.btn_ok)
    void saveAndNextQuestion() {

        if (checkSelectRadioButton(rbnId)) {
            Intent saveAndNextQuestion = new Intent(getActivity(), QuestionTwo.class);
            startActivity(saveAndNextQuestion);
        } else {

        }

    }

    private boolean checkSelectRadioButton(int[] rbnId){
        boolean check = false;
            for(int i = 0; i < rbnId.length; i++){
                RadioButton radioButton = (RadioButton) getActivity().findViewById(rbnId[i]);
                if(radioButton.isChecked()){
                    String selected = radioButton.getText().toString();
                    String[] strings = new String[rbnId.length];
                    strings[i] = selected;
                    check = true;
                }else{

                }
            }
        return check;
    }

    /*private Boolean getRadioGroupSelect() {
        if (rgpCh1.getCheckedRadioButtonId() != -1) {
            int selectId = rgpCh1.getCheckedRadioButtonId();
            RadioButton rbn_select = (RadioButton) getActivity().findViewById(selectId);
            String answer1 = rbn_select.getText().toString().trim();
            Result result = new Result();
            result.setAnswer1(answer1);
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



}
