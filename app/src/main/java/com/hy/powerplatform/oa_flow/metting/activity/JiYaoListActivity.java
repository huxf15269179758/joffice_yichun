package com.hy.powerplatform.oa_flow.metting.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.metting.bean.JiYaoList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class JiYaoListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;

    int limit = 20;
    int start = 0;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<JiYaoList> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.oaflow_metting_rb5));
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<JiYaoList>(this, R.layout.adapter_rzlist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final JiYaoList resultBean) {
                holder.setText(R.id.tv1, "标题");
                holder.setText(R.id.tvName, resultBean.getTitle());
                holder.setText(R.id.tv2, "创建人");
                holder.setText(R.id.tvPhone, resultBean.getCreator());
                holder.setText(R.id.tv3, "创建日期");
                holder.setText(R.id.tvIdCard, resultBean.getCreatetime());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialogUtil alertDialogUtil = new AlertDialogUtil(JiYaoListActivity.this);
                        alertDialogUtil.showPictureSmallDialog("纪要内容",resultBean.getSumContent(), new AlertDialogCallBack() {
                            @Override
                            public void select(String data) {

                            }

                            @Override
                            public void confirm() {

                            }

                            @Override
                            public void cancel() {

                            }
                        });
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);

        getData(start, limit);
        setClient();
    }

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.JIYAO + "?start=" + start + "&limit=" + limit;
        map.clear();
        map.put("sort", "confId");
        map.put("dir", "DESC");
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
        return R.layout.activity_mywill_open;
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
                    Toast.makeText(JiYaoListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    try {
                        JSONObject jsonObject = new JSONObject(data);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String data1 = String.valueOf(jsonObject1.getString("confId"));
                            JSONObject jsonObject2 = new JSONObject(data1);
                            JiYaoList bean = new JiYaoList();
                            bean.setTitle(jsonObject2.getString("confTopic"));
                            bean.setCreator(jsonObject1.getString("creator"));
                            bean.setCreatetime(jsonObject2.getString("createtime"));
                            bean.setSumContent(jsonObject1.getString("sumContent"));
                            beanList.add(bean);
                        }
                        if (jsonArray.length() == 0 && beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                        }else if (jsonArray.length() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        } else if (jsonArray.length() != 0 && beanList.size() != 0 && jsonArray.length() < 20) {
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
                        ProgressDialogUtil.stopLoad();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    JiYaoList bean = new Gson().fromJson(data, JiYaoList.class);
//                    if (bean.getTotalCounts() != 0) {
//                        for (int i = 0; i < bean.getResult().size(); i++) {
//                            beanList.add(bean.getResult().get(i));
//                        }
//                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
//                            recyclerView.setVisibility(View.GONE);
//                            llNoContent.setVisibility(View.VISIBLE);
//                        }else if (bean.getResult().size() == 0 && beanList.size() != 0) {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                recyclerView.onNoMore();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                recyclerView.onNoMore();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        } else {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        }
//                        baseAdapter.notifyDataSetChanged();
//                    } else {
//                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
//                            recyclerView.setVisibility(View.GONE);
//                            llNoContent.setVisibility(View.VISIBLE);
//                        }else {
//                            recyclerView.setVisibility(View.VISIBLE);
//                            llNoContent.setVisibility(View.GONE);
//                            recyclerView.complete();
//                            recyclerView.onNoMore();
//                            baseAdapter.notifyDataSetChanged();
//                        }
//                    }
//                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
