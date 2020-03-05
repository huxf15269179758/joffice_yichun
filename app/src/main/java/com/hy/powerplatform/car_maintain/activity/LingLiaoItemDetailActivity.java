package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.car_maintain.bean.LingLiaoItem;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.BaseRequestBackTLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.base.MyHttpURLConnection;
import com.hy.powerplatform.my_utils.myViews.Header;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LingLiaoItemDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvCode)
    TextView tvCode;
    @BindView(R.id.tvZhuJi)
    TextView tvZhuJi;
    @BindView(R.id.tvKuWei)
    TextView tvKuWei;
    @BindView(R.id.tvDanJia)
    TextView tvDanJia;
    @BindView(R.id.tvNum)
    TextView tvNum;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.btn)
    Button btn;

    String applyId;
    LingLiaoItem.DataBean.StockBean bean;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    String Url = "";
    String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        bean = (LingLiaoItem.DataBean.StockBean) intent.getSerializableExtra("bean");
        tvType.setText(bean.getMaterialTypeName()+"");
        tvName.setText(bean.getMaterialName()+"");
        tvCode.setText(bean.getMaterialNum()+"");
        tvZhuJi.setText(bean.getMaterialCode()+"");
        tvKuWei.setText(bean.getHouseArea()+"");
        tvDanJia.setText(bean.getUnitprice()+"");
        tvNum.setText(bean.getNum()+"");
        tvMoney.setText(bean.getOutprice()+"");
        applyId = String.valueOf(bean.getApplyId());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_ling_liao_item_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        Url = BASE_URL+"stock/deleteRepairApplywarehous.do"+"?ids="+applyId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyHttpURLConnection.getData(Url, new BaseRequestBackTLisenter() {
                    @Override
                    public void success(Object o) {
                        data = String.valueOf(o);
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void fail(String msg) {
                        Message message = new Message();
                        message.what = Constant.TAG_TWO;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void failF(String msg) {
                        Message message = new Message();
                        message.what = Constant.TAG_THERE;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Constant.TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(data);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        String ad = jsonArray.toString();
                        Log.e("XXXH",ad);
                        if (jsonArray.equals("[]")){

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(LingLiaoItemDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_THERE:
                    Toast.makeText(LingLiaoItemDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
