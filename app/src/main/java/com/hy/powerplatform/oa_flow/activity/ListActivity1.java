package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.WillDoNum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class ListActivity1 extends BaseActivity {
    @BindView(R.id.header)
    Header header;

    String datanum;
    String rolues;
    List<String> dataList = new ArrayList<>();
    List<WillDoNum.ResultBean> beanList = new ArrayList<>();
    @BindView(R.id.tvNum1)
    TextView tvNum1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tvNum2)
    TextView tvNum2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.tvNum3)
    TextView tvNum3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.tvNum4)
    TextView tvNum4;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.tvNum5)
    TextView tvNum5;
    @BindView(R.id.ll5)
    LinearLayout ll5;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        rolues = new SharedPreferencesHelper(this, "login").getData(this, "rolues", "");
        String userName = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
        getData();
    }

    /**
     * 获取数据
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String name =URLDecoder.decode(待转值,"utf-8");
                String url = Constant.BASE_URL2 + Constant.DETAILWILLNUM;
                DBHandler dbA = new DBHandler();
                datanum = dbA.OAWillDoNum(url);
                if (datanum.equals("获取数据失败") || datanum.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3, R.id.ll4, R.id.ll5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                intent = new Intent(this, MyWillDoActivity.class);
                intent.putExtra("type","4814");
                startActivity(intent);
                break;
            case R.id.ll2:
                intent = new Intent(this, MyWillDoActivity.class);
                intent.putExtra("type","4815");
                startActivity(intent);
                break;
            case R.id.ll3:
                intent = new Intent(this, MyWillDoActivity.class);
                intent.putExtra("type","4816");
                startActivity(intent);
                break;
            case R.id.ll4:
                intent = new Intent(this, MyWillDoActivity.class);
                intent.putExtra("type","4817");
                startActivity(intent);
                break;
            case R.id.ll5:
                intent = new Intent(this, MyWillDoActivity.class);
                intent.putExtra("type","4813");
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    beanList.clear();
                    tvNum1.setText("");
                    tvNum2.setText("");
                    tvNum3.setText("");
                    tvNum4.setText("");
                    tvNum5.setText("");
                    tvNum1.setVisibility(View.GONE);
                    tvNum2.setVisibility(View.GONE);
                    tvNum3.setVisibility(View.GONE);
                    tvNum4.setVisibility(View.GONE);
                    tvNum5.setVisibility(View.GONE);
                    Gson gson = new Gson();
                    WillDoNum bean = gson.fromJson(datanum, WillDoNum.class);
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        beanList.add(bean.getResult().get(i));
                    }
                    for (int k = 0;k<beanList.size();k++){
                        if (beanList.get(k).getProTypeId().equals("4814")){
                            tvNum1.setVisibility(View.VISIBLE);
                            tvNum1.setText(beanList.get(k).getQuantity());
                        }
                        if (beanList.get(k).getProTypeId().equals("4815")){
                            tvNum2.setVisibility(View.VISIBLE);
                            tvNum2.setText(beanList.get(k).getQuantity());
                        }
                        if (beanList.get(k).getProTypeId().equals("4816")){
                            tvNum3.setVisibility(View.VISIBLE);
                            tvNum3.setText(beanList.get(k).getQuantity());
                        }
                        if (beanList.get(k).getProTypeId().equals("4817")){
                            tvNum4.setVisibility(View.VISIBLE);
                            tvNum4.setText(beanList.get(k).getQuantity());
                        }
                        if (beanList.get(k).getProTypeId().equals("4813")){
                            tvNum5.setVisibility(View.VISIBLE);
                            tvNum5.setText(beanList.get(k).getQuantity());
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(ListActivity1.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
