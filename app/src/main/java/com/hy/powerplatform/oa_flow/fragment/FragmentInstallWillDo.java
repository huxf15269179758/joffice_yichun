package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.FlowInstallWillDetailActivity;
import com.hy.powerplatform.oa_flow.adapter.FlowQingJiaWillDoAdapter;
import com.hy.powerplatform.oa_flow.bean.QingJiaWillDo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;


/**
 * Created by dell on.
 */

public class FragmentInstallWillDo extends Fragment implements FlowQingJiaWillDoAdapter.OnGetAdapterPositionListener,Runnable {
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    @BindView(R.id.liContent1)
    LinearLayout llNoContent;

    int start = 0;
    int limit = 20;
    String res;
    View view;
    Unbinder unbinder;
    FlowQingJiaWillDoAdapter adapter;
    List<QingJiaWillDo.ResultBean> beanList = new ArrayList<>();
    String tag = "";
    Thread thread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.getRecyclerView().setLayoutManager(manager);
        //禁止下拉刷新
//        recyclerView.setRefreshEnable(false);
        //禁止加载更多
//        recyclerView.setLoadMoreEnable(false);
        adapter = new FlowQingJiaWillDoAdapter(getActivity(), beanList);
        recyclerView.setAdapter(adapter);
        adapter.sendOnGetAdapterPositionListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ProgressDialogUtil.startLoad(getActivity(), "获取数据中");
        beanList.clear();
        getData(0, 20);
        setClient();
    }

    /**
     * 获取数据
     *
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit) {
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        String url = Constant.BASE_URL2 + Constant.WILLDOLIST + start +
                "&limit=" + limit+"&Q_subject_S_LK="+Constant.INSTALLNNAME;
        DBHandler dbA = new DBHandler();
        res = dbA.OAQingJiaWillDo(url);
        if (res.equals("获取数据失败") || res.equals("")) {
            handler.sendEmptyMessage(TAG_TWO);
        } else {
            handler.sendEmptyMessage(TAG_ONE);
        }
    }

    /**
     * 滑动监听
     */
    private void setClient() {
        recyclerView.setOnLoadListener(new CustomRefreshView.OnLoadListener() {
            @Override
            public void onRefresh() {
                tag = "down";
                beanList.clear();
                start = 0;
                limit = 20;
                getData(start, limit);
            }

            @Override
            public void onLoadMore() {
                tag = "up";
                start = limit;
                limit += 20;
                getData(start, limit);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        thread.interrupt();
    }

    @Override
    public void getAdapterPosition(int position) {
        Intent intent = new Intent(getActivity(), FlowInstallWillDetailActivity.class);
        intent.putExtra("activityName", beanList.get(position).getActivityName());
        intent.putExtra("taskId", beanList.get(position).getTaskId());
        startActivity(intent);
    }

    /**
     * @return
     * @author suncat
     * @category 判断是否有外网连接（普通方法不能判断外网的网络是否连接，比如连接上局域网）
     */
    public static final boolean ping() {

        String result = null;
        try {
            String ip = "www.baidu.com";// ping 的地址，可以换成任何一种可靠的外网
            Process p = Runtime.getRuntime().exec("ping -c 3 -w 100 " + ip);// ping网址3次
            // 读取ping的内容，可以不加
            InputStream input = p.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            StringBuffer stringBuffer = new StringBuffer();
            String content = "";
            while ((content = in.readLine()) != null) {
                stringBuffer.append(content);
            }
            Log.d("------ping-----", "result content : " + stringBuffer.toString());
            // ping的状态
            int status = p.waitFor();
            if (status == 0) {
                result = "success";
                return true;
            } else {
                result = "failed";
            }
        } catch (IOException e) {
            result = "IOException";
        } catch (InterruptedException e) {
            result = "InterruptedException";
        } finally {
            Log.d("----result---", "result = " + result);
        }
        return false;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        if (jsonArray.length() == 0 && beanList.size() == 0) {
                            if (recyclerView != null) {
                                recyclerView.setVisibility(View.GONE);
                                llNoContent.setVisibility(View.VISIBLE);
                            }
                            ProgressDialogUtil.stopLoad();
                            break;
                        } else if (jsonArray.length() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                            }
                        }
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonOnjectData = jsonArray.getJSONObject(i);
                            QingJiaWillDo.ResultBean bean = new QingJiaWillDo.ResultBean();
                            bean.setTaskName(jsonOnjectData.getString("taskName"));
                            bean.setActivityName(jsonOnjectData.getString("activityName"));
                            if (!jsonOnjectData.isNull("assignee")) {
                                bean.setAssignee(jsonOnjectData.getString("assignee"));
                            }
                            bean.setCreateTime(jsonOnjectData.getString("createTime"));
                            bean.setExecutionId(jsonOnjectData.getString("executionId"));
                            bean.setIsDue(jsonOnjectData.getString("isDue"));
                            bean.setPiId(jsonOnjectData.getString("piId"));
                            bean.setTaskId(jsonOnjectData.getString("taskId"));
                            bean.setState(jsonOnjectData.getString("state"));
                            bean.setIsMultipleTask(jsonOnjectData.getString("isMultipleTask"));
                            bean.setCandidateUsers(jsonOnjectData.getString("candidateUsers"));
                            bean.setCandidateRoles(jsonOnjectData.getString("candidateRoles"));
                            beanList.add(bean);
                        }
                        if (jsonArray.length() < 20) {
                            if (tag.equals("down")) {
                                if (recyclerView != null) {
                                    adapter.notifyDataSetChanged();
                                    recyclerView.complete();
                                    recyclerView.onNoMore();
                                }
                            } else {
                                if (recyclerView != null) {
                                    adapter.notifyDataSetChanged();
                                    recyclerView.complete();
                                    recyclerView.onNoMore();
                                }
                            }
                        } else {
                            if (recyclerView != null) {
                                adapter.notifyDataSetChanged();
                                recyclerView.complete();
                            }
                        }
                        if (start == 0) {
                            ProgressDialogUtil.stopLoad();
                            if (recyclerView != null) {
                                recyclerView.complete();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(TAG_THERE);
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(getActivity(), "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(getActivity(), "解析失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}