package com.mvp.view.avtivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.base.BaseActivity;
import com.mvp.model.utils.LogUtils;
import com.mvp.model.utils.ToastUtils;
import com.mvp.presenter.MainPresenter;
import com.mvp.view.fragment.RecommendFragment;
import com.mvp.view.fragment.SatinFragment;
import com.mvp.view.fragment.VideoFragment;
import com.mvp.view.iview.MainView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.tbar)
    Toolbar mTbar;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.lin_left)
    LinearLayout left;
    @BindView(R.id.lin_right)
    LinearLayout right;
    @BindView(R.id.fragment_main)
    FrameLayout mFragmentMain;
    @BindView(R.id.rbRecom)
    RadioButton mRbRecom;
    @BindView(R.id.rbSatin)
    RadioButton mRbSatin;
    @BindView(R.id.rbVideo)
    RadioButton mRbVideo;
    @BindView(R.id.ivLeft)
    ImageView mIvLeft;
    @BindView(R.id.ivRight)
    ImageView mIvRight;
    @BindView(R.id.ivAvatar)
    CircleImageView mIvAvatar;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;
    @BindView(R.id.tvFollow)
    TextView mTvFollow;
    @BindView(R.id.tvFans)
    TextView mTvFans;
    @BindView(R.id.tvNiuBi)
    TextView mTvNiuBi;
    @BindView(R.id.tvSeed)
    TextView mTvSeed;
    @BindView(R.id.tvRecharge)
    TextView mTvRecharge;
    @BindView(R.id.tvStarLight)
    TextView mTvStarLight;
    @BindView(R.id.tvContribution)
    TextView mTvContribution;
    @BindView(R.id.tvWatch)
    TextView mTvWatch;
    @BindView(R.id.tvLevel)
    TextView mTvLevel;
    @BindView(R.id.tvTask)
    TextView mTvTask;
    @BindView(R.id.tvGame)
    TextView mTvGame;
    @BindView(R.id.tvSetting)
    TextView mTvSetting;
    @BindView(R.id.srl)
    SwipeRefreshLayout mSrl;
    private boolean isExit;
    private ActionBarDrawerToggle mDrawerToggle;

    private RecommendFragment mRecommendFragment;
    private SatinFragment mSatinFragment;
    private VideoFragment mVideoFragment;


    @Override
    public void onSucceed(Object object) {
    }

    @Override
    public void onFail(String str) {
        LogUtils.a(str);
        ToastUtils.showToast(mContext, str);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected void initDatas() {

        setTbar();

        if (mRecommendFragment == null) {
            mRecommendFragment = new RecommendFragment();
        }
        showFragment(mRecommendFragment, R.id.fragment_main);

    }

    private void setTbar() {

        mTbar.setTitle("推荐");
        mTbar.setTitleMarginStart(170);
        mTbar.setBackgroundColor(Color.parseColor("#E44D40"));
        setSupportActionBar(mTbar);
        mTbar.setOnMenuItemClickListener(onMenuItemClick);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDl, mTbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };

        mDrawerToggle.syncState();
        //设置侧滑菜单的点击图片  及取消默认图片
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mTbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        // 取消默认后  增加点击事件
        mTbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDl.openDrawer(GravityCompat.START);
            }
        });

        mDl.setDrawerListener(mDrawerToggle);
        //   从新 绘制侧滑页面 实现推动主页的效果
        mDl.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                right.layout(left.getRight(), 0, left.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (!isExit) {
            ToastUtils.showToast(mContext, R.string.press_again_to_exit);
            isExit = true;
            EventBus.getDefault().post(isExit);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        isExit = false;
    }


    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.action_share:
                    ToastUtils.showToast(mContext, "点击了action_share");
                    // TODO: 2017/7/21  发表页面
                    startActivity(UpLoadActivity.class);
                    break;
            }

            return true;
        }


    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_left; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //  推荐   段子  视频
    @OnClick({R.id.rbRecom, R.id.rbSatin, R.id.rbVideo ,R.id.ivAvatar, R.id.btnLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbRecom:
                if (mRecommendFragment == null) {
                    mRecommendFragment = new RecommendFragment();
                }
                showFragment(mRecommendFragment, R.id.fragment_main);
                break;
            case R.id.rbSatin:
                if (mSatinFragment == null) {
                    mSatinFragment = new SatinFragment();
                }
                showFragment(mSatinFragment, R.id.fragment_main);
                break;
            case R.id.rbVideo:
                if (mVideoFragment == null) {
                    mVideoFragment = new VideoFragment();
                }
                showFragment(mVideoFragment, R.id.fragment_main);
                break;
            case R.id.ivAvatar:
                    startActivity(LoginActivity.class);
                break;
            case R.id.btnLogin:
                     startActivity(LoginActivity.class);
                break;
        }
    }





}
