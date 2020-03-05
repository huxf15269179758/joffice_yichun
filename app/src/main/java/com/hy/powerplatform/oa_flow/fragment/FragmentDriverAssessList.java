package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.FlowDriverAssessDetailActivity;
import com.hy.powerplatform.oa_flow.adapter.FlowContractPayListAdapter;
import com.hy.powerplatform.oa_flow.bean.MyLeave;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

/**
 * Created by Administrator on 2019/1/15.
 */

public class FragmentDriverAssessList extends Fragment implements FlowContractPayListAdapter.OnGetAdapterPositionListener {

    @BindView(R.id.liContent1)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;

    int limit = 20;
    int start = 0;
    String res = "";
    String tag;
    View view;
    Unbinder unbinder;
    FlowContractPayListAdapter adapter;
    List<MyLeave.ResultBean> beanList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.getRecyclerView().setLayoutManager(manager);
        adapter = new FlowContractPayListAdapter(getActivity(), beanList);
        adapter.sendOnGetAdapterPositionListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProgressDialogUtil.startLoad(getActivity(),"获取数据中");
        getData(start, limit);
        setClient();
    }

    /**
     * 获取数据
     *
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "";
                url = Constant.BASE_URL2 + Constant.MYLIST + start + "&limit=" + limit
                        + "&Q_subject_S_LK=" + Constant.DRIVERASSESSNAME;
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaMy(url);
                if (res.equals("获取数据失败") || res.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
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
    public void getAdapterPosition(int position) {
        MyLeave.ResultBean bean = beanList.get(position);
        Intent intent = new Intent(getActivity(), FlowDriverAssessDetailActivity.class);
        intent.putExtra("bean", bean.getRunId());
        startActivity(intent);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Gson gson = new Gson();
                    MyLeave bean = gson.fromJson(res, MyLeave.class);
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        beanList.add(bean.getResult().get(i));
                    }

                    if (bean.getResult().size() == 0 && beanList.size() == 0) {
                        if (recyclerView != null) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                        }
                        ProgressDialogUtil.stopLoad();
                        break;
                    } else if (bean.getResult().size() == 0 && beanList.size() != 0) {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            recyclerView.onNoMore();
                            adapter.notifyDataSetChanged();
                        }
                    } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            recyclerView.onNoMore();
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            adapter.notifyDataSetChanged();
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(getActivity(), "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
