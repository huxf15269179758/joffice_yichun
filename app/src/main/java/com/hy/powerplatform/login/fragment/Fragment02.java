package com.hy.powerplatform.login.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.login.activity.AppUpHistoryActivity;
import com.hy.powerplatform.login.bean.PersonContent;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

/**
 * Created by Administrator on 2019/9/25.
 */

public class Fragment02 extends Fragment {
    View view;
    @BindView(R.id.tvmyName)
    TextView tvmyName;
    @BindView(R.id.myinform)
    LinearLayout myinform;
    @BindView(R.id.tvMyStatus)
    TextView tvMyStatus;
    @BindView(R.id.studyArchives)
    LinearLayout studyArchives;
    @BindView(R.id.btnQuit)
    Button btnQuit;

    SharedPreferencesHelper sharedPreferencesHelper;
    @BindView(R.id.tvVersion)
    TextView tvVersion;
    @BindView(R.id.tvLoginNum)
    TextView tvLoginNum;
    @BindView(R.id.tvOldIp)
    TextView tvOldIp;
    @BindView(R.id.tvOldLogin)
    TextView tvOldLogin;
    @BindView(R.id.tvVersionH)
    TextView tvVersionH;
    private OkHttpUtil httpUtil;
    String versionName;
    int versionCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        ButterKnife.bind(this, view);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        String name = sharedPreferencesHelper.getData(getActivity(), "userName", "");
        String status = sharedPreferencesHelper.getData(getActivity(), "depName", "");
        tvmyName.setText(name);
        tvMyStatus.setText(status);
        PackageManager pm = getActivity().getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(getActivity().getPackageName(), 0);
            versionName = pi.versionName;
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvVersion.setText(versionName);
        httpUtil = OkHttpUtil.getInstance(getActivity());
        getData();
        return view;
    }

    private void getData() {
        final String path_url = Constant.BASE_URL2 + Constant.PERSONCENTER;
        httpUtil.getAsynHttp(path_url, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    PersonContent bean = new Gson().fromJson(data, PersonContent.class);
                    tvLoginNum.setText(bean.getResult().get(0).getNum() + "");
                    tvOldIp.setText(bean.getResult().get(0).getLogIp() + "");
                    tvOldLogin.setText(bean.getResult().get(0).getLogTime() + "");
                    break;
            }
        }
    };

    @OnClick(R.id.tvVersionH)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), AppUpHistoryActivity.class);
        startActivity(intent);
    }
}
