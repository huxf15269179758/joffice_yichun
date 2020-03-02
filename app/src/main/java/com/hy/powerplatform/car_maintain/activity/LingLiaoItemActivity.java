package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.LingLiaoListItemAdapter;
import com.hy.powerplatform.car_maintain.bean.LingLiao;
import com.hy.powerplatform.car_maintain.bean.LingLiaoItem;
import com.hy.powerplatform.car_maintain.presenter.LingLiaoItemPresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.LingLiaoItemPresenterImpl;
import com.hy.powerplatform.car_maintain.view.LingLiaoItemView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LingLiaoItemActivity extends BaseActivity implements LingLiaoItemView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    LingLiaoItemPresenter presenter;
    List<LingLiaoItem.DataBean.StockBean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Intent intent = getIntent();
        LingLiao.ResultBean bean = (LingLiao.ResultBean) intent.getSerializableExtra("bean");
        String ZCode = bean.getMeasureBusNo();
        presenter = new LingLiaoItemPresenterImpl(this, this);
        presenter.getLingLiaoItemPresenter(ZCode);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_ling_liao_item;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this,ClassIfyActivity.class);
        startActivity(intent);
    }

    @Override
    public void getLingLiaoItemView(LingLiaoItem lingLiaoItem) {
        if (lingLiaoItem.getData().size() != 0) {
//            for (int i = 0;i<lingLiaoItem.getData().size();i++){
//                int num = lingLiaoItem.getData().size();
            if (lingLiaoItem.getData().get(2).getStock().size() != 0) {
                for (int k = 0; k < lingLiaoItem.getData().get(2).getStock().size(); k++) {
                    dataList.add(lingLiaoItem.getData().get(2).getStock().get(k));
                }
                LingLiaoListItemAdapter adapter = new LingLiaoListItemAdapter(this, dataList);
                recyclerView.setAdapter(adapter);
            }
//            }
        }
    }
}
