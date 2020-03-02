package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.adapter.SelectOneCarAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.CorrelatCarNoPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CorrectCarNoPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.CorrelatCarNoView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectOneCarActivity extends BaseActivity implements SelectOneCarAdapter.CallBackPosition
        , CarCodeView, CorrelatCarNoView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String etText;
    int position;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;
    AlertDialogUtil alertDialogUtil;
    SelectOneCarAdapter adapter;
    String selectCar, selectCarId;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    CarCodePresenter carCodePresenter;
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.activity_selectcar)
    LinearLayout activitySelectcar;
    @BindView(R.id.llimageView)
    LinearLayout llimageView;
    CorrelatCarNoPresenter correlatCarNoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        Intent intent = getIntent();
        String line = intent.getStringExtra("line");
        String date = intent.getStringExtra("date");
        carCodePresenter = new CarCodePresenterimpl(this, this);
        correlatCarNoPresenter = new CorrectCarNoPresenterimpl(this, this);
        new EditTextChange(etSelectCar).changeText();
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        new EditTextChange(editText).changeText();
        //查询数据
        String sqlR = "select * from carcode";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listCarCode = DbManager.cursorToClassCar(cursor);
        if (listCarCode.size() != 0) {
            if (line == null || line.equals("")) {
                LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
                recyclerView.setLayoutManager(manager);
                adapter = new SelectOneCarAdapter(SelectOneCarActivity.this, listCarCode);
                recyclerView.setAdapter(adapter);
                adapter.setOnClientMyTextView(SelectOneCarActivity.this);
            } else {
                String rq = null;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
                Date date0 = null;
                try {
                    date0 = df.parse(date);
                    rq = df2.format(date0);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                correlatCarNoPresenter.getCorrelatCarNoPresenterData(line, rq);
            }
        } else {
            carCodePresenter.getCarCodePresenterData();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String tag = editText.getText().toString();
                listCarCode = new ArrayList<>();
                String sql = "select * from carcode where name like '%" + tag + "%'";
                cursor = DbManager.queryBySQL(db, sql, null);
                listCarCode = DbManager.cursorToClassCar(cursor);
                if (listCarCode.size() != 0) {
                    adapter = new SelectOneCarAdapter(SelectOneCarActivity.this, listCarCode);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnClientMyTextView(SelectOneCarActivity.this);
                    adapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.VISIBLE);
                    llimageView.setVisibility(View.GONE);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    llimageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_selectcar;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void myTextViewClient(int position) {
        selectCar = listCarCode.get(position).getName();
        selectCarId = listCarCode.get(position).getValue();
        Intent i = new Intent();
        if (selectCar==null||selectCar.equals("")||selectCarId==null||selectCarId.equals("")){
            i.putExtra("bian", selectCar);
            i.putExtra("bianId", selectCarId);
            setResult(Constant.TAG_THERE, i);
            finish();
        }else {
            finish();
        }
    }


    @Override
    public void getCarCodeViewData(CarCode carCode) {
        listCarCode.clear();
        if (carCode.getData().size() != 0) {
            for (int i = 0; i < carCode.getData().size(); i++) {
                listCarCode.add(carCode.getData().get(i));
            }
            GetDataThread.saveCarCoodeData(carCode, db, helper, listCarCode);
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectOneCarAdapter(SelectOneCarActivity.this, listCarCode);
            recyclerView.setAdapter(adapter);
            adapter.setOnClientMyTextView(SelectOneCarActivity.this);
        } else {
            alertDialogUtil.showDialog(getResources().getString(R.string.no_search_phone)
                    , new AlertDialogCallBack() {
                        @Override
                        public void select(String data) {

                        }

                        @Override
                        public void confirm() {
                            finish();
                        }

                        @Override
                        public void cancel() {
                            finish();
                        }
                    });
        }
    }

    @OnClick(R.id.imageView)
    public void onViewClicked() {
        String tag = editText.getText().toString();
        listCarCode = new ArrayList<>();
        if (!tag.isEmpty()) {
            String sql = "select * from carcode where name like '%" + tag + "%'";
            cursor = DbManager.queryBySQL(db, sql, null);
            listCarCode = DbManager.cursorToClassCar(cursor);
            if (listCarCode.size() != 0) {
                adapter = new SelectOneCarAdapter(SelectOneCarActivity.this, listCarCode);
                recyclerView.setAdapter(adapter);
                adapter.setOnClientMyTextView(SelectOneCarActivity.this);
                adapter.notifyDataSetChanged();
            } else {
                recyclerView.setVisibility(View.GONE);
                llimageView.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getCorrelatCarNoViewData(CarCode carCode) {
        listCarCode.clear();
        if (carCode.getData().size() != 0) {
            for (int i = 0; i < carCode.getData().size(); i++) {
                listCarCode.add(carCode.getData().get(i));
            }
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectOneCarAdapter(SelectOneCarActivity.this, listCarCode);
            recyclerView.setAdapter(adapter);
            adapter.setOnClientMyTextView(SelectOneCarActivity.this);
        } else {
            alertDialogUtil.showDialog("暂无对应数据，请重新选择线路"
                    , new AlertDialogCallBack() {
                        @Override
                        public void select(String data) {

                        }

                        @Override
                        public void confirm() {
                            finish();
                        }

                        @Override
                        public void cancel() {
                            finish();
                        }
                    });
        }
    }
}
