package com.hy.powerplatform.oa_flow.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.adapter.InboxListAdapter;
import com.hy.powerplatform.oa_flow.bean.Inbox;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class InboxActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    String data;
    InboxListAdapter adapter;
    List<Inbox.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ProgressDialogUtil.startLoad(this,"获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.GETINBOX;
                DBHandler dbA = new DBHandler();
                data = dbA.getInbox(url);
                if (data.equals("获取数据失败") || data.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inbox;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TAG_ONE:
                    Inbox inbox = new Gson().fromJson(data, Inbox.class);
                    for (int i = 0;i<inbox.getResult().size();i++){
                        beanList.add(inbox.getResult().get(i));
                    }
                    LinearLayoutManager manager = new LinearLayoutManager(InboxActivity.this);
                    recyclerView.setLayoutManager(manager);
                    adapter = new InboxListAdapter(InboxActivity.this,beanList);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(InboxActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
