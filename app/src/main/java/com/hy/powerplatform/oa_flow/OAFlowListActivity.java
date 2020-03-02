package com.hy.powerplatform.oa_flow;

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
import com.hy.powerplatform.duban.activity.DBActivity;
import com.hy.powerplatform.duban.bean.ItemBean;
import com.hy.powerplatform.login.bean.DbNum;
import com.hy.powerplatform.login.bean.GgNum;
import com.hy.powerplatform.login.bean.HyNum;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.WillDoNum;
import com.hy.powerplatform.oa_flow.metting.MettingListActivity;
import com.hy.powerplatform.oa_flow.notice.NoticeListActivity;
import com.hy.powerplatform.oa_flow.phone.PhoneActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class OAFlowListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int num =0;
    int numhy =0;
    int numgg =0;
    int numdb =0;
    String rights;
    String userStatus;
    Intent intent;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter mAdapter;
    AlertDialogUtil alertDialogUtil;
    List<ItemBean> itemList = new ArrayList<>();
    List<WillDoNum.ResultBean> willDoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        rights = new SharedPreferencesHelper(this, "login").getData(this, "rights", "");
        userStatus = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
//        //添加模块
//        addItem();
//        setItemAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        httpUtil = OkHttpUtil.getInstance(this);
        getNum();
    }

    /**
     * 获取代办数量
     */
    private void getNum() {
        itemList.clear();
        ProgressDialogUtil.startLoad(OAFlowListActivity.this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.MYWILLDOLIST + 0 + "&limit=" + 200;
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

    /**
     * 获取督办数量
     */
    private void getDbNum() {
        final String path_url = Constant.BASE_URL2 + Constant.DBNUM;
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
                message.what = TAG_THERE;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 获取公告数量
     */
    private void getGgNum() {
        final String path_url = Constant.BASE_URL2 + Constant.GGNUM;
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
                message.what = TAG_FOUR;
                handler.sendMessage(message);
            }
        });
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
                message.what = TAG_FIVE;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oaflow_list;
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
        int drawableId1 = getResources().getIdentifier("oaflow_rb1", "drawable", getPackageName());
        bean1.setAddress(drawableId1);
        bean1.setName(getResources().getString(R.string.oaflow_rb1));
        if (rights.contains(",NoticeView")) {
            itemList.add(bean1);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean1);
        }

        ItemBean bean2 = new ItemBean();
        int drawableId2 = getResources().getIdentifier("oaflow_rb2", "drawable", getPackageName());
        bean2.setAddress(drawableId2);
        bean2.setName(getResources().getString(R.string.oaflow_rb2));
        if (rights.contains(",MyJoinConferenceView")||rights.contains(",MyJoinedConferenceView")||rights.contains(",WaitOpenConferenceView")
                ||rights.contains(",HaveOpenConferenceView")||rights.contains(",ConfSummaryView")) {
            itemList.add(bean2);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean2);
        }

        ItemBean bean3 = new ItemBean();
        int drawableId3 = getResources().getIdentifier("oaflow_rb3", "drawable", getPackageName());
        bean3.setAddress(drawableId3);
        bean3.setName(getResources().getString(R.string.oaflow_rb3));
        if (rights.contains(",NewProcess")||rights.contains(",MyTaskView")||rights.contains(",MyProcessRunView")
                ||rights.contains(",RelevantProcessRunView")||rights.contains(",RevokeFlowDetailView")) {
            itemList.add(bean3);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean3);
        }

        ItemBean bean4 = new ItemBean();
        int drawableId4 = getResources().getIdentifier("oaflow_rb4", "drawable", getPackageName());
        bean4.setAddress(drawableId4);
        bean4.setName(getResources().getString(R.string.oaflow_rb4));
        if (rights.contains(",FileSendView")) {
            itemList.add(bean4);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean4);
        }

        ItemBean bean5 = new ItemBean();
        int drawableId5 = getResources().getIdentifier("data_analysis", "drawable", getPackageName());
        bean5.setAddress(drawableId5);
        bean5.setName(getResources().getString(R.string.oaflow_rb5));
        if (rights.contains(",SuperWorkTaskView")||rights.contains(",SuperWorkTaskView")||rights.contains(",SuperTaskOperView")
                ||rights.contains(",SuperWorkTaskSuperView")) {
            itemList.add(bean5);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean5);
        }
    }

    private void setItemAdapter() {
        GridLayoutManager manager = new GridLayoutManager (this,4);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapter<ItemBean>(this, R.layout.adapter_maindata, itemList) {
            @Override
            public void convert(BaseViewHolder holder, final ItemBean itemBean) {
                if (itemBean.getName().equals(getResources().getString(R.string.oa_flow)) &&Integer.valueOf(num)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(num));
                }
                if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb1)) &&Integer.valueOf(numgg)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numgg));
                }
                if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb2)) &&Integer.valueOf(numhy)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numhy));
                }
                if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb5)) &&Integer.valueOf(numdb)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numdb));
                }
                holder.setText(R.id.textView, itemBean.getName());
                holder.setImageResource(R.id.imageView, itemBean.getAddress());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb1))){
                            intent = new Intent(OAFlowListActivity.this, NoticeListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb2))){
                            intent = new Intent(OAFlowListActivity.this, MettingListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb3))){
                            intent = new Intent(OAFlowListActivity.this, OAListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb4))){
                            intent = new Intent(OAFlowListActivity.this, PhoneActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_rb5))){
                            intent = new Intent(OAFlowListActivity.this, DBActivity.class);
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
                    Toast.makeText(OAFlowListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    //添加模块
                    itemList.clear();
                    addItem();
                    setItemAdapter();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    willDoList.clear();
                    Bundle bnum = msg.getData();
                    String datanum = bnum.getString("data");
                    WillDoNum beannum = new Gson().fromJson(datanum, WillDoNum.class);
                    for (int i = 0; i < beannum.getResult().size(); i++) {
                        willDoList.add(beannum.getResult().get(i));
                    }
                    if (willDoList.size()!=0){
                        num=0;
                        num=willDoList.size();
                    }
                    getDbNum();
                    break;
                case TAG_THERE:
                    numdb = 0;
                    Bundle dbNum = msg.getData();
                    String dbNumData = dbNum.getString("data");
                    DbNum beanDbNum = new Gson().fromJson(dbNumData, DbNum.class);
                    numdb = numdb+Integer.parseInt(beanDbNum.getResult().get(0).getDshnum());
                    numdb = numdb+Integer.parseInt(beanDbNum.getResult().get(0).getDzxnum());
                    getGgNum();
                    break;
                case TAG_FOUR:
                    numgg = 0;
                    Bundle ggNum = msg.getData();
                    String ggNumData = ggNum.getString("data");
                    GgNum beanGgNum = new Gson().fromJson(ggNumData, GgNum.class);
                    numgg = numgg+Integer.parseInt(beanGgNum.getResult().get(0).getNum());
                    getHyNum();
                    break;
                case TAG_FIVE:
                    numhy = 0;
                    Bundle hyNum = msg.getData();
                    String hyNumData = hyNum.getString("data");
                    HyNum beanHyNum = new Gson().fromJson(hyNumData, HyNum.class);
                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getDcjnum());
//                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getYcjnum());
                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getDknum());
//                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getYknum());
                    //添加模块
                    itemList.clear();
                    addItem();
                    setItemAdapter();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
