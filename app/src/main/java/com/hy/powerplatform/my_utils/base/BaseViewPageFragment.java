package com.hy.powerplatform.my_utils.base;

/**
 * Created by Administrator on 2019/3/1.
 */

/**
 * 在ViewPager中使用，可以防止数据预加载, 只预加载View，滑动到哪一页才会加载哪一页的数据
 */
public abstract class BaseViewPageFragment extends BaseFragment {
    private boolean mIsDataInited;

    @Override
    protected void onViewCreated() {
        initView();
        initListener();
        if (!mIsDataInited) {
            if (getUserVisibleHint()) {
                initData();
                mIsDataInited = true;
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //防止数据预加载, 只预加载View，不预加载数据
        if (isVisibleToUser && isVisible() && !mIsDataInited) {
            initData();
            mIsDataInited = true;
        }
    }

    @Override
    public abstract void initView();

    @Override
    public abstract void initData();
}
