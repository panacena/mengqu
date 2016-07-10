package zkk.com.mengqu.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.home.adapter.HomeThemeAdapter;
import zkk.com.mengqu.home.bean.HomeThemeBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class HomeThemeFragment extends Fragment {

    private GridView gridView;
    private HomeThemeAdapter homeThemeAdapter;
    private Context context;
    private  int pageNo3item=1;
    List<HomeThemeBean.DataBean> liveBeens=new ArrayList<HomeThemeBean.DataBean>();

    Observer<HomeThemeBean> observer=new Observer<HomeThemeBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(HomeThemeBean result) {

            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);
            if(strJson!=null&&!"".equals(strJson)
                    &&strJson.equals(SharePreferences.getInstance(context).getHomeTheme())){
                SharePreferences.getInstance(context).setHomeTheme(strJson);
                return ;
            }
            SharePreferences.getInstance(context).setHomeTheme(strJson);
            liveBeens.addAll(result.getData());
            homeThemeAdapter.notifyDataSetChanged();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmeng_theme_content,null);
        context=getActivity();
        gridView=(GridView) view.findViewById(R.id.gv_list);
        homeThemeAdapter=new HomeThemeAdapter(liveBeens,context);
        gridView.setAdapter(homeThemeAdapter);

        liveBeens.clear();
        getAppIndexData(0,pageNo3item);
        return view;
    }



    private void getAppIndexData(int dataType,int pageNo3){


        if(!Utils.isNull(SharePreferences.getInstance(context).getHomeTheme())){
            Gson gson = new Gson();
            HomeThemeBean list = gson.fromJson(SharePreferences.getInstance(context).getHomeTheme(),HomeThemeBean.class );
            liveBeens.addAll(list.getData());
            homeThemeAdapter.notifyDataSetChanged();
        }

        //lastId=0&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=1.7&os=a&channel=
        MengquApi.getInstance().getHometheme("5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}