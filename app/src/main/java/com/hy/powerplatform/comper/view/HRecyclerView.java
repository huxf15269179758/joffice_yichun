package com.hy.powerplatform.comper.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;

import static com.hy.powerplatform.my_utils.utils.DensityUtils.dip2px;

/**
 * Created by Administrator on 2020/2/28.
 */

public class HRecyclerView extends RelativeLayout {

    //头部title布局
    private LinearLayout mRightTitleLayout;
    //手指按下时的位置
    private float mStartX = 0;
    //滑动时和按下时的差值
    private int mMoveOffsetX = 0;
    //最大可滑动差值
    private int mFixX = 0;
    //左边标题集合
    private String[] mLeftTextList;
    //左边标题的宽度集合
    private int[] mLeftTextWidthList;
    //右边标题集合
    private String[] mRightTitleList = new String[]{};
    //右边标题的宽度集合
    private int[] mRightTitleWidthList = null;
    //展示数据时使用的RecycleView
    private RecyclerView mRecyclerView;
    //RecycleView的Adapter
    private Object mAdapter;
    //需要滑动的View集合
    private ArrayList<View> mMoveViewList = new ArrayList();
    private Context context;
    //右边可滑动的总宽度
    private int mRightTotalWidth = 0;
    //触发拦截手势的最小值
    private int mTriggerMoveDis=30;

    public HRecyclerView(Context context) {
        this(context, null);
    }

    public HRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    private void initView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(createHeadLayout());
        linearLayout.addView(createMoveRecyclerView());
        addView(linearLayout, new LayoutParams(LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

    }

    /**
     * 创建头部布局
     * @return
     */
    private View createHeadLayout() {
        LinearLayout headLayout = new LinearLayout(getContext());
        headLayout.setGravity(Gravity.CENTER);
        LinearLayout leftLayout = new LinearLayout(getContext());
        addListHeaderTextView(mLeftTextList[0], mLeftTextWidthList[0], leftLayout, 0);
        leftLayout.setGravity(Gravity.CENTER);
        final float scale = context.getResources().getDisplayMetrics().density;
        headLayout.addView(leftLayout);

        mRightTitleLayout = new LinearLayout(getContext());
        for (int i = 0; i < mRightTitleList.length; i++) {
            addListHeaderTextView(mRightTitleList[i], mRightTitleWidthList[i], mRightTitleLayout, i+1);
        }
        headLayout.addView(mRightTitleLayout);
        return headLayout;
    }

    /**
     * 创建数据展示布局
     * @return
     */
    private View createMoveRecyclerView() {
        RelativeLayout linearLayout = new RelativeLayout(getContext());
        mRecyclerView = new RecyclerView(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        if(null !=mAdapter){
            if (mAdapter instanceof CommonAdapter) {
                mRecyclerView.setAdapter((CommonAdapter) mAdapter);
                mMoveViewList = ((CommonAdapter) mAdapter).getMoveViewList();
            }
        }

        linearLayout.addView(mRecyclerView, new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        return linearLayout;
    }

    /**
     * 设置adapter
     * @param adapter
     */
    public void setAdapter(Object adapter) {
        mAdapter = adapter;
        initView();
    }

    /**
     * 设置头部title单个布局
     * @param headerName
     * @param width
     * @param leftLayout
     * @return
     */
    private TextView addListHeaderTextView(String headerName, int width, LinearLayout leftLayout, int tag) {
        TextView textView = new TextView(getContext());
        textView.setText(headerName);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(getResources().getColor(R.color.list_header));
        final float scale = context.getResources().getDisplayMetrics().density;
        if (tag == 0){
            leftLayout.addView(textView, (int) (130 * scale + 0.5f), dip2px(context, 50));
        }else {
            leftLayout.addView(textView, (int) (85 * scale + 0.5f), dip2px(context, 50));
        }

        return textView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = (int) Math.abs(ev.getX() - mStartX);
                if (offsetX > mTriggerMoveDis) {//水平移动大于30触发拦截
                    return true;
                } else {
                    return false;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 右边可滑动的总宽度
     * @return
     */
    private int rightTitleTotalWidth() {
        if (0 == mRightTotalWidth) {
            for (int i = 0; i < mRightTitleWidthList.length; i++) {
                mRightTotalWidth = mRightTotalWidth + mRightTitleWidthList[i];
            }
        }
        return mRightTotalWidth;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                int offsetX = (int) Math.abs(event.getX() - mStartX);
                if (offsetX > 30) {
                    mMoveOffsetX = (int) (mStartX - event.getX() + mFixX);
                    if (0 > mMoveOffsetX) {
                        mMoveOffsetX = 0;
                    } else {
                        //当滑动大于最大宽度时，不在滑动（右边到头了）
                        if ((mRightTitleLayout.getWidth() + mMoveOffsetX) > rightTitleTotalWidth()) {
                            mMoveOffsetX = rightTitleTotalWidth() - mRightTitleLayout.getWidth();
                        }
                    }
                    //跟随手指向右滚动
                    mRightTitleLayout.scrollTo(mMoveOffsetX, 0);
                    if (null != mMoveViewList) {
                        for (int i = 0; i < mMoveViewList.size(); i++) {
                            //使每个item随着手指向右滚动
                            mMoveViewList.get(i).scrollTo(mMoveOffsetX, 0);
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                mFixX = mMoveOffsetX; //设置最大水平平移的宽度
                break;

        }

        return super.onTouchEvent(event);
    }

    /**
     * 列表头部数据
     * @param headerListData
     */
    public void setHeaderListData(String[] headerListData) {
        mRightTitleList = headerListData;
        mRightTitleWidthList = new int[headerListData.length];
        final float scale = context.getResources().getDisplayMetrics().density;
//        leftLayout.addView(textView, (int) (85 * scale + 0.5f), dip2px(context, 50));
        for (int i = 0; i < headerListData.length; i++) {
            mRightTitleWidthList[i] = (int) (85 * scale + 0.5f);
        }
//        mRightTitleWidthList[0] = 200;
//        mRightTitleWidthList[1] = 160;
//        mRightTitleWidthList[2] = 160;
//        mRightTitleWidthList[3] = 160;
//        mRightTitleWidthList[4] = 160;
//        mRightTitleWidthList[5] = 160;
//        mRightTitleWidthList[6] = 160;
        mLeftTextWidthList = new int[]{(int) (130 * scale + 0.5f)};
        mLeftTextList = new String[]{"标题"};
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}