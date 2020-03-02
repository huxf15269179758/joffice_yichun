package com.hy.powerplatform;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class Fragment_Adapter extends PagerAdapter {
    List<Fragment> list=new ArrayList<Fragment>();
    private FragmentManager manager;
    public Fragment_Adapter(FragmentManager fm, List<Fragment> list) {
        manager=fm;
        this.list = list;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return list.get(position);
//    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = list.get(position);
        //判断当前的fragment是否已经被添加进入Fragmentanager管理器中
        if (!fragment.isAdded()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(fragment, fragment.getClass().getSimpleName());
            //不保存系统参数，自己控制加载的参数
            transaction.commitAllowingStateLoss();
            //手动调用,立刻加载Fragment片段
            manager.executePendingTransactions();
        }
        if (fragment.getView().getParent() == null) {
            //添加布局
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //移除布局
//        container.removeView(list.get(position).getView());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
