package com.hy.powerplatform.human.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.human.bean.YingPinList;
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

public class YingPinListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.etWork)
    EditText etWork;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;

    String data;
    int limit = 20;
    int start = 0;
    private OkHttpUtil httpUtil;
    ArrayAdapter<String> adapter;
    BaseRecyclerAdapter baseAdapter;
    List<String> dataList = new ArrayList<>();
    final HashMap<String, String> map = new HashMap();
    List<YingPinList.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        dataList.add("");
        dataList.add("合格并录用");
        dataList.add("合格未录用");
        dataList.add("应聘不合格");
        dataList.add("转正未通过");
        dataList.add("待定");
        dataList.add("已提交转正申请");
        dataList.add("已转正");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<YingPinList.ResultBean>(this, R.layout.adapter_rzlist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final YingPinList.ResultBean resultBean) {
                holder.setText(R.id.tvName, resultBean.getFullname());
                holder.setText(R.id.tvPhone, resultBean.getMobile());
                holder.setText(R.id.tvIdCard, resultBean.getIdNo());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(YingPinListActivity.this,YingPinDetailActivity.class);
                        intent.putExtra("bean",resultBean);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();

        httpUtil = OkHttpUtil.getInstance(this);
        getData(start, limit);
        setClient();
    }

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.YINGPIN+"?start="+start+"&limit="+limit;
        map.clear();
        map.put("Q_fullname_S_LK", etName.getText().toString());
        map.put("Q_position_S_LK", etWork.getText().toString());
        map.put("Q_status_S_EQ", spinner.getSelectedItem().toString());
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 滑动监听
     */
    private void setClient() {
        recyclerView.setOnLoadListener(new CustomRefreshView.OnLoadListener() {
            @Override
            public void onRefresh() {
                beanList.clear();
                start = 0;
                limit = 20;
                getData(start, limit);
            }

            @Override
            public void onLoadMore() {
                start = limit;
                limit += 20;
                getData(start, limit);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_ying_pin_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        limit = 20;
        start = 0;
        getData(start,limit);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TAG_ONE:
                    String message =  msg.getData().getString("error");
                    Toast.makeText(YingPinListActivity.this,message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    YingPinList bean = new Gson().fromJson(data, YingPinList.class);
                    if (bean.getTotalCounts() != 0) {
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        if (bean.getResult().size() == 0&&beanList.size()!=0){
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }else if (bean.getResult().size() != 0&&beanList.size()!=0&&bean.getResult().size()<20){
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }else {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }
                        baseAdapter.notifyDataSetChanged();
                    }else {
                        recyclerView.complete();
                        recyclerView.onNoMore();
                        baseAdapter.notifyDataSetChanged();
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
