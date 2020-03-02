package com.hy.powerplatform.login.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.login.bean.AppUpData;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class AppUpHistoryActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<AppUpData.ResultBean> appUpList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        httpUtil = OkHttpUtil.getInstance(this);
        getUpData();
    }

    private void getUpData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.APPUPDATA;
        map.clear();
        map.put("type", "0");
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
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
    protected int provideContentViewId() {
        return R.layout.activity_app_up_history;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(AppUpHistoryActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle bappUpData = msg.getData();
                    String appUpData = bappUpData.getString("data");
                    AppUpData appUpBean = new Gson().fromJson(appUpData, AppUpData.class);
                    if (appUpBean.getResult().size() != 0) {
                        for (int i = 0; i < appUpBean.getResult().size(); i++) {
                            appUpList.add(appUpBean.getResult().get(i));
                        }
                    }
                    baseAdapter = new BaseRecyclerAdapter<AppUpData.ResultBean>(AppUpHistoryActivity.this, R.layout.adapter_rzlist_itemw, appUpList) {
                        @Override
                        public void convert(BaseViewHolder holder, final AppUpData.ResultBean resultBean) {
                            holder.setText(R.id.tvName, resultBean.getVersionNo());
                            holder.setText(R.id.tvPhone, resultBean.getChangeDate());
                            holder.setText(R.id.tvIdCard, resultBean.getSubstance());
                        }
                    };
                    recyclerView.setAdapter(baseAdapter);
                    baseAdapter.notifyDataSetChanged();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
