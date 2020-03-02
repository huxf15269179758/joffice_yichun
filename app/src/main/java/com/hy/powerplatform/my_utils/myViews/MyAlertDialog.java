package com.hy.powerplatform.my_utils.myViews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hy.powerplatform.DialogAddSubPrivateTopicRecyclerViewAdapter;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;

import java.util.List;

/**
 * Created by Administrator on 2019/2/1.
 */

public class MyAlertDialog {
    public static void MyListAlertDialog(final String isShow, final List<String> codeList, final List<String> nameList,
                                         final List<String> nameList1, final Context context,
                                         final AlertDialogCallBackP alertDialogCallBack){
        LinearLayout linearLayoutMain = new LinearLayout(context);// 自定义一个布局文件
        linearLayoutMain.setLayoutParams(new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT));
        final ListView listView = new ListView(context);// this为获取当前的上下文
        listView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, 300));
        listView.setFadingEdgeLength(0);

//        SimpleAdapter adapter = new SimpleAdapter(context, nameList,
//                R.layout.alert_item, new String[]{"name"},
//                new int[]{R.id.tv_name});
        AlertDialogAdapter adapter = new AlertDialogAdapter(context,nameList,isShow);
        listView.setAdapter(adapter);
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        linearLayoutMain.addView(listView);// 往这个布局中加入listview

        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("请选择条目")
                .setView(linearLayoutMain)// 在这里把写好的这个listview的布局加载dialog中
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0;i<nameList.size();i++){
                            // 获得子item的layout
                            LinearLayout layout = (LinearLayout)listView.getChildAt(i);
                            CheckBox cb = (CheckBox) layout.findViewById(R.id.cb);
                            CheckBox cb1 = (CheckBox) layout.findViewById(R.id.cb1);
                            // 从layout中获得控件,其id
                            if (isShow.equals("true")){
                                cb.setVisibility(View.GONE);
                                if (cb1.isChecked()){
                                    nameList1.add(codeList.get(i));
                                }
                            }else {
                                cb1.setVisibility(View.GONE);
                                if (cb.isChecked()){
                                    nameList1.add(codeList.get(i));
                                }
                            }
                        }
                        if (nameList1.size()==0){
                            alertDialogCallBack.confirm();
                        }else {
                            alertDialogCallBack.select(nameList1);
                            dialog.cancel();
                        }
                    }
                }).create();
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // TODO Auto-generated method stub
//                        dialog.cancel();
//                    }
//                }).create();
        dialog.setCanceledOnTouchOutside(false);// 使除了dialog以外的地方不能被点击
        dialog.show();
    }

    public static void MyListAlertDialog( final Context context,final List<String> nameList,
                                          final AlertDialogCallBackP alertDialogCallBack){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog mAlertDialog = builder.create();
        //在这里使用新的视图
        View view = LayoutInflater.from(context).inflate(R.layout.alert_recycler, null);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rc_dialog_add_sub_private_topic);
        //初始化Adapter
        DialogAddSubPrivateTopicRecyclerViewAdapter dialogAddSubPrivateTopicRecyclerViewAdapter = new DialogAddSubPrivateTopicRecyclerViewAdapter(nameList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dialogAddSubPrivateTopicRecyclerViewAdapter);
        //设置点击事件
        dialogAddSubPrivateTopicRecyclerViewAdapter.setOnItemClickListener(new DialogAddSubPrivateTopicRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //在这里处理点击事件
                alertDialogCallBack.oneselect(nameList.get(position));
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.show();
        mAlertDialog.getWindow().setContentView(view);
    }

    public static void MyListAlertDialog1( final Context context,final List<String> nameList,
                                          final AlertDialogCallBackP alertDialogCallBack){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog mAlertDialog = builder.create();
        //在这里使用新的视图
        View view = LayoutInflater.from(context).inflate(R.layout.alert_recycler1, null);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rc_dialog_add_sub_private_topic);
        //初始化Adapter
        DialogAddSubPrivateTopicRecyclerViewAdapter dialogAddSubPrivateTopicRecyclerViewAdapter = new DialogAddSubPrivateTopicRecyclerViewAdapter(nameList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dialogAddSubPrivateTopicRecyclerViewAdapter);
        //设置点击事件
        dialogAddSubPrivateTopicRecyclerViewAdapter.setOnItemClickListener(new DialogAddSubPrivateTopicRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //在这里处理点击事件
                alertDialogCallBack.oneselect(nameList.get(position));
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.show();
        mAlertDialog.getWindow().setContentView(view);
    }
}
