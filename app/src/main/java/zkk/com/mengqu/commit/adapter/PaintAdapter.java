package zkk.com.mengqu.commit.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;
import zkk.com.mengqu.commit.activity.PaintActivity;
import zkk.com.mengqu.commit.bean.PaintBean;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class PaintAdapter extends BaseAdapter {

    private static final int TYPE_DATE = 0;//带日期
    private static final int TYPE_NOTDATE = 1;//不带日期
    private List<PaintBean.DataBean> paints=new ArrayList<PaintBean.DataBean>();

    private Context context;
    public PaintAdapter(List<PaintBean.DataBean> paint, Context con) {
        this.paints = paint;
        this.context=con;
    }

    @Override
    public int getCount() {
        return paints==null?0:paints.size();
    }

    @Override
    public Object getItem(int position) {
        return paints.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final PaintBean.DataBean dataBean =paints.get(position);
        MyPaintHolder myPaintHolder;
            if(convertView==null){
                myPaintHolder=new MyPaintHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.item_paint,null);
                myPaintHolder.comic_name=(TextView)convertView.findViewById(R.id.comic_name);
                myPaintHolder.comic_title=(TextView)convertView.findViewById(R.id.comic_title);
                myPaintHolder.img_icon=(ImageView) convertView.findViewById(R.id.comic_img_paint);
                myPaintHolder.img_user=(ImageView) convertView.findViewById(R.id.img_user_paint);
                myPaintHolder.iv_like=(ImageView) convertView.findViewById(R.id.iv_like_paint);
                myPaintHolder.like_btn=(Button) convertView.findViewById(R.id.like_btn);
                convertView.setTag(myPaintHolder);
            }else{
                myPaintHolder=(MyPaintHolder)convertView.getTag();
            }

            ViewGroup.LayoutParams layoutParams=myPaintHolder.img_icon.getLayoutParams();
            layoutParams.height= Utils.getScreenHeight(context)*3/5;
            myPaintHolder.img_icon.setLayoutParams(layoutParams);


            myPaintHolder.comic_name.setText(dataBean.getNickname());
            myPaintHolder.comic_title.setText(dataBean.getContent());
            myPaintHolder.like_btn.setText(dataBean.getLikedNum()+"");

            Log.d("zkk--paint",position+"----"+dataBean.getAvatar());
            MyglideImageView.setRoundImg(context,myPaintHolder.img_user,dataBean.getAvatar());
           MyglideImageView.setImg(context,myPaintHolder.img_icon,dataBean.getPicture());
            if(dataBean.getLiked()==1){
                MyglideImageView.setLocalImg(context,myPaintHolder.iv_like,R.drawable.liked_red2x);
            }else{
                MyglideImageView.setLocalImg(context,myPaintHolder.iv_like,R.drawable.liked_gray2x);
            }

            myPaintHolder.img_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PaintActivity.class);
                intent.putExtra("id",dataBean.getOid()+"");
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
            });

        return convertView;
    }

    class MyPaintHolder{

        ImageView img_user;
        TextView comic_name,comic_title;
        ImageView img_icon,iv_like;
        Button like_btn;
    }

}
