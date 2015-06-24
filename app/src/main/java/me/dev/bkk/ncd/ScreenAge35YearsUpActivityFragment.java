package me.dev.bkk.ncd;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import me.dev.bkk.ncd.adapter.QuestionAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScreenAge35YearsUpActivityFragment extends Fragment {

    ListView listView;

    TextView tv_headerScreenAge35YearsUp, tv_question;
    RadioButton rbn_yes, rbn_no;
    TabLayout tabLayout;
    Button btn_next, btn_back;

    int count = 0;
    String headerScreenAge35YearsUp = "แบบบันทึกคัดกรองความเสี่ยงประชากร อายุ 35 ปีขึ้นไป";

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


        tv_headerScreenAge35YearsUp = (TextView) rootView.findViewById(R.id.tv_header);
        tv_question = (TextView) rootView.findViewById(R.id.tv_question);

        btn_next = (Button) rootView.findViewById(R.id.btn_next);
        btn_back = (Button) rootView.findViewById(R.id.btn_back);

        btn_back.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);

        showQuestion();
//


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count != (question.length-1)){
                    btn_back.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.VISIBLE);
                    count++;
                    showQuestion();

                }else{
                    btn_back.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.INVISIBLE);
//                    count--;
                    showQuestion();
//
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count != 0){
                    btn_back.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.VISIBLE);
                    count--;
                    showQuestion();

                }else{
                    btn_back.setVisibility(View.INVISIBLE);
                    btn_next.setVisibility(View.VISIBLE);
                    showQuestion();
//                    count++;
                }
            }
        });



        tv_headerScreenAge35YearsUp.setText(headerScreenAge35YearsUp);


        return rootView;
    }

    private void showQuestion() {
        tv_question.setText("ข้อ "+(count+1)+". "+question[count]);


    }
}
