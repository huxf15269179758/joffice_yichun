package com.hy.powerplatform.statist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hy.powerplatform.R;
import com.hy.powerplatform.duban.bean.ItemBean;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.statist.activity.CLXHTongJiActivity;
import com.hy.powerplatform.statist.activity.CostComparisonActivity;
import com.hy.powerplatform.statist.activity.HuiZongActivity;
import com.hy.powerplatform.statist.activity.MileYearActivity;
import com.hy.powerplatform.statist.activity.PersonChangeActivity;
import com.hy.powerplatform.statist.activity.PersonTongJiActivity;
import com.hy.powerplatform.statist.activity.YingYunShouRuActivity;
import com.hy.powerplatform.statist.activity.YueDuWGCSActivity;
import com.hy.powerplatform.statist.activity.YueDuYCBCActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatistListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Intent intent;
    BaseRecyclerAdapter mAdapter;
    AlertDialogUtil alertDialogUtil;
    List<ItemBean> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        //添加模块
        addItem();
        setItemAdapter();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_statist_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private void addItem() {
        ItemBean bean1 = new ItemBean();
        int drawableId1 = getResources().getIdentifier("oaflow_statist_rb1", "drawable", getPackageName());
        bean1.setAddress(drawableId1);
        bean1.setName(getResources().getString(R.string.oaflow_statist_rb1));
        itemList.add(bean1);

        ItemBean bean2 = new ItemBean();
        int drawableId2 = getResources().getIdentifier("oaflow_statist_rb2", "drawable", getPackageName());
        bean2.setAddress(drawableId2);
        bean2.setName(getResources().getString(R.string.oaflow_statist_rb2));
        itemList.add(bean2);

        ItemBean bean3 = new ItemBean();
        int drawableId3 = getResources().getIdentifier("oaflow_statist_rb3", "drawable", getPackageName());
        bean3.setAddress(drawableId3);
        bean3.setName(getResources().getString(R.string.oaflow_statist_rb3));
        itemList.add(bean3);

        ItemBean bean4 = new ItemBean();
        int drawableId4 = getResources().getIdentifier("oaflow_statist_rb4", "drawable", getPackageName());
        bean4.setAddress(drawableId4);
        bean4.setName(getResources().getString(R.string.oaflow_statist_rb4));
        itemList.add(bean4);

        ItemBean bean5 = new ItemBean();
        int drawableId5 = getResources().getIdentifier("oaflow_statist_rb5", "drawable", getPackageName());
        bean5.setAddress(drawableId5);
        bean5.setName(getResources().getString(R.string.oaflow_statist_rb5));
        itemList.add(bean5);

        ItemBean bean6 = new ItemBean();
        int drawableId6 = getResources().getIdentifier("oaflow_statist_rb6", "drawable", getPackageName());
        bean6.setAddress(drawableId6);
        bean6.setName(getResources().getString(R.string.oaflow_statist_rb6));
        itemList.add(bean6);

        ItemBean bean7 = new ItemBean();
        int drawableId7 = getResources().getIdentifier("oaflow_statist_rb7", "drawable", getPackageName());
        bean7.setAddress(drawableId7);
        bean7.setName(getResources().getString(R.string.oaflow_statist_rb7));
//        itemList.add(bean7);

        ItemBean bean8 = new ItemBean();
        int drawableId8 = getResources().getIdentifier("oaflow_statist_rb8", "drawable", getPackageName());
        bean8.setAddress(drawableId8);
        bean8.setName(getResources().getString(R.string.oaflow_statist_rb8));
//        itemList.add(bean8);

        ItemBean bean9 = new ItemBean();
        int drawableId9 = getResources().getIdentifier("oaflow_statist_rb9", "drawable", getPackageName());
        bean9.setAddress(drawableId9);
        bean9.setName(getResources().getString(R.string.oaflow_statist_rb9));
        itemList.add(bean9);

        ItemBean bean10 = new ItemBean();
        int drawableId10 = getResources().getIdentifier("oaflow_statist_rb10", "drawable", getPackageName());
        bean10.setAddress(drawableId10);
        bean10.setName(getResources().getString(R.string.oaflow_statist_rb10));
        itemList.add(bean10);

        ItemBean bean11 = new ItemBean();
        int drawableId11 = getResources().getIdentifier("oaflow_statist_rb11", "drawable", getPackageName());
        bean11.setAddress(drawableId11);
        bean11.setName(getResources().getString(R.string.oaflow_statist_rb11));
        itemList.add(bean11);
    }

    private void setItemAdapter() {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapter<ItemBean>(this, R.layout.adapter_itembean, itemList) {
            @Override
            public void convert(BaseViewHolder holder, final ItemBean itemBean) {
                holder.setText(R.id.textView, itemBean.getName());
                holder.setImageResource(R.id.imageView, itemBean.getAddress());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb1))) {
                            intent = new Intent(StatistListActivity.this, PersonTongJiActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb2))) {
                            intent = new Intent(StatistListActivity.this, PersonChangeActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb3))) {
                            intent = new Intent(StatistListActivity.this, MileYearActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb4))) {
                            intent = new Intent(StatistListActivity.this, CostComparisonActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb5))) {
                            intent = new Intent(StatistListActivity.this, HuiZongActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb6))) {
                            intent = new Intent(StatistListActivity.this, CLXHTongJiActivity.class);
                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb7))) {
//                            intent = new Intent(StatistListActivity.this, StatistListActivity.class);
//                            startActivity(intent);
                        } else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb8))) {
//                            intent = new Intent(StatistListActivity.this, FaultUpActivity.class);
//                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb9))) {
                            intent = new Intent(StatistListActivity.this, YueDuYCBCActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb10))) {
                            intent = new Intent(StatistListActivity.this, YueDuWGCSActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.oaflow_statist_rb11))) {
                            intent = new Intent(StatistListActivity.this, YingYunShouRuActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
