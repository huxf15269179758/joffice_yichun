package com.hy.powerplatform.duban.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.duban.bean.DBCheckPerson;
import com.hy.powerplatform.duban.model.DBCheckPersonModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class DBCheckPersonModelimpl implements DBCheckPersonModel {
    @Override
    public void getCheckPersonModelData(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getDBCheckPerson()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<DBCheckPerson>() {
                    @Override
                    public void success(DBCheckPerson checkPerson) {
                        baseModeBackLisenter.success(checkPerson);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
