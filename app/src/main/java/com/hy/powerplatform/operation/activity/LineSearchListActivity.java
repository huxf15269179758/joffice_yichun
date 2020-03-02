package com.hy.powerplatform.operation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
import com.hy.powerplatform.operation.bean.Department;
import com.hy.powerplatform.operation.bean.DepartmentData;
import com.hy.powerplatform.operation.bean.LineSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class LineSearchListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String depId = "";
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<String> stringList = new ArrayList<>();
    List<DepartmentData> departmentList = new ArrayList<>();
    List<LineSearch.ResultBean> lineList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.oaflow_operation_rb2));
        header.setRightTv(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<LineSearch.ResultBean>(this, R.layout.adapter_rzlist_item, lineList) {
            @Override
            public void convert(BaseViewHolder holder, final LineSearch.ResultBean resultBean) {
                holder.setText(R.id.tv1, "线路");
                holder.setText(R.id.tvName, resultBean.getLineName());
                holder.setText(R.id.tv2, "公司");
                holder.setText(R.id.tvPhone, resultBean.getDepartment().getDepName());
                holder.setText(R.id.tv3, "始末站点");
                holder.setText(R.id.tvIdCard, resultBean.getSmz());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LineSearchListActivity.this, LineSearchDetailActivity.class);
                        intent.putExtra("bean", resultBean);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();

        httpUtil = OkHttpUtil.getInstance(this);
        getData();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                depId = departmentList.get(position).getDepIp();
                lineList.clear();
                getDataList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        getDataList(start, limit);
    }

    /**
     * 获取部门
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.DEPARTMENT;
        map.clear();
        map.put("demId","1");
        map.put("depType","1");
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

    /**
     * 获取数据
     */
    private void getDataList() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.LINESEARCH;
        map.clear();
        map.put("depId", depId);
        map.put("start","0");
        map.put("limit","1000");
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
                message.what = Constant.TAG_THERE;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_line_search_list;
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
                    Toast.makeText(LineSearchListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Department bean = new Gson().fromJson(data, Department.class);
                    if (bean.getData().getChildren().size() != 0) {
                        stringList.add("全部组织");
                        DepartmentData beanData = new DepartmentData();
                        beanData.setDepIp("0");
                        beanData.setDepName("全部组织");
                        departmentList.add(beanData);
                        for (int i = 0; i < bean.getData().getChildren().get(0).getChildren().size(); i++) {
                            DepartmentData beanLineData = new DepartmentData();
                            beanLineData.setDepIp(bean.getData().getChildren().get(0).getChildren().get(i).getKey());
                            beanLineData.setDepName(bean.getData().getChildren().get(0).getChildren().get(i).getText());
                            departmentList.add(beanLineData);
                            stringList.add(bean.getData().getChildren().get(0).getChildren().get(i).getText());
                        }
                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                                LineSearchListActivity.this, android.R.layout.simple_spinner_item, stringList);

                        //下拉的样式res
                        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        //绑定 Adapter到控件
                        spinner.setAdapter(spinnerAdapter);
                    }
                    ProgressDialogUtil.stopLoad();
//                    getDataList(start, limit);
                    break;
                case TAG_THERE:
                    Bundle b2 = msg.getData();
                    String data2 = b2.getString("data");
                    LineSearch bean2 = new Gson().fromJson(data2, LineSearch.class);
                    if (bean2.getResult().size() != 0) {
                        for (int i = 0; i < bean2.getResult().size(); i++) {
                            lineList.add(bean2.getResult().get(i));
                        }
                    }
                    baseAdapter.notifyDataSetChanged();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
