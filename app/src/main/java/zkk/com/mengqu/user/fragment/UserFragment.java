package zkk.com.mengqu.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;
import zkk.com.mengqu.news.adapter.NewsAdapter;
import zkk.com.mengqu.news.bean.NewsItemBean;
import zkk.com.mengqu.simplepreferences.SharePreferences;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class UserFragment extends Fragment{

    private  View view;
    List<NewsItemBean> newsItemBeen=new ArrayList<NewsItemBean>();
    private NewsAdapter newsAdapter;
    private Context context;
    private LinearLayout ll_clear;


    public static UserFragment newInstance(){

        UserFragment gameInfoFragment=new UserFragment();
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_user,container,false);
        context=getActivity();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private  void  init(){
        ll_clear=(LinearLayout)view.findViewById(R.id.ll_clear);
        ll_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePreferences.getInstance(context).clear(context);
            }
        });



    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
}
