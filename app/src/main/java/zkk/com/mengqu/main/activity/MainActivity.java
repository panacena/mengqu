package zkk.com.mengqu.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import zkk.com.mengqu.R;
import zkk.com.mengqu.base.activity.BaseActivity;
import zkk.com.mengqu.commit.fragment.CommitVageFragment;
import zkk.com.mengqu.game.fragment.GameFragment;
import zkk.com.mengqu.home.activity.TabLayoutActivity;
import zkk.com.mengqu.news.fragment.NewsFragment;
import zkk.com.mengqu.user.fragment.UserFragment;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private FragmentManager fm;
    private FragmentTransaction ft;
    private LinearLayout ll_picture,ll_game,ll_daily,ll_info,ll_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    private void initView(){
        ll_picture=(LinearLayout)findViewById(R.id.ll_picture);
        ll_game=(LinearLayout)findViewById(R.id.ll_game);
        ll_daily=(LinearLayout)findViewById(R.id.ll_daily);
        ll_info=(LinearLayout)findViewById(R.id.ll_info);
        ll_user=(LinearLayout)findViewById(R.id.ll_user);
        fm=getSupportFragmentManager();

        ll_picture.setOnClickListener(this);
        ll_game.setOnClickListener(this);
        ll_daily.setOnClickListener(this);
        ll_info.setOnClickListener(this);
        ll_user.setOnClickListener(this);

        change_main_picture();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_picture:
                change_main();
                ll_picture.setSelected(true);
                ll_game.setSelected(false);
                ll_daily.setSelected(false);
                ll_info.setSelected(false);
                ll_user.setSelected(false);
                break;
            case R.id.ll_game:
                change_main_game();
                ll_picture.setSelected(false);
                ll_game.setSelected(true);
                ll_daily.setSelected(false);
                ll_info.setSelected(false);
                ll_user.setSelected(false);
                break;
            case R.id.ll_daily:

                change_main_commit();
                ll_picture.setSelected(false);
                ll_game.setSelected(false);
                ll_daily.setSelected(true);
                ll_info.setSelected(false);
                ll_user.setSelected(false);
                break;
            case R.id.ll_info:
                change_main_news();
                ll_picture.setSelected(false);
                ll_game.setSelected(false);
                ll_daily.setSelected(false);
                ll_info.setSelected(true);
                ll_user.setSelected(false);
                break;
            case R.id.ll_user:

                change_main_user();
                ll_picture.setSelected(false);
                ll_game.setSelected(false);
                ll_daily.setSelected(false);
                ll_info.setSelected(false);
                ll_user.setSelected(true);
                break;
        }
    }

    private Fragment fromFrament;
    private TabLayoutActivity frament;
    private GameFragment videoframent;
    private NewsFragment newsFragment;
    private CommitVageFragment commitVageFragment;
    private UserFragment userFragment;
    private void change_main_picture(){
        ll_picture.setSelected(true);
        ft=fm.beginTransaction();
        if(frament==null){
            frament=new TabLayoutActivity();
            fromFrament=frament;
        }
        ft.replace(R.id.frameContent, frament);
        ft.commit();
    }


    private void change_main(){
        ll_picture.setSelected(true);
        ft = fm.beginTransaction();
        if(frament==null){
            frament=new TabLayoutActivity();
        }
        if (!frament.isAdded()) {    // 先判断是否被add过
            ft.hide(fromFrament).add(R.id.frameContent, frament).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            ft.hide(fromFrament).show(frament).commit(); // 隐藏当前的fragment，显示下一个
        }
        fromFrament=frament;
    }


    private void change_main_commit(){
        ll_game.setSelected(true);
        ft = fm.beginTransaction();
        if(commitVageFragment==null){
            commitVageFragment=new CommitVageFragment();
        }
        if (!commitVageFragment.isAdded()) {    // 先判断是否被add过
            ft.hide(fromFrament).add(R.id.frameContent, commitVageFragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            ft.hide(fromFrament).show(commitVageFragment).commit(); // 隐藏当前的fragment，显示下一个
        }
        fromFrament=commitVageFragment;
    }

    /**
     *
     */
    private void change_main_game(){
        ll_game.setSelected(true);
        ft = fm.beginTransaction();
        if(videoframent==null){
            videoframent=new GameFragment();
        }
        if (!videoframent.isAdded()) {    // 先判断是否被add过
            ft.hide(fromFrament).add(R.id.frameContent, videoframent).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            ft.hide(fromFrament).show(videoframent).commit(); // 隐藏当前的fragment，显示下一个
        }
        fromFrament=videoframent;
    }


    private void change_main_news(){
        ll_info.setSelected(true);
        ft = fm.beginTransaction();
        if(newsFragment==null){
            newsFragment=new NewsFragment();
        }
        if (!newsFragment.isAdded()) {    // 先判断是否被add过
            ft.hide(fromFrament).add(R.id.frameContent, newsFragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            ft.hide(fromFrament).show(newsFragment).commit(); // 隐藏当前的fragment，显示下一个
        }
        fromFrament=newsFragment;
    }


    private void change_main_user(){
        ll_info.setSelected(true);
        ft = fm.beginTransaction();
        if(userFragment==null){
            userFragment=new UserFragment();
        }
        if (!userFragment.isAdded()) {    // 先判断是否被add过
            ft.hide(fromFrament).add(R.id.frameContent, userFragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            ft.hide(fromFrament).show(userFragment).commit(); // 隐藏当前的fragment，显示下一个
        }
        fromFrament=userFragment;
    }





    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if (keyCode == KeyEvent.KEYCODE_BACK) {
			/*
			 * if(mMapView!=null){ mMapView.destroy(); }
			 */
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
            return true;
        }
        // 拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
