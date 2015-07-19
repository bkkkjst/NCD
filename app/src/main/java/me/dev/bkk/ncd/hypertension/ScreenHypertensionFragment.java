package me.dev.bkk.ncd.hypertension;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.dev.bkk.ncd.R;
import me.dev.bkk.ncd.model.Result;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScreenHypertensionFragment extends Fragment implements Validator.ValidationListener{
    Result result = new Result();
    @Bind(R.id.tv_headerScreenHypertension)
    TextView tvHeaderScreenHypertension;
    @Bind(R.id.tv_BloodPressure)
    TextView tvBloodPressure;
    @Bind(R.id.etx_BloodPressureFront)@Order(value = 1)@NotEmpty
    EditText etxBloodPressureFront;
    @Bind(R.id.tv_slash)
    TextView tvSlash;
    @Bind(R.id.etx_BloodPressureBack)@Order(value = 2)@NotEmpty
    EditText etxBloodPressureBack;
    @Bind(R.id.btn_ok)
    Button btnOk;

    Validator validator;

    public ScreenHypertensionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_hypertension, container, false);
        ButterKnife.bind(this, view);

        validator = new Validator(this);
        validator.setValidationListener(this);

        return view;
    }

    @OnClick(R.id.btn_ok)
    void save() {

        validator.validate();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void screenHypertension(final int front, final int back){
        if(front <= 129 && back <=84){
            new MaterialDialog.Builder(getActivity())
                    .title("ประมวลผล")
                    .content("ความดันปกติ")
                    .contentGravity(GravityEnum.CENTER)
                    .positiveText("ตกลง")
                    .btnStackedGravity(GravityEnum.CENTER)
                    .cancelable(false)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            result.setHypertension(front + " / " + back + " : " + "ความดันปกติ");
                            dialog.dismiss();
                        }
                    })
                    .show();
        }else if((front <= 149 && front >= 130) || (back <= 89 && back >= 85 )){
            new MaterialDialog.Builder(getActivity())
                    .title("ประมวลผล")
                    .content("ค่าความดันปกติแต่สูง (เสี่ยง)")
                    .contentGravity(GravityEnum.CENTER)
                    .positiveText("ตกลง")
                    .btnStackedGravity(GravityEnum.CENTER)
                    .cancelable(false)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            result.setHypertension(front + " / " + back + " : " + "ค่าความดันปกติแต่สูง (เสี่ยง)");
                            dialog.dismiss();
                        }
                    })
                    .show();
        }else if((front <= 169 && front >= 150) || (back <= 99 && back >= 90 )){
            new MaterialDialog.Builder(getActivity())
                    .title("ประมวลผล")
                    .content("ความดันสูงระดับ 1")
                    .contentGravity(GravityEnum.CENTER)
                    .positiveText("ตกลง")
                    .btnStackedGravity(GravityEnum.CENTER)
                    .cancelable(false)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            result.setHypertension(front + " / " + back + " : " + "ความดันสูงระดับ 1");
                            dialog.dismiss();
                        }
                    })
                    .show();
        }else if((front <= 189 && front >= 170) || (back <= 109 && back >= 100 )){
            new MaterialDialog.Builder(getActivity())
                    .title("ประมวลผล")
                    .content("ความดันสูงระดับ 2")
                    .contentGravity(GravityEnum.CENTER)
                    .positiveText("ตกลง")
                    .btnStackedGravity(GravityEnum.CENTER)
                    .cancelable(false)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            result.setHypertension(front + " / " + back + " : " + "ความดันสูงระดับ 2");
                            dialog.dismiss();
                        }
                    })
                    .show();
        }else if(front >= 180 || back >= 110){
            new MaterialDialog.Builder(getActivity())
                    .title("ประมวลผล")
                    .content("ความดันสูงระดับ 3")
                    .contentGravity(GravityEnum.CENTER)
                    .positiveText("ตกลง")
                    .btnStackedGravity(GravityEnum.CENTER)
                    .cancelable(false)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            result.setHypertension(front + " / " + back + " : " + "ความดันสูงระดับ 3");
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }

    @Override
    public void onValidationSucceeded() {

        int front = Integer.parseInt(etxBloodPressureFront.getText().toString());
        int back = Integer.parseInt(etxBloodPressureBack.getText().toString());
        screenHypertension(front, back);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
