package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.EntryPerson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class EntryPersonActivity extends BaseActivity {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter mAdapter;
    List<EntryPerson.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        getData();
    }

    /**
     * 获取人员列表
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.ENTRYPERSON;
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
    protected int provideContentViewId() {
        return R.layout.activity_entry_person;
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
                    Toast.makeText(EntryPersonActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    EntryPerson bean = new Gson().fromJson(data, EntryPerson.class);
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        beanList.add(bean.getResult().get(i));
                    }
                    if (beanList.size()==0){
                        Toast.makeText(EntryPersonActivity.this, "暂无入职人员", Toast.LENGTH_SHORT).show();
                    }else {
                        mAdapter = new BaseRecyclerAdapter<EntryPerson.ResultBean>(EntryPersonActivity.this, R.layout.adapter_easy, beanList) {
                            @Override
                            public void convert(BaseViewHolder holder, final EntryPerson.ResultBean itemBean) {
                                holder.setText(R.id.tvData, itemBean.getFullname());
                                holder.setOnClickListener(R.id.tvData, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent();
                                        i.putExtra("resumeId", itemBean.getResumeId());
                                        i.putExtra("fullname", itemBean.getFullname());
                                        i.putExtra("sex", itemBean.getSex());
                                        i.putExtra("mobile", itemBean.getMobile());
                                        i.putExtra("idNo", itemBean.getIdNo());
                                        i.putExtra("vehicleClass", itemBean.getVehicleClass());
                                        setResult(Constant.TAG_ONE, i);
                                        finish();
                                    }
                                });
                            }
                        };
                        recyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
