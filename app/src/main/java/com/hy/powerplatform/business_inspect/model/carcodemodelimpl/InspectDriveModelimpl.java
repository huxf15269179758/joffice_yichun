package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.model.InspectDriveModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectDriveModelimpl implements InspectDriveModel{

    @Override
    public void getInspectDriveModelData(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).inspectDrive()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<InspectDrive>() {
                    @Override
                    public void success(InspectDrive inspectDrive) {
                        baseModeBackLisenter.success(inspectDrive);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
