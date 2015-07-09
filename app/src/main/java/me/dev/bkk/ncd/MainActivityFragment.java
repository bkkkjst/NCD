package me.dev.bkk.ncd;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.annotations.RegExp;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    RadioGroup rgp_gender, rgp_religion, rgp_diabetes, rgp_Hypertension, rgp_graduate,
               rgp_status, rgp_work;

    RadioButton rbn_male, rbn_female, rbn_genderSelect, rbn_religionSelect,
                rbn_diabetesSelect, rbn_HypertensionSelect, rbn_graduateSelect,
                rbn_statusSelect, rbn_workSelect;

    @RegExp(value = "EMAIL", messageId = R.string.validation_idCard)
    EditText etx_idCard;

    EditText etx_birthDay, etx_weightBody, etx_height, etx_waistline,
             etx_BloodPressureFront, etx_BloodPressureBack, etx_other;

    Button btn_save;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);



        etx_birthDay = (EditText) rootView.findViewById(R.id.etx_birthDay);
        rgp_gender = (RadioGroup) rootView.findViewById(R.id.rgp_gender);
//        rbn_male = (RadioButton) rootView.findViewById(R.id.rbn_male);
//        rbn_female = (RadioButton) rootView.findViewById(R.id.rbn_female);
//        rbn_genderSelect = (RadioButton) getActivity().findViewById(genderSelect);
        rgp_religion = (RadioGroup) rootView.findViewById(R.id.rgp_religion);
        rgp_diabetes = (RadioGroup) rootView.findViewById(R.id.rgp_diabetes);
        rgp_Hypertension = (RadioGroup) rootView.findViewById(R.id.rgp_Hypertension);
        rgp_graduate = (RadioGroup) rootView.findViewById(R.id.rgp_graduate);
        rgp_status = (RadioGroup) rootView.findViewById(R.id.rgp_status);
        rgp_work = (RadioGroup) rootView.findViewById(R.id.rgp_work);

        btn_save = (Button) rootView.findViewById(R.id.btn_save);

        etx_idCard = (EditText) rootView.findViewById(R.id.etx_idCard);
        etx_birthDay = (EditText) rootView.findViewById(R.id.etx_birthDay);
        etx_weightBody = (EditText) rootView.findViewById(R.id.etx_weightBody);
        etx_height = (EditText) rootView.findViewById(R.id.etx_height);
        etx_waistline = (EditText) rootView.findViewById(R.id.etx_waistline);
        etx_BloodPressureFront = (EditText) rootView.findViewById(R.id.etx_BloodPressureFront);
        etx_BloodPressureBack = (EditText) rootView.findViewById(R.id.etx_BloodPressureBack);
        etx_other = (EditText) rootView.findViewById(R.id.etx_other);


        etx_birthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"bkk.dev.me@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , textToString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return rootView;
    }


    private String textToString(){

        String textToEmail,other;

        int genderSelect = rgp_gender.getCheckedRadioButtonId();
        rbn_genderSelect = (RadioButton) getActivity().findViewById(genderSelect);

        int religionSelect = rgp_religion.getCheckedRadioButtonId();
        rbn_religionSelect = (RadioButton) getActivity().findViewById(religionSelect);

        int diabetesSelect = rgp_diabetes.getCheckedRadioButtonId();
        rbn_diabetesSelect = (RadioButton) getActivity().findViewById(diabetesSelect);

        int HypertensionSelect = rgp_Hypertension.getCheckedRadioButtonId();
        rbn_HypertensionSelect = (RadioButton) getActivity().findViewById(HypertensionSelect);

        int graduateSelect = rgp_graduate.getCheckedRadioButtonId();
        rbn_graduateSelect = (RadioButton) getActivity().findViewById(graduateSelect);

        int statusSelect = rgp_status.getCheckedRadioButtonId();
        rbn_statusSelect = (RadioButton) getActivity().findViewById(statusSelect);

        int workSelect = rgp_work.getCheckedRadioButtonId();
        rbn_workSelect = (RadioButton) getActivity().findViewById(workSelect);

        other = rbn_workSelect.getText().toString();

        if(other.equals("อื่นๆ")){
            other = etx_other.getText().toString();

        }


        textToEmail =   "เพศ : "+rbn_genderSelect.getText().toString()+"\n" +
                        "เลขบัตรประจำตัวประชาชน : "+ etx_idCard.getText().toString()+"\n" +
                        "วัน/เดือน/ปี : "+etx_birthDay.getText().toString()+"\n" +
                        "ศาสนา : "+rbn_religionSelect.getText().toString()+"\n" +
                        "น้ำหนัก : "+etx_weightBody.getText().toString()+"\n" +
                        "ส่วนสูง : "+etx_height.getText().toString()+"\n" +
                        "รอบเอว : "+etx_waistline.getText().toString()+"\n" +
                        "ความดันโลหิต : "+etx_BloodPressureFront.getText().toString()+" / "+etx_BloodPressureBack.getText().toString()+"\n" +
                        "โรคประจำตัว : \n" +
                                    "\t\t\t\t\t\t โรคเบาหวาน : "+rbn_diabetesSelect.getText().toString()+"\n" +
                                    "\t\t\t\t\t\t โรคความดันโลหิตสูง : "+rbn_HypertensionSelect.getText().toString()+"\n" +
                        "จบการศึกษา : "+rbn_graduateSelect.getText().toString()+"\n" +
                        "สถานภาพ : "+rbn_statusSelect.getText().toString()+"\n" +
                        "อาชีพ : "+other;

        return textToEmail;
    }



}
