package zkk.com.mengqu.theme.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.theme.adapter.ThemeListsAdapter;
import zkk.com.mengqu.theme.bean.ThemeItemBena;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class ThemeItemActivity extends AppCompatActivity  {

    private ListView listView;
    private ThemeListsAdapter themeListsAdapter;
    private Context context;
    private  int pageNo3item=1;
    ThemeItemBena liveBeens=new ThemeItemBena();

    Observer<ThemeItemBena> observer=new Observer<ThemeItemBena>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(ThemeItemBena result) {
            liveBeens=result;
            themeListsAdapter=new ThemeListsAdapter(liveBeens,context);
            listView.setAdapter(themeListsAdapter);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        Bundle bundle=getIntent().getExtras();
        listView=(ListView)findViewById(R.id.expandableListView);
        pageNo3item=bundle.getInt("themeId");
        Log.d("zkk","onCreate"+pageNo3item);
        getAppIndexData(pageNo3item,pageNo3item);
    }


    //http://api.moeju.cn/Picture/themePicture?themeId=19&lastId=0&lastTime=0
    private void getAppIndexData(int dataType, int pageNo3){
        MengquApi.getInstance().getthemePicture(dataType+"","0","0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}