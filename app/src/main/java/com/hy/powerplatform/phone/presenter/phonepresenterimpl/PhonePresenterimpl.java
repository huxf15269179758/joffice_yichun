package com.hy.powerplatform.phone.presenter.phonepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.phone.bean.Phone;
import com.hy.powerplatform.phone.model.PhoneModel;
import com.hy.powerplatform.phone.model.phonemodelimpl.PhoneModelimpl;
import com.hy.powerplatform.phone.presenter.PhonePresenter;
import com.hy.powerplatform.phone.view.PhoneView;

/**
 * Created by dell on 2018/5/8.
 */

public class PhonePresenterimpl implements PhonePresenter {

    private PhoneModel phoneModel;
    private Context context;
    private PhoneView phoneView;

    //构造方法
    public PhonePresenterimpl(PhoneView phoneView, Context context){
        this.context = context;
        this.phoneView = phoneView;
        phoneModel = new PhoneModelimpl();
    }


    @Override
    public void getPhonePresenterData(String userId) {
        phoneModel.getPhoneModelData(Constant.UPRESULT,userId,context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                phoneView.getPhoneViewData((Phone) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
