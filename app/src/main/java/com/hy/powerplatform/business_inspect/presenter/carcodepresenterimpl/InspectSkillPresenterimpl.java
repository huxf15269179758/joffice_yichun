package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectSkill;
import com.hy.powerplatform.business_inspect.model.InspectSkillModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectSkillModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectSkillPresenter;
import com.hy.powerplatform.business_inspect.view.InspectSkillView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectSkillPresenterimpl implements InspectSkillPresenter {

    Context context;
    InspectSkillModel inspectSkillModel;
    InspectSkillView inspectSkillView;

    public InspectSkillPresenterimpl(InspectSkillView inspectSkillView, Context context){
        this.context = context;
        this.inspectSkillView = inspectSkillView;
        inspectSkillModel = new InspectSkillModelimpl();
    }

    @Override
    public void getInspectSkillPresenterData() {
        inspectSkillModel.getInspectSkillModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectSkillView.getInspectSkillViewData((InspectSkill) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
