package com.hy.powerplatform.duban.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.duban.bean.DBCheckPerson;
import com.hy.powerplatform.duban.model.DBCheckPersonModel;
import com.hy.powerplatform.duban.model.carcodemodelimpl.DBCheckPersonModelimpl;
import com.hy.powerplatform.duban.presenter.DBCheckPersonPresenter;
import com.hy.powerplatform.duban.view.DBCheckPersonView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class DBCheckPersonPresenterimpl implements DBCheckPersonPresenter {

    Context context;
    DBCheckPersonModel checkPersonModel;
    DBCheckPersonView checkPersonView;

    public DBCheckPersonPresenterimpl(DBCheckPersonView checkPersonView, Context context){
        this.context = context;
        this.checkPersonView = checkPersonView;
        checkPersonModel = new DBCheckPersonModelimpl();
    }

    @Override
    public void getCheckPersonPresenterData() {
        checkPersonModel.getCheckPersonModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                checkPersonView.getCheckPersonViewData((DBCheckPerson) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
