package com.hy.powerplatform.car_maintain.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.ClassIfy;
import com.hy.powerplatform.car_maintain.model.ClassIfyModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class ClassIfyModelImpl implements ClassIfyModel {

    @Override
    public void getClassIfyModel(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getClassIfy()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<ClassIfy>() {
                    @Override
                    public void success(ClassIfy classIfy) {
                        baseModeBackLisenter.success(classIfy);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
