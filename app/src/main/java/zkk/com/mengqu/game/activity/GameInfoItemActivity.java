package zkk.com.mengqu.game.activity;

import android.content.Context;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.base.activity.BaseActivity;
import zkk.com.mengqu.game.bean.InfoHtmlBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GameInfoItemActivity extends BaseActivity {


    private PullToZoomScrollViewEx scrollViewEx;
    private Context context;
    private ImageView iv_zoom;
    private TextView tv_time;
    private TextView tv_type;
    private WebView content_webview;
    private String id;

    Observer<InfoHtmlBean> observer=new Observer<InfoHtmlBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("zkk---","错误-"+e);
        }


        @Override
        public void onNext(InfoHtmlBean result) {
            Log.d("zkk---","onNext"+result.getData().getContent());

            String CSS_STYPE = "<head><style>img{max-width:340px !important;}</style></head>" +
                    " <h3><b>"+result.getData().getTitle()+"</b></h3> \n";

            MyglideImageView.setImg(context,iv_zoom,result.getData().getCoverImage());
            tv_time.setText(Utils.getDate(Long.parseLong(result.getData().getTime())));
         //   MyglideImageView.setImg(context,content_webview,result.getData().getCoverImage());
            tv_type.setText(result.getData().getCategory());
            content_webview.loadDataWithBaseURL("about:blank",CSS_STYPE+result.getData().getContent(), "text/html", "utf-8", null);
           // content_webview.loadData(fmtString(result.getData().getContent()), "text/html", "utf-8");
           // content_webview.loadUrl("http://www.baidu.com");

            //.loadUrl("http://www.baidu.com");
        }
    };


    private String fmtString(String str){
        String notice = "";
        try{
            notice = URLEncoder.encode(str, "utf-8");
        }catch(UnsupportedEncodingException ex){
        }
        return notice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_scroll_view);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context=this;
        scrollViewEx=(PullToZoomScrollViewEx)findViewById(R.id.scroll_view);

        Bundle bundle=getIntent().getExtras();
        id=bundle.getString("id");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollViewEx.setHeaderLayoutParams(localObject);
        scrollViewEx.setZoomEnabled(true);
        View view= LayoutInflater.from(context).inflate(R.layout.activity_info_detail,null,false);
        View view2= LayoutInflater.from(context).inflate(R.layout.profile_zoom_view,null,false);

        scrollViewEx.setZoomView(view2);
        scrollViewEx.setScrollContentView(view);

        iv_zoom=(ImageView)view2.findViewById(R.id.iv_zoom);
        tv_time=(TextView)view.findViewById(R.id.tv_time);
        tv_type=(TextView)view.findViewById(R.id.tv_type);
        content_webview=(WebView) view.findViewById(R.id.content_webview2);


        this.content_webview.getSettings().setSupportZoom(false);
        this.content_webview.getSettings().setJavaScriptEnabled(true);
        this.content_webview.getSettings().setDomStorageEnabled(true);
       // content_webview.getSettings().setLoadsImagesAutomatically(false);
        content_webview.setWebViewClient(new WebViewClient(){
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });




        getAppIndexData(id,0);
    }

    private void getAppIndexData(String dataType,int pageNo3){
        //http://www.moeju.cn/api//newsdetail?id=751426&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
        MengquApi.getwwwInstance().getnewsdetail(dataType+"","5ed40069e20354be","~68EECA63-0FB4-1EB8-628D-CDCF663CEB41")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
