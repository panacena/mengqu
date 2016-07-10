package zkk.com.mengqu.commit.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.base.activity.BaseActivity;
import zkk.com.mengqu.commit.adapter.PaintListviewAdapter;
import zkk.com.mengqu.commit.bean.PaintHeadBean;
import zkk.com.mengqu.commit.bean.ReplyBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class PaintActivity extends BaseActivity{

    private ListView listView;
    List<ReplyBean.DataBean> paintBeens=new ArrayList<ReplyBean.DataBean>();
    private PaintListviewAdapter paintAdapter;
    private Context context;
    private ImageView comic_user_img;
    private ImageView comic_bg,iv_paint_like;
    private Button like_btn;
    private TextView tv_paint_title,tv_paint_time;
    private  String id;
    private  Integer type;
    Observer<ReplyBean> observer=new Observer<ReplyBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(ReplyBean result) {

            paintBeens.clear();
            if(result.getData()!=null&&!"".equals(result.getData())){
                paintBeens.addAll(result.getData());
                paintAdapter.notifyDataSetChanged();
            }

        }
    };



    Observer<PaintHeadBean> observer2=new Observer<PaintHeadBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(PaintHeadBean result) {


            ViewGroup.LayoutParams layoutParams=comic_bg.getLayoutParams();
            layoutParams.height= Utils.getScreenHeight(context)*3/5;
            comic_bg.setLayoutParams(layoutParams);

            Log.d("cal---",result.getData()==null?"kong":"not kong"+result.getData().getContent());
            MyglideImageView.setRoundImg(context,comic_user_img,result.getData().getAvatar());
            MyglideImageView.setImg(context,comic_bg,result.getData().getPicture());
            tv_paint_title.setText(result.getData().getContent());
            tv_paint_time.setText(Utils.getRefreshTimeText(result.getData().getCreateTime()+""));
            like_btn.setText(result.getData().getLikedNum()+"");
        }
    };


    public static PaintActivity newInstance(){

        PaintActivity gameInfoFragment=new PaintActivity();
        return gameInfoFragment;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        context=this;
        Bundle bundle=getIntent().getExtras();
        id=bundle.getString("id");
        type=bundle.getInt("type");

        Log.d("cal---","id"+id+"type"+type);
        init();
    }

    private  void  init(){
        View  view= LayoutInflater.from(context).inflate(R.layout.item_paintitem,null);
        listView=(ListView)findViewById(R.id.lv_paint_activity);
        listView.addHeaderView(view);

        comic_user_img=(ImageView) view.findViewById(R.id.comic_user_img);
        comic_bg=(ImageView)view.findViewById(R.id.comic_bg);
        iv_paint_like=(ImageView)view.findViewById(R.id.iv_paint_like);

        tv_paint_title=(TextView) view.findViewById(R.id.tv_paint_title);
        tv_paint_time=(TextView)view.findViewById(R.id.tv_paint_time);
        like_btn=(Button) view.findViewById(R.id.like_btn);

        paintAdapter=new PaintListviewAdapter(context,paintBeens);
        listView.setAdapter(paintAdapter);
        if(type==3){
            getAppIndexData3(id,0);
        }else{
            getAppIndexData(id,0);
        }

        getAppIndexData2(type,id);
    }
    @Override
    public void setContentView(int paramInt) {
        super.setContentView(paramInt);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void getAppIndexData(String dataType,int pageNo3){

        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getleaderboard(dataType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }


    private void getAppIndexData3(String dataType,int pageNo3){

        MengquApi.getInstance().getSharedetail(dataType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }

    private void getAppIndexData2(int types,String ids){

        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getInstance().getcomment(types+"",ids,"0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
