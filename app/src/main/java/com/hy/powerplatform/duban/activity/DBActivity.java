package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.duban.bean.ItemBean;
import com.hy.powerplatform.login.bean.DbNum;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class DBActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    Intent intent;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int numdzx = 0;
    int numdsh = 0;
    String rights;
    String userStatus;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter mAdapter;
    List<ItemBean> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        GridLayoutManager manager = new GridLayoutManager (this,3);
        recyclerView.setLayoutManager(manager);
        rights = new SharedPreferencesHelper(this, "login").getData(this, "rights", "");
        userStatus = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
//        addItem();
//        setItemAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        httpUtil = OkHttpUtil.getInstance(this);
        ProgressDialogUtil.startLoad(this,"获取数据中");
        getDbNum();
    }

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
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    private void addItem() {
        ItemBean bean1 = new ItemBean();
        int drawableId1 = getResources().getIdentifier("business_inspection", "drawable", getPackageName());
        bean1.setAddress(drawableId1);
        bean1.setName("发布督办");
        if (rights.contains(",SuperWorkTaskView")) {
            itemList.add(bean1);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean1);
        }

        ItemBean bean2 = new ItemBean();
        int drawableId2 = getResources().getIdentifier("mycenter", "drawable", getPackageName());
        bean2.setAddress(drawableId2);
        bean2.setName("待办督办");
        if (rights.contains(",SuperWorkTaskView")) {
            itemList.add(bean2);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean2);
        }

        ItemBean bean3 = new ItemBean();
        int drawableId3 = getResources().getIdentifier("flow_item1d", "drawable", getPackageName());
        bean3.setAddress(drawableId3);
        bean3.setName("执行任务");
        if (rights.contains(",SuperTaskOperView")) {
            itemList.add(bean3);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean3);
        }


        ItemBean bean4 = new ItemBean();
        int drawableId4 = getResources().getIdentifier("flow_item4d", "drawable", getPackageName());
        bean4.setAddress(drawableId4);
        bean4.setName("督办管理");
        if (rights.contains(",SuperWorkTaskSuperView")) {
            itemList.add(bean4);
        }else if (userStatus.equals("超级管理员")){
            itemList.add(bean4);
        }
    }

    private void setItemAdapter() {
        mAdapter = new BaseRecyclerAdapter<ItemBean>(this, R.layout.adapter_maindata, itemList) {
            @Override
            public void convert(BaseViewHolder holder, final ItemBean itemBean) {
                if (itemBean.getName().equals("执行任务") &&Integer.valueOf(numdzx)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numdzx));
                }
                if (itemBean.getName().equals("待办督办") &&Integer.valueOf(numdsh)!=0){
                    holder.setVisitiomV(R.id.tvRolese);
                    holder.setText(R.id.tvRolese, String.valueOf(numdsh));
                }
                holder.setText(R.id.textView, itemBean.getName());
                holder.setImageResource(R.id.imageView, itemBean.getAddress());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemBean.getName().equals("发布督办")){
                            intent = new Intent(DBActivity.this, DBUpActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals("待办督办")){
                            intent = new Intent(DBActivity.this, DBListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals("执行任务")){
                            intent = new Intent(DBActivity.this, DBZXListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals("督办管理")){
                            intent = new Intent(DBActivity.this, DBGuanLiActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_db;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this, DBUpActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this, DBListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(this, DBZXListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb4:
                intent = new Intent(this, DBGuanLiActivity.class);
                startActivity(intent);
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(DBActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    itemList.clear();
                    //添加模块
                    addItem();
                    setItemAdapter();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    numdzx = 0;
                    numdsh = 0;
                    Bundle dbNum = msg.getData();
                    String dbNumData = dbNum.getString("data");
                    DbNum beanDbNum = new Gson().fromJson(dbNumData, DbNum.class);
                    numdzx = numdzx+Integer.parseInt(beanDbNum.getResult().get(0).getDzxnum());
//                    numhy = numhy+Integer.parseInt(beanHyNum.getResult().get(0).getYcjnum());
                    numdsh = numdsh+Integer.parseInt(beanDbNum.getResult().get(0).getDshnum());
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
