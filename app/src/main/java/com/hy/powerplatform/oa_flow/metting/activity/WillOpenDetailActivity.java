package com.hy.powerplatform.oa_flow.metting.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.myViews.RichTextView;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.metting.bean.WillOpenList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class WillOpenDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.tvJB)
    TextView tvJB;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvOverTime)
    TextView tvOverTime;
    @BindView(R.id.tvContent)
    RichTextView tvContent;
    @BindView(R.id.tvZCR)
    TextView tvZCR;
    @BindView(R.id.tvJLR)
    TextView tvJLR;
    @BindView(R.id.tvCJJYR)
    TextView tvCJJYR;
    @BindView(R.id.tvXGR)
    TextView tvXGR;
    @BindView(R.id.tvCKR)
    TextView tvCKR;
    @BindView(R.id.tvCJR)
    TextView tvCJR;
    @BindView(R.id.tvCSR)
    TextView tvCSR;
    @BindView(R.id.tvCSBZ)
    TextView tvCSBZ;
    @BindView(R.id.tvSPR)
    TextView tvSPR;
    @BindView(R.id.tvZT)
    TextView tvZT;
    @BindView(R.id.tvSHBZ)
    TextView tvSHBZ;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.llData)
    LinearLayout llData;
    @BindView(R.id.scollView)
    ScrollView scollView;

    String downloadData = "";
    List<String> fileNameList = new ArrayList<>();
    List<String> fileIdList = new ArrayList<>();
    List<String> filePathList = new ArrayList<>();
    List<WillOpenList.ResultBean.AttachFilesBean> fileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.oaflow_metting_rb3));
        WillOpenList.ResultBean bean = (WillOpenList.ResultBean) getIntent().getSerializableExtra("bean");
        tvTitle.setText(bean.getConfTopic());
        tvType.setText(bean.getConfProperty());
        tvHome.setText(bean.getRoomName());
        tvStartTime.setText(bean.getStartTime());
        tvOverTime.setText(bean.getEndTime());
        tvContent.setHtml1(bean.getConfContent(), 500);
        tvZCR.setText(bean.getCompereName());
        tvJLR.setText(bean.getRecorderName());
        tvCJR.setText(bean.getAttendUsersName());
        tvXGR.setText(bean.getRecorderName());
        tvCSR.setText(bean.getApprovedName());
        tvCSBZ.setText(bean.getApprovedText());
        tvSPR.setText(bean.getApprovedName());

        fileList = bean.getAttachFiles();
        for (int i = 0;i<fileList.size();i++){
            fileNameList.add(fileList.get(i).getFileName());
            fileIdList.add(fileList.get(i).getFileId());
            filePathList.add(fileList.get(i).getFilePath());
        }
        if (fileNameList.size()!=0){
            tvData.setText(fileNameList.toString());
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mywill_open_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.tvData)
    public void onViewClicked() {
        if (!tvData.getText().toString().equals("")) {
            if (fileNameList.size() == 1) {
                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + fileIdList.get(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DBHandler dbA = new DBHandler();
                        downloadData = dbA.OAQingJiaMyDetail(url);
                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            handler.sendEmptyMessage(TAG_NINE);
                        }
                    }
                }).start();
            } else if (fileNameList.size() > 1) {
                MyAlertDialog.MyListAlertDialog(this, fileNameList, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data1) {
                        String id = "";
                        for (int i = 0;i<fileNameList.size();i++){
                            if (fileNameList.get(i).equals(data1)){
                                id = fileIdList.get(i);
                            }
                        }
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    }

                    @Override
                    public void select(List<String> list) {

                    }

                    @Override
                    public void confirm() {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        }else {
            llData.setVisibility(View.GONE);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(WillOpenDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
            }
        }
    };
}
