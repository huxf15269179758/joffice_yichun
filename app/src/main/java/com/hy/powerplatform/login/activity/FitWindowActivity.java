package com.hy.powerplatform.login.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FitWindowActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_FitIp)
    EditText etFitIp;
    @BindView(R.id.btn_FitSure)
    Button btnFitSure;
    @BindView(R.id.et_FitSocket)
    EditText etFitSocket;

    SharedPreferencesHelper sharedPreferencesHelper;
    AlertDialogUtil alertDialogUtil;
    @BindView(R.id.et_FitFoud)
    EditText etFitFoud;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.activity_fit_window)
    LinearLayout activityFitWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        String Ip = sharedPreferencesHelper.getData(this,"Ip","");
        String Socket = sharedPreferencesHelper.getData(this,"Socket","");
        String Address = sharedPreferencesHelper.getData(this,"Address","");
        if (!Ip.isEmpty()){
            etFitIp.setText(Ip);
        }
        if (!Socket.isEmpty()){
            etFitSocket.setText(Socket);
        }
        if ((!Address.isEmpty())){
            etAddress.setText(Address);
        }
        alertDialogUtil = new AlertDialogUtil(this);
        //监听软键盘的删除键
        setTextChangeListener();
    }

    private void setTextChangeListener() {
        new EditTextChange(etFitIp).changeText();
        new EditTextChange(etFitSocket).changeText();
        new EditTextChange(etAddress).changeText();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_fit_window;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.btn_FitSure)
    public void onViewClicked() {
        sharedPreferencesHelper.saveData(this,"Ip","");
        sharedPreferencesHelper.saveData(this,"Socket","");
        sharedPreferencesHelper.saveData(this,"Found","");
        sharedPreferencesHelper.saveData(this,"Address","");
        String etIp = etFitIp.getText().toString().trim();
        String etSocket = etFitSocket.getText().toString();
        String found =etFitFoud.getText().toString();
        String address = etAddress.getText().toString();
        if (etIp.equals("") && etSocket.equals("")&& etAddress.equals("")) {
            alertDialogUtil.showSmallDialog(getResources().getString(R.string.toast_infor));
        } else {
            sharedPreferencesHelper.saveData(this, "Ip", etIp);
            sharedPreferencesHelper.saveData(this, "Socket", etSocket);
            if (!found.isEmpty()) {
                sharedPreferencesHelper.saveData(this, "Found", found);
            }
            if (!address.isEmpty()) {
                sharedPreferencesHelper.saveData(this, "Address", address);
            }
        }
        finish();
    }

}
