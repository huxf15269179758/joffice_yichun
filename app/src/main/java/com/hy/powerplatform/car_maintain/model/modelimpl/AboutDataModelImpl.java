package com.hy.powerplatform.car_maintain.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.AboutData;
import com.hy.powerplatform.car_maintain.model.AboutDataModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class AboutDataModelImpl implements AboutDataModel {

    @Override
    public void getAboutDataModel(String httpTag, String busCode, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getAboutData(busCode)
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<AboutData>() {
                    @Override
                    public void success(AboutData aboutData) {
                        baseModeBackLisenter.success(aboutData);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
