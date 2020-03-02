package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.duban.bean.DBCKXQ;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class DBChaKanCKActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvZXR)
    TextView tvZXR;
    @BindView(R.id.tvZT)
    TextView tvZT;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvMomo)
    TextView tvMomo;
    @BindView(R.id.tvFJ)
    TextView tvFJ;

    Bundle bundle;
    Gson gson;
    String downloadData = "";
    private OkHttpUtil httpUtil;
    List<String> fileNameList = new ArrayList<>();
    List<String> fileIdList = new ArrayList<>();
    List<String> filePathList = new ArrayList<>();
    List<DBCKXQ.DataBean.SuperTaskOperFilesBean> fileList = new ArrayList<>();
    final HashMap<String, String> map = new HashMap();
    String path_url = Constant.BASE_URL1 + Constant.DBCKXQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String operId = intent.getStringExtra("operId");
        httpUtil = OkHttpUtil.getInstance(this);
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.put("operId", operId);
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbcha_kan_ck;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.tvFJ)
    public void onViewClicked() {
        if (!tvFJ.getText().toString().equals("")) {
            if (fileNameList.size() == 1) {
                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + fileIdList.get(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DBHandler dbA = new DBHandler();
                        downloadData = dbA.OAQingJiaMyDetail(url);
                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                            handler.sendEmptyMessage(TAG_THERE);
                        } else {
                            handler.sendEmptyMessage(TAG_FOUR);
                        }
                    }
                }).start();
            } else if (fileNameList.size() > 1) {
                MyAlertDialog.MyListAlertDialog(this, fileNameList, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data1) {
                        String id = "";
                        for (int i = 0; i < fileNameList.size(); i++) {
                            if (fileNameList.get(i).equals(data1)) {
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
                                    handler.sendEmptyMessage(TAG_THERE);
                                } else {
                                    handler.sendEmptyMessage(TAG_FOUR);
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
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(DBChaKanCKActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case TAG_TWO:
                    bundle = msg.getData();
                    String data = bundle.getString("data");
                    gson = new Gson();
                    DBCKXQ bean = gson.fromJson(data, DBCKXQ.class);
                    if (bean.isSuccess()) {
                        tvZXR.setText(bean.getData().getOperatorName());
                        if (bean.getData().getOperStatus() == 1) {
                            tvZT.setText("未查看");
                        } else if (bean.getData().getOperStatus() == 2) {
                            tvZT.setText("已查看");
                        } else if (bean.getData().getOperStatus() == 3) {
                            tvZT.setText("已接收");
                        } else if (bean.getData().getOperStatus() == 4) {
                            tvZT.setText("已退回");
                        } else if (bean.getData().getOperStatus() == 5) {
                            tvZT.setText("已提交");
                        } else if (bean.getData().getOperStatus() == 6) {
                            tvZT.setText("已撤回");
                        } else if (bean.getData().getOperStatus() == 7) {
                            tvZT.setText("已完成");
                        } else if (bean.getData().getOperStatus() == 8) {
                            tvZT.setText("已冻结");
                        } else if (bean.getData().getOperStatus() == 9) {
                            tvZT.setText("逾期完成");
                        } else if (bean.getData().getOperStatus() == 10) {
                            tvZT.setText("未完成");
                        }
                        tvTime.setText(bean.getData().getOperTime());
                        tvTitle.setText(bean.getData().getSubmitTitle());
                        tvContent.setText(bean.getData().getSubmitContext());
                        tvMomo.setText(bean.getData().getMemo());
                        tvFJ.setText(bean.getData().getFileIds());

                        fileList = bean.getData().getSuperTaskOperFiles();
                        for (int i = 0; i < fileList.size(); i++) {
                            fileNameList.add(fileList.get(i).getFileName());
                            fileIdList.add(fileList.get(i).getFileId());
                            filePathList.add(fileList.get(i).getFilePath());
                        }
                        if (fileNameList.size() != 0) {
                            tvFJ.setText(fileNameList.toString());
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;

                case TAG_THERE:
                    Toast.makeText(DBChaKanCKActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FOUR:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
            }
        }
    };

}
