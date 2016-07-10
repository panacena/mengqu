package zkk.com.mengqu.imagslists.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.multithreaddownload.CallBack;
import com.aspsine.multithreaddownload.DownloadException;
import com.aspsine.multithreaddownload.DownloadManager;
import com.aspsine.multithreaddownload.DownloadRequest;
import com.bm.library.PhotoView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.GridViewWithHeaderAndFooter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zkk.com.mengqu.R;
import zkk.com.mengqu.imagslists.adapter.ImagesListsAdapter;
import zkk.com.mengqu.imagslists.bean.ImagsListBean;
import zkk.com.mengqu.retrofit2.api.MengquApi;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class ImagesListsActivity extends AppCompatActivity  implements View.OnClickListener{

    private GridViewWithHeaderAndFooter gridViewWithHeaderAndFooter;
    private ImagesListsAdapter gameLiveAdapter;
    private Context context;
    private  int pageNo3item=1;
    private View headerView;
    private ImageView iv_cover;
    ImagsListBean liveBeens=new ImagsListBean();
    private PopupWindow bigImagePopup;
    private ViewPager popupPhotoPager;
    private  PhotsPagesAdapter  myPagesAdapter;
    private View view;
    private  ImageView iv_down;
    private TextView tv_down,tv_itemall;
    private  TextView tv_num_info;
    Observer<ImagsListBean> observer=new Observer<ImagsListBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(context,"fail", Toast.LENGTH_SHORT).show();
            Log.d("zkk---","错误-"+e);
        }

        @Override
        public void onNext(ImagsListBean result) {
            liveBeens=result;
           // gameLiveAdapter.notifyDataSetChanged();
            gameLiveAdapter=new ImagesListsAdapter(liveBeens,context);
            gridViewWithHeaderAndFooter.setAdapter(gameLiveAdapter);
            MyglideImageView.setImg(context,iv_cover,liveBeens.getCoverImage());
            gameLiveAdapter.setItemclick(new ImagesListsAdapter.Itemclick() {
                @Override
                public void setMyOnitemclick(int poistions) {

                    showBigPopup(poistions);
                }
            });
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        context=this;
        Bundle bundle=getIntent().getExtras();
        pageNo3item=bundle.getInt("id");
        Log.d("zkk---","onCreate---pageNo3item"+pageNo3item);
        gridViewWithHeaderAndFooter=(GridViewWithHeaderAndFooter)findViewById(R.id.gv_photos);
        getAppIndexData(0,pageNo3item);

        headerView = LayoutInflater.from(context).inflate(R.layout.imglist_header, null);
        iv_cover=(ImageView)headerView.findViewById(R.id.iv_cover);
        gridViewWithHeaderAndFooter.addHeaderView(headerView);
        iv_down=(ImageView)findViewById(R.id.iv_down);
        tv_down=(TextView)findViewById(R.id.tv_down);
        tv_itemall=(TextView)findViewById(R.id.tv_itemall);

        iv_down.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_down:
                for(int i=0;i<liveBeens.getImages().size();i++){
                    Log.d("zkk",liveBeens.getImages().get(i).toString());
                    download(liveBeens.getTitle()+"--"+i,liveBeens.getImages().get(i).toString(),i);
                }
                break;
        }
    }

    /**
     * Dir: /Download
     */
    private final File mDownloadDir = new File(Environment.getExternalStorageDirectory()+"/"+"mengqu");
    private void download(String tag,String url,int nowdown) {
        if(!mDownloadDir.exists()){
            try {
                mDownloadDir.mkdir();
            }catch (Exception e){
                e.printStackTrace();
            }
        }final File mDownloadDironw=new File(mDownloadDir+"/"+liveBeens.getFileName());
        if(!mDownloadDironw.exists()){
            try {
                mDownloadDironw.mkdir();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        tv_itemall.setText("初始化中--");
        tv_itemall.setVisibility(View.VISIBLE);
        final DownloadRequest request = new DownloadRequest.Builder()
                .setTitle(tag+".png")
                .setUri(url)
                .setFolder(mDownloadDironw)
                .build();

        DownloadManager.getInstance().download(request, tag, new DownloadCallback(nowdown));
    }

    private  int hasDown=1;
    class DownloadCallback implements CallBack{
        private int mPosition;
        public DownloadCallback(int position) {
            mPosition = position;
        }

        @Override
        public void onStarted() {
        }

        @Override
        public void onConnecting() {

        }

        @Override
        public void onConnected(long total, boolean isRangeSupport) {

        }

        @Override
        public void onProgress(long finished, long total, int progress) {
            String downloadPerSize = Utils.getDownloadPerSize(finished, total);
            tv_down.setText(downloadPerSize);
            tv_down.setVisibility(View.VISIBLE);

            String downloadPer= Utils.getDownloadPer(hasDown,liveBeens.getImages().size());
            tv_itemall.setText(downloadPer);
            tv_itemall.setVisibility(View.VISIBLE);
        }

        @Override
        public void onCompleted() {
            hasDown=hasDown+1;
            Log.d("zkk","success");
            tv_down.setVisibility(View.GONE);
            tv_itemall.setVisibility(View.GONE);
        }

        @Override
        public void onDownloadPaused() {

        }

        @Override
        public void onDownloadCanceled() {

        }

        @Override
        public void onFailed(DownloadException e) {
            e.printStackTrace();
            Log.d("zkk","fail");
        }
    }


    /**
     * 展示大图
     * @param paramInt
     */
    public void showBigPopup(int paramInt){

        View localView = null;
        if (bigImagePopup!=null){
            bigImagePopup.dismiss();
            bigImagePopup=null;
        }
        localView = LayoutInflater.from(context).inflate(R.layout.pop_beautypics, null);
        bigImagePopup = new PopupWindow(localView, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT,false);
        bigImagePopup.setTouchable(true);
        localView.setClickable(true);
       // bigImagePopup.setAnimationStyle(R.style.photosWindowAnimation);

        bigImagePopup.setBackgroundDrawable(new BitmapDrawable());
        bigImagePopup.setFocusable(true);
        bigImagePopup.setOutsideTouchable(true);

        popupPhotoPager = ((ViewPager)localView.findViewById(R.id.poiPhotoPager));
        popupPhotoPager.setOffscreenPageLimit(1);
        localView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                if (arg1 == KeyEvent.KEYCODE_BACK){
                    if(bigImagePopup != null) {
                        bigImagePopup.dismiss();
                        bigImagePopup=null;
                    }
                }
                return false;
            }
        });

        myPagesAdapter=new PhotsPagesAdapter(liveBeens);
        popupPhotoPager.setAdapter(myPagesAdapter);
        popupPhotoPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        popupPhotoPager.setCurrentItem(paramInt, false);
        bigImagePopup.showAtLocation(headerView, 83, 0, 0);

    }


    private void getAppIndexData(int dataType,int pageNo3){

        //lastId=0&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=1.7&os=a&channel=
        MengquApi.getInstance().getimageList(pageNo3+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }






    class PhotsPagesAdapter extends PagerAdapter {

        private ImagsListBean mBigPoiImageList;
        private int size2;
        private LayoutInflater mInflater;
        private List<View> views = new ArrayList<View>();
        public PhotsPagesAdapter(ImagsListBean arrayLists){

            mBigPoiImageList=arrayLists;
            mInflater = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));

            for (int i = 0; i < 3; i++){
                View localView = this.mInflater.inflate(R.layout.image_detail, null);
                this.views.add(localView);
            }

            size2 =views.size();

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mBigPoiImageList.getImages()==null?0:mBigPoiImageList.getImages().size();
        }

        @Override
        public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
            View localView = getViewAt(paramInt);
            PhotoView  localPhotoView = (PhotoView)localView.findViewById(R.id.layout_shareView);

            ProgressBar tv_num_info=(ProgressBar)localView.findViewById(R.id.tv_num_info);

            tv_num_info.setVisibility(View.VISIBLE);


            // 启用图片缩放功能
            localPhotoView.enable();
            if (paramViewGroup.indexOfChild(localView) >= 0){
                paramViewGroup.removeView(localView);
            }
            MyglideImageView.setTextImg(context,localPhotoView,mBigPoiImageList.getImages().get(paramInt).toString()
                    +"?imageMogr2/thumbnail/!42p",tv_num_info);

            localView.setTag(Integer.valueOf(paramInt));

            paramViewGroup.addView(localView);
            return localView;
        }


        @Override
        public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject){

            View localView = getViewAt(paramInt);
            if ((localView != null) && (paramViewGroup != null)){
                if (((Integer)localView.getTag()).intValue() == paramInt){
                    paramViewGroup.removeView(localView);
                }
                System.gc();
            }
        }

        public View getViewAt(int paramInt){
            return (View)views.get(paramInt % this.size2);
        }


        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }


    }
}