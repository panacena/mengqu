package zkk.com.mengqu.commit.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;
import zkk.com.mengqu.commit.activity.PaintActivity;
import zkk.com.mengqu.commit.bean.ShareBean;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class ShareAdapter extends BaseAdapter {

    private static final int TYPE_DATE = 0;//带日期
    private static final int TYPE_NOTDATE = 1;//不带日期
    private List<ShareBean.DataBean> shares=new ArrayList<ShareBean.DataBean>();

    private Context context;
    public ShareAdapter(List<ShareBean.DataBean> paint, Context con) {
        this.shares = paint;
        this.context=con;
    }

    @Override
    public int getCount() {
        return shares==null?0:shares.size();
    }

    @Override
    public Object getItem(int position) {
        return shares.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ShareBean.DataBean dataBean =shares.get(position);
        MyPaintHolder myPaintHolder;
            if(convertView==null){
                myPaintHolder=new MyPaintHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.item_commic_daily,null);
                myPaintHolder.comic_name=(TextView)convertView.findViewById(R.id.comic_name);
                myPaintHolder.comic_title=(TextView)convertView.findViewById(R.id.comic_title);
                myPaintHolder.tv_comment=(TextView)convertView.findViewById(R.id.tv_comment);
                myPaintHolder.tv_likenum=(TextView)convertView.findViewById(R.id.tv_likenum);
                myPaintHolder.btn_category=(TextView)convertView.findViewById(R.id.btn_category);

                //comic_img_share,img_user_share,iv_like_share,btn_category
                myPaintHolder.comic_img_share=(ImageView) convertView.findViewById(R.id.comic_img_share);
                myPaintHolder.img_user_share=(ImageView) convertView.findViewById(R.id.img_user_share);
                myPaintHolder.iv_like_share=(ImageView) convertView.findViewById(R.id.iv_like_share);
                convertView.setTag(myPaintHolder);
            }else{
                myPaintHolder=(MyPaintHolder)convertView.getTag();
            }

            ViewGroup.LayoutParams layoutParams=myPaintHolder.comic_img_share.getLayoutParams();
            layoutParams.height= Utils.getScreenHeight(context)*3/5;
            myPaintHolder.comic_img_share.setLayoutParams(layoutParams);


            myPaintHolder.comic_name.setText(dataBean.getNickname());
            myPaintHolder.comic_title.setText(dataBean.getContent());
            myPaintHolder.tv_comment.setText(dataBean.getComments()+"");
            myPaintHolder.tv_likenum.setText(dataBean.getLikedNum()+"");
              MyglideImageView.setRoundImg(context,myPaintHolder.img_user_share,dataBean.getAvatar());
            Log.d("zkk--","----"+dataBean.getAvatar());
            MyglideImageView.setImg(context,myPaintHolder.comic_img_share,dataBean.getPicture());

            if(dataBean.getLiked()==1){
                MyglideImageView.setLocalImg(context,myPaintHolder.iv_like_share,R.drawable.liked_red2x);
            }else{
                MyglideImageView.setLocalImg(context,myPaintHolder.iv_like_share,R.drawable.liked_gray2x);
            }
            myPaintHolder.btn_category.setVisibility(View.GONE);


            myPaintHolder.comic_img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PaintActivity.class);
                intent.putExtra("id",dataBean.getId()+"");
                intent.putExtra("type",3);
                context.startActivity(intent);
            }});

        return convertView;
    }

    class MyPaintHolder{

        ImageView img_user_share;
        TextView comic_name,comic_title,tv_comment,tv_likenum,btn_category;
        ImageView comic_img_share,iv_like_share;
    }

}
