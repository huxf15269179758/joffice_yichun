package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.Line;
import com.hy.powerplatform.car_maintain.model.LineModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.LineModelImpl;
import com.hy.powerplatform.car_maintain.presenter.LinePresenter;
import com.hy.powerplatform.car_maintain.view.LineView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class LinePresenterImpl implements LinePresenter {
    private LineModel lineModel;
    private Context context;
    private LineView lineView;

    //构造方法
    public LinePresenterImpl(LineView lineView, Context context){
        this.context = context;
        this.lineView = lineView;
        lineModel = new LineModelImpl();
    }

    @Override
    public void getLinePresenter() {
        lineModel.getLineModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                lineView.getLineView((Line) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
