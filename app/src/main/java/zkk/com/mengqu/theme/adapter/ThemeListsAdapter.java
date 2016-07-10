package zkk.com.mengqu.theme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import zkk.com.mengqu.R;
import zkk.com.mengqu.imagslists.activity.ImagesListsActivity;
import zkk.com.mengqu.theme.bean.ThemeItemBena;
import zkk.com.mengqu.view.glide.MyglideImageView;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class ThemeListsAdapter extends BaseAdapter {

  //  List<ImagsListBean> liveBeens=new ArrayList<ImagsListBean>();
  ThemeItemBena imagsListBean =new ThemeItemBena();
    private Context context;
    private ItemThemeclick itemclick;

    public ThemeListsAdapter() {

    }
    public ThemeListsAdapter(ThemeItemBena liveBeen2, Context context) {
        this.imagsListBean = liveBeen2;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagsListBean.getData() ==null?0:imagsListBean.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return imagsListBean.getData().get(position);
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_themelist,null);
            homeHolder.iv_img=(ImageView)convertView.findViewById(R.id.img_icon2);
            homeHolder.tv_title=(TextView)convertView.findViewById(R.id.tv_title);

            convertView.setTag(homeHolder);
        }else{
            homeHolder=(HomeHolder)convertView.getTag();
        }

        MyglideImageView.setImg(context,homeHolder.iv_img,imagsListBean.getData().get(position).getImages().get(0).toString());
        homeHolder.tv_title.setText(imagsListBean.getData().get(position).getTitle());
        homeHolder.iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ImagesListsActivity.class);
                intent.putExtra("id",imagsListBean.getData().get(position).getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class HomeHolder{
        ImageView iv_img;
        TextView tv_title;
    }

    public  void setItemThemeclick(ItemThemeclick l){
        itemclick=l;
    }

    public interface  ItemThemeclick{
        void setMyOnitemclick(int poistions);
    }
}