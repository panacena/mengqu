package zkk.com.mengqu.game.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zkk.com.mengqu.R;
import zkk.com.mengqu.game.activity.GameInfoItemActivity;
import zkk.com.mengqu.game.bean.GoodThemeBean;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class GoodThemeAdapter extends BaseAdapter {

    List<GoodThemeBean.DataBean> liveBeens=new ArrayList<GoodThemeBean.DataBean>();
    private Context context;

    public GoodThemeAdapter() {
    }

    public GoodThemeAdapter(List<GoodThemeBean.DataBean> liveBeens, Context context) {
        this.liveBeens = liveBeens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liveBeens==null?0:liveBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return liveBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        HomeHolder homeHolder;
        if(convertView==null){
            homeHolder=new HomeHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_game_theme,null);
            homeHolder.iv_tagImg=(ImageView)convertView.findViewById(R.id.img_icon);
            homeHolder.tv_tagName=(TextView)convertView.findViewById(R.id.tv_title);

            convertView.setTag(homeHolder);
        }else{
            homeHolder=(HomeHolder)convertView.getTag();
        }

        MyglideImageView.setImg(context,homeHolder.iv_tagImg,liveBeens.get(position).getCoverImage());
        homeHolder.tv_tagName.setText(liveBeens.get(position).getTitle());


        homeHolder.iv_tagImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, GameInfoItemActivity.class);
                intent.putExtra("id",liveBeens.get(position).getId()+"");
                context.startActivity(intent);
            }
        });


        return convertView;
    }

    class HomeHolder{
        ImageView iv_tagImg;
        TextView tv_tagName;
    }
}