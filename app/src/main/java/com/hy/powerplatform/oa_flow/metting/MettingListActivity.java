package com.hy.powerplatform.oa_flow.metting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.duban.bean.ItemBean;
import com.hy.powerplatform.login.bean.HyNum;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.metting.activity.JiYaoListActivity;
import com.hy.powerplatform.oa_flow.metting.activity.MyOverOpenListActivity;
import com.hy.powerplatform.oa_flow.metting.activity.MyWillOpenListActivity;
import com.hy.powerplatform.oa_flow.metting.activity.OverOpenListActivity;
import com.hy.powerplatform.oa_flow.metting.activity.WillOpenListActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class MettingListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int numdcj = 0;
    int numdk = 0;
    Intent intent;
    String rights;
    String userStatus;
    BaseRecyclerAdapter mAdapter;
    AlertDialogUtil alertDialogUtil;
    private OkHttpUtil httpUtil;
    List<ItemBean> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        rights = new SharedPreferencesHelper(this, "login").getData(this, "rights", "");
        userStatus = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
//        addItem();
//        setItemAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        httpUtil = OkHttpUtil.getInstance(this);
        getHyNum();
    }

    /**
     * 获取会议数量
     */
    private void getHyNum() {
        final String path_url = Constant.BASE_URL2 + Constant.HYNUM;
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
        return R.layout.activity_metting_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private void addItem() {
        ItemBean bean1 = new ItemBean();
        int drawableId1 = getResources().getIdentifier("oaflow_metting_rb1", "drawable", getPackageName());
        bean1.setAddress(drawableId1);
        bean1.setName(getResources().getString(R.string.oaflow_metting_rb1));
        if (rights.contains(",MyJoinConferenceView")) {
            itemList.add(bean1);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean1);
        }

        ItemBean bean2 = new ItemBean();
        int drawableId2 = getResources().getIdentifier("oaflow_metting_rb2", "drawable", getPackageName());
        bean2.setAddress(drawableId2);
        bean2.setName(getResources().getString(R.string.oaflow_metting_rb2));
        if (rights.contains(",MyJoinedConferenceView")) {
            itemList.add(bean2);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean2);
        }

        ItemBean bean3 = new ItemBean();
        int drawableId3 = getResources().getIdentifier("oaflow_metting_rb3", "drawable", getPackageName());
        bean3.setAddress(drawableId3);
        bean3.setName(getResources().getString(R.string.oaflow_metting_rb3));
        if (rights.contains(",WaitOpenConferenceView")) {
            itemList.add(bean3);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean3);
        }

        ItemBean bean4 = new ItemBean();
        int drawableId4 = getResources().getIdentifier("oaflow_metting_rb4", "drawable", getPackageName());
        bean4.setAddress(drawableId4);
        bean4.setName(getResources().getString(R.string.oaflow_metting_rb4));
        if (rights.contains(",HaveOpenConferenceView")) {
            itemList.add(bean4);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean4);
        }

        ItemBean bean5 = new ItemBean();
        int drawableId5 = getResources().getIdentifier("oaflow_metting_rb5", "drawable", getPackageName());
        bean5.setAddress(drawableId5);
        bean5.setName(getResources().getString(R.string.oaflow_metting_rb5));
        if (rights.contains(",ConfSummaryView")) {
            itemList.add(bean5);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean5);
        }
    }

    private void setItemAdapter() {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapter<ItemBean>(this, R.layout.adapter_maindata, itemList) {
            @Override
            public void convert(BaseViewHolder holder, final ItemBean itemBean) {
                if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb1)) &&Integer.valueOf(numdcj)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numdcj));
                }
                if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb3)) &&Integer.valueOf(numdk)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numdk));
                }
                holder.setText(R.id.textView, itemBean.getName());
                holder.setImageResource(R.id.imageView, itemBean.getAddress());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb1))) {
                            intent = new Intent(MettingListActivity.this, MyWillOpenListActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb2))) {
                            intent = new Intent(MettingListActivity.this, MyOverOpenListActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb3))) {
                            intent = new Intent(MettingListActivity.this, WillOpenListActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb4))) {
                            intent = new Intent(MettingListActivity.this, OverOpenListActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_metting_rb5))) {
                            intent = new Intent(MettingListActivity.this, JiYaoListActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(MettingListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    itemList.clear();
                    //添加模块
                    addItem();
                    setItemAdapter();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    numdcj = 0;
                    numdk = 0;
                    Bundle hyNum = msg.getData();
                    String hyNumData = hyNum.getString("data");
                    HyNum beanHyNum = new Gson().fromJson(hyNumData, HyNum.class);
                    numdcj = numdcj+Integer.parseInt(beanHyNum.getResult().get(0).getDcjnum());
//                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getYcjnum());
                    numdk = numdk+Integer.parseInt(beanHyNum.getResult().get(0).getDknum());
//                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getYknum());
                    itemList.clear();
                    //添加模块
                    addItem();
                    setItemAdapter();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
