package com.hy.powerplatform.oa_flow.phone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.PersonListActivity;
import com.hy.powerplatform.oa_flow.phone.bean.Phone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class PhoneActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;

    int limit = 20;
    int start = 0;
    @BindView(R.id.tvName)
    TextView tvName;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    String departName = "", departId = "", userName = "", userId = "", profileId = "";
    final HashMap<String, String> map = new HashMap();
    List<Phone.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<Phone.ResultBean>(this, R.layout.adapter_rzlist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final Phone.ResultBean resultBean) {
                holder.setText(R.id.tv1, "账号");
                holder.setText(R.id.tvName, resultBean.getUsername());
                holder.setText(R.id.tv2, "部门");
                holder.setText(R.id.tvPhone, resultBean.getDepNames());
                holder.setText(R.id.tv3, "手机号");
                holder.setText(R.id.tvIdCard, resultBean.getPhone());
                holder.setOnClickListener(R.id.tvIdCard, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(resultBean.getPhone()==null||resultBean.getPhone().equals("")){

                        }else {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            Uri data = Uri.parse("tel:" + resultBean.getPhone());
                            intent.setData(data);
                            startActivity(intent);
                        }
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

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_phone;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        getData(start, limit);
    }

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.PHONE + "?start=" + start + "&limit=" + limit;
        map.clear();
        map.put("depId", departId);
        map.put("Q_username_S_LK", tvName.getText().toString());
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

    @OnClick({R.id.tvDepartment, R.id.tvName})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDepartment:
                Intent intent = new Intent(this, PhoneDepartmentActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.tvName:
                Intent intent1 = new Intent(this, PersonListActivity.class);
                startActivityForResult(intent1, Constant.TAG_FOUR);
                break;
        }
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_THERE:
                if (resultCode == Constant.TAG_THERE) {
                    departName = data.getStringExtra("name");
                    departId = data.getStringExtra("id");
                    tvDepartment.setText(departName);
                }
                break;
            case TAG_FOUR:
                try {
                    profileId = data.getStringExtra("profileId");
                    userName = data.getStringExtra("userName");
                    tvName.setText(userName);
                }catch (Exception e) {

            }
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
                    Toast.makeText(PhoneActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Phone bean = new Gson().fromJson(data, Phone.class);
                    if (bean.getTotalCounts() != 0) {
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        if (bean.getResult().size() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        } else {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }
                        baseAdapter.notifyDataSetChanged();
                    } else {
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
