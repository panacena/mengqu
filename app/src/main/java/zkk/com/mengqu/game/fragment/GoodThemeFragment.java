package zkk.com.mengqu.game.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.GridViewWithHeaderAndFooter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.game.adapter.GoodThemeAdapter;
import zkk.com.mengqu.game.bean.GoodThemeBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GoodThemeFragment extends Fragment{

    private  View view;
    private GridViewWithHeaderAndFooter gridViewWithHeaderAndFooter;
    List<GoodThemeBean> goodThemeBeen=new ArrayList<GoodThemeBean>();
    private GoodThemeAdapter goodThemeAdapter;
    private Context context;
    List<GoodThemeBean.DataBean> lists=new ArrayList<GoodThemeBean.DataBean>();



    Observer<GoodThemeBean> observer=new Observer<GoodThemeBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(GoodThemeBean result) {


            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);
            if(strJson!=null&&!"".equals(strJson)
                    &&strJson.equals(SharePreferences.getInstance(context).getGameTheme())){
                SharePreferences.getInstance(context).setGameTheme(strJson);
                return ;
            }
            SharePreferences.getInstance(context).setGameTheme(strJson);
            lists.addAll(result.getData());
            goodThemeAdapter.notifyDataSetChanged();
        }
    };

    public static GoodThemeFragment newInstance(){

        GoodThemeFragment gameInfoFragment=new GoodThemeFragment();
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_goodtheme,container,false);
        context=getParentFragment().getActivity();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void getAppIndexData(int dataType,int pageNo3){


        if(!Utils.isNull(SharePreferences.getInstance(context).getGameTheme())){
            Gson gson = new Gson();
            GoodThemeBean list = gson.fromJson(SharePreferences.getInstance(context).getGameTheme(),GoodThemeBean.class );
            lists.addAll(list.getData());
            goodThemeAdapter.notifyDataSetChanged();
        }

        //http://api.moeju.cn/news/more?lastId=0&lastTime=0&cat=%E6%B8%B8%E6%88%8F%E8%B5%84%E8%AE%AF
        MengquApi.getInstance().getmoreGameInfo("0","0","游戏资讯")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    private  void  init(){
        gridViewWithHeaderAndFooter=(GridViewWithHeaderAndFooter) view.findViewById(R.id.gv_super_gridview);
        goodThemeAdapter=new GoodThemeAdapter(lists,context);
        gridViewWithHeaderAndFooter.setAdapter(goodThemeAdapter);

        getAppIndexData(0,0);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
}
