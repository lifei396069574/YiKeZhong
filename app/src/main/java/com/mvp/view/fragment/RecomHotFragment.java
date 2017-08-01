package com.mvp.view.fragment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.github.library.BaseMultiItemAdapter;
import com.github.library.BaseViewHolder;
import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.model.bean.ImageMenu;
import com.mvp.model.utils.LogUtils;
import com.mvp.presenter.RecomHotPresenter;
import com.mvp.view.adapter.ImageHolder;
import com.mvp.view.adapter.Multype;
import com.mvp.view.iview.RecomHotView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：李飞 on 2017/7/21 11:44
 * 类的用途：
 */

public class RecomHotFragment extends BaseFragment<RecomHotPresenter> implements RecomHotView {

    @BindView(R.id.rlc)
    RecyclerView mRlc;
    private BaseMultiItemAdapter mAdapter;
    private ConvenientBanner convenientBanner;
    private List mImageList = new ArrayList<String>();
    List<ImageMenu> list_isShow;
    private List<ImageView> imageViews ;
    private final int radius1 = 80;

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onSucceed(Object object) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new RecomHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recom_hot;
    }

    @Override
    protected void initData() {

        mRlc.setLayoutManager(new LinearLayoutManager(mActivity));
        List<Multype> list = new ArrayList<>();
        list_isShow = new ArrayList<>();
        Multype multype;
        ImageMenu imageMenu;
        for (int i = 0; i <10 ; i++) {
            multype = new Multype();
            imageMenu = new ImageMenu(false ,false ,false ,false ,false ,false ,false ,false ,i);
            if (i % 2 == 0) {
                multype.itemType = multype.FIRST;
                multype.content = "";
            } else {
                multype.itemType = multype.SECOND;
                multype.content = "";
            }
            list.add(multype);
            list_isShow.add(imageMenu);
        }

        mRlc.setAdapter(mAdapter = new BaseMultiItemAdapter<Multype>(mContext, list) {
            @Override
            protected void convert(final BaseViewHolder helper, Multype item) {
                switch (helper.getItemViewType()) {
                    case Multype.FIRST:

                        break;
                    case Multype.SECOND:

                        break;
                }

                setMenuListener(helper);

                boolean guanZhu = list_isShow.get(helper.getPosition() - 1).isGuanZhu();
                boolean shouC = list_isShow.get(helper.getPosition() - 1).isShouC();
                boolean fenX = list_isShow.get(helper.getPosition() - 1).isFenX();
                boolean pinLun = list_isShow.get(helper.getPosition() - 1).isPinLun();



            }
            @Override
            protected void addItemLayout() {
                addItemType(Multype.FIRST, R.layout.rlv_item1);
                addItemType(Multype.SECOND, R.layout.rlv_item2);
            }
        });



        View headerView=mActivity.getLayoutInflater().inflate(R.layout.banner, null);
        headerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        convenientBanner = (ConvenientBanner)headerView.findViewById(R.id.convenientBanner);

        mImageList.add("http://www.tklife.com.cn/home/attachment/201101/18/28360_129532657211iS.jpg");
        mImageList.add("http://new-img1.ol-img.com/16/789/liQhJJuH1vDs.jpg");
        mImageList.add("http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=32c015eaf6039245b5b8e94ceffdceb7/d788d43f8794a4c28c10040c04f41bd5ad6e39e2.jpg");
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder() {
                return new ImageHolder();
            }
        },mImageList)
                .setPageIndicator(new int[]{R.drawable.ic_dot_normal,R.drawable.ic_dot_pressed})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

        if(!convenientBanner.isTurning()){
            convenientBanner.startTurning(2000);
        }
        mAdapter.addHeaderView(headerView);


    }

    private void setMenuListener(final BaseViewHolder helper) {

        imageViews = new ArrayList<>();
        ImageView iv = helper.getView(R.id.iv_menu);
        ImageView iv1 = helper.getView(R.id.iv_menu1);
        ImageView iv2 = helper.getView(R.id.iv_menu2);
        ImageView iv3 = helper.getView(R.id.iv_menu3);
        imageViews.add(iv1);
        imageViews.add(iv2);
        imageViews.add(iv3);

        Boolean isShowing = list_isShow.get(helper.getPosition()-1).isShow();
        LogUtils.a("==="+(helper.getPosition()-1)+" "+list_isShow.get(helper.getPosition()-1).isShow());
        if (isShowing) {
            sectorShowMenu(iv,imageViews);
        } else {
            sectorCloseMenu(iv,imageViews);
        }

        helper.setOnClickListener(R.id.iv_menu, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isShowing = list_isShow.get(helper.getPosition()-1).isShow();
                LogUtils.a("---"+(helper.getPosition()-1)+" "+list_isShow.get(helper.getPosition()-1).isShow());
                if (null == isShowing || isShowing == false) {
                    list_isShow.get(helper.getPosition()-1).setShow(true);
                    showSectorMenu(v,imageViews);
                } else {
                    list_isShow.get(helper.getPosition()-1).setShow(false);
                    closeSectorMenu(v,imageViews);
                }
            }
        });

        helper.setOnClickListener(R.id.iv_menu1, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        helper.setOnClickListener(R.id.iv_menu2, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        helper.setOnClickListener(R.id.iv_menu3, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if(convenientBanner!=null && !convenientBanner.isTurning()) {
            convenientBanner.startTurning(2000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(convenientBanner!=null){
            convenientBanner.stopTurning();
        }

    }

    /**
     * 显示菜单
     */
    private void showSectorMenu(View v , List<ImageView> imageViews) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, 45);
        objectAnimator.setDuration(500);
        objectAnimator.start();
        /***第一步，遍历所要展示的菜单ImageView*/
        for (int i = 0; i < imageViews.size(); i++) {

            PointF point = new PointF();
            point.x = - radius1 * (i+1);
            /**
             * 第一个参数代表要操作的对象
             * 第二个参数代表要操作的对象的属性
             * 第三个参数代表要操作的对象的属性的起始值
             * 第四个参数代表要操作的对象的属性的终止值
             */
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", 0, point.x);
            /**设置动画时长**/
            objectAnimatorX.setDuration(500);
            /**开始播放动画**/
            objectAnimatorX.start();
        }
    }

    private void sectorShowMenu(View v , List<ImageView> imageViews) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 0, 45);
        objectAnimator.setDuration(10);
        objectAnimator.start();

        /***第一步，遍历所要展示的菜单ImageView*/
        for (int i = 0; i < imageViews.size(); i++) {

            PointF point = new PointF();
            point.x = - radius1 * (i+1);
            /**
             * 第一个参数代表要操作的对象
             * 第二个参数代表要操作的对象的属性
             * 第三个参数代表要操作的对象的属性的起始值
             * 第四个参数代表要操作的对象的属性的终止值
             */
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", 0, point.x);
            /**设置动画时长**/
            objectAnimatorX.setDuration(10);
            /**开始播放动画**/
            objectAnimatorX.start();

        }
    }

    /**
     * 关闭菜单
     */
    private void closeSectorMenu(View v,List<ImageView> imageViews) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 45, 0);
        objectAnimator.setDuration(500);
        objectAnimator.start();

        for (int i = 0; i < imageViews.size(); i++) {
            PointF point = new PointF();
            point.x = - radius1 * i;
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", point.x, 0);

            objectAnimatorX.setDuration(500);

            objectAnimatorX.start();

        }
    }

    private void sectorCloseMenu(View v,List<ImageView> imageViews) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", 45, 0);
        objectAnimator.setDuration(10);
        objectAnimator.start();

        for (int i = 0; i < imageViews.size(); i++) {

            PointF point = new PointF();
            point.x = - radius1 * i;
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", point.x, 0);

            objectAnimatorX.setDuration(10);

            objectAnimatorX.start();
        }
    }
}
