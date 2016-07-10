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
import zkk.com.mengqu.game.bean.InfoItemBean;
import zkk.com.mengqu.util.Utils;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class GameInfoAdapter extends BaseAdapter {

    private static final int TYPE_DATE = 0;//带日期
    private static final int TYPE_NOTDATE = 1;//不带日期
    private List<InfoItemBean> infoItemBeens=new ArrayList<InfoItemBean>();

    private Context context;
    public GameInfoAdapter(List<InfoItemBean> infoItemBeens, Context con) {
        this.infoItemBeens = infoItemBeens;
        this.context=con;
    }

    @Override
    public int getCount() {
        return infoItemBeens==null?0:infoItemBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return infoItemBeens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if(infoItemBeens.get(position).getType()==0){
            return  TYPE_DATE;
        }else {
            return  TYPE_NOTDATE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final InfoItemBean infoItemBean=infoItemBeens.get(position);
        MyGameHolder myGameHolder;
        int conType=getItemViewType(position);
        if(conType==TYPE_DATE){
            if(convertView==null){
                myGameHolder=new MyGameHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.item_info_top,null);
                myGameHolder.tv_time=(TextView)convertView.findViewById(R.id.tv_time);
                myGameHolder.tv_type=(TextView)convertView.findViewById(R.id.tv_type);
                myGameHolder.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
                myGameHolder.img_icon=(ImageView) convertView.findViewById(R.id.img_icon);

                convertView.setTag(myGameHolder);
            }else{
                myGameHolder=(MyGameHolder)convertView.getTag();
            }
            myGameHolder.tv_time.setText(Utils.getDate(Long.parseLong(infoItemBean.getTime())));
            myGameHolder.tv_type.setText(infoItemBean.getCategory());
            myGameHolder.tv_title.setText(infoItemBean.getTitle());
            MyglideImageView.setImg(context,myGameHolder.img_icon,infoItemBean.getCoverImage());
        }else {

            if(convertView==null){
                myGameHolder=new MyGameHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.item_info,null);
                myGameHolder.tv_type=(TextView)convertView.findViewById(R.id.tv_type);
                myGameHolder.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
                myGameHolder.img_icon=(ImageView) convertView.findViewById(R.id.img_icon);

                convertView.setTag(myGameHolder);
            }else{
                myGameHolder=(MyGameHolder)convertView.getTag();
            }
            myGameHolder.tv_type.setText(infoItemBean.getCategory());
            myGameHolder.tv_title.setText(infoItemBean.getTitle());
            MyglideImageView.setImg(context,myGameHolder.img_icon,infoItemBean.getCoverImage());
        }
        myGameHolder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, GameInfoItemActivity.class);
                intent.putExtra("id",infoItemBean.getId()+"");
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class MyGameHolder{

        TextView tv_time,tv_type,tv_title;
        ImageView img_icon;
    }

}
