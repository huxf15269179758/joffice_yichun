package com.hy.powerplatform.phone.model.phonemodelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils1;
import com.hy.powerplatform.phone.bean.Phone;
import com.hy.powerplatform.phone.model.PhoneModel;

/**
 * Created by dell on 2018/5/8.
 */

public class PhoneModelimpl implements PhoneModel {

    @Override
    public void getPhoneModelData(String httpTag, String userId, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils1.initlist(HttpUtils1.getService(RetrofitService.class).getPhone(userId)
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<Phone>() {
                    @Override
                    public void success(Phone phone) {
                        baseModeBackLisenter.success(phone);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
