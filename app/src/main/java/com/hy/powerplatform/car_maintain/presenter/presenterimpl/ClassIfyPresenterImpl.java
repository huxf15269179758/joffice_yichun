package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.ClassIfy;
import com.hy.powerplatform.car_maintain.model.ClassIfyModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.ClassIfyModelImpl;
import com.hy.powerplatform.car_maintain.presenter.ClassIfyPresenter;
import com.hy.powerplatform.car_maintain.view.ClassIfyView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class ClassIfyPresenterImpl implements ClassIfyPresenter {
    private ClassIfyModel classIfyModel;
    private Context context;
    private ClassIfyView classIfyView;

    //构造方法
    public ClassIfyPresenterImpl(ClassIfyView classIfyView, Context context){
        this.context = context;
        this.classIfyView = classIfyView;
        classIfyModel = new ClassIfyModelImpl();
    }

    @Override
    public void getClassIfyPresenter() {
        classIfyModel.getClassIfyModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                classIfyView.getClassIfyView((ClassIfy) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
