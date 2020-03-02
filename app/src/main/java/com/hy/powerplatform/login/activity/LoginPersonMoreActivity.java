package com.hy.powerplatform.login.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.login.bean.LoginPerson;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class LoginPersonMoreActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private OkHttpUtil httpUtil;
    BaseRecyclerAdapterPosition mAdapterLogin;
    final HashMap<String, String> map1 = new HashMap();
    List<LoginPerson.ResultBean> loginPersonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mAdapterLogin = new BaseRecyclerAdapterPosition<LoginPerson.ResultBean>(this, R.layout.adapter_loginperson, loginPersonList) {
            @Override
            public void convert(BaseViewHolderPosition holder, final LoginPerson.ResultBean itemBean, int position) {
                holder.setText(R.id.tvNum, position + 1 + "");
                holder.setText(R.id.tvUserName, itemBean.getFullName());
                holder.setText(R.id.tvLoginNum, String.valueOf(itemBean.getDlcs()));
                if (position % 2 != 0) {
                    holder.setColor(R.id.ll);
                }
            }
        };
        recyclerView.setAdapter(mAdapterLogin);
        httpUtil = OkHttpUtil.getInstance(this);
        getLoginPerson();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login_person_more;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 获取登录次数
     */
    private void getLoginPerson() {
        ProgressDialogUtil.startLoad(LoginPersonMoreActivity.this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.LOGINPERSON;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        String endDate = now.split(" ")[0];
        map1.clear();
        map1.put("beginDate",day);
        map1.put("endDate",endDate);
        httpUtil.postForm(path_url,map1, new OkHttpUtil.ResultCallback() {
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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(LoginPersonMoreActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    LoginPerson bean = new Gson().fromJson(data, LoginPerson.class);
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        loginPersonList.add(bean.getResult().get(i));
                    }
                    mAdapterLogin.notifyDataSetChanged();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
