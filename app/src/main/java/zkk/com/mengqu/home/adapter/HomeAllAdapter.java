package zkk.com.mengqu.home.adapter;

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
import zkk.com.mengqu.home.bean.HomeitemBean;
import zkk.com.mengqu.imagslists.activity.ImagesListsActivity;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class HomeAllAdapter extends BaseAdapter {

    List<HomeitemBean.DataBean> liveBeens=new ArrayList<HomeitemBean.DataBean>();
    private Context context;

    public HomeAllAdapter() {
    }

    public HomeAllAdapter(List<HomeitemBean.DataBean> liveBeens, Context context) {
        this.liveBeens = liveBeens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liveBeens.size();
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_home,null);
            homeHolder.home_img=(ImageView)convertView.findViewById(R.id.home_img);
            homeHolder.home_icon_number=(TextView)convertView.findViewById(R.id.home_icon_number);
            homeHolder.home_great_number=(TextView)convertView.findViewById(R.id.home_great_number);
            homeHolder.home_title=(TextView)convertView.findViewById(R.id.home_title);

            convertView.setTag(homeHolder);
        }else{
            homeHolder=(HomeHolder)convertView.getTag();
        }

        MyglideImageView.setImg(context,homeHolder.home_img,liveBeens.get(position).getCoverImage());
        homeHolder.home_icon_number.setText(liveBeens.get(position).getCount()+"");
        homeHolder.home_great_number.setText(liveBeens.get(position).getLike()+"");
        homeHolder.home_title.setText(liveBeens.get(position).getTitle());

        homeHolder.home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ImagesListsActivity.class);
                intent.putExtra("id",liveBeens.get(position).getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class HomeHolder{
        ImageView home_img;
        TextView home_icon_number,home_great_number,home_title;
    }
}