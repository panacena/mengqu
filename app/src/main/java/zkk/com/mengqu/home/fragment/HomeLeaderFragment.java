package zkk.com.mengqu.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.home.adapter.HomeLeaderAdapter;
import zkk.com.mengqu.home.bean.HomeitemBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.simplepreferences.SharePreferences;
import zkk.com.mengqu.util.Utils;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class HomeLeaderFragment extends Fragment {

    private ListView listView;
    private HomeLeaderAdapter gameLiveAdapter;
    private Context context;
    private  int pageNo3item=1;
    List<HomeitemBean.DataBean> liveBeens=new ArrayList<HomeitemBean.DataBean>();

    Observer<HomeitemBean> observer=new Observer<HomeitemBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(HomeitemBean result) {
            String strJson = "";
            Gson gson = new Gson();
            strJson = gson.toJson(result);
            if(strJson!=null&&!"".equals(strJson)
                    &&strJson.equals(SharePreferences.getInstance(context).getHomeLeader())){
                SharePreferences.getInstance(context).setHomeLeader(strJson);
                return ;
            }
            SharePreferences.getInstance(context).setHomeLeader(strJson);

            liveBeens.clear();
            liveBeens.addAll(result.getData());
            gameLiveAdapter.notifyDataSetChanged();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_leaderhome,null);
        context=getActivity();
        listView=(ListView) view.findViewById(R.id.expandableListView);
        gameLiveAdapter=new HomeLeaderAdapter(liveBeens,context);
        listView.setAdapter(gameLiveAdapter);

        liveBeens.clear();
        getAppIndexData(0,pageNo3item);
        return view;
    }



    private void getAppIndexData(int dataType,int pageNo3){

        if(!Utils.isNull(SharePreferences.getInstance(context).getHomeLeader())){
            Gson gson = new Gson();
            HomeitemBean  list = gson.fromJson(SharePreferences.getInstance(context).getHomeLeader(),HomeitemBean.class );
            liveBeens.addAll(list.getData());
            gameLiveAdapter.notifyDataSetChanged();
        }

///http://www.moeju.cn/api/leaderboard?dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getwwwInstance().getHomeleaderboard("5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41"
        ,"2.1.0","a","Xiaomi")
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