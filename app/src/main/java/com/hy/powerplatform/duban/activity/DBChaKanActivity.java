package com.hy.powerplatform.duban.activity;

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
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.duban.bean.DBCKLIST;
import com.hy.powerplatform.duban.bean.DBCKSHZT;
import com.hy.powerplatform.duban.bean.DBXG;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackDB;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
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

public class DBChaKanActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Bundle b1;
    Gson gsonF;
    String operId = "";
    String workId = "";
    String userName = "";
    String taskName = "";
    String submitTitle = "";
    String operatorName = "";
    String createName = "";
    String operatorId = "";
    String approveTime = "";
    String supervisorNames = "";
    String contactsName = "";
    private OkHttpUtil httpUtil;
    AlertDialogUtil alertDialogUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<DBCKLIST.ResultBean> beanList = new ArrayList<>();
    String path_url = Constant.BASE_URL1 + Constant.DBCKLIST;
    String path_url1 = Constant.BASE_URL1 + Constant.DBCKCB;
    String path_url2 = Constant.BASE_URL1 + Constant.DBCKXG;
    String path_url3 = Constant.BASE_URL1 + Constant.DBCKSHZT;
    String path_urlQR = Constant.BASE_URL1 + Constant.DBCKSHZTQR;
    String path_urlFQ = Constant.BASE_URL1 + Constant.DBCKSHZTFD;
    String path_urlBH = Constant.BASE_URL1 + Constant.DBCKSHZTBH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        Intent intent = getIntent();
        userName = new SharedPreferencesHelper(this,"login").getData(this,"userStatus","");
        workId = intent.getStringExtra("workId");
        taskName = intent.getStringExtra("taskName");
        approveTime = intent.getStringExtra("approveTime");
        createName = intent.getStringExtra("createName");
        operatorId = intent.getStringExtra("operatorId");
        contactsName = intent.getStringExtra("contactsName");
        supervisorNames = intent.getStringExtra("supervisorNames");
        httpUtil = OkHttpUtil.getInstance(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<DBCKLIST.ResultBean>(this, R.layout.adapter_dbcklist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final DBCKLIST.ResultBean resultBean) {
                if (resultBean.getSubmitTitle()==null){
                    holder.setVisitiomLL(R.id.llTitle);
                }else {
                    holder.setText(R.id.tvCKBT, resultBean.getSubmitTitle());
                }
                if (resultBean.getSubmitContext()==null){
                    holder.setVisitiomLL(R.id.llContent);
                }else {
                    holder.setText(R.id.tvContent, resultBean.getSubmitContext());
                }
                if (resultBean.getOperTime()==null){
                    holder.setVisitiomLL(R.id.llTime);
                }else {
                    holder.setText(R.id.tvTime, resultBean.getOperTime());
                }
                if (resultBean.getOperStatus()==1){
                    holder.setText(R.id.tvType, "未查看");
                }else if (resultBean.getOperStatus()==2){
                    holder.setText(R.id.tvType, "已查看");
                }else if (resultBean.getOperStatus()==3){
                    holder.setText(R.id.tvType, "已接收");
                }else if (resultBean.getOperStatus()==4){
                    holder.setText(R.id.tvType, "已退回");
                }else if (resultBean.getOperStatus()==5){
                    holder.setText(R.id.tvType, "已提交");
                }else if (resultBean.getOperStatus()==6){
                    holder.setText(R.id.tvType, "已撤回");
                }else if (resultBean.getOperStatus()==7){
                    holder.setText(R.id.tvType, "已完成");
                }else if (resultBean.getOperStatus()==8){
                    holder.setText(R.id.tvType, "已冻结");
                }else if (resultBean.getOperStatus()==9){
                    holder.setText(R.id.tvType, "逾期完成");
                }else if (resultBean.getOperStatus()==10){
                    holder.setText(R.id.tvType, "未完成");
                }
                operatorName = resultBean.getOperatorName();
                submitTitle = resultBean.getSubmitTitle();
                holder.setText(R.id.tvZXR, resultBean.getOperatorName());

                if (resultBean.getUpdateType()!=null&&resultBean.getStatusName()!=null){
                    if (resultBean.getUpdateType().equals("1")&&resultBean.getOperStatus()==5&&resultBean.getStatusName().contains(userName)){
                        if (createName.equals(userName)||contactsName.equals(userName)){
                            holder.setVisitiomBtn(R.id.btnXG);
                        }
                    }
                }

                if (resultBean.getOperStatus()==5){
                    if (supervisorNames.contains(userName)||contactsName.equals(userName)){
                        holder.setVisitiomBtn(R.id.btnSH);
                    }
                }
                if (resultBean.getOperStatus()<5){
                    if (supervisorNames.contains(userName)||contactsName.equals(userName)){
                        holder.setVisitiomBtn(R.id.btnCB);
                    }
                }
                holder.setOnClickListener(R.id.btnCK, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DBChaKanActivity.this,DBChaKanCKActivity.class);
                        operId = String.valueOf(resultBean.getOperId());
                        intent.putExtra("operId",String.valueOf(resultBean.getOperId()));
                        startActivity(intent);
                    }
                });
                holder.setOnClickListener(R.id.btnCB, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        operId = String.valueOf(resultBean.getOperId());
                        onCuiBan(String.valueOf(resultBean.getOperator()),approveTime,taskName,String.valueOf(resultBean.getOperId()));
                    }
                });
                holder.setOnClickListener(R.id.btnSH, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        operId = String.valueOf(resultBean.getOperId());
                        submitTitle = resultBean.getSubmitTitle();
                        onShengHe();
                    }
                });
                holder.setOnClickListener(R.id.btnXG, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        operId = String.valueOf(resultBean.getOperId());
                        onXiuGai(resultBean.getOperId());
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();
        onChaKanDetail();
    }

    /**
     * 审核
     */
    private void onShengHe() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        httpUtil.getAsynHttp(path_url3,  new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_FIVE;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 修改
     * @param operId
     */
    private void onXiuGai(int operId) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("operId", String.valueOf(operId));
        httpUtil.postForm(path_url2, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_FOUR;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 催办
     * @param operatorId
     * @param approveTime
     * @param taskName
     * @param s
     */
    private void onCuiBan(String operatorId, String approveTime, String taskName, String s) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("operatorId", operatorId);
        map.put("approveTime", approveTime.split(" ")[0]);
        map.put("taskName", taskName);
        map.put("operId", s);
        httpUtil.postForm(path_url1, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_THERE;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 确认
     */
    private void onQueRen(String annotation) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("annotation", annotation);
        map.put("operId", operId);
        map.put("ident", "1");
        httpUtil.postForm(path_urlQR, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_SIX;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 驳回
     */
    private void onBoHui(String annotation) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("operId", operId);
        map.put("ident", "1");
        map.put("annotation", annotation);
        map.put("operatorName", operatorName);
        map.put("msg", "驳回");
        map.put("submitTitle", submitTitle);
        httpUtil.postForm(path_urlBH, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_SIX;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 退回
     */
    private void onTuiHui(String annotation) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final HashMap<String, String> map = new HashMap();
        map.put("operId", operId);
        map.put("ident", "1");
        map.put("annotation", annotation);
        map.put("operatorName", operatorName);
        map.put("msg", "退回");
        map.put("submitTitle", submitTitle);
        httpUtil.postForm(path_urlBH, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_SIX;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 否定
     */
    private void onFouDing(String annotation) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("annotation", annotation);
        map.put("operId", operId);
        map.put("ident", "1");
        httpUtil.postForm(path_urlFQ, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_SIX;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 查看详情
     */
    private void onChaKanDetail() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("Q_workId_L_EQ", workId);
        map.put("searchAll", "false");
        map.put("contactsName", contactsName);
        map.put("supervisorNames", supervisorNames);
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbcha_kan;
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
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(DBChaKanActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    b1 = msg.getData();
                    String data = b1.getString("data");
                    gsonF = new Gson();
                    DBCKLIST bean = gsonF.fromJson(data, DBCKLIST.class);
                    if (bean.isSuccess()){
                        if (bean.getTotalCounts() != 0) {
                            for (int i = 0; i < bean.getResult().size(); i++) {
                                beanList.add(bean.getResult().get(i));
                            }
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    baseAdapter.notifyDataSetChanged();
                    break;
                case Constant.TAG_THERE:
                    Bundle b3 = msg.getData();
                    String data3 = b3.getString("data");
                    Gson gsonFB = new Gson();
                    DBXG bean2 = gsonFB.fromJson(data3, DBXG.class);
                    if (bean2.isSuccess()) {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBChaKanActivity.this, bean2.getMsg(), Toast.LENGTH_SHORT).show();
                    }else {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBChaKanActivity.this, bean2.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Constant.TAG_FOUR:
                    b1 = msg.getData();
                    String data4 = b1.getString("data");
                    gsonF = new Gson();
                    DBXG bean4 = gsonF.fromJson(data4, DBXG.class);
                    if (bean4.isSuccess()) {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBChaKanActivity.this, "操作成功", Toast.LENGTH_SHORT).show();
                    }else {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBChaKanActivity.this, bean4.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Constant.TAG_FIVE:
                    b1 = msg.getData();
                    String data5 = b1.getString("data");
                    gsonF = new Gson();
                    DBCKSHZT bean5 = gsonF.fromJson(data5, DBCKSHZT.class);
                    if (bean5.isSuccess()) {
                        String tag = "";
                        ProgressDialogUtil.stopLoad();
                        if (bean5.getData().get(0).getFlag().equals("true")){
                            tag = "1";
                        }else {
                            tag = "2";
                        }
                        alertDialogUtil.showDialog3(tag,"批注", new AlertDialogCallBackDB() {
                            @Override
                            public void select1(String annotation) {
                                onQueRen(annotation);
                            }

                            @Override
                            public void select2(String annotation) {
                                onBoHui(annotation);
                            }

                            @Override
                            public void select3(String annotation) {
                                onTuiHui(annotation);
                            }

                            @Override
                            public void select4(String annotation) {
                                onFouDing(annotation);
                            }
                        });
                    }
                    break;
                case Constant.TAG_SIX:
                    b1 = msg.getData();
                    String data6 = b1.getString("data");
                    gsonF = new Gson();
                    DBXG bean6 = gsonF.fromJson(data6, DBXG.class);
                    if (bean6.isSuccess()) {
                        ProgressDialogUtil.stopLoad();
                        finish();
                        Toast.makeText(DBChaKanActivity.this, "操作成功", Toast.LENGTH_SHORT).show();
                    }else {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBChaKanActivity.this, bean6.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}
