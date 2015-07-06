package me.dev.bkk.ncd;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import me.dev.bkk.ncd.adapter.QuestionAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScreenAge35YearsUpActivityFragment extends Fragment {

    ListView listView;

    TextView tv_headerScreenAge35YearsUp, tv_question;
    RadioButton rbn_yes, rbn_no;

    Button btn_next, btn_back, btn_result;
    RadioGroup rgp_yes_or_no;
    int point =0 ;
    int count = 0;
    String headerScreenAge35YearsUp = "แบบบันทึกคัดกรองความเสี่ยงโรคเบาหวาน อายุ 35 ปีขึ้นไป";

    public ScreenAge35YearsUpActivityFragment() {
    }

    String[] question = {   "มีพ่อ  แม่  พี่หรือน้อง เป็นโรคเบาหวาน",
                            "มีภาวะอ้วน(ดัชนีมวลกาย >25 กก/ตร.ม)  หรือ เอวเกิน ชาย > 90 ซม.  หญิง > 80  ซม.",
                            "มีภาวะความดันโลหิตสูง  BP  > = 140/90 MmHg หรือเคยมีประวัติเป็นโรคความดันโลหิตสูง",
                            "มีรอยพับรอบคอหรือใต้รักแร้ดำ",
                            "มีประวัติหรือเคยมีประวัติน้ำตาลในเลือดสูง",
                            "มีภาวะไขมันในเลือดผิดปกติ (ไตรกลีเซอไรด์)  ≥250 มก./ดล. และ/หรือ เอส ดี แอล  < 35 มก./ดล.",
                            "มีประวัติเป็นเบาหวานขณะตั้งครรภ์หรือมีประวัติการคลอดบุตรที่น้ำหนักตัวแรกคลอด >  4  กิโลกรัม"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_ui_model, container, false);

        rgp_yes_or_no = (RadioGroup) rootView.findViewById(R.id.rgp_yes_or_no);
        rbn_yes = (RadioButton) rootView.findViewById(R.id.rbn_yes);
        rbn_no = (RadioButton) rootView.findViewById(R.id.rbn_no);

        tv_headerScreenAge35YearsUp = (TextView) rootView.findViewById(R.id.tv_header);
        tv_question = (TextView) rootView.findViewById(R.id.tv_question);

        btn_next = (Button) rootView.findViewById(R.id.btn_next);
        btn_back = (Button) rootView.findViewById(R.id.btn_back);
        btn_result = (Button) rootView.findViewById(R.id.btn_result);

        btn_back.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);
        btn_result.setVisibility(View.GONE);

        showQuestion();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbn_yes.isChecked() || rbn_no.isChecked()) {
                    nextQuestion();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbn_yes.isChecked() || rbn_no.isChecked()) {
                    previousQuestion();
                }
            }
        });


        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(point >= 1){
                    Intent result_risk = new Intent(getActivity(), ResultRiskActivity.class);
                    getActivity().startActivity(result_risk);
                    getActivity().finish();
                }else{
                    Intent result_not_risk = new Intent(getActivity(), ResultNotRiskActivity.class);
                    getActivity().startActivity(result_not_risk);
                    getActivity().finish();
                }
            }
        });

        tv_headerScreenAge35YearsUp.setText(headerScreenAge35YearsUp);

        return rootView;
    }

    private void previousQuestion() {
        count--;
        if (count != 0) {
            btn_back.setVisibility(View.VISIBLE);
            btn_next.setVisibility(View.VISIBLE);

            showQuestion();
            rgp_yes_or_no.clearCheck();

        } else {
            btn_back.setVisibility(View.INVISIBLE);
            btn_next.setVisibility(View.VISIBLE);
            showQuestion();
            rgp_yes_or_no.clearCheck();
//                    count++;
        }
    }


    private void showQuestion() {
        tv_question.setText((count+1)+". "+question[count]);
        if(rgp_yes_or_no.getCheckedRadioButtonId() == R.id.rbn_yes){
            point++;
        }else if(rgp_yes_or_no.getCheckedRadioButtonId() == R.id.rbn_no){
            point--;
        }

    }

    private void nextQuestion(){
        count++;
        if (count != (question.length - 1)) {
            btn_back.setVisibility(View.VISIBLE);
            btn_next.setVisibility(View.VISIBLE);


            showQuestion();
            rgp_yes_or_no.clearCheck();
        } else {
            btn_back.setVisibility(View.INVISIBLE);
//            btn_back.setVisibility(View.VISIBLE);
            btn_next.setVisibility(View.INVISIBLE);
            btn_result.setVisibility(View.VISIBLE);
//                    count--;
            showQuestion();
            rgp_yes_or_no.clearCheck();
//
        }
    }


}
